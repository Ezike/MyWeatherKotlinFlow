package ezike.tobenna.myweather.repository

import android.content.Context
import android.content.SharedPreferences
import ezike.tobenna.myweather.AppCoroutineDispatchers
import ezike.tobenna.myweather.data.Resource
import ezike.tobenna.myweather.data.local.LocalDataSource
import ezike.tobenna.myweather.data.model.WeatherResponse
import ezike.tobenna.myweather.data.remote.RemoteSource
import ezike.tobenna.myweather.provider.LocationProvider
import ezike.tobenna.myweather.widget.WeatherWidgetProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@ExperimentalCoroutinesApi
class WeatherRepository @Inject constructor(
        private val dispatcher: AppCoroutineDispatchers,
        private val remoteSource: RemoteSource,
        private val localDataSource: LocalDataSource,
        private val locationProvider: LocationProvider,
        private val prefEditor: SharedPreferences.Editor,
        private val context: Context
) : Repository {

    @ExperimentalCoroutinesApi
    override fun fetchWeather(): Flow<Resource<WeatherResponse>> {
        return flow<Resource<WeatherResponse>> {
            val currentData: WeatherResponse = localDataSource.getWeather().first()
            emit(Resource.Loading(currentData))
            fetchWeatherAndCache()
            updateWidgetData(currentData)
            emitAll(localDataSource.getWeather().map { Resource.Success(it) })
        }.catch { cause ->
            val previousData: WeatherResponse = localDataSource.getWeather().first()
            emit(Resource.Error(cause, previousData))
            cause.printStackTrace()
        }.flowOn(dispatcher.io)
    }

    private fun updateWidgetData(weather: WeatherResponse) {
        saveToPreferences(weather)
        WeatherWidgetProvider.updateWidget(context)
    }

    private suspend fun fetchWeatherAndCache() {
        val weather: WeatherResponse = remoteSource
                .fetchWeather(locationProvider.preferredLocationString)
        localDataSource.save(weather)
    }

    private fun saveToPreferences(weather: WeatherResponse?) {
        weather?.let {
            if (it.current.weatherDescriptions.isNotEmpty()) {
                prefEditor.putString(WIDGET_TEXT, weather.current.weatherDescriptions.first())
                prefEditor.putString(WIDGET_LOCATION, weather.weatherLocation.region)
                prefEditor.putString(WIDGET_ICON, weather.current.weatherDescriptions.first())
                prefEditor.apply()
            }
        }
    }

    companion object {
        const val WIDGET_TEXT: String = "ezike.tobenna.myweather.ui.widget.text"
        const val WIDGET_LOCATION: String = "ezike.tobenna.myweather.ui.widget.location"
        const val WIDGET_ICON: String = "ezike.tobenna.myweather.ui.widget.icon"
    }
}
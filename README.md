# MyWeather
App shows real-time weather updates for your location and any custom location you set.
Was initially written in Java but is now in Kotlin and uses coroutines. Data is from [Apixu Api](https://www.apixu.com/api.aspx)
 
* You can clone the project and fix stuff or maybe write some tests 😉☺️

<h4 align="center">
<img src="https://res.cloudinary.com/diixxqjcx/image/upload/v1554216525/Nexus_5x-Screenshot1.png" vspace="4" align= "center" width=255 ></h4>


## Features
* kotlin coroutines for async operations
* kotlin flow for data streaming
* Local persistence using Room database
* MVVM architecture
* Databinding for binding data to views
* Navigation component
* Homescreen Widget that shows weather information
* Dependency injection with Dagger 2

#### 1. Clone or fork the repository (Master Branch) by running the command below
on your git terminal
```
git clone https://github.com/Ezike/MyWeather.git
```

#### 2. Import the project in AndroidStudio, and add API Key
1.  In Android Studio, go to File -> New -> Import project
2.  Follow the dialog for set up instructions
3.  Get your api key from [Apixu website](https://www.apixu.com/api.aspx)
4.  Create a local `gradle.properties` file and store the api key there

```
ApiXuKey="Your API Key here"
```

## Libraries
*   [Coroutines](https://developer.android.com/kotlin/coroutines)
*   [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-flow/)
*   [AndroidX](https://developer.android.com/jetpack/androidx/)
*   [Navigation component](https://developer.android.com/guide/navigation)
*   [Retrofit 2](https://github.com/square/retrofit)
*   [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
*   [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
*   [Room](https://developer.android.com/topic/libraries/architecture/room)
*   [Glide](https://github.com/bumptech/glide)
*   [DataBinding](https://developer.android.com/topic/libraries/data-binding)
*   [Dagger2](https://google.github.io/dagger/users-guide)
*   [Timber](https://github.com/JakeWharton/timber)
*   [WeatherIconView](https://github.com/pwittchen/WeatherIconView)
*   [Moshi](https://github.com/square/moshi)
*   [ThreeTenABP](https://github.com/JakeWharton/ThreeTenABP)
*   [OkHttp3](https://square.github.io/okhttp)
*   [Google Admob](https://developers.google.com/admob/android/quick-start)

## Author
Ezike Tobenna

## License
This project is licensed under the Apache License 2.0 - See: http://www.apache.org/licenses/LICENSE-2.0.txt


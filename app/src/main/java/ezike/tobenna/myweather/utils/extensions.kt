package ezike.tobenna.myweather.utils

import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

var ActionBar.toolbarTitle: String?
    get() = title.toString()
    set(value) {
        title = value ?: title ?: ""
    }

val Fragment.actionBar: ActionBar?
    get() = (requireActivity() as AppCompatActivity).supportActionBar

var View.visible: Boolean
    get() = visibility == View.VISIBLE
    set(value) = if (value) visibility = View.VISIBLE else visibility = View.GONE
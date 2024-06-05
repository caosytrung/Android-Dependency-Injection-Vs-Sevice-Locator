package com.trungcs.simple_dependency_injection.simple_di.component

import android.app.Activity
import androidx.fragment.app.Fragment
import com.trungcs.simple_dependency_injection.simple_di.annotation.SimpleComponent

@SimpleComponent([])
interface AppComponent {
    fun injectActivity(activity: Activity)
    fun injectFragment(fragment: Fragment)

}
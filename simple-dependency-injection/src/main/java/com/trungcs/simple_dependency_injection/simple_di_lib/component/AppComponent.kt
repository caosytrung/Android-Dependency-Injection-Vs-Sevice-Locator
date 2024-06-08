package com.trungcs.simple_dependency_injection.simple_di_lib.component

import android.app.Activity
import androidx.fragment.app.Fragment
import com.trungcs.simple_dependency_injection.simple_di_lib.annotation.SimpleComponent

@SimpleComponent([])
interface AppComponent {
    fun injectActivity(activity: Activity)
    fun injectFragment(fragment: Fragment)

}
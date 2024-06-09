package com.trungcs.simple_dependency_injection.simple_di_lib.component

import android.app.Activity
import androidx.fragment.app.Fragment
import com.trungcs.simple_dependency_injection.main.di.DataModule
import com.trungcs.simple_dependency_injection.simple_di_lib.annotation.SimpleComponent

@SimpleComponent([DataModule::class])
interface AppComponent {
    fun injectActivity(activity: Activity)
    fun injectFragment(fragment: Fragment)
}
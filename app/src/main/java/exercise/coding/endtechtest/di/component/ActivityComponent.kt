package exercise.coding.endtechtest.di.component

import dagger.Component
import exercise.coding.endtechtest.ui.activity.MainActivity
import exercise.coding.endtechtest.di.module.ActivityModule

@Component(modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)
}
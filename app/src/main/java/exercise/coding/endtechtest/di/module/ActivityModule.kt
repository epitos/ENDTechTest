package exercise.coding.endtechtest.di.module

import dagger.Module
import dagger.Provides
import exercise.coding.endtechtest.ui.MainActivityVP
import exercise.coding.endtechtest.ui.presenter.MainPresenter

@Module
class ActivityModule(private val view: MainActivityVP.View) {
    @Provides
    fun providePresenter(): MainPresenter {
        return MainPresenter(view)
    }
}
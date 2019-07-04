package exercise.coding.endtechtest.di.module

import dagger.Module
import dagger.Provides
import exercise.coding.endtechtest.ui.ProductListVP
import exercise.coding.endtechtest.ui.presenter.ProductListPresenter

@Module
class FragmentModule (private val view: ProductListVP.View) {

    @Provides
    fun providePresenter(): ProductListPresenter {
        return ProductListPresenter(view)
    }
}
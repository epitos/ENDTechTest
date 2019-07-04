package exercise.coding.endtechtest.di.component

import dagger.Component
import exercise.coding.endtechtest.di.module.FragmentModule
import exercise.coding.endtechtest.ui.fragment.ProductListFragment

@Component(modules = [FragmentModule::class])
interface FragmentComponent {
    fun inject(fragment: ProductListFragment)
}
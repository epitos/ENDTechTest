package exercise.coding.endtechtest.ui

import exercise.coding.endtechtest.base.BaseFragment

interface MainActivityVP {
    interface View {
        fun setFragment(fragment: BaseFragment)
        fun hideProgressbar()
        fun setTitle(title: String)
    }

    interface Presenter {
        fun getProductListing()
        fun clearUpResources()
    }
}
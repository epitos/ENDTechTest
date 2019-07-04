package exercise.coding.endtechtest.ui

import exercise.coding.endtechtest.base.BaseFragment
import exercise.coding.endtechtest.ui.presenter.MainPresenter

interface FragmentNavigation {
    interface View {
        fun attachPresenter(presenter: MainPresenter)
    }

    interface Presenter {
        fun addFragment(fragment: BaseFragment)
    }
}
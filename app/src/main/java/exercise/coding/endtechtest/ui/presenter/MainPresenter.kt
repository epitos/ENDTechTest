package exercise.coding.endtechtest.ui.presenter

import example.coding.repositories.api.ApiServiceInterface
import exercise.coding.endtechtest.base.BaseFragment
import exercise.coding.endtechtest.network.model.Product
import exercise.coding.endtechtest.network.model.ProductListingResponse
import exercise.coding.endtechtest.ui.FragmentNavigation
import exercise.coding.endtechtest.ui.MainActivityVP
import exercise.coding.endtechtest.ui.fragment.ProductListFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainPresenter (private val view: MainActivityVP.View) : MainActivityVP.Presenter, FragmentNavigation.Presenter {

    private var compositeDisposable = CompositeDisposable()

    override fun getProductListing() {
        compositeDisposable.add(
            ApiServiceInterface.create().getProductListing()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse))
    }

    override fun clearUpResources() {
        compositeDisposable.clear()
    }

    override fun addFragment(fragment: BaseFragment) {
        view.setFragment(fragment)
    }

    private fun handleResponse(response: ProductListingResponse) {
        if(response != null) {
            view.setFragment(
                ProductListFragment.newInstance(response.products as ArrayList<Product>,
                response.product_count))
            view.hideProgressbar()
            view.setTitle(response.title)
        }
    }
}
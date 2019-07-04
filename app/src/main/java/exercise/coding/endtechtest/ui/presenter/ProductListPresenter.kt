package exercise.coding.endtechtest.ui.presenter

import exercise.coding.endtechtest.network.model.Product
import exercise.coding.endtechtest.ui.ProductListVP

class ProductListPresenter (private val view: ProductListVP.View) : ProductListVP.Presenter {
    override fun getProduct(product: Product) {
        view.setProduct(product)
    }
}
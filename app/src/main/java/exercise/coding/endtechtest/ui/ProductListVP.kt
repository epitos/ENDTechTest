package exercise.coding.endtechtest.ui

import exercise.coding.endtechtest.network.model.Product

interface ProductListVP {
    interface View {
        fun setProduct(product: Product)
    }

    interface Presenter {
        fun getProduct(product: Product)
    }
}
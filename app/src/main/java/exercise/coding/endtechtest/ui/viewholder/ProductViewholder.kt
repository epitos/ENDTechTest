package exercise.coding.endtechtest.ui.viewholder

import android.view.View
import com.squareup.picasso.Picasso
import exercise.coding.endtechtest.base.BaseViewHolder
import exercise.coding.endtechtest.network.model.Product
import exercise.coding.endtechtest.ui.ProductListVP
import kotlinx.android.synthetic.main.item_layout.view.*

class ProductViewholder (view: View) : BaseViewHolder<Any>(view), View.OnClickListener  {

    private var productImageOne = view.product_image_one
    private var productTitleOne = view.product_title_one
    private var productPriceOne = view.product_price_one
    private var productImageTwo = view.product_image_two
    private var productTitleTwo = view.product_title_two
    private var productPriceTwo = view.product_price_two
    private var presenter: ProductListVP.Presenter? = null
    private var productOne: Product? = null
    private var productTwo: Product? = null

    override fun bind(item: Any) {}

    override fun bind(itemOne: Any, itemTwo: Any, presenter: ProductListVP.Presenter) {
        this.presenter = presenter

        if (itemOne is Product && itemTwo is Product) {
            productOne = itemOne
            productTwo = itemTwo

            productTitleTwo.text = itemOne.name
            productPriceTwo.text = itemOne.price
            productTitleOne.text = itemTwo.name
            productPriceOne.text = itemTwo.price

            Picasso.get()
                .load(itemOne.image)
                .into(productImageOne)
            Picasso.get()
                .load(itemTwo.image)
                .into(productImageTwo)

            setListener()
        }
    }

    private fun setListener() {
        productImageOne.setOnClickListener(this)
        productImageTwo.setOnClickListener(this)
    }
    override fun onClick(p0: View?) {
        productOne?.let { presenter?.getProduct(it) }
    }
}
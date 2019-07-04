package exercise.coding.endtechtest.ui.viewholder

import android.view.View
import exercise.coding.endtechtest.base.BaseViewHolder
import exercise.coding.endtechtest.ui.ProductListVP
import kotlinx.android.synthetic.main.no_of_items_layout.view.*

class TotalProductsViewholder (view: View) : BaseViewHolder<Any>(view) {

    private var numberOfItems: Int? = null
    private var itemCount = view.no_of_items

    override fun bind(item: Any) {
        if(item is Int) {
            numberOfItems = item
            itemCount.text = numberOfItems.toString() + " items"
        }
    }

    override fun bind(itemOne: Any, itemTwo: Any, presenter: ProductListVP.Presenter) {}
}
package exercise.coding.endtechtest.base

import android.support.v7.widget.RecyclerView
import android.view.View
import exercise.coding.endtechtest.ui.ProductListVP

abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(numOfItems: Any)
    abstract fun bind(itemOne: Any, itemTwo: Any, presenter: ProductListVP.Presenter)
}
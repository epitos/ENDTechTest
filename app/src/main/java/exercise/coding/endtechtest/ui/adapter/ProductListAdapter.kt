package exercise.coding.endtechtest.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import exercise.coding.endtechtest.R
import exercise.coding.endtechtest.base.BaseViewHolder
import exercise.coding.endtechtest.network.model.Product
import exercise.coding.endtechtest.ui.ProductListVP
import exercise.coding.endtechtest.ui.viewholder.ProductViewholder
import exercise.coding.endtechtest.ui.viewholder.TotalProductsViewholder

class ProductListAdapter (private var dataList: ArrayList<Any>,
                          private var presenter: ProductListVP.Presenter) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    companion object {
        private const val NUM_OF_ITEMS = 0
        private const val ITEMS = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {

        return when(viewType) {
            NUM_OF_ITEMS -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.no_of_items_layout, parent, false)
                TotalProductsViewholder(view)
            }
            ITEMS -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_layout, parent, false)
                ProductViewholder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount(): Int = dataList.count() - 25

    override fun onBindViewHolder(viewholder: BaseViewHolder<*>, position: Int) {

        when(viewholder) {
            is TotalProductsViewholder -> viewholder.bind(dataList[position])
            is ProductViewholder -> {
                if (position != dataList.size) {
                    viewholder.bind(dataList[position],
                        dataList[position + 1], presenter)
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val comparable = dataList[position]
        return when (comparable) {
            is Int -> NUM_OF_ITEMS
            is Product -> ITEMS
            else -> throw IllegalArgumentException("Invalid type of data " + position)
        }
    }
}
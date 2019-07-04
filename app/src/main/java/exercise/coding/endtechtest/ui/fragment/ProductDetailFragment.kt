package exercise.coding.endtechtest.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import com.squareup.picasso.Picasso
import exercise.coding.endtechtest.R
import exercise.coding.endtechtest.base.BaseFragment
import exercise.coding.endtechtest.di.module.FragmentModule
import exercise.coding.endtechtest.network.model.Product
import exercise.coding.endtechtest.ui.ProductListVP
import exercise.coding.endtechtest.ui.adapter.ProductListAdapter
import exercise.coding.endtechtest.ui.presenter.ProductListPresenter
import kotlinx.android.synthetic.main.fragment_product.*
import kotlinx.android.synthetic.main.fragment_product_list.*
import javax.inject.Inject

private const val ARG_PRODUCT = "product"

class ProductDetailFragment : BaseFragment() {

    private var product: Product? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            product = it.getParcelable(ARG_PRODUCT)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var v = inflater.inflate(R.layout.fragment_product, container, false)
        setHasOptionsMenu(true)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewVisibility()
        setHomeBtnEnabled(true)
        product?.let {
            setProduct(it)
            setToolbarTitle(product!!.name)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.main_nav, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun setProduct(product: Product) {
        product_price.text = product.price
        Picasso.get()
            .load(product.image)
            .into(product_image)
    }

    private fun setViewVisibility() {
        showOptionBar(false)
        showAddToCartBtn(true)
        showIcon(false)
    }

    companion object {
        @JvmStatic
        fun newInstance(product: Product) =
            ProductDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PRODUCT, product)
                }
            }
    }
}
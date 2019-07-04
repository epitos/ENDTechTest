package exercise.coding.endtechtest.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import exercise.coding.endtechtest.R
import exercise.coding.endtechtest.base.BaseFragment
import exercise.coding.endtechtest.di.component.DaggerFragmentComponent
import exercise.coding.endtechtest.di.module.FragmentModule
import exercise.coding.endtechtest.network.model.Product
import exercise.coding.endtechtest.ui.ProductListVP
import exercise.coding.endtechtest.ui.adapter.ProductListAdapter
import exercise.coding.endtechtest.ui.presenter.ProductListPresenter
import kotlinx.android.synthetic.main.fragment_product_list.*
import javax.inject.Inject


private const val ARG_PRODUCTS = "products"
private const val ARG_ITEM_COUNT = "item_count"


class ProductListFragment : BaseFragment(), ProductListVP.View {

    @Inject
    lateinit var presenter: ProductListPresenter
    private var products: ArrayList<Product>? = null
    private var dataList = arrayListOf<Any>()
    private var numberOfItems: Int? = null
    private var productListAdapter: ProductListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            products = it.getParcelableArrayList(ARG_PRODUCTS)
            numberOfItems = it.getInt(ARG_ITEM_COUNT)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_product_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        injectDependency()

        if (numberOfItems != null) {
            dataList.add(numberOfItems!!)
        }

        if (products != null) {
            dataList.addAll(products!!)
        }

        initRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        showIcon(true)
        showAddToCartBtn(false)
        showOptionBar(true)
        activity?.resources?.getString(R.string.exercise_listing_title)?.let { setToolbarTitle(it) }
        setHomeBtnEnabled(false)
    }

    override fun setProduct(product: Product) {
        navigationPresenter?.addFragment(ProductDetailFragment.newInstance(product))
    }

    private fun initRecyclerView() {
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(activity)
        product_list.layoutManager = layoutManager
        productListAdapter = products?.let {
            ProductListAdapter(dataList, presenter)
        }
        product_list.adapter = productListAdapter
    }

    private fun injectDependency() {
        val fragmentComponent = DaggerFragmentComponent
            .builder()
            .fragmentModule(FragmentModule(this))
            .build()
        fragmentComponent.inject(this)
    }

    companion object {
        @JvmStatic
        fun newInstance(products: ArrayList<Product>, noOfItems: Int) =
            ProductListFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(ARG_PRODUCTS, products)
                    putInt(ARG_ITEM_COUNT, noOfItems)
                }
            }
    }
}
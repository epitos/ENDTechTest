package exercise.coding.endtechtest.base

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import exercise.coding.endtechtest.R
import exercise.coding.endtechtest.ui.FragmentNavigation
import exercise.coding.endtechtest.ui.presenter.MainPresenter

abstract class BaseFragment : Fragment(), FragmentNavigation.View {
    protected var navigationPresenter: FragmentNavigation.Presenter? = null
    override fun attachPresenter(presenter: MainPresenter) {
        navigationPresenter = presenter
    }

    fun setToolbarTitle(title: String) {
        val toolbar = activity?.findViewById<Toolbar>(R.id.toolbar)
        toolbar?.title = title
    }

    fun showOptionBar(isShown: Boolean) {
        val optionBar = activity?.findViewById<LinearLayout>(R.id.options)
        if (isShown) {
            optionBar?.visibility = View.VISIBLE
        } else {
            optionBar?.visibility = View.GONE
        }
    }

    fun setHomeBtnEnabled(isEnabled: Boolean) {
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(isEnabled)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(isEnabled)
    }

    fun showAddToCartBtn(isShown: Boolean) {
        val addToCartBtn = activity?.findViewById<Button>(R.id.add_to_cart_btn)

        if (isShown) {
            addToCartBtn?.visibility = View.VISIBLE
        } else {
            addToCartBtn?.visibility = View.GONE
        }
    }

    fun showIcon(isShown: Boolean) {
        val iconImage = activity?.findViewById<ImageView>(R.id.icon)

        if (isShown) {
            iconImage?.visibility = View.VISIBLE
        } else {
            iconImage?.visibility = View.GONE
        }
    }
}
package exercise.coding.endtechtest.ui.activity

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import exercise.coding.endtechtest.R
import exercise.coding.endtechtest.base.BaseFragment
import exercise.coding.endtechtest.di.component.DaggerActivityComponent
import exercise.coding.endtechtest.di.module.ActivityModule
import exercise.coding.endtechtest.ui.MainActivityVP
import exercise.coding.endtechtest.ui.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_product_listing.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainActivityVP.View {

    @Inject
    lateinit var presenter: MainPresenter
    private var fm: FragmentManager = supportFragmentManager
    private lateinit var ft: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_listing)
        setSupportActionBar(toolbar)
        injectDependency()
        presenter.getProductListing()
    }

    override fun hideProgressbar() {
        progressbar.visibility = View.GONE
    }

    override fun setTitle(title: String) {
        toolbar.title = title
    }

    override fun setFragment(fragment: BaseFragment) {
        fragment.attachPresenter(presenter)
        ft = fm.beginTransaction()
        ft.replace(R.id.container, fragment)
        ft.addToBackStack(null)
        ft.commit()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> super.onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent
            .builder()
            .activityModule(ActivityModule(this))
            .build()
        activityComponent.inject(this)
    }
}

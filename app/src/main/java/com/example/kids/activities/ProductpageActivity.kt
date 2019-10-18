package com.example.kids.activities

import android.os.Bundle
import android.view.View
import android.widget.ImageView

import com.example.kids.R
import com.example.kids.adapters.ProductPageAdapter
import com.example.kids.adapters.TabproductpageAdapter
import com.google.android.material.tabs.TabLayout


import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.toolbar_product_page.*
import me.relex.circleindicator.CircleIndicator

class ProductpageActivity : AppCompatActivity() {

    private var v1: androidx.viewpager.widget.ViewPager? = null
    private var a: ProductPageAdapter? = null
    private val indicator: CircleIndicator? = null

    internal var favimg1: ImageView? = null

    private var viewpager1: ViewPager? = null

    private var tablayout1: TabLayout? = null
    private var adapter: TabproductpageAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_page)
        v1 = findViewById(R.id.v1)
        val indicator = findViewById<View>(R.id.indicator) as CircleIndicator
        a = ProductPageAdapter(supportFragmentManager)
        v1!!.adapter = a
        indicator.setViewPager(v1)
        a!!.registerDataSetObserver(indicator.dataSetObserver)

        tablayout1 = findViewById(R.id.tablayout1)

        viewpager1 = findViewById(R.id.viewpager1)

        //        setCustomFontAndStyle(tabLayout1, 0);
        tablayout1?.setTabGravity(TabLayout.GRAVITY_FILL)

        tablayout1?.addTab(tablayout1?.newTab()!!.setText("INFO"))
        tablayout1?.addTab(tablayout1?.newTab()!!.setText("SIZE CHART"))




        adapter = TabproductpageAdapter(supportFragmentManager, tablayout1!!.tabCount)
        viewpager1?.adapter = adapter
        viewpager1?.offscreenPageLimit = 2
        viewpager1?.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tablayout1))
        tablayout1?.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab) {
                viewpager1?.currentItem = tab.position

            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
        back.setOnClickListener {
            finish()
        }
    }
}

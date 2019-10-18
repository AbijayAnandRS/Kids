package com.example.kids.activities

import android.os.Bundle


import android.view.View


import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.kids.R
import com.example.kids.adapters.ImageAdapter
import com.example.kids.adapters.ProductTypeRecylerAdapter
import com.example.kids.data.ImageData
import com.example.kids.data.ProductType
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.content_main.*

import java.util.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

  var productTypeAdapter : ProductTypeRecylerAdapter ? =null;
    var imageAdapter : ImageAdapter ? =null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        rv_types?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        productTypeAdapter = ProductTypeRecylerAdapter(this)
        rv_types.adapter = productTypeAdapter;

        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById<View>(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)

       val  productList = Arrays.asList(ProductType(), ProductType(), ProductType())

        productList.forEach {
            it.description = "Hai This is description"
            it.type = "ProductTypes"
            it.imgUrl = "https://c8.alamy.com/comp/HE6THJ/autumn-tree-at-sunset-with-nice-background-bokeh-HE6THJ.jpg"
            productTypeAdapter?.addProductView(it)
        }
        rv_images.layoutManager = GridLayoutManager(this, 2)
        imageAdapter =  ImageAdapter(this)
        rv_images.adapter = imageAdapter
        val imageList = Arrays.asList(ImageData(), ImageData(), ImageData())
        imageList.forEach {
            it.imgUrl = "https://as1.ftcdn.net/jpg/02/20/91/80/500_F_220918065_DUV9fUjF588O6qtGQmfQ7plHsVUX4RQ7.jpg"
            it.imageName = "Image Header"
            imageAdapter?.addImage(it)
        }
    }

    override fun onBackPressed() {
        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val id = item.itemId

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}

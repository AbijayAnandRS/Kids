package com.example.kids.activities

import android.os.Bundle
import android.os.PersistableBundle

import com.example.kids.R
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.toolbar_product_page.*

class CategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)
        back.setOnClickListener {
            finish()
        }
    }
}

package com.lectorium.hw_6.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lectorium.hw_6.R
import com.lectorium.hw_6.databinding.ListItemsActivityBinding

class ListItemsActivity : AppCompatActivity() {

    lateinit var binding: ListItemsActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ListItemsActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment = FragmentMain()
        showFragment(fragment)

    }

    private fun showFragment(fragment: FragmentMain){
        val frag = supportFragmentManager.beginTransaction()
        frag.replace(R.id.mainFragment,fragment)
        frag.commit()
    }

}
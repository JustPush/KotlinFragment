package me.yukang.kotlinfragment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private var isFragmentOneLoaded = true
    private val fm = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnChange = findViewById<Button>(R.id.btn_change)

        showFragmentOne()
        btnChange.setOnClickListener({
            if (isFragmentOneLoaded) showFragmentTwo()
            else showFragmentOne()
        })
    }

    private fun showFragmentOne() {
        val transaction = fm.beginTransaction()
        val fragment = FragmentOne()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun showFragmentTwo() {
        val transaction = fm.beginTransaction()
        val fragment = FragmentTwo()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}

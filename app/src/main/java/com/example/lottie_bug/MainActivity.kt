package com.example.lottie_bug

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            showAnimationFragment()
        }

        setupActionBar()
        supportFragmentManager.addOnBackStackChangedListener {
            setupActionBar()
        }
    }

    private fun showAnimationFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, AnimationFragment.newInstance())
            .commit()
    }

    private fun setupActionBar() {
        val showUp = supportFragmentManager.backStackEntryCount > 0
        supportActionBar?.setDisplayHomeAsUpEnabled(showUp)
    }

    override fun onSupportNavigateUp(): Boolean {
        supportFragmentManager.popBackStack()
        return true
    }

}
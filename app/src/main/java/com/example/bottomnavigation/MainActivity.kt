package com.example.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.bottomnavigation.fragment.HomeFragment
import com.example.bottomnavigation.fragment.NotificationFragment
import com.example.bottomnavigation.fragment.SettingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val HomeFragment = HomeFragment()
        val notificationFragment = NotificationFragment()
        val settingFragment = SettingFragment()

        makeCurrentFragment (HomeFragment)

        val bottom_navigation= findViewById<BottomNavigationView>(R.id.botton_navigation)


        bottom_navigation.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.menu_home -> makeCurrentFragment(HomeFragment)
                R.id.menu_notivication -> makeCurrentFragment(notificationFragment)
                R.id.menu_settings -> makeCurrentFragment(settingFragment)
            }
            true

        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fram_nav, fragment)
            commit()
        }

    }
}
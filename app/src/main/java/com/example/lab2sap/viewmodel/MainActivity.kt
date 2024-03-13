package com.example.lab2sap.viewmodel

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab2sap.R
import com.example.lab2sap.databinding.ActivityMainBinding
import com.example.lab2sap.view.StudentListFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val currentFragment=supportFragmentManager.
        findFragmentById(R.id.fragment_container)
        if(currentFragment==null){
            val fragment= StudentListFragment.newInstance()
            supportFragmentManager.beginTransaction().
            add(R.id.fragment_container,fragment).commit()
        }
    }
}
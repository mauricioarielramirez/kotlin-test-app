package ar.com.arieltest.testapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ar.com.arieltest.testapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtons()
    }

    private fun navigate() {
        val intent = Intent(this, RecycleDemoActivity::class.java)
        startActivity(intent)
    }

    private fun initButtons() {
        binding.button.setOnClickListener { navigate() }
    }
}
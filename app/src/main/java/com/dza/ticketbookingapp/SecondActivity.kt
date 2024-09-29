package com.dza.ticketbookingapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dza.ticketbookingapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

//         Ambil data dari Login Page
        val username = intent.getStringExtra("USERNAME")
        val time = intent.getStringExtra("TIME")
        val date = intent.getStringExtra("DATE")
        val destination = intent.getStringExtra("DESTINATION")

        with(binding) {
            user.text = username
            jam.text = time
            tanggal.text = date
            tujuan.text = destination
        }
    }
}
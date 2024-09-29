package com.dza.ticketbookingapp

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dza.ticketbookingapp.databinding.ActivityMainBinding

class MainActivity :
    AppCompatActivity(),
    DatePickerDialog.OnDateSetListener,
    TimePickerDialog.OnTimeSetListener{
    private lateinit var binding: ActivityMainBinding
    private lateinit var provinces: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        provinces = resources.getStringArray(R.array.provinces)
        with(binding) {
            val adapterProvinces = ArrayAdapter(this@MainActivity,
                android.R.layout.simple_spinner_item, provinces
            )
            adapterProvinces.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
            )
            txtDestination.setAdapter(adapterProvinces)

            txtDate.setOnClickListener {
                val datePicker = DatePicker()
                datePicker.show(supportFragmentManager, "datePicker")
            }

            txtTime.setOnClickListener{
                val timePicker = TimePicker()
                timePicker.show(supportFragmentManager,"timePicker")
            }

            btnOrder.setOnClickListener {
                val username = binding.txtUser.text.toString()
                val time = binding.txtTime.text.toString()
                val date = binding.txtDate.text.toString()
                val destination = binding.txtDestination.text.toString()

                // Tampilkan dialog konfirmasi dengan data pengguna
                val dialog = DialogConfirm(username, time, date, destination)
                dialog.show(supportFragmentManager, "dialogConfirm")
            }
        }
    }

    override fun onDateSet(p0: android.widget.DatePicker?, p1: Int, p2: Int, p3: Int) {
        val txtDate = findViewById<EditText>(R.id.txt_date)
        val selectedDate = "$p3/${p2 + 1}/$p1"
        txtDate.setText(selectedDate)
        Toast.makeText(this@MainActivity, selectedDate,
            Toast.LENGTH_SHORT).show()
    }

    override fun onTimeSet(p0: android.widget.TimePicker?, hourOfDay: Int, minute: Int) {
        // Get the EditText for time
        val txtTime = findViewById<EditText>(R.id.txt_time)

        // Format and display the selected time
        val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
        txtTime.setText(selectedTime)
        Toast.makeText(this@MainActivity,selectedTime,
            Toast.LENGTH_SHORT).show()
    }
}

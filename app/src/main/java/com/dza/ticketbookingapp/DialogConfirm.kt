package com.dza.ticketbookingapp

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.dza.ticketbookingapp.databinding.DialogConfirmBinding

class DialogConfirm(
    private val username: String?,
    private val time: String?,
    private val date: String?,
    private val destination: String?) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder= AlertDialog.Builder(requireActivity())
        val inflater= requireActivity().layoutInflater
        val binding= DialogConfirmBinding.inflate(inflater)
        with(binding){
            btnBeli.setOnClickListener {
                val intent = Intent(requireActivity(), SecondActivity::class.java).apply {
                    putExtra("USERNAME", username)
                    putExtra("TIME", time)
                    putExtra("DATE", date)
                    putExtra("DESTINATION", destination)
                }
                startActivity(intent)
            }
            btnBatal.setOnClickListener{
                dismiss()
            }
        }

        builder.setView(binding.root)
        return builder.create()
    }
}
package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.app.AlertDialog
import android.content.DialogInterface

class MainActivity : AppCompatActivity() {
    private lateinit var exitDialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        exitDialog = createExitDialog()
    }

    override fun onBackPressed() {
        exitDialog.show()
    }

    private fun createExitDialog(): AlertDialog {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Exit")
        builder.setMessage("Are you sure you want to exit?")
        builder.setPositiveButton("Yes") { _, _ ->
            finish() // Close the activity
        }
        builder.setNegativeButton("No", null)
        return builder.create()
    }
}
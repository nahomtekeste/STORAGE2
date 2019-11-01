package com.example.sharedprefernceprojects

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPreference:SharedPreference=SharedPreference(this)

        btnClear.setOnClickListener {
            sharedPreference.clearSharedPreference()
            Toast.makeText(this@MainActivity,"Data Cleared",Toast.LENGTH_SHORT).show()
        }

    }



    //saving data
    fun saveData(view: View) {
        val sharedPref = this.getPreferences(Context.MODE_PRIVATE) ?: return
        with(sharedPref.edit()) {
            putString("name", et_name.text.toString()).clear()
            putInt("number", et_number.text.toString().toInt()).clear()
            clear()

            //to make sure to clear the message in threr
            et_name.text.clear()
            et_number.text.clear()


        }
    }

    fun getData(view: View) {
        val sharedPref = this.getPreferences(Context.MODE_PRIVATE) ?: return
        val str_name = sharedPref.getString("name", "")
        val int_number = sharedPref.getInt("number", 0)
        Toast.makeText(this, "$str_name $int_number", Toast.LENGTH_LONG).show()

    }


}
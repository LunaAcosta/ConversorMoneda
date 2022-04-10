package com.example.conversordemoneda

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toolbar


class Coonfiguracion : AppCompatActivity() {

    private lateinit var pre: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coonfiguracion)

        val euro: EditText = findViewById(R.id.EditModi)
        val aceptar: Button = findViewById(R.id.btObtener)



        pre = getSharedPreferences("SHARE", Context.MODE_PRIVATE)

        aceptar.setOnClickListener {
            val nu: Int = euro.text.toString().toInt()

            val editor: SharedPreferences.Editor = pre.edit()
            editor.putInt("Euro",nu)
            editor.apply()

            Toast.makeText(this,"MODIFICACION EXITOSA", Toast.LENGTH_LONG).show()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)


        }

    }
}
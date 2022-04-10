package com.example.conversordemoneda

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val saldo:EditText = findViewById(R.id.txtsaldo)
        val resultado: TextView = findViewById(R.id.txtresultado)
        val convertir: Button = findViewById(R.id.btncon)

        // llamado
        val Actualizar: Button = findViewById(R.id.btbact)
        val Nuevoo: TextView = findViewById(R.id.nuevoeuro)

        preferences = getSharedPreferences("SHARE", Context.MODE_PRIVATE)


        Actualizar.setOnClickListener  {
            val nu = preferences.getInt("Euro",0)
            Nuevoo.text = "EL VALOR ACTUAL DEL EURO ES DE :"+nu

            convertir.setOnClickListener {

                val ope = saldo.text.toString().toInt() * nu
                resultado.setText("EL VALOR DE LA CONVERSION ES: € "+ope+" EUROS")

            }
        }
        convertir.setOnClickListener {

            val op = saldo.text.toString().toInt() * 0.93
            resultado.setText("EL VALOR DE LA CONVERSION ES: € "+op+" EUROS")

        }

}
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.configuracion, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.ajustes -> {

                val configu: Intent = Intent(this,Coonfiguracion::class.java)
                startActivity(configu)

                true
            }
            R.id.Quien -> {

                val configu: Intent = Intent(this, Quien::class.java)
                startActivity(configu)

                true
            }

            else ->super.onOptionsItemSelected(item)

        }

    }



}
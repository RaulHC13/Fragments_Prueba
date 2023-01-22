package com.example.practica_fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practica_fragments.Fragments.InterfazBoton

class MainActivity : AppCompatActivity(), InterfazBoton {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    override fun onClickedBotonMenu(btnNum: Int) {
        val i = Intent(this, DosActivity::class.java).apply {
            putExtra("BOTON", btnNum)
        }
        startActivity(i)
    }
}
package com.example.practica_fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.practica_fragments.Fragments.*

class DosActivity : AppCompatActivity(), InterfazBoton {
    //Array con los fragments
    private val fragments = arrayOf(FragmentUno(), FragmentDos(), FragmentTres())
    private var numBtn = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dos)
        val extras = intent.extras
        extras?.let {
            numBtn = it.getInt("BOTON")
        }
        cargarFragment(fragments[numBtn])
    }

    private fun cargarFragment(fragment: Fragment) {
        val bundle = Bundle().apply {
            putInt("BOTON", numBtn)
        }

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<FragmentMenu>(R.id.fg_menu, args = bundle)
            replace(R.id.fg_predeterminado, fragment)
            addToBackStack(null)
        }
    }

    override fun onClickedBotonMenu(btnNum: Int) {
        numBtn = btnNum
        cargarFragment(fragments[numBtn])
    }
}
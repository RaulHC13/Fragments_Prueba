package com.example.practica_fragments.Fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.practica_fragments.R

class FragmentMenu : Fragment() {

    private var listener: InterfazBoton ?= null

    private var botonesMenu = arrayOf(R.id.btn1, R.id.btn2, R.id.btn3)
    private var botonSeleccionado = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            botonSeleccionado = it.getInt("BOTON")
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        for (i in botonesMenu.indices) {
            var boton = view.findViewById<Button>(botonesMenu[i])

            boton.setOnClickListener {
                listener?.onClickedBotonMenu(i)
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is InterfazBoton) listener = context
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}
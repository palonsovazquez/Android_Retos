package com.dam2.android_tutoriales_basicos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_tuto1_actividad2.*

class Tuto1_actividad2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tuto1_actividad2)
// este codigo recoje los datos de intent usando un nombre en clave "color"
        val textoxx= intent.getStringExtra("color")
        Log.e("fdasfsa","creada segunda actividad")
        textViewaaaa.setText(textoxx)

    }
}

package com.dam2.android_tutoriales_basicos

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_suma.*
import kotlinx.android.synthetic.main.activity_tuto1_actividad2.*

class Activity_suma : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suma)

        val num1= intent.getDoubleExtra("numero1",0.0)
        val num2= intent.getDoubleExtra("numero2",0.0)
        val suma = num1+num2


        textoNum1.setText("numero1= " +num1)
        textoNum2.setText("numero2= " +num2)
        textoNum2.setText("suma= " +suma)

        val data = Intent()
            Log.e("Tut2",""+suma)
        data.putExtra("resultado", suma)
        setResult(Activity.RESULT_OK, data)

        btn_volver.setOnClickListener { finish() }

    }
}

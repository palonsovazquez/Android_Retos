package com.dam2.android_tutoriales_basicos

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_tutorial1.*
import org.jetbrains.anko.browse
import android.net.Uri


class Tutorial1 : AppCompatActivity() {
var reto1 = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial1)


        botonT1.setOnClickListener {
            textoBoton.setText("Boton superior pulsado")
            Log.e("Tut1","botonPulsado")
             //longToast("sdjfkhasdkfhaslkj")

            it.setBackgroundColor(Color.YELLOW)


            browse("https://www.google.es")
            reto1 = 1
            val data = Intent()

            data.putExtra("reto1", reto1)
            setResult(Activity.RESULT_OK, data)

        }
        buttonVolver.setOnClickListener{
            // ubicacion en latitud y longitud
           /* var latitud = 42.2364295
            var longitud = -8.7163505


            val ubicationDir = Uri.parse("geo:"+latitud+","+longitud) // parseo a uri la ubicacion GPS
            val intent = Intent(Intent.ACTION_VIEW, ubicationDir) // creo el intent con la ubicacion
            intent.setPackage("com.google.android.apps.maps")       // especifico la aplicacion con la que se tiene que abrir

                startActivity(intent) // inicio la actividad

*/

           finish()



        }





    }




}

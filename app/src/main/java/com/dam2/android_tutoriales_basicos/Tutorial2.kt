package com.dam2.android_tutoriales_basicos

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

import kotlinx.android.synthetic.main.activity_tutorial2.*

class Tutorial2 : AppCompatActivity() {
    var reto2 = 0
    var numero1 = 4.0
    var numero2 = 5.0
 var PICK_CONTACT_REQUEST = 1234;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial2)


        buttonSumar.setOnClickListener {
            val intent = Intent(this, Activity_suma::class.java)
            intent.putExtra("numero1", numero1)
            intent.putExtra("numero2", numero2)

            startActivityForResult(intent,PICK_CONTACT_REQUEST )

        }
        buttonVolver.setOnClickListener{


            finish()



        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
       // super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_CONTACT_REQUEST) {
            // Make sure the request was successful
            if (resultCode == Activity.RESULT_OK) {
                    if(data!= null) {
                        var resultado = data.getDoubleExtra("resultado", 0.0)
                        Log.e("sdfa", "r- " + resultado)
                        textResultado.setText("Resultado =" + resultado)
                        reto2 = 1
                        val data = Intent()

                        data.putExtra("reto2", reto2)
                        setResult(Activity.RESULT_OK, data)
                    }
            }
        }


    }
}

package com.dam2.android_tutoriales_basicos

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_tutorial1.*
import kotlinx.android.synthetic.main.activity_tutorial2.*
import org.jetbrains.anko.longToast

class MainActivity : AppCompatActivity() {
    var reto1 = 0
    var reto2 = 0
    var reto3 = 0
    var reto4 = 0
    val RETO_1_REQUEST = 111
    val RETO_2_REQUEST = 222
    val RETO_3_REQUEST = 333
    val RETO_4_REQUEST = 444


    fun resetRetos(){

        reto1=0
        reto2=0
        reto3=0
        reto4=0
        desactivarBotones()


    }


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button1.setOnClickListener {
        val intent = Intent(this, Tutorial1::class.java)




            startActivityForResult(intent,RETO_1_REQUEST )

        }

        button2.setOnClickListener {
            val intent = Intent(this, Tutorial2::class.java)


            startActivityForResult(intent,RETO_2_REQUEST )

        }

        button3.setOnClickListener {
            val intent = Intent(this, Tutorial3::class.java)


            startActivityForResult(intent,RETO_3_REQUEST )

        }

        button4.setOnClickListener {
            val intent = Intent(this, Tutorial4::class.java)


            startActivityForResult(intent,RETO_4_REQUEST )

        }

        buttonReset.setOnClickListener{


            resetRetos()

        }
        desactivarBotones()






        // esto se ejecuta cuando se crea la actividad
    Log.e("primerTest","Pasa Por OnCreate")

    }

    override fun onStart() {
        super.onStart()
        // Esto se ejecuta justo de despues de onCreate() o un  onRestart()
        Log.e("primerTest","Pasa Por OnStart")
    }

    override fun onResume() {

        super.onResume()
        // esto se ejecuta cuanto el usuario reanuda la actividad
        Log.e("primerTest","Pasa Por OnResume")

    }

    override fun onPause() {
        super.onPause()
        // esto se ejecuta cuando cambias la actividad a segundo plano y pausa la actual si el proceso de la aplicacion es matado tiene que pasar por el onCreate()

        Log.e("primerTest","Pasa Por OnPause")
    }

    override fun onStop() {
        super.onStop()
        // esto se ejecuta cuando la actividad ya no es visible
        Log.e("primerTest","Pasa Por OnStop")

    }

    override fun onDestroy() {
        super.onDestroy()
        // esto se ejecuta cuando la actividad se cierra totalmente
        Log.e("primerTest","Pasa Por OnDestroy")

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
      if(data!=null) {
          if (resultCode == Activity.RESULT_OK) {
              when (requestCode) {
                  RETO_1_REQUEST -> reto1 = data.getIntExtra("reto1", 0)
                  RETO_2_REQUEST -> reto2 = data.getIntExtra("reto2", 0)
                  RETO_3_REQUEST -> reto3 = data.getIntExtra("reto3", 0)
                  RETO_4_REQUEST -> reto4 = data.getIntExtra("reto4", 0)


              }
              desactivarBotones()
              longToast("r1="+reto1+"r2="+reto2+"r3="+reto3+"r4="+reto4)

          }
      }




    }

    fun desactivarBotones(){
        if(reto1== 1){
            button1.isEnabled = false}else{
            button1.isEnabled = true }

        if(reto2== 1){
            button2.isEnabled = false}else{
            button2.isEnabled = true }


        if(reto3== 1){
            button3.isEnabled = false}else{
            button3.isEnabled = true }


        if(reto4== 1){
            button4.isEnabled = false}else{
            button4.isEnabled = true }

        if(reto1== 1 && reto2 == 1 && reto3 == 1 && reto4 == 1){
            buttonReset.isEnabled = true}else{
            buttonReset.isEnabled = false }



    }

}

package com.dam2.android_tutoriales_basicos

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tutorial4.*
import org.jetbrains.anko.toast

class Tutorial4 : AppCompatActivity(), SensorEventListener {
var reto4 = 4

    private lateinit var mSensorManager: SensorManager
    private var mSensors: Sensor? = null
    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }
    override fun onSensorChanged(p0: SensorEvent?) {
//        Sensor change value
        val rotacionX = p0!!.values[0]
        val rotacionY = p0!!.values[1]
        val rotacionZ = p0!!.values[2]
        if (p0.sensor.type == Sensor.TYPE_ROTATION_VECTOR)
            textComponentes.setText("Pon el telefono en vertical Para lograr el reto" +
                    "\nrotacion x = "+rotacionX+"\nrotacion Y ="+rotacionY+"\nrotacion Z ="+rotacionZ)

            if(rotacionX < 0.57 && rotacionX > 0.45 && rotacionY < 0.43 && rotacionY > 0.37)
                metodoAllamarEnPosicionVertical()


    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial4)
        getWindow().getDecorView().setBackgroundColor(Color.RED);
        buttonVolver.setOnClickListener{


            finish()
        }

        // Get an instance of the sensor service, and use that to get an instance of
        // a particular sensor.
        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        mSensors = mSensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR)
        if (mSensors != null) {
            // Success!
            Log.v("SensorTest","Si Existe el sensor")

        } else {
            // Failure!
            Log.v("SensorTest","No se encontro el sensor")
        }
    }


    fun metodoAllamarEnPosicionVertical(){
        getWindow().getDecorView().setBackgroundColor(Color.GREEN);
        toast("Posicion Vertical")
        reto4 = 1
        val data = Intent()

        data.putExtra("reto4", reto4)
        setResult(Activity.RESULT_OK, data)

    }
    override fun onResume() {
        super.onResume()
                // iniciamos la captura de datos
        mSensorManager.registerListener(this, mSensors, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()

        // detenemos la captura de datos
        mSensorManager.unregisterListener(this)



    }




}

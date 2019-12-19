package com.dam2.android_tutoriales_basicos

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Camera
import android.hardware.camera2.CameraCaptureSession
import android.hardware.camera2.CameraDevice
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_tutorial3.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.longToast

class Tutorial3 : AppCompatActivity() {
    var  okvar = false
    var PICK_FOTO_REQUEST = 456
    var reto3 = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial3)

        buttonCameraPermisionTest.setOnClickListener {

            // Log.e("fdsafa","datos ok00="+ okvar)
            // basicPermissionsDemo()
            advancedPermissionsDemo()
            //  Log.e("fdsafa","datos ok000="+ okvar)
            reto3=1
        }

        buttonVolver.setOnClickListener{


            finish()



        }


    }





    fun basicPermissionsDemo(){

        Log.e("fdsafa","botonPulsadoCamera")

        // longToast("sdjfkhasdkfhaslkj")
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            == PackageManager.PERMISSION_GRANTED) {
            longToast("tienes permiso para la camara")
        }


        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            == PackageManager.PERMISSION_DENIED) {
            longToast("No tienes permiso para la camara")
        }

    }
    fun advancedPermissionsDemo(){
        Log.e("fdsafa","datos ok0"+ okvar)
        // Here, thisActivity is the current activity
        Log.e("fdsafa","botonPulsadoCamera")
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED) {
            longToast("No tienes permiso para la camara")
            // Permission is not granted




            Log.e("fdsafa","datos ok="+ okvar)
            if(okvar== true) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.CAMERA), 0
                )
            }else{
                alert("Testing alerts") {

                    positiveButton("Okey") { okvar = true}
                    negativeButton("nope"){okvar = true;                    Log.e("fdsafa","datos ok="+ okvar) }


                }.show()

            }
            // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
            // app-defined int constant. The callback method gets the
            // result of the request.

        } else {
            longToast("Ya tienes permiso para la camara")


            //val intent = Intent(this, CameraDevice::class.java)

            //startActivityForResult(intent,PICK_FOTO_REQUEST )
            dispatchTakePictureIntent()



        }

    }

    val REQUEST_IMAGE_CAPTURE = 1

    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }}

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

            if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {


                if(data!=null){
                    val imageBitmap = data.extras?.get("data") as Bitmap
                    if(imageBitmap!= null){
                    imageView.setImageBitmap(imageBitmap)

                        val data = Intent()

                        data.putExtra("reto3", reto3)
                        setResult(Activity.RESULT_OK, data)
                    }}
            }
        }
    }

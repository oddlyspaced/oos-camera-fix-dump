package com.oplus.permission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //android.hardware.camera2.CameraDevice.setVendorStreamConfigMode
        CheckStuff.check()
    }
}
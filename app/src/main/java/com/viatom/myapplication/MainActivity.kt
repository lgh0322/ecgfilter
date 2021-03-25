package com.viatom.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




       filter(0.0, true)

        var j=0

        var n=0
        for(k in 0 until 10000){
            val doubleArray: DoubleArray? = filter(Math.random(), reset = false)
            doubleArray?.run {
                if(doubleArray.isNotEmpty()){
                    n++
                    Log.e("sdfsdfsdf", "${k - j}    $n         ${doubleArray.size}")
                    j=k

                }
            }

        }
    }

    external fun filter(f: Double, reset: Boolean): DoubleArray?

    external fun shortfilter(shorts: ShortArray?): ShortArray?


    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */

    companion object {
        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("offline-lib");
            System.loadLibrary("native-lib");
        }
    }
}
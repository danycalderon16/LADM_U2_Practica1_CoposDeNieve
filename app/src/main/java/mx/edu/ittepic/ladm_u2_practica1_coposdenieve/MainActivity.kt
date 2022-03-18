package mx.edu.ittepic.ladm_u2_practica1_coposdenieve

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.edu.ittepic.ladm_u2_ejercico6_canvas_corrutinas_touchevent.Lienzo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val lienzo =  Lienzo(this)
        setContentView(lienzo)
    }
}
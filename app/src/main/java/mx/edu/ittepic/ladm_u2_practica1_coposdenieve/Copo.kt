package mx.edu.ittepic.ladm_u2_ejercico6_canvas_corrutinas_touchevent

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import kotlin.random.Random

class Copo (l:Lienzo){
    val l = l

    var x = 0f
    var y = 0f
    var movX = 0f
    var movY = 0f
    var color = Color.argb(100,255,255,255)
    var factor = 0f
    var radio = 0f
    var intensidad = 50

    init {
        factor = rand(intensidad) / 100
        x = rand(1000)
        y = rand(2000)



        movX = rand(6)+2
        movY = 30*factor

        if (rand(100)<50f){
            movX *= -1
        }

        radio = rand(40)+10

        val alpha = 255*factor
        color = Color.argb(alpha.toInt(),255,255,255)
       // Log.i("FA","Factor "+factor+" - Alpha "+alpha+" - "+movY)
        Log.i("FA","Factor "+factor)

    }

    private fun rand(hasta: Int): Float {
        return Random.nextInt(hasta).toFloat()
    }

    fun move(){
        y+=movY

        if(y>l.height)
            y = -40f
    }

    fun pintar(c: Canvas){
        var p = Paint()
        p.color = color
        //c.drawCircle(x,y,radio,p)

        p.strokeWidth = 8f
        c.drawLine(x+0f,y+50f,x+50f,y+50f,p)
        c.drawLine(x+50f,y+50f,x+100f,y+50f,p)
        c.drawLine(x+50f,y+0f,x+50f,y+50f,p)
        c.drawLine(x+50f,y+50f,x+50f,y+100f,p)

        c.drawLine(x+25f,y+25f,x+50f,y+50f,p)
        c.drawLine(x+25f,y+75f,x+50f,y+50f,p)
        c.drawLine(x+50f,y+50f,x+75f,y+25f,p)
        c.drawLine(x+50f,y+50f,x+75f,y+75f,p)
    }

    fun velocidadAlta(){
        factor = rand(33)/100 + 0.66f

        movY = 30*factor
        val alpha = 255*factor
        color = Color.argb(alpha.toInt(),255,255,255)
        Log.i("FA AI","Factor "+factor+" - Alpha "+alpha+" - "+movY)
    }
    fun velocidadAMedia(){
        factor = rand(33)/100 + 0.33f

        movY = 40*factor
        val alpha = 255*factor
        color = Color.argb(alpha.toInt(),255,255,255)
        Log.i("FA AI","Factor "+factor+" - Alpha "+alpha+" - "+movY)
    }

    fun velocidadBaja(){
        factor = (rand(33)/ 100)


        movY = 20*factor
        val alpha = 255*factor
        color = Color.argb(alpha.toInt(),255,255,255)
        Log.i("FA DI","Factor "+factor+" - Alpha "+alpha+" - "+movY)
    }
}
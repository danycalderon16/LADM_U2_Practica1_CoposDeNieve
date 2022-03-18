package mx.edu.ittepic.ladm_u2_ejercico6_canvas_corrutinas_touchevent

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import kotlin.random.Random

class Carro (l:Lienzo){
    val l = l

    var x = 0f
    var y = 0f
    var movX = 0f

    init {
        x = 100f
        y = 1700f
        movX = rand(6)+2

    }

    private fun rand(hasta: Int): Float {
        return Random.nextInt(hasta).toFloat()
    }

    fun move(){
        x+=movX

        if(x-100>l.width) {
            movX = rand(15)+8
            x = -100f
        }
    }

    fun pintar(canvas: Canvas){
        var p = Paint()

        p.color = Color.RED
        canvas.drawRect(x-70,y-30,x+50,y,p)
        canvas.drawRect(x-120,y,x+120,y+50,p)
        p.color = Color.rgb(40, 247, 227)
        canvas.drawRect(x-65,y-25,x-5,y-5,p)
        canvas.drawRect(x+5,y-25,x+45,y-5,p)

        p.color = Color.BLACK
        canvas.drawCircle(x-60,y+60,30f,p)
        canvas.drawCircle(x+60,y+60,30f,p)
        p.color = Color.rgb(73, 91, 92)

        canvas.drawCircle(x-60,y+60,20f,p)
        canvas.drawCircle(x+60,y+60,20f,p)


        p.color = Color.WHITE
        canvas.drawCircle(x-75,y,5f,p)
        canvas.drawCircle(x-85,y,5f,p)
        canvas.drawCircle(x-90,y,5f,p)
        canvas.drawCircle(x-95,y,5f,p)
        canvas.drawCircle(x-100,y,5f,p)
        canvas.drawCircle(x-110,y,5f,p)
        canvas.drawCircle(x+65,y,5f,p)
        canvas.drawCircle(x+70,y,5f,p)
        canvas.drawCircle(x+75,y,5f,p)
        canvas.drawCircle(x+85,y,5f,p)
        canvas.drawCircle(x+95,y,5f,p)
        canvas.drawCircle(x+100,y,5f,p)
        canvas.drawCircle(x+115,y,5f,p)
        canvas.drawCircle(x+105,y,5f,p)
        canvas.drawCircle(x-60,y-35,5f,p)
        canvas.drawCircle(x-50,y-35,5f,p)
        canvas.drawCircle(x-40,y-35,5f,p)
        canvas.drawCircle(x-30,y-35,5f,p)
        canvas.drawCircle(x-20,y-35,5f,p)
        canvas.drawCircle(x-10,y-35,5f,p)
        canvas.drawCircle(x+40,y-35,5f,p)
        canvas.drawCircle(x+30,y-35,5f,p)
        canvas.drawCircle(x+20,y-35,5f,p)
        canvas.drawCircle(x+10,y-35,5f,p)
    }
}
package mx.edu.ittepic.ladm_u2_practica1_coposdenieve

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import mx.edu.ittepic.ladm_u2_ejercico6_canvas_corrutinas_touchevent.Lienzo

class Pato (lienzo: Lienzo,x:Float, y:Float){

    var x = x
    var y = y

    init {
    }

    fun paint(c: Canvas){
        var p = Paint()
        p.color = Color.WHITE
        c.drawRect(x+115f,y+400f,x+140f,y+425f,p)//cuerpo
        c.drawRect(x+130f,y+390f,x+140f,y+400f,p)//cabeza
        c.drawRect(x+105f,y+410f,x+115f,y+415f,p)//cola

        p.color = Color.rgb(255, 208, 0)
        c.drawRect(x+140f,y+395f,x+150f,y+400f,p)//trompa
        c.drawRect(x+120f,y+425f,x+125f,y+435f,p)//pata
        c.drawRect(x+130f,y+425f,x+135f,y+435f,p)//pata
    }
}
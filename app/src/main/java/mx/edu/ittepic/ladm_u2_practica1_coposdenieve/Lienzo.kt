package mx.edu.ittepic.ladm_u2_ejercico6_canvas_corrutinas_touchevent

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import android.view.View
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import mx.edu.ittepic.ladm_u2_practica1_coposdenieve.MainActivity

class Lienzo (mainActivity: MainActivity) : View(mainActivity){

    val thisActivity = mainActivity

    val copos = Array<Copo>(95,{Copo(this)})
    val carro = Array<Carro>(1,{Carro(this)})

    var i = 0
    val corrutina = GlobalScope.launch {
        while (true){
            thisActivity.runOnUiThread {
                invalidate()
            }
            delay(30L)
            i++
            if(i==1000)
                i=0
        }
    }

    override fun onDraw(c: Canvas){
        super.onDraw(c)

        val p = Paint()

        c.drawColor(Color.rgb(75, 175, 80))

        p.color = Color.rgb(0,255,255)

        /**
         * Rio
         * */
        (0..20).forEach {
            c.drawRect(width/20*it+0f,it*10f+250,(width/20*(it+1)).toFloat()+30,(it+1)*25f +280,p)
        }

        /**
         * Carretera
         * */
        p.color = Color.rgb(150, 150, 150)
        c.drawRect(0f,1500f,width.toFloat(),1800f,p)

        /**
         * ancho = 1080
         * 1080/8 = 135
         * 0-135   | 135-270 | 270-405 | 405-540 ....
         * w*0-w*1 |         | w*2-w*3
         * */
        p.color = Color.rgb(255, 255, 0)

        c.drawRect(30f,1640f,(width/8).toFloat()+30,1660f,p)
        c.drawRect((width/8).toFloat()*2+30,1640f,(width/8).toFloat()*3+30,1660f,p)
        c.drawRect((width/8).toFloat()*4+30,1640f,(width/8).toFloat()*5+30,1660f,p)
        c.drawRect((width/8).toFloat()*6+30,1640f,(width/8).toFloat()*7+30,1660f,p)


        /**
         * Lanchero
         * */
        p.color = Color.rgb(222, 166, 98)
        c.drawCircle(850f,490f,15f,p)

        p.color = Color.BLACK
        c.drawRect(835f,475f,865f,483f,p)

        p.color = Color.rgb(181, 100, 0)
        c.drawRect(700f,500f,900f,510f,p)
        c.drawRect(710f,510f,890f,520f,p)
        c.drawRect(720f,520f,880f,530f,p)

        p.color = Color.rgb(120, 83, 40)
        c.drawRect(848f,500f,855f,540f,p)

        /**
         * Patos
         * */

        p.color = Color.WHITE
        c.drawRect(115f,400f,140f,425f,p)//cuerpo
        c.drawRect(130f,390f,140f,400f,p)//cabeza
        c.drawRect(105f,410f,115f,415f,p)//cola

        p.color = Color.rgb(255, 208, 0)
        c.drawRect(140f,395f,150f,400f,p)//trompa
        c.drawRect(120f,425f,125f,435f,p)//pata
        c.drawRect(130f,425f,135f,435f,p)//pata





        carro.forEach {
            it.move()
            it.pintar(c)
        }

        copos.forEach {
            if(i==333)
                it.velocidadBaja()
            if(i==666)
                it.velocidadAMedia()
            if(i==999)
                it.velocidadAlta()

            it.move()
            it.pintar(c)
        }
    }
}
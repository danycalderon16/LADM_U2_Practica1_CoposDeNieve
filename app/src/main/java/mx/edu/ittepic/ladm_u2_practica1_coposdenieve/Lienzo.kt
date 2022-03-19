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
import mx.edu.ittepic.ladm_u2_practica1_coposdenieve.Pato

class Lienzo (mainActivity: MainActivity) : View(mainActivity){

    val thisActivity = mainActivity

    val copos = Array<Copo>(95,{Copo(this)})
    val carro = Array<Carro>(1,{Carro(this)})
    //val patos = Array<Pato>(4,{Pato(this,0f,0f)})

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

        p.color = Color.rgb(255, 255, 255)
        c.drawLine(100f,280f,width+0f,550f,p)
        c.drawLine(100f,300f,width+0f,600f,p)
        c.drawLine(100f,320f,width+0f,650f,p)

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

        val pato1 = Pato(this,0f,80f)
        val pato2 = Pato(this,30f,100f)
        val pato3 = Pato(this,20f,140f)
        val pato4 = Pato(this,50f,120f)
        pato1.paint(c)
        pato2.paint(c)
        pato3.paint(c)
        pato4.paint(c)

        /**
         * Cerca de patos
         * */
        p.color = Color.rgb(138, 90, 0)
        (0..10).forEach {
            if(it%2==0) {
                c.drawRect(it * 10f + 100f, 600f, it * 10f + 110, 650f, p)
                c.drawRect(it * 10f + 100f, 400f, it * 10f + 110, 450f, p)
            }
        }
        c.drawRect(100f, 630f, 200f, 635f, p)
        c.drawRect(100f, 430f, 200f, 435f, p)
        c.drawRect(100f, 430f, 110f, 635f, p)
        c.drawRect(200f, 430f, 210f, 635f, p)

        /**
         * Granja
         * */

        p.color = Color.rgb(166, 19, 26)

        c.drawRect(200f,1000f,700f,1300f,p)
        p.color = Color.rgb(118, 23, 18)
        c.drawRect(180f,950f,720f,1000f,p)
        (0..10).forEach {
            c.drawRect(200f,990f+30*it,700f,1000f+30*it,p)
        }

        p.color = Color.WHITE //Puerta
        c.drawRect(300f,1100f,600f,1300f,p)
        p.color = Color.rgb(196, 196, 196)
        c.drawRect(300f,1100f,600f,1130f,p)
        c.drawRect(300f,1270f,600f,1300f,p)
        c.drawRect(300f,1100f,330f,1300f,p)
        c.drawRect(570f,1100f,600f,1300f,p)
        c.drawRect(420f,1100f,450f,1300f,p)
        c.drawRect(450f,1100f,480f,1300f,p)

        p.color = Color.rgb(58, 224, 49)
        c.drawCircle(650f,1300f,40f,p)
        c.drawCircle(690f,1300f,40f,p)
        c.drawCircle(697f,1280f,40f,p)
        c.drawCircle(710f,1300f,40f,p)

        carro.forEach {
            it.move()
            it.pintar(c)
        }

        copos.forEach {
            if(i==0)
                it.velocidadBaja()
            if(i==333)
                it.velocidadAMedia()
            if(i==666)
                it.velocidadAlta()

            it.move()
            it.pintar(c)
        }
    }
}
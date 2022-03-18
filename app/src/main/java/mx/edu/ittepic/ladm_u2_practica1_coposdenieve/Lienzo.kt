package mx.edu.ittepic.ladm_u2_ejercico6_canvas_corrutinas_touchevent

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import mx.edu.ittepic.ladm_u2_practica1_coposdenieve.MainActivity

class Lienzo (mainActivity: MainActivity) : View(mainActivity){

    val thisActivity = mainActivity

    val copos = Array<Copo>(95,{Copo(this)})
    val carro = Array<Carro>(1,{Carro(this)})

    val corrutina = GlobalScope.launch {
        while (true){
            thisActivity.runOnUiThread {
                invalidate()
            }
            delay(30L)
        }
    }

    override fun onDraw(c: Canvas){
        super.onDraw(c)

        val p = Paint()

        c.drawColor(Color.rgb(75, 175, 80))

        p.color = Color.rgb(0,255,255)

        (0..20).forEach {
            c.drawRect(width/20*it+0f,it*10f,(width/20*(it+1)).toFloat()+30,(it+1)*30f,p)
        }

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


        carro.forEach {
            it.move()
            it.pintar(c)
        }

        copos.forEach {
            it.move()
            it.pintar(c)
        }
    }
}
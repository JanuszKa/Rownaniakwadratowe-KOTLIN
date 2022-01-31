package com.example.rownaniakwadratowe_kotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import kotlin.math.sqrt


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    public fun onClickRysuj(view: View) {
        val graph = findViewById<View>(R.id.graph) as GraphView
        val series = LineGraphSeries(
            arrayOf<DataPoint>()
        )
        var b: Double
        var radian: Double
        for (i in 0..360) {
            radian = i * (3.1415 / 180).toDouble()
            b = kotlin.math.sin(radian)
            series.appendData(DataPoint(i, b), true, 360)
        }
        graph.addSeries(series)
        graph.viewport.setMaxX(400.0);
        val rozwiazania = findViewById<View>(R.id.rozwiazanie)
        rozwiazania.visibility = View.VISIBLE
        rozwiaz()
    }

    private fun DataPoint(a: Int, b: Double): DataPoint {
        return DataPoint(a.toDouble(), b.toDouble())
    }

    @SuppressLint("SetTextI18n")
    private fun rozwiaz() {

        val a:Float = findViewById<EditText>(R.id.input_a).text.toString().toFloat()
        val b:Float = findViewById<TextView>(R.id.input_b).text.toString().toFloat()
        val c:Float = findViewById<TextView>(R.id.input_c).text.toString().toFloat()
        var delta:Float=b*b-4*a*c
        if(delta>0) {
            val x1 = (-b - sqrt(delta)) / (2 * a)
            val x2 = (-b + sqrt(delta)) / (2 * a)
            findViewById<TextView>(R.id.rx1).text= "X1=$x1"
            findViewById<TextView>(R.id.rx2).text= "X2=$x2"
            val rx1 = findViewById<View>(R.id.rx1)
            rx1.visibility = View.VISIBLE
            val rx2 = findViewById<View>(R.id.rx2)
            rx2.visibility = View.VISIBLE
        }
        if(delta==0f){
            val x1 = -b/(2*a)
            val x2 = -b/(2*a)
            findViewById<TextView>(R.id.rx1).text= "X1=$x1"
            findViewById<TextView>(R.id.rx2).text= "X2=$x2"
            val rx1 = findViewById<View>(R.id.rx1)
            rx1.visibility = View.VISIBLE
            val rx2 = findViewById<View>(R.id.rx2)
            rx2.visibility = View.VISIBLE
        }

        if(delta<0){
            val rozwiazania = findViewById<TextView>(R.id.rozwiazanie)
            rozwiazania.text="BRAK ROZWIĄZAŃ"
            rozwiazania.visibility = View.VISIBLE
        }



    }


}


package com.example.rownaniakwadratowe_kotlin

import android.os.Bundle
import android.view.View
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
    }

    private fun DataPoint(a: Int, b: Double): DataPoint {
        return DataPoint(a.toDouble(), b.toDouble())
    }

    private fun rozwiaz() {

        val delta:Float
        val a=findViewById<TextView>(R.id.input_a).toString().toFloat()
        val b=findViewById<TextView>(R.id.input_b).toString().toFloat()
        val c=findViewById<TextView>(R.id.input_c).toString().toFloat()
        delta=b*b-4*a*c
        if(delta>0) {
            var x1 = (-b - sqrt(delta)) / (2 * a)
            var x2 = (-b + sqrt(delta)) / (2 * a)
        }
        if(delta==0f){
            var x1 = -b/(2*a)
            var x2 = -b/(2*a)
        }

        if(delta<0){
            val rozwiazania = findViewById<TextView>(R.id.rozwiazanie)
            rozwiazania.text="BRAK ROZWIĄZAŃ"
            rozwiazania.visibility = View.VISIBLE
        }



    }


}


package com.example.rownaniakwadratowe_kotlin

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import java.lang.Math.asin


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    public fun onClickRysuj(view :View){
        val graph = findViewById<View>(R.id.graph) as GraphView
        val series = LineGraphSeries(
            arrayOf<DataPoint>()
        )
        var b:Double
        var radian:Double
        for (i in 0..360) {
            radian=i*(3.1415/180).toDouble()
            b= kotlin.math.sin(radian)
            series.appendData(DataPoint(i, b), true, 360)
        }
            graph.addSeries(series)
        graph.viewport.setMaxX(400.0);

    }
    private fun DataPoint(a: Int, b: Double): DataPoint {
        return DataPoint(a.toDouble(), b.toDouble())
    }




}


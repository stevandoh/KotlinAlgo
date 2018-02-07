package com.superconsult.algo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigInteger

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSubmit.setOnClickListener{

            if (!etNumber.text.isNullOrEmpty()){

                var startTime = System.nanoTime()
                var result = fibonacci(etNumber.text.toString().toInt()).toString()
                var endTime = System.nanoTime()
                var totalTime = (endTime - startTime)/ 1000000000.0

                txtBenchmark.text = "Running time ".plus( totalTime.toString()).plus(" seconds")

                txtResult.text = "Fibonacci Number: ".plus(result)
            }else{
                Toast.makeText(applicationContext,"Please Enter a number",Toast.LENGTH_LONG).show()
            }

        }


    }

    private fun fibonacci(n : Int): BigInteger {
        var currentValue = BigInteger.valueOf(0)
        var futureValue = BigInteger.valueOf(1)
        var temp  =BigInteger.valueOf(0)

        for (i in 0..n -1 step 1) run {

            temp = currentValue
            currentValue = futureValue
            futureValue = temp + futureValue
        }

        return currentValue
    }
}

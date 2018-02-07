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

                txtResult.text = "Result: ".plus(result)
            }else{
                Toast.makeText(applicationContext,"Please Enter a number",Toast.LENGTH_LONG).show()
            }



        }


    }

    private fun fibonacci(n : Int): BigInteger {
        var current = BigInteger.valueOf(0)
        var after = BigInteger.valueOf(1)
        var temp  =BigInteger.valueOf(0)

        for (i in 0..n -1 step 1) run {
            //            curent , after = after , current + after  1 1 2 3 5 8
//            temp = x;
//            x = y;
//            y = temp;
            temp = current
            current = after
            after = temp + after
        }
//        280571172992510140037611932413038677189525


        return current
    }
}

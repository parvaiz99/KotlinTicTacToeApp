package com.pab.tictaclocal

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

         private lateinit var ress : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ress = findViewById(R.id.res)
        ress.setOnClickListener {
            resset()
        }
    }

      fun bClick(v:View){

        val buSel = v as Button
        var cellId=0
        when(buSel.id){

            R.id.bu1 -> cellId=1
            R.id.bu2 -> cellId=2
            R.id.bu3 -> cellId=3
            R.id.bu4 -> cellId=4
            R.id.bu5 -> cellId=5
            R.id.bu6 -> cellId=6
            R.id.bu7 -> cellId=7
            R.id.bu8 -> cellId=8
            R.id.bu9 -> cellId=9

        }
        //Toast.makeText(this@MainActivity,"ID : $cellId",Toast.LENGTH_LONG).show()

          playGame(cellId,buSel)
    }

    var p1 = ArrayList<Int>()
    var p2 = ArrayList<Int>()
    var activep = 1

    fun playGame(cellId:Int,buSel:Button){

        if(activep ==1){
            buSel.text ="X"
            buSel.setBackgroundColor(resources.getColor(R.color.RoyalBlue))
            p1.add(cellId)
            activep = 2
            buSel.isEnabled=false      //button disabled

            checkWinner()
            autoPlay()
        }
        else{

                buSel.text ="O"
                buSel.setBackgroundColor(resources.getColor(R.color.Aqua))
                p2.add(cellId)
                activep = 1
            buSel.isEnabled=false      //button disabled

            checkWinner()
        }


    }

    fun checkWinner() {

        var winer = -1
        //row 1
        if (p1.contains(1) && p1.contains(2) && p1.contains(3)) {
            winer = 1
        }
        if (p2.contains(1) && p2.contains(2) && p2.contains(3)) {
            winer = 2
        }
        //row 2
        if (p1.contains(4) && p1.contains(5) && p1.contains(6)) {
            winer = 1
        }
        if (p2.contains(4) && p2.contains(5) && p2.contains(6)) {
            winer = 2
        }
        //row 2
        if (p1.contains(7) && p1.contains(8) && p1.contains(9)) {
            winer = 1
        }
        if (p2.contains(7) && p2.contains(8) && p2.contains(9)) {
            winer = 2
        }

        //col 1
        if (p1.contains(1) && p1.contains(4) && p1.contains(7)) {
            winer = 1
        }
        if (p2.contains(1) && p2.contains(4) && p2.contains(7)) {
            winer = 2
        }
        //col 2
        if (p1.contains(3) && p1.contains(6) && p1.contains(9)) {
            winer = 1
        }
        if (p2.contains(3) && p2.contains(6) && p2.contains(9)) {
            winer = 2
        }
        //col 3
        if (p1.contains(2) && p1.contains(5) && p1.contains(8)) {
            winer = 1
        }
        if (p2.contains(2) && p2.contains(5) && p2.contains(8)) {
            winer = 2
        }
        //cross
        if (p1.contains(1) && p1.contains(5) && p1.contains(9)) {
            winer = 1
        }
        if (p2.contains(1) && p2.contains(5) && p2.contains(9)) {
            winer = 2
        }
        //cross 2
        if (p1.contains(3) && p1.contains(5) && p1.contains(7)) {
            winer = 1
        }
        if (p2.contains(3) && p2.contains(5) && p2.contains(7)) {
            winer = 2
        }

        if (winer != -1) {


            var b1: Button = findViewById(R.id.bu1)
            var b2: Button = findViewById(R.id.bu2)
            var b3: Button = findViewById(R.id.bu3)
            var b4: Button = findViewById(R.id.bu4)
            var b5: Button = findViewById(R.id.bu5)
            var b6: Button = findViewById(R.id.bu6)
            var b7: Button = findViewById(R.id.bu7)
            var b8: Button = findViewById(R.id.bu8)
            var b9: Button = findViewById(R.id.bu9)

            b1.isEnabled= false
            b2.isEnabled= false
            b3.isEnabled= false
            b4.isEnabled= false
            b5.isEnabled= false
            b6.isEnabled= false
            b7.isEnabled= false
            b8.isEnabled= false
            b9.isEnabled= false

            if (winer == 1) {
                Toast.makeText(this, "...You Won... ", Toast.LENGTH_SHORT).show()
                val handler = Handler(Looper.getMainLooper())
                handler.postDelayed({
                   resset()
                }, 2000)
            } else {
                Toast.makeText(this, "...You Lost... ", Toast.LENGTH_SHORT).show()
                val handler = Handler(Looper.getMainLooper())
                handler.postDelayed({
                    resset()
                }, 2000)
            }
        }
    }
        fun autoPlay(){

            var emptyCell = ArrayList<Int>()
            for(cellId in 1..9){
                if(!(p1.contains(cellId) || p2.contains(cellId))){

                    emptyCell.add(cellId)

                }
            }
            if(emptyCell.size != 0){
            var r = Random
            val randomIndex = r.nextInt(emptyCell.size-1)+0
            val cellId = emptyCell[randomIndex]          //or .getrandomIndex

            var buSel: Button?
            when(cellId){
                1 -> buSel = findViewById(R.id.bu1)
                2 -> buSel = findViewById(R.id.bu2)
                3 -> buSel = findViewById(R.id.bu3)
                4 -> buSel = findViewById(R.id.bu4)
                5 -> buSel = findViewById(R.id.bu5)
                6 -> buSel = findViewById(R.id.bu6)
                7 -> buSel = findViewById(R.id.bu7)
                8 -> buSel = findViewById(R.id.bu8)
                9 -> buSel = findViewById(R.id.bu9)
                else -> buSel =findViewById(R.id.bu1)
            }
            playGame(cellId,buSel)
            }else{

                  Toast.makeText(this,"...Game Over...",Toast.LENGTH_LONG).show()
                val handler = Handler(Looper.getMainLooper())
                handler.postDelayed({
                    resset()
                }, 2000)
                  activep = 1
            }
        }
     fun resset() {
         var buSel: Button?
         for(cellId in 1..9){
             when (cellId) {
                 1 -> {
                     buSel = findViewById(R.id.bu1)
                     buSel.setBackgroundColor(resources.getColor(R.color.white))
                     buSel.text = ""
                     buSel.isEnabled = true
                 }
                 2 -> {
                     buSel = findViewById(R.id.bu2)
                     buSel.setBackgroundColor(resources.getColor(R.color.white))
                     buSel.text = ""
                     buSel.isEnabled = true
                 }
                 3 -> {
                     buSel = findViewById(R.id.bu3)
                     buSel.setBackgroundColor(resources.getColor(R.color.white))
                     buSel.text = ""
                     buSel.isEnabled = true
                 }
                 4 -> {
                     buSel = findViewById(R.id.bu4)
                     buSel.setBackgroundColor(resources.getColor(R.color.white))
                     buSel.text = ""
                     buSel.isEnabled = true
                 }
                 5 -> {
                     buSel = findViewById(R.id.bu5)
                     buSel.setBackgroundColor(resources.getColor(R.color.white))
                     buSel.text = ""
                     buSel.isEnabled = true
                 }
                 6 -> {
                     buSel = findViewById(R.id.bu6)
                     buSel.setBackgroundColor(resources.getColor(R.color.white))
                     buSel.text = ""
                     buSel.isEnabled = true
                 }
                 7 -> {
                     buSel = findViewById(R.id.bu7)
                     buSel.setBackgroundColor(resources.getColor(R.color.white))
                     buSel.text = ""
                     buSel.isEnabled = true
                 }
                 8 -> {
                     buSel = findViewById(R.id.bu8)
                     buSel.setBackgroundColor(resources.getColor(R.color.white))
                     buSel.text = ""
                     buSel.isEnabled = true
                 }
                 9 -> {
                     buSel = findViewById(R.id.bu9)
                     buSel.setBackgroundColor(resources.getColor(R.color.white))
                     buSel.text = ""
                     buSel.isEnabled = true
                 }

             }
         }

         p1.clear()
         p2.clear()

     }
}
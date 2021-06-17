package com.hungto.day1_kotlin.tictac_toe

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hungto.day1_kotlin.R
import kotlinx.android.synthetic.main.activity_tictactoe.*
import java.util.*
import kotlin.collections.ArrayList

class Tictactoe : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tictactoe)
    }

    fun onclick(view: View) {
        val selected: Button = view as Button
        var cellID = 0
        when (selected.id) {
            R.id.btn_1 -> cellID = 1
            R.id.btn_2 -> cellID = 2
            R.id.btn_3 -> cellID = 3
            R.id.btn_4 -> cellID = 4
            R.id.btn_5 -> cellID = 5
            R.id.btn_6 -> cellID = 6
            R.id.btn_7 -> cellID = 7
            R.id.btn_8 -> cellID = 8
            R.id.btn_9 -> cellID = 9
        }
        Playgame(cellID, selected)
        //   Toast.makeText(this, "ID" + cellID, Toast.LENGTH_SHORT).show()
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1
    fun Playgame(cellId: Int, selected: Button) {
        if (activePlayer == 1) {
            selected.setText("X")
            selected.setBackgroundColor(Color.GREEN)
            player1.add(cellId)
            activePlayer = 2
            AutoPlay()
        } else {
            selected.setText("o")
            selected.setBackgroundColor(Color.BLUE)
            player2.add(cellId)
            activePlayer = 1
        }
        selected.isEnabled = false
        CheckWinner()
    }

    //TODO:check Winner
    fun CheckWinner() {
        var winer = -1
        //row
        //TODO:player1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winer = 1
        }
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winer = 1
        }
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winer = 1
        }
        //col
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winer = 1
        }
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winer = 1
        }
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winer = 1
        }

        //cross
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winer = 1
        }
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winer = 1
        }

        //TODO:player2
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winer = 2
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winer = 2
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winer = 2
        }
        //col
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winer = 2
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winer = 2
        }
        if (player1.contains(3) && player1.contains(6) && player2.contains(9)) {
            winer = 2
        }
        //cross
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winer = 2
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winer = 2
        }
        if (winer != -1) {
            if (winer == 1) {
                Toast.makeText(this, "Player 1 win the game", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Player 2 win the game", Toast.LENGTH_SHORT).show()
            }
        }

    }

    //ToDO: auto play
    fun AutoPlay() {
        var emptyCell = ArrayList<Int>()
        for (cellID in 1..9){
            if(!(player1.contains(cellID)||player2.contains(cellID))){
                emptyCell.add(cellID)
            }
        }
        var r=Random()
        val randIndex=r.nextInt(emptyCell.size)
        val cellId=emptyCell[randIndex]
        var selected:Button?
        when(cellId){
            1->selected=btn_1
            2->selected=btn_2
            3->selected=btn_3
            4->selected=btn_4
            5->selected=btn_5
            6->selected=btn_6
            7->selected=btn_7
            8->selected=btn_8
            9->selected=btn_9
            else->{
                selected=btn_1
            }
        }
        Playgame(cellId,selected)
    }
}
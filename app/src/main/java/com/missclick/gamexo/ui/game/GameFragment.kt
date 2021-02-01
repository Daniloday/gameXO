package com.missclick.gamexo.ui.game

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.missclick.gamexo.R
import com.missclick.gamexo.data.Finish
import com.missclick.gamexo.ui.finish.FinishFragment
import kotlin.reflect.typeOf

class GameFragment : Fragment() {

    private lateinit var gameViewModel: GameViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        gameViewModel =
                ViewModelProvider(this).get(GameViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_game, container, false)


        return root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var field = mutableListOf<Int>(-1, -1, -1, -1, -1, -1, -1, -1, -1)
//        var player = 0
        val playerText : TextView = view.findViewById(R.id.result_text)

        val fieldBtn = mutableListOf<ImageView>()
        val btn0 : ImageView = view.findViewById(R.id.field1_btn)
        val btn1 : ImageView = view.findViewById(R.id.field2_btn)
        val btn2 : ImageView = view.findViewById(R.id.field3_btn)
        val btn3 : ImageView = view.findViewById(R.id.field4_btn)
        val btn4 : ImageView = view.findViewById(R.id.field5_btn)
        val btn5 : ImageView = view.findViewById(R.id.field6_btn)
        val btn6 : ImageView = view.findViewById(R.id.field7_btn)
        val btn7 : ImageView = view.findViewById(R.id.field8_btn)
        val btn8 : ImageView = view.findViewById(R.id.field9_btn)
        gameViewModel.player.observe(viewLifecycleOwner, {
            if (it == 0) playerText.text = "Player 1"
            else playerText.text = "Player 2"
        })
        fieldBtn.add(btn0)
        fieldBtn.add(btn1)
        fieldBtn.add(btn2)
        fieldBtn.add(btn3)
        fieldBtn.add(btn4)
        fieldBtn.add(btn5)
        fieldBtn.add(btn6)
        fieldBtn.add(btn7)
        fieldBtn.add(btn8)

        for (i in 0..8){
            fieldBtn[i].setOnClickListener {
                if (field[i] == -1){
                    field[i] = gameViewModel.player.value!!
                    if (gameViewModel.player.value!! == 0) fieldBtn[i].setImageResource(R.drawable.first)
                    else fieldBtn[i].setImageResource(R.drawable.second)
                    gameViewModel.changePlayer()
                    val result = checkEnd(field = field)
                    gameViewModel.player.observe(viewLifecycleOwner, {
                        if (it == 0) playerText.text = "Player 1"
                        else playerText.text = "Player 2"
                    })
                    if (result != -1) {
                        val finish = Finish(field = field, winner = result)
                        it.findNavController().navigate(R.id.navigation_finish, FinishFragment.newInstance(result = finish))
                    }

                }

            }
        }
    }

    private fun checkEnd(field : MutableList<Int>): Int{
        for (j in 0..1) {
            for (i in 0..2) {
                if (field[3 * i] == j && field[3 * i + 1] == j && field[3 * i + 2] == j) return j
                if (field[i] == j && field[3 + i] == j && field[6 + i] == j) return j
            }
            if (field[0] == j && field[4] == j && field[8] == j) return j
            if (field[2] == j && field[4] == j && field[6] == j) return j
        }
        for (j in 0..8) {
            if (field[j] == -1) return -1
        }
        return 2
    }

}
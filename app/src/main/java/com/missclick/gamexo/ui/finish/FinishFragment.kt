package com.missclick.gamexo.ui.finish

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.missclick.gamexo.MainActivity
import com.missclick.gamexo.R
import com.missclick.gamexo.data.Finish

class FinishFragment : Fragment() {

    private lateinit var finishViewModel: FinishViewModel
    private var result: Finish? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            result = it.getSerializable("result") as Finish?
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        finishViewModel =
                ViewModelProvider(requireActivity()).get(FinishViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_finish, container, false)
//        val textView: TextView = root.findViewById(R.id.text_notifications)
        finishViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
        })
        return root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val resultText : TextView = view.findViewById(R.id.result_text)
        if (result!!.winner == 2) resultText.text = "No winner"
        else resultText.text = "Winner: player ${result!!.winner + 1}"
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
            if (result!!.field[i] == 0) fieldBtn[i].setImageResource(R.drawable.first)
            if (result!!.field[i] == 1) fieldBtn[i].setImageResource(R.drawable.second)
        }
        finishViewModel.saveResult(result!!)
        val restartBtn : ImageView = view.findViewById(R.id.restart_btn)
        restartBtn.setOnClickListener {
            it.findNavController().navigate(R.id.navigation_game)
        }
    }

    companion object {
        fun newInstance(result : Finish):Bundle{
            return Bundle().apply {
                putSerializable("result", result)
            }
        }
    }

}
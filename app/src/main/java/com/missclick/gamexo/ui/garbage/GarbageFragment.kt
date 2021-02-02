package com.missclick.gamexo.ui.garbage

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.missclick.gamexo.MainActivity
import com.missclick.gamexo.R
import com.missclick.gamexo.adapters.ResultsAdapter
import com.missclick.gamexo.data.Finish

class GarbageFragment : Fragment() {

    companion object {
        fun newInstance() = GarbageFragment()
    }

    private lateinit var viewModel: GarbageViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.garbage_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GarbageViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btn1 = view.findViewById<Button>(R.id.button)
        val btn2 = view.findViewById<Button>(R.id.button2)
        val btn3 = view.findViewById<Button>(R.id.button3)
        val btn4 = view.findViewById<Button>(R.id.button4)

        btn1.setOnClickListener {
            viewModel.btn1(activity as MainActivity)
        }
        btn2.setOnClickListener {
            viewModel.btn2(activity as MainActivity)
        }
        btn3.setOnClickListener {
            viewModel.btn3(activity as MainActivity)
        }
        btn4.setOnClickListener {
            viewModel.btn4(activity as MainActivity)
        }
        val recycle = view.findViewById<RecyclerView>(R.id.recycler)
        val f : MutableList<Finish> = mutableListOf()
        recycle.adapter = ResultsAdapter(
            f as MutableList<Finish>,
            object : ResultsAdapter.Callback {
                override fun onItemClicked(item: Finish) {

                }
            }
        )


        recycle.layoutManager = LinearLayoutManager(activity as MainActivity)
    }


}
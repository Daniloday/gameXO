package com.missclick.gamexo.ui.start

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
import com.missclick.gamexo.R

class StartFragment : Fragment() {

    private lateinit var startViewModel: StartViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        startViewModel =
                ViewModelProvider(this).get(StartViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_start, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        startViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        val start : ImageView = root.findViewById(R.id.start_btn)
        start.setOnClickListener {
            it.findNavController().navigate(R.id.navigation_game)
        }
        return root
    }
}
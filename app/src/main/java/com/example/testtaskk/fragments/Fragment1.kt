package com.example.testtaskk.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testtaskk.Item
import com.example.testtaskk.R
import com.example.testtaskk.RcViewAdapter
import com.example.testtaskk.databinding.Fragment1Binding
import com.example.testtaskk.items


class Fragment1 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = Fragment1Binding.inflate(inflater, container, false)
        val rcView = binding.rcView


        val adapter = RcViewAdapter(items)
        rcView.adapter = adapter
        rcView.layoutManager = LinearLayoutManager(activity)
        return binding.root
    }

}
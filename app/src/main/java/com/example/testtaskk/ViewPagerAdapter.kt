package com.example.testtaskk

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.testtaskk.fragments.Fragment1
import com.example.testtaskk.fragments.Fragment2
import com.example.testtaskk.fragments.Fragment3
import com.example.testtaskk.fragments.Fragment4

private const val NUM_TABS = 4

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle):
        FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return Fragment1()
            1 -> return Fragment2()
            2 -> return Fragment3()
            3 -> return Fragment4()
        }
        return Fragment4()

    }
}
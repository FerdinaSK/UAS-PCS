package com.ferdinask.github.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ferdinask.github.ui.fragment.FollowersFragment
import com.ferdinask.github.ui.fragment.FollowingFragment



class TabsAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 2
    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return FollowersFragment()
            1 -> return FollowingFragment()
        }
        return FollowersFragment()
    }

}
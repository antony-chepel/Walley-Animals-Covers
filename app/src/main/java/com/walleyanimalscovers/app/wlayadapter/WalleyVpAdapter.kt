package com.walleyanimalscovers.app.wlayadapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class WalleyVpAdapter(fa : FragmentActivity, private val fragList : List<Fragment>)  : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return fragList.size
    }

    override fun createFragment(position: Int): Fragment {
       return fragList[position]
    }
}
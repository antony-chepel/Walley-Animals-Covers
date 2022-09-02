package com.walleyanimalscovers.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.walleyanimalscovers.app.databinding.MainScreenWalleyBinding
import com.walleyanimalscovers.app.wlayadapter.WalleyVpAdapter
import com.walleyanimalscovers.app.wleyscreens.CatsFragment
import com.walleyanimalscovers.app.wleyscreens.DogsFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainScreenWalleyBinding
    private lateinit var vpAdapter : WalleyVpAdapter
    val idsfsdfsd = listOf<Fragment>(CatsFragment.newInstance(),DogsFragment.newInstance())
    val jdksdsdksd = listOf<String>("Cats","Dogs")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainScreenWalleyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }


    private fun init() = with(binding){
        vpAdapter = WalleyVpAdapter(this@MainActivity,idsfsdfsd)
        viewPwalley.adapter = vpAdapter
        TabLayoutMediator(tabLayout,viewPwalley){
                tab,pos ->
            tab.text = jdksdsdksd[pos]
        }.attach()

    }
}
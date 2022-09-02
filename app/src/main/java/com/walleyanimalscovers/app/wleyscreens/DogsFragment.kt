package com.walleyanimalscovers.app.wleyscreens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.walleyanimalscovers.app.databinding.FragmentDogsBinding
import com.walleyanimalscovers.app.wlayadapter.WalleyAnimalsAdapter
import com.walleyanimalscovers.app.wlayutils.WalleyAnimalsUtils


class DogsFragment : Fragment() {

    private lateinit var binding : FragmentDogsBinding
    private var adapterAurum : WalleyAnimalsAdapter? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDogsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rcAurumInit()
    }
    private fun rcAurumInit() = with(binding){
        adapterAurum = WalleyAnimalsAdapter(WalleyAnimalsUtils.dogArray,activity as AppCompatActivity)
        rcDogs.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.VERTICAL,false)
        rcDogs.adapter = adapterAurum

    }

    companion object {
        @JvmStatic
        fun newInstance() = DogsFragment()
    }
}
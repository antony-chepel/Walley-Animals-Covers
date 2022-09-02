package com.walleyanimalscovers.app.wleyscreens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.walleyanimalscovers.app.databinding.FragmentCatsBinding
import com.walleyanimalscovers.app.wlayadapter.WalleyAnimalsAdapter
import com.walleyanimalscovers.app.wlayutils.WalleyAnimalsUtils


class CatsFragment : Fragment() {

    private lateinit var binding : FragmentCatsBinding
    private var adapterAurum : WalleyAnimalsAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCatsBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rcAurumInit()

    }

    private fun rcAurumInit() = with(binding){
        adapterAurum = WalleyAnimalsAdapter(WalleyAnimalsUtils.catArray,activity as AppCompatActivity)
        rcCats.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        rcCats.adapter = adapterAurum

    }

    companion object {

        @JvmStatic
        fun newInstance() = CatsFragment()
    }
}
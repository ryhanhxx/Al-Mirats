package com.ch.al_mirats.presentation.fatwa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.ch.al_mirats.databinding.FragmentFatwaBinding
import com.ch.al_mirats.dummy.DummyFatwaDataSource
import com.ch.al_mirats.dummy.DummyFatwaDataSourceImpl
import com.ch.al_mirats.model.Fatwa
import com.ch.al_mirats.model.Materi
import com.ch.al_mirats.presentation.fatwa.adapter.FatwaAdapter
import com.ch.al_mirats.presentation.materi.MateriActivity
import com.ch.al_mirats.utils.AdapterLayoutMode

class FatwaFragment : Fragment() {

    private lateinit var binding: FragmentFatwaBinding

    private val datasource: DummyFatwaDataSource by lazy {
        DummyFatwaDataSourceImpl()
    }

    private val adapter: FatwaAdapter by lazy {
        FatwaAdapter(AdapterLayoutMode.LINEAR){ fatwa: Fatwa ->
            navigateToDetailFragment(fatwa)
        }
    }

    private fun navigateToDetailFragment(fatwa: Fatwa) {
        FatwaActivity.startActivity(requireContext(), fatwa)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFatwaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupList()
        setupSwitch()
    }

    private fun setupList() {
        val span = if(adapter.adapterLayoutMode == AdapterLayoutMode.LINEAR) 1 else 2
        binding.rvMateri.apply {
            layoutManager = GridLayoutManager(requireContext(),span)
            adapter = this@FatwaFragment.adapter
        }
        adapter.setItems(datasource.getFatwaData(requireContext()))
    }

    private fun setupSwitch() {
        binding.swGrid.setOnCheckedChangeListener { _, isChecked ->
            (binding.rvMateri.layoutManager as GridLayoutManager).spanCount = if (isChecked) 2 else 1
            adapter.adapterLayoutMode = if(isChecked) AdapterLayoutMode.GRID else AdapterLayoutMode.LINEAR
            adapter.refreshList()
        }
    }

}
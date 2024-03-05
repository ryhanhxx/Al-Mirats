package com.ch.al_mirats.presentation.materi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.ch.al_mirats.databinding.FragmentMateriBinding
import com.ch.al_mirats.dummy.DummyMateriDataSource
import com.ch.al_mirats.dummy.DummyMateriDataSourceImpl
import com.ch.al_mirats.model.Materi
import com.ch.al_mirats.utils.AdapterLayoutMode
import com.ch.al_mirats.presentation.materi.adapter.MateriAdapter

class MateriFragment : Fragment() {

    private lateinit var binding: FragmentMateriBinding

    private val adapter: MateriAdapter by lazy {
        MateriAdapter(AdapterLayoutMode.LINEAR){ materi: Materi ->
            navigateToDetailFragment(materi)
        }
    }

    private val datasource: DummyMateriDataSource by lazy {
        DummyMateriDataSourceImpl()
    }

    private fun navigateToDetailFragment(materi: Materi) {
        MateriActivity.startActivity(requireContext(), materi)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMateriBinding.inflate(inflater, container, false)
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
            adapter = this@MateriFragment.adapter
        }
        adapter.setItems(datasource.getMateriData(requireContext()))
    }

    private fun setupSwitch() {
        binding.swGrid.setOnCheckedChangeListener { _, isChecked ->
            (binding.rvMateri.layoutManager as GridLayoutManager).spanCount = if (isChecked) 2 else 1
            adapter.adapterLayoutMode = if(isChecked) AdapterLayoutMode.GRID else AdapterLayoutMode.LINEAR
            adapter.refreshList()
        }
    }


}
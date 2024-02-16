package com.ch.al_mirats.presentation.materi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ch.al_mirats.databinding.FragmentMateriBinding
import com.ch.al_mirats.dummy.DummyHomeDataSourceImpl
import com.ch.al_mirats.dummy.DummyMateriDataSourceImpl
import com.ch.al_mirats.presentation.home.adapter.HomeAdapter
import com.ch.al_mirats.presentation.materi.adapter.MateriAdapter

class MateriFragment : Fragment() {

    private lateinit var binding: FragmentMateriBinding

    // This property is only valid between onCreateView and
    // onDestroyView.

    private val adapterMateri: MateriAdapter by lazy {
        MateriAdapter {

        }
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
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.rvHome.adapter = adapterMateri
        adapterMateri.setItems(DummyMateriDataSourceImpl().getMateriData())
    }
}
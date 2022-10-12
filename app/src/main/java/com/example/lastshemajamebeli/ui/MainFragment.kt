package com.example.lastshemajamebeli.ui

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lastshemajamebeli.BaseFragment
import com.example.lastshemajamebeli.Resource
import com.example.lastshemajamebeli.adapters.UsersAdapter
import com.example.roomtest.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {
    private val teamsAdapter: UsersAdapter by lazy { UsersAdapter() }
    private val teamsViewModel: MainViewModel by viewModels()


    override fun viewCreated() {
        get()
        teamsViewModel.setData()
    }

    override fun listeners() {


    }

    private fun get() {
        setupRecycler()
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                teamsViewModel.info.collectLatest {
                        when(it){
                            is Resource.Error -> Log.d("TAG", " ${it.error}")
                            is Resource.Loading -> Log.d("TAG", " ${it.loading}")
                            is Resource.Success -> teamsAdapter.submitList(it.data)
                        }
                }
            }
        }
    }


    private fun setupRecycler() {
        binding.recyclerView.apply {
            adapter = teamsAdapter
            layoutManager =
                LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.VERTICAL,
                    false
                )
        }
    }

}
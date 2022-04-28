package com.example.spacex.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.spacex.R
import androidx.navigation.fragment.findNavController
import com.example.spacex.core.Resource
import com.example.spacex.databinding.FragmentLaunchesBinding
import com.example.spacex.presentation.adapter.SpaceAdapter
import com.example.spacex.presentation.viewmodel.SpacesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class LaunchesFragment : Fragment() {

    private lateinit var binding: FragmentLaunchesBinding
    private val spaceAdapter by lazy { SpaceAdapter() }
    private val viewModel by viewModels<SpacesViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLaunchesBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.launchesRv.adapter = spaceAdapter
        viewModel.queryLaunches()
        observeLiveData()

        spaceAdapter.onItemClicked = { launches ->
            launches.let {
                if (!launches.mission_name.isNullOrBlank()) {
                    findNavController().navigate(
                        LaunchesFragmentDirections.actionLaunchesFragmentToLaunchDetailsFragment(
                            id = launches.mission_name
                        )
                    )
                }
            }
        }

    }

    private fun observeLiveData() {
        viewModel.launches.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Loading -> {
                    binding.launchesRv.visibility = View.GONE
                    binding.launchesFetchProgress.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    if (response.value?.data?.launches?.size == 0) {
                        spaceAdapter.submitList(emptyList())
                        binding.launchesFetchProgress.visibility = View.GONE
                        binding.launchesRv.visibility = View.GONE
                        binding.launchesEmptyText.visibility = View.VISIBLE
                    } else {
                        binding.launchesRv.visibility = View.VISIBLE
                        binding.launchesEmptyText.visibility = View.GONE
                    }
                    val results = response.value?.data?.launches
                    spaceAdapter.submitList(results)
                    binding.launchesFetchProgress.visibility = View.GONE
                }
                is Resource.Error -> {
                    spaceAdapter.submitList(emptyList())
                    binding.launchesFetchProgress.visibility = View.GONE
                    binding.launchesRv.visibility = View.GONE
                    binding.launchesEmptyText.visibility = View.VISIBLE
                }
            }
        }
    }

}
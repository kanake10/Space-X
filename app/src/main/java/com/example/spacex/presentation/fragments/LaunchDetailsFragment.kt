package com.example.spacex.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import coil.annotation.ExperimentalCoilApi
import com.example.spacex.core.Resource
import com.example.spacex.databinding.FragmentLaunchDetailsBinding
import com.example.spacex.presentation.viewmodel.SpacesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class LaunchDetailsFragment : Fragment() {

    private lateinit var binding: FragmentLaunchDetailsBinding
    private val args: LaunchDetailsFragmentArgs by navArgs()

    private val viewModel by viewModels<SpacesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLaunchDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val launchId = args.id
       viewModel.queryLaunchDetails(launchId)
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.launchDetails.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Loading -> {

                    binding.launchesFetchProgress.visibility = View.VISIBLE
                    binding.launchesEmptyText.visibility = View.GONE
                }
                is Resource.Success -> {
                    if (response.value?.data?.launch == null) {
                        binding.launchesFetchProgress.visibility = View.GONE
                       binding.launchesEmptyText.visibility = View.VISIBLE
                    } else {
                        binding.launchDetails = response.value.data
                        binding.launchesFetchProgress.visibility = View.GONE
                        binding.launchesEmptyText.visibility = View.GONE
                    }
                }
                is Resource.Error -> {
                    binding.launchesFetchProgress.visibility = View.GONE
                   binding.launchesEmptyText.visibility = View.VISIBLE
                }
            }
        }
    }
}
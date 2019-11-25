package com.trantordev.superheroapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe

import com.trantordev.superheroapp.adapters.MainAdapter
import com.trantordev.superheroapp.databinding.FragmentMainBinding
import com.trantordev.superheroapp.util.InjectorUtils
import com.trantordev.superheroapp.viewmodel.MainViewModel


class MainFragment : Fragment(), MainListener {

    private lateinit var binding: FragmentMainBinding

    private val viewModel: MainViewModel by viewModels {
        InjectorUtils.provideMainListViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        context ?: return binding.root
        val adapter = MainAdapter()
        binding.heroList.adapter = adapter
        binding.viewmodel = viewModel
        viewModel.mainListener = this
        subscribeUi(adapter)

        setHasOptionsMenu(true)
        return binding.root
    }


    private fun subscribeUi(adapter: MainAdapter) {

        viewModel.heroes.observe(viewLifecycleOwner) { result ->
            adapter.submitList(result.heroes)
            //binding.progressBarStatementLayout.visibility = View.GONE
        }

    }

    override fun onClose(){
        activity!!.finish()
    }
}

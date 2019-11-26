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
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment(), MainListener {

    private lateinit var binding: FragmentMainBinding
    private var ano: Int = 2003
    private val adapter = MainAdapter()

    private val viewModel: MainViewModel by viewModels {
        InjectorUtils.provideMainListViewModelFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        context ?: return binding.root
        binding.heroList.adapter = adapter
        binding.viewmodel = viewModel
        viewModel.mainListener = this
        viewModel.year = ano;
        subscribeUi()
        setHasOptionsMenu(true)
        return binding.root
    }


    private fun subscribeUi() {

        viewModel.loadNext().observe(viewLifecycleOwner) { result ->
            swipeContainer.isRefreshing = false
            textViewYear.text = viewModel.year.toString()
            adapter.submitList(result.heroes)
        }

    }

    override fun onClose() {
        activity!!.finish()
    }

    override fun onRefresh() {
        subscribeUi()
    }
}

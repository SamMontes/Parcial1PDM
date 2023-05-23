package com.example.parcial1samael.ui.sculpture.sculpturelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parcial1samael.R
import com.example.parcial1samael.data.models.SculptureModel
import com.example.parcial1samael.databinding.FragmentListBinding
import com.example.parcial1samael.ui.sculpture.sculpturelist.recyclerview.SculptureRecyclerViewAdapter
import com.example.parcial1samael.ui.sculpture.viewmodel.SculptureViewModel

class ListFragment : Fragment() {

    private val sculptureViewModel: SculptureViewModel by activityViewModels{
        SculptureViewModel.Factory
    }

    private lateinit var adapter: SculptureRecyclerViewAdapter

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.btnNavCreateNewSculpture.setOnClickListener {
            sculptureViewModel.clearData()
            it.findNavController().navigate(R.id.action_listFragment_to_createFragment)
        }
    }

    private fun setRecyclerView(view: View){
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = SculptureRecyclerViewAdapter{selectedSculpture ->
            showSelectedItem(selectedSculpture)
        }

        binding.recyclerView.adapter = adapter
        displaySculptures()
    }

    private fun showSelectedItem(sculpture: SculptureModel){
        sculptureViewModel.setSelectedSculpture(sculpture)
        findNavController().navigate(R.id.action_listFragment_to_informationFragment)
    }

    private fun displaySculptures(){
        adapter.setData(sculptureViewModel.getSculptures())
        adapter.notifyDataSetChanged()
    }


}
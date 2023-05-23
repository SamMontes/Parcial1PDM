package com.example.parcial1samael.ui.sculpture.newsculpture

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.parcial1samael.R
import com.example.parcial1samael.databinding.FragmentCreateBinding
import com.example.parcial1samael.ui.sculpture.viewmodel.SculptureViewModel

class CreateFragment : Fragment() {
    private val viewModel: SculptureViewModel by activityViewModels{
        SculptureViewModel.Factory
    }

    private lateinit var binding: FragmentCreateBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCreateBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        observeStatus()
    }

    private fun setViewModel(){
        binding.viewmodel = viewModel
    }

    private fun observeStatus(){
        viewModel.status.observe(viewLifecycleOwner){status ->
            when{
                status.equals(SculptureViewModel.SCULPTURE_CREATED) -> {
                    Log.d("APP_TAG", status)
                    Log.d("APP_TAG", viewModel.getSculptures().toString())

                    viewModel.clearStatus()
                    viewModel.clearData()

                    findNavController().popBackStack()
                }
                status.equals(SculptureViewModel.WRONG_DATA) -> {
                    Log.d("APP_TAG", status)
                    viewModel.clearStatus()
                }
            }
        }
    }

    private fun createMovie(){
        //viewModel.addMovies(newMovie)

        Log.d("APP TAG", viewModel.getSculptures().toString())

        findNavController().popBackStack()
    }


}
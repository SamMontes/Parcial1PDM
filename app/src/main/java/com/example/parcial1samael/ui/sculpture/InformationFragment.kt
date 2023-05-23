package com.example.parcial1samael.ui.sculpture

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.parcial1samael.R
import com.example.parcial1samael.databinding.FragmentInformationBinding
import com.example.parcial1samael.ui.sculpture.viewmodel.SculptureViewModel

class InformationFragment : Fragment() {
    private val ViewModel: SculptureViewModel by activityViewModels{
        SculptureViewModel.Factory
    }

    private lateinit var binding: FragmentInformationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_information, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewSculpture()
    }

    private fun setViewSculpture(){
        binding.viewmodel = ViewModel
        /*binding.imageView.setOnClickListener {
            Toast.makeText(requireContext(), "Movie", Toast.LENGTH_SHORT).show()
        }*/
    }

}
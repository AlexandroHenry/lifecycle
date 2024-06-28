package com.ret.lifecycle.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ret.lifecycle.R
import com.ret.lifecycle.databinding.FragmentABinding
import com.ret.lifecycle.databinding.FragmentBBinding

class BFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentBBinding? = null

    private val binding get() = _binding!!

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBBinding.inflate(inflater, container, false)

        with(binding) {
            backBtn.setOnClickListener(this@BFragment)
            moveToCBtn.setOnClickListener(this@BFragment)
        }

        return binding.root
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.backBtn -> {
                findNavController().popBackStack()
            }

            binding.moveToCBtn -> {
                findNavController().navigate(R.id.action_BFragment_to_CFragment)
            }
        }
    }
}
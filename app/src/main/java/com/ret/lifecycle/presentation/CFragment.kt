package com.ret.lifecycle.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ret.lifecycle.R
import com.ret.lifecycle.databinding.FragmentCBinding

class CFragment : Fragment(), View.OnClickListener  {
    private var _binding: FragmentCBinding? = null

    private val binding get() = _binding!!

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCBinding.inflate(inflater, container, false)

        with(binding) {
            moveToABtn.setOnClickListener(this@CFragment)
            moveBackBtn.setOnClickListener(this@CFragment)
        }

        return binding.root
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.moveToABtn -> {
                findNavController().navigate(R.id.action_CFragment_to_AFragment)
            }

            binding.moveBackBtn -> {
                findNavController().popBackStack()
            }
        }
    }
}
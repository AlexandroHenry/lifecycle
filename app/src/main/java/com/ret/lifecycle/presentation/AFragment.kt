package com.ret.lifecycle.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ret.lifecycle.R
import com.ret.lifecycle.constants.logger
import com.ret.lifecycle.databinding.FragmentABinding

class AFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentABinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logger("onCreate 이 실행된다")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        logger("onCreateView 이 실행된다")
        _binding = FragmentABinding.inflate(inflater, container, false)

        with(binding) {
            moveBtn.setOnClickListener(this@AFragment)
        }

        return binding.root
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        logger("onViewStateRestored 이 실행된다")
    }

    override fun onStart() {
        super.onStart()
        logger("onStart 이 실행된다")
    }

    override fun onResume() {
        super.onResume()
        logger("onResume 이 실행된다")
    }

    override fun onPause() {
        super.onPause()
        logger("onPause 이 실행된다")
    }

    override fun onStop() {
        super.onStop()
        logger("onStop 이 실행된다")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        logger("onSaveInstanceState 이 실행된다")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        logger("onDestroyView 이 실행된다")
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        logger("onDestroy 이 실행된다")
    }

    override fun onClick(v: View?) {
        when(v) {
            binding.moveBtn -> {
                findNavController().navigate(R.id.action_AFragment_to_BFragment)
            }
        }
    }
}
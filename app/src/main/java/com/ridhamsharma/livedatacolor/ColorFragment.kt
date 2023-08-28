package com.ridhamsharma.livedatacolor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ridhamsharma.livedatacolor.databinding.FragmentColorBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ColorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ColorFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentColorBinding
    lateinit var mainActivity: MainActivity
    lateinit var colorViewModel: ColorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = activity as MainActivity
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentColorBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        colorViewModel = ViewModelProvider(mainActivity)[ColorViewModel::class.java]
        colorViewModel.color.observe(mainActivity) {
            System.out.println("in observe method $it")
            when (it) {
                1 -> binding.fragView.setBackgroundColor(
                    ContextCompat.getColor(
                        mainActivity,
                        R.color.red
                    )
                )

                2 -> binding.fragView.setBackgroundColor(
                    ContextCompat.getColor(
                        mainActivity,
                        R.color.blue
                    )
                )

                3 -> binding.fragView.setBackgroundColor(
                    ContextCompat.getColor(
                        mainActivity,
                        R.color.green
                    )
                )
            }
        }
        colorViewModel.number.observe(mainActivity) {
            binding.tvInsertNumberFragment.setText(it.toString())
        }

                binding.btnClear.setOnClickListener {
                    var num = 0
                    binding.tvInsertNumberFragment.setText(num.toString())
                    colorViewModel.number.value = num

                }


        }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ColorFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ColorFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}

package com.example.spaceapp.ui.home

import android.app.ActionBar
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.spaceapp.MainActivity
import com.example.spaceapp.R
import com.example.spaceapp.databinding.FragmentHomeBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog


class HomeFragment : Fragment() {
    //bottomSheet
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<FrameLayout>


    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
/*
    val textView: TextView = binding.textHome
    homeViewModel.text.observe(viewLifecycleOwner, Observer {
      textView.text = it
    })*/

    bottomSheetBehavior = BottomSheetBehavior.from(binding.root.findViewById(R.id.persistent_bottom_sheet))

    (activity as? AppCompatActivity)?.supportActionBar?.title = "Launches"

            return root
    }

  private fun expandCollapseSheet() {
    if (bottomSheetBehavior.state != BottomSheetBehavior.STATE_EXPANDED) {
      bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
    } else {
      bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
    }
  }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
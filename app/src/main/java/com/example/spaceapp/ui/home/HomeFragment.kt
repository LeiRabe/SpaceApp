package com.example.spaceapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spaceapp.R
import com.example.spaceapp.RecyclerAdapter
import com.example.spaceapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

  // --------------------------- Recycler View display ------------- //

  private lateinit var homeViewModel: HomeViewModel
  private var _binding: FragmentHomeBinding? = null

  // ------------------------- Binding --------------------------------- //
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

    return binding.root
  }

  override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
    super.onViewCreated(itemView, savedInstanceState)
    itemView.findViewById<RecyclerView>(R.id.recycler_view).apply {
      // set a LinearLayoutManager to handle Android
      // RecyclerView behavior
      layoutManager = LinearLayoutManager(activity)
      // set the custom adapter to the RecyclerView
      adapter = RecyclerAdapter()
    }
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
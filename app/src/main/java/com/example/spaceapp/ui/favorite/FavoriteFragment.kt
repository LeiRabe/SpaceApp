package com.example.spaceapp.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.spaceapp.databinding.FragmentFavoriteBinding
import com.example.spaceapp.ui.home.HomeFragment

class FavoriteFragment : Fragment() {

  private lateinit var favoriteViewModel: FavoriteViewModel
private var _binding: FragmentFavoriteBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    favoriteViewModel =
            ViewModelProvider(this).get(FavoriteViewModel::class.java)

    _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
    val root: View = binding.root

    val textView: TextView = binding.textFavorite
    favoriteViewModel.text.observe(viewLifecycleOwner, Observer {
      textView.text = it
    })
    (activity as? AppCompatActivity)?.supportActionBar?.title = "Favorites"

    return root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
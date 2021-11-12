package com.example.spaceapp.ui.iss

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.spaceapp.databinding.FragmentIssBinding

class IssFragment : Fragment() {

  private lateinit var issViewModel: IssViewModel
private var _binding: FragmentIssBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    issViewModel =
            ViewModelProvider(this).get(IssViewModel::class.java)

    _binding = FragmentIssBinding.inflate(inflater, container, false)
    val root: View = binding.root

      (activity as? AppCompatActivity)?.supportActionBar?.title = "International Space Station"
    return root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.example.spaceapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.telecom.Call
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.spaceapp.R
import com.example.spaceapp.databinding.FragmentHomeBinding
import com.example.spaceapp.retrofit.Launch
import com.example.spaceapp.retrofit.model.LaunchResult

class HomeFragment : Fragment(){
  private lateinit var listFavorite:ArrayList<Int>
  //call api
  private val api: Launch = Launch()

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

    val root: View = binding.root
    //button handler
    // get reference to button
    val recyclerView : View = root.findViewById(R.id.recycler_view)

    //test api
    Log.d("FRAGMENT","test")

      return binding.root
  }

  override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
    super.onViewCreated(itemView, savedInstanceState)

      //set the listener on the button star (favorite button)
      var btnStar : ImageButton = itemView.findViewById(R.id.favorite_star_button)
      //btnStar.setOnClickListener(View.OnClickListener {
      //})


      //call Launch to get the data
    var recyclerView : RecyclerView = itemView.findViewById(R.id.recycler_view)
    api.displayAllLaunches(recyclerView, activity)
  }

  override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
  }

  fun getListFavorites() : ArrayList<LaunchResult>{
    var data = api.getResults()
    var favorite : ArrayList<LaunchResult> = ArrayList(listFavorite.size)

    for (c in listFavorite){
      favorite.add(data[c])
    }
    return favorite
  }

    fun onclickImage(view: View){
        val btnStar = view.tag.toString()

        var present = false

        for (c in listFavorite){
            if (c.equals(btnStar)){
                listFavorite.remove(c)
                present = true
            }
        }
        if(!present)
            listFavorite.add(btnStar as Int)

    }

}
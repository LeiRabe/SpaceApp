package com.example.spaceapp

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.spaceapp.retrofit.model.LaunchResult
import com.example.spaceapp.retrofit.model.LaunchResultPad
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class RecyclerAdapter(dataList:List<LaunchResult>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    //données recueillies : name, image, date de lancement, description de la fusée, nom de la fusée, abbréviation
    //manque ça :  date de lancement, description de la fusée
    var titles : ArrayList<String?> = ArrayList(dataList.size)
    var status : ArrayList<String?> = ArrayList(dataList.size)
    var launchServiceProvider : ArrayList<String?> = ArrayList(dataList.size)
    var images : ArrayList<String?> = ArrayList(dataList.size)
    var launchResultPad : ArrayList<LaunchResultPad?> = ArrayList(dataList.size)
    var dateLaunch : ArrayList<String?> = ArrayList(dataList.size)

    init {
        for(c in dataList) {
            //données recueillies :
            // name, image, date de lancement, description de la fusée,
            // nom de la fusée, abbréviation
            images.add(c.image!!)
            titles.add(c.name!!)
            status.add(c.status!!.abbrev!!)
            launchServiceProvider.add(c.launch_service_provider!!.name!!)
            launchResultPad.add(c.pad!!)
            dateLaunch.add(c.net!!)
            Log.d("ALL LAUNCHES FROM API", "one launch: ${c.name} : ${c.pad}")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_upcoming_events, parent, false)
        return ViewHolder(v)
    }

    //populate our data to our card view
    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemPad.text = launchResultPad[position]?.location?.name
        holder.itemProvider.text = launchServiceProvider[position]

        //Status background set
        holder.itemStatus.text = status[position]

        var gd = GradientDrawable()
        gd.mutate()
        gd.cornerRadius = 20.0F
        Log.d("ALL LAUNCHES FROM API", "one launch: ${status[position]}")
        if(status[position].equals("Go"))
            gd.setColor(Color.parseColor("#48c82d"))
        else
            gd.setColor(Color.parseColor("#e67e30"))


        holder.itemStatus.background = gd

        //Image set
         Picasso.get().load(images[position]).into(holder.itemImage)

        //date launch set
        var day:String
        var month:String
        var year: String

        val date = dateLaunch[position]!!.trim().substringBefore("T")
        year = date.trim().substringBefore("-")
        val intermediate = date.trim().substringAfter("-")
        month = intermediate.trim().substringBefore("-")
        day = intermediate.trim().substringAfter("-")

        var time = dateLaunch[position]!!.trim().substringAfter("T").substringBefore("Z")

        holder.itemDate.text = "${day}/${month}/${year} ${time} UTC"

        //favorite star tag
        holder.itemFavorite.tag = position

    }

    //identify how many items are we passing to our view holder
    override fun getItemCount(): Int {
        Log.d("ADAPTER", "one launch: $titles")
        return titles.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemPad: TextView
        var itemStatus : TextView
        var itemProvider : TextView
        var itemDate : TextView
        var itemFavorite : ImageButton

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle= itemView.findViewById(R.id.item_title)
            itemPad = itemView.findViewById(R.id.item_pad)
            itemStatus = itemView.findViewById(R.id.item_status)
            itemProvider = itemView.findViewById(R.id.item_provider)
            itemDate = itemView.findViewById(R.id.item_date)
            itemFavorite = itemView.findViewById(R.id.favorite_star_button);

            itemView.setOnClickListener{
                //todo: what do we want to do/get when we click on one item
                //todo: start an another activity while clicking in a card
            }
        }




    }
}
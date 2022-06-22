package com.ilaydabykakova.landmarkbook

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ilaydabykakova.landmarkbook.databinding.RecyclerRowBinding

class LandmarkAdapter(val landmarkList : ArrayList<Landmark>) : RecyclerView.Adapter <LandmarkAdapter.LandmarkHolder>() {
    //itemView : binding root -> image or text
    class LandmarkHolder(val binding : RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandmarkHolder {
        //We connected to layout
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LandmarkHolder(binding)
    }

    override fun onBindViewHolder(holder: LandmarkHolder, position: Int) {
        holder.binding.recyclerRowTextView.text = landmarkList.get(position).name

        holder.itemView.setOnClickListener(){
            // holder.itemView.context -> reach the main
            val intent = Intent(holder.itemView.context,DetailsActivity::class.java)
            //chosenLandmark = landmarkList.get(position)
            //intent.putExtra("landmark",landmarkList.get(position))
            MySingleton.chosenLandmark = landmarkList.get(position)
            holder.itemView.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return landmarkList.size
    }
}
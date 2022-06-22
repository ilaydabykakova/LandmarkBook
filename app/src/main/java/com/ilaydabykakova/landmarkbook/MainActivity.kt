package com.ilaydabykakova.landmarkbook

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import com.ilaydabykakova.landmarkbook.databinding.ActivityMainBinding
//var chosenLandmark : Landmark ?= null

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private  lateinit var landmarkList : ArrayList<Landmark>
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //initialize
        landmarkList = ArrayList<Landmark>()

        // Data

        val pisa = Landmark("Pisa","Italy",R.drawable.pisa)
        val colosseum = Landmark("Colloseum","Italy",R.drawable.colosseum)
        val effel = Landmark("Eiffel","France",R.drawable.effel)
        val londonBridge = Landmark("London Bridge","UK",R.drawable.lodonbridge)

        //Inefficient
        //val pisaBitmap = BitmapFactory.decodeResource(resources,R.drawable.pisa)

        landmarkList.add(pisa)
        landmarkList.add(colosseum)
        landmarkList.add(effel)
        landmarkList.add(londonBridge)

        // We have to give recyclerView for layout -> Grid or Linear
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        //we call it with constructor to arrayList
        val landmarkAdapter = LandmarkAdapter(landmarkList)
        binding.recyclerView.adapter = landmarkAdapter

        /*
        for (land in landmarkList){
            println(land.name)
            println(land.country)
            println(land.image)
        }

        // Adapter : Layout & Data

        //Mapping

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,landmarkList.map { landmark -> landmark.name })

       // binding.listViewText.adapter = adapter

       */






    }
}
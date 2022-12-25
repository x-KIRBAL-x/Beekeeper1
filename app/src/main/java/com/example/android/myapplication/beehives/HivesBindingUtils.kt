package com.example.android.myapplication.beehives

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.android.myapplication.R
import com.example.android.myapplication.database.Beehive

@BindingAdapter("BeehiveImage")
fun ImageView.SetBeehiveImg(item: Beehive?){
    item?.let {
        setImageResource(R.drawable.mehecske)
    }
}

@BindingAdapter("BeehiveName")
fun TextView.setBeehiveName(item: Beehive?){
    item?.let {
        text = item.beehiveName
    }
}
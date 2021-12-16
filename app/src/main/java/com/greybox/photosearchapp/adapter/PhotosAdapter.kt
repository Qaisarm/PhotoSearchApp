package com.greybox.photosearchapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.greybox.photosearchapp.R
import com.greybox.photosearchapp.models.Photo
import com.greybox.photosearchapp.util.Constants.Companion.IMAGE_PXILE
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.photo_item.view.*

class PhotosAdapter(val photos: MutableList<Photo> = mutableListOf()) :
    RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        return PhotosViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.photo_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = photos.size

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {

        holder.bind(photos[position])
        holder.itemView.apply {
            tvTitle.text = "Image Name:  " + photos[position].title
        }
    }

    inner class PhotosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(photo: Photo) {
            Picasso.get().load(photo.url)
                .resize(IMAGE_PXILE, IMAGE_PXILE)
                .centerCrop()
                .into(itemView.ivImage)

        }

    }
}



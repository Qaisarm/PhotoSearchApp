package com.greybox.photosearchapp.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.greybox.photosearchapp.R
import com.greybox.photosearchapp.models.Photo
import com.greybox.photosearchapp.ui.MainActivity
import com.greybox.photosearchapp.ui.PhotosViewModel
import kotlinx.android.synthetic.main.fragment_search.*



class SearchFragment : Fragment(R.layout.fragment_search) {
    lateinit var viewModel: PhotosViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel = (activity as MainActivity).viewModel
        prvRecyclerView.adapter = viewModel.photosAdapter
        prvRecyclerView.layoutManager = LinearLayoutManager(activity)
        viewModel.loadPhotos().observe(viewLifecycleOwner,
            Observer<List<Photo>> { list ->
                with(viewModel.photosAdapter) {
                    photos.clear()
                    photos.addAll(list)
                    notifyDataSetChanged()
                }
            })
    }


}
package com.greybox.photosearchapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.greybox.photosearchapp.repository.PhotoRepository

class PhotosViewModelProviderFactory(
    val photoRepository: PhotoRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       return PhotosViewModel(photoRepository)as T
    }
}

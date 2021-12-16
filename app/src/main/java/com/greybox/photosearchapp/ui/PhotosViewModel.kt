package com.greybox.photosearchapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greybox.photosearch.api.RetrofitInstance
import com.greybox.photosearchapp.adapter.PhotosAdapter
import com.greybox.photosearchapp.models.Photo
import com.greybox.photosearchapp.repository.PhotoRepository
import kotlinx.coroutines.launch

class PhotosViewModel(photoRepository: PhotoRepository) : ViewModel() {

    private val mutablePhotosListLiveData = MutableLiveData<List<Photo>>()
    private val photosListLiveData: LiveData<List<Photo>> = mutablePhotosListLiveData

    var photosAdapter = PhotosAdapter()
    fun loadPhotos(): LiveData<List<Photo>> {
        viewModelScope.launch {
            val searchResponse = RetrofitInstance.api.fetchImages()
            if (searchResponse!=null){

                val photosList = searchResponse.photos.photo.map { photo ->
                    Photo(
                        id = photo.id,
                        url = "https://farm${photo.farm}.staticflickr.com/${photo.server}/${photo.id}_${photo.secret}.jpg",
                        title = photo.title
                    )
                }
                mutablePhotosListLiveData.postValue(photosList)
            }

        }
        return photosListLiveData
    }
}

package com.greybox.photosearchapp.repository

import com.greybox.photosearch.api.RetrofitInstance


class PhotoRepository {
    suspend fun searchPhoto(searchQuery: String) =
         RetrofitInstance.api.fetchImages()
}
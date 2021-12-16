package com.greybox.photosearch.api


import com.greybox.photosearchapp.models.PhotosSearchResponse
import com.greybox.photosearchapp.util.Constants.Companion.API_KEY
import com.greybox.photosearchapp.util.Constants.Companion.format
import com.greybox.photosearchapp.util.Constants.Companion.text
import retrofit2.http.GET

interface SearchAPI {
@GET("?method=flickr.photos.search&format=$format&text=$text&api_key=$API_KEY")
suspend fun fetchImages(): PhotosSearchResponse
}
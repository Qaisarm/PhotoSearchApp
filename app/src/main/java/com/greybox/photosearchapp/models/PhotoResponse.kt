package com.greybox.photosearchapp.models

data class PhotosSearchResponse(
    val photos: PhotosSearchData
)

data class PhotosSearchData(
    val page: Int,
    val photo: List<PhotoResponse>
)

data class PhotoResponse(
    val id: String,
    val owner: String,
    val secret: String,
    val server: String,
    val farm: Int,
    val title: String
)

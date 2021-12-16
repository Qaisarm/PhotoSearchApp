package com.greybox.photosearchapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.greybox.photosearchapp.R
import com.greybox.photosearchapp.repository.PhotoRepository
import com.greybox.photosearchapp.ui.fragment.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: PhotosViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchFragment = SearchFragment()
        val photosRepository = PhotoRepository()
        val viewModelProviderFactory = PhotosViewModelProviderFactory(photosRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(PhotosViewModel::class.java)

        val btnSearch = findViewById<Button>(R.id.btnSearch)
        btnSearch.setOnClickListener{
            var enteredString = searchText.text.toString()
            println("You have entered this: $enteredString")
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, searchFragment)
                commit()
            }
        }
    }
}
package com.example.newdogapi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newdogapi.network.DogImage
import com.example.newdogapi.network.DogImageApi
import kotlinx.coroutines.launch

//create mainviewmodel and inherit from viewModel

class MainViewModel : ViewModel() {

    //image constantly changes so it needs to be mutable and live
    private val _currentlyDisplayedImage = MutableLiveData<DogImage>()
    //live data can get updated
    val currentlyDisplayedDog: LiveData<DogImage> = _currentlyDisplayedImage

    //initialize as soon as our app starts something gets put on the screen
    init {
        getNewDog()
    }

    //returns a random dog image
    fun getNewDog() {

        //this may need to say randomdogimage
        viewModelScope.launch {
            _currentlyDisplayedImage.value = DogImageApi.retrofitService.getRandomDogImage()

        }
    }
}
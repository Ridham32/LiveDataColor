package com.ridhamsharma.livedatacolor

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ColorViewModel: ViewModel() {
    var number : MutableLiveData<Int> = MutableLiveData(0)
    var color : MutableLiveData<Int> = MutableLiveData(0)

}
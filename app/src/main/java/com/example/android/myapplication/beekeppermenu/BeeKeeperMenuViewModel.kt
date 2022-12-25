package com.example.android.myapplication.beekeppermenu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job

class BeeKeeperMenuViewModel : ViewModel() {

    private val viewModelJob = Job()

    private val _navigateToBeeGroupsFragment = MutableLiveData<Boolean?>()

    val navigateToBeeGroupsFragment: LiveData<Boolean?>
        get() = _navigateToBeeGroupsFragment

    fun doneNavigating(){
        _navigateToBeeGroupsFragment.value = null
    }

    fun click(){
        _navigateToBeeGroupsFragment.value=true
    }

}
package com.example.android.myapplication.beehives

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.myapplication.database.BeeDatabaseDao
import com.example.android.myapplication.database.Beehive
import kotlinx.coroutines.launch

class BeehivesViewModel(private val beeGroupKey: Long = 0L,
               private val dataSource: BeeDatabaseDao): ViewModel(){

    private val _navigateToBeeGroupsFragment = MutableLiveData<Boolean?>()
    private val _navigateToAddNewBeehiveFragment = MutableLiveData<Beehive?>()
    private val _navigateToGroupDeleteFragment = MutableLiveData<Boolean?>()
    private val _navigateToBeeDetailFragment = MutableLiveData<Long>()

    val database = dataSource

    val beehives = database.getAllBeehiveWithId(beeGroupKey)

    val navigateToBeeGroupsFragment: LiveData<Boolean?>
        get() = _navigateToBeeGroupsFragment

    val navigateToAddNewBeehiveFragment: LiveData<Beehive?>
        get() = _navigateToAddNewBeehiveFragment

    val navigateToGroupDeleteFragment: LiveData<Boolean?>
        get() = _navigateToGroupDeleteFragment

    val navigateToBeeDetailFragment
        get() = _navigateToBeeDetailFragment


    fun doneNavigateToBeeGroupsFragment(){
        _navigateToBeeGroupsFragment.value = null
    }

    fun doneNavigateToAddNewBeehiveFragment(){
        _navigateToAddNewBeehiveFragment.value = null
    }

    fun doneNavigateToGroupDeleteFragment(){
        _navigateToGroupDeleteFragment.value = null
    }

    fun doneNavigateToBeeDetailFragment(){
        _navigateToBeeDetailFragment.value=null
    }

    fun  onBeehiveClicked(id: Long){
        _navigateToBeeDetailFragment.value=id
    }

    fun navigateToGroupDeleteFragment(){
        _navigateToGroupDeleteFragment.value = true
    }

    fun clickOnClose(){
        _navigateToBeeGroupsFragment.value=true
    }

    private suspend fun insertBeehive(beehive: Beehive){
        database.insertHive(beehive)
    }

    fun clickOnAddNewBeehive(){
        viewModelScope.launch {
            val newBeehive = Beehive()
            insertBeehive(newBeehive)
            var newnewBeehive = database.getLastBeehive()
            _navigateToAddNewBeehiveFragment.value= newnewBeehive
        }
    }

}
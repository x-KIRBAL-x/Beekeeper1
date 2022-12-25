package com.example.android.myapplication.beehivedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.myapplication.database.BeeDatabaseDao
import com.example.android.myapplication.database.Beehive

class BeehiveDetailViewModel(
        private val beehiveKey: Long,
        private val beeGroupKey: Long,
        private val dataSource: BeeDatabaseDao): ViewModel() {

        val database = dataSource

        private val beehive: LiveData<Beehive>

        fun getBeehive() = beehive

        init {
            beehive=database.getBeehiveWithId(beehiveKey)
        }

        private val _navigateToBeehivesFragment = MutableLiveData<Boolean?>()
        private val _navgateToBeehiveDeleteFragment = MutableLiveData<Boolean?>()


        val navigateToBeehivesFragment: LiveData<Boolean?>
                get() = _navigateToBeehivesFragment
        val navgateToBeehiveDeleteFragment: LiveData<Boolean?>
                get() = _navgateToBeehiveDeleteFragment

        fun doneNavigateToBeehivesFragment(){
                _navigateToBeehivesFragment.value= null
        }

        fun clickOnCloseButton(){
                _navigateToBeehivesFragment.value=true
        }

        fun doneNavgateToBeehiveDeleteFragment(){
                _navgateToBeehiveDeleteFragment.value = null
        }

        fun clickOnDeleteButton(){
                _navgateToBeehiveDeleteFragment.value = true
        }

}
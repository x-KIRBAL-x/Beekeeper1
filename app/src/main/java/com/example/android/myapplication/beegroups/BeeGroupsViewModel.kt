package com.example.android.myapplication.beegroups

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.myapplication.database.BeeDatabaseDao
import com.example.android.myapplication.database.BeeGroup
import kotlinx.coroutines.launch

class BeeGroupsViewModel(
        dataSource: BeeDatabaseDao) : ViewModel() {

        val database = dataSource

        val groups = database.getAllGroups()

        private val _navigateToBeeMenuFragment = MutableLiveData<Boolean?>()
        private val _navigateToAddNewGroupFragment = MutableLiveData<BeeGroup?>()
        private val _navigateToBeehivesFragment = MutableLiveData<Long>()
        private val lastGroup = MutableLiveData<BeeGroup?>()

        val navigateToBeeMenuFragment: LiveData<Boolean?>
                get() = _navigateToBeeMenuFragment

        val navigateToAddNewGroupFragment: LiveData<BeeGroup?>
                get() = _navigateToAddNewGroupFragment

        val navigateToBeehivesfragment
                get() = _navigateToBeehivesFragment

        fun doneNavigatingClose(){
                _navigateToBeeMenuFragment.value = null
        }

        fun doneNavigatingAddNewGroup(){
                _navigateToAddNewGroupFragment.value = null
        }


        fun onBeeGroupsClicked(id: Long){
                _navigateToBeehivesFragment.value = id
        }

        fun doneNavigatingToBeehiveFragment(){
                _navigateToBeehivesFragment.value = null
        }


        private suspend fun getLastGroupFromDatabase(): BeeGroup? {
                var group = database.getLastGroup()
                return group
        }

        private suspend fun insertgroup(group: BeeGroup){
                database.insertGroup(group)
        }

        private fun initializelastGroup(){
                viewModelScope.launch {
                        lastGroup.value = getLastGroupFromDatabase()
                }
        }

        init {
            initializelastGroup()
        }

        fun clickClose(){
                /*viewModelScope.launch {                                 //  EZT MAJD TOROLNI!!
                        database.deleteAllGroups()
                }*/
                _navigateToBeeMenuFragment.value=true
        }

        fun clickAddNewGroup(){
                viewModelScope.launch {
                        val newGroup = BeeGroup()
                        insertgroup(newGroup)
                        var newnewGroup = getLastGroupFromDatabase() ?: return@launch

                        _navigateToAddNewGroupFragment.value = newnewGroup
                }
        }

}
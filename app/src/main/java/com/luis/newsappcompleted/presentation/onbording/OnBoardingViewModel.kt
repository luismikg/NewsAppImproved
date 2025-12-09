package com.luis.newsappcompleted.presentation.onbording

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luis.newsappcompleted.domain.usecases.SaveAppEntryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val saveAppEntryUseCase: SaveAppEntryUseCase
) : ViewModel() {

    fun onEvent(event: OnBoardingEvent) {
        when (event) {
            OnBoardingEvent.SaveAppEntry -> saveAppEntry()
        }
    }

    private fun saveAppEntry(){
        viewModelScope.launch(Dispatchers.IO) {
            saveAppEntryUseCase()
        }
    }
}
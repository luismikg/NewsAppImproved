package com.luis.newsappcompleted.presentation.onbording

sealed class OnBoardingEvent {
    data object SaveAppEntry : OnBoardingEvent()
}
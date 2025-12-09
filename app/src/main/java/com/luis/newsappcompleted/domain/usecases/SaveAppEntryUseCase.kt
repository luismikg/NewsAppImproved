package com.luis.newsappcompleted.domain.usecases

import com.luis.newsappcompleted.domain.manager.LocalUserManager

class SaveAppEntryUseCase(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke() {
        return localUserManager.saveAppEntry()
    }
}
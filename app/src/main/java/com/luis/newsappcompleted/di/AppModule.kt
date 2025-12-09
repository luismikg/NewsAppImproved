package com.luis.newsappcompleted.di

import android.content.Context
import com.luis.newsappcompleted.data.manager.LocalUserManagerImpl
import com.luis.newsappcompleted.domain.manager.LocalUserManager
import com.luis.newsappcompleted.domain.usecases.ReadAppEntryUseCase
import com.luis.newsappcompleted.domain.usecases.SaveAppEntryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideLocalUserManager(@ApplicationContext context: Context): LocalUserManager {
        return LocalUserManagerImpl(context = context)
    }

    @Singleton
    @Provides
    fun provideReadEntryUseCase(localUserManager: LocalUserManager): ReadAppEntryUseCase {
        return ReadAppEntryUseCase(localUserManager = localUserManager)
    }

    @Singleton
    @Provides
    fun provideSaveAppEntryUseCase(localUserManager: LocalUserManager): SaveAppEntryUseCase {
        return SaveAppEntryUseCase(localUserManager = localUserManager)
    }
}

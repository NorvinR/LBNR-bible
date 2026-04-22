package com.dnorvinreyes.lbnrbible.di

import com.dnorvinreyes.lbnrbible.data.repository.BibleRepositoryImp
import com.dnorvinreyes.lbnrbible.domain.repository.BibleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindBibleRepository(
        bibleRepositoryImp: BibleRepositoryImp
    ): BibleRepository
}

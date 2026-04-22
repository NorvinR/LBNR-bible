package com.dnorvinreyes.lbnrbible.di

import android.content.Context
import androidx.room.Room
import com.dnorvinreyes.lbnrbible.data.database.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    private const val BIBLE_DATABASE_NAME = "bible.db"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            BIBLE_DATABASE_NAME
        )
            .createFromAsset("databases/bible.db")
            .build()
    }

    @Singleton
    @Provides
    fun provideBookDao(db: AppDatabase) = db.getBookDao()
}
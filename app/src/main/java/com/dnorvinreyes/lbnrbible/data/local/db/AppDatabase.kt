package com.dnorvinreyes.lbnrbible.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dnorvinreyes.lbnrbible.data.local.dao.CapituloDao
import com.dnorvinreyes.lbnrbible.data.local.dao.LibroDao
import com.dnorvinreyes.lbnrbible.data.local.entity.Capitulo
import com.dnorvinreyes.lbnrbible.data.local.entity.Concordancia
import com.dnorvinreyes.lbnrbible.data.local.entity.Libro
import com.dnorvinreyes.lbnrbible.data.local.entity.Titulo
import com.dnorvinreyes.lbnrbible.data.local.entity.Versiculo

@Database(
    entities = [
        Libro::class,
        Capitulo::class,
        Versiculo::class,
        Titulo::class,
        Concordancia::class
    ],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {
    // DAOs
    abstract fun libroDao(): LibroDao
    abstract fun capituloDao(): CapituloDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "biblia.db" // Nombre interno de la base de datos
                )
                    .createFromAsset("databases/biblia.db")
                    .fallbackToDestructiveMigration() // Opcional
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

}
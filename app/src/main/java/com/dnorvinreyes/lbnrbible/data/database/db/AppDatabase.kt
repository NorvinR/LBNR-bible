package com.dnorvinreyes.lbnrbible.data.database.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dnorvinreyes.lbnrbible.data.database.dao.ChapterDao
import com.dnorvinreyes.lbnrbible.data.database.dao.BookDao
import com.dnorvinreyes.lbnrbible.data.database.entity.ChapterEntity
import com.dnorvinreyes.lbnrbible.data.database.entity.ConcordanceEntity
import com.dnorvinreyes.lbnrbible.data.database.entity.BookEntity
import com.dnorvinreyes.lbnrbible.data.database.entity.TitleEntity
import com.dnorvinreyes.lbnrbible.data.database.entity.VerseEntity

/**
 * AppDatabase define la configuracion de la base de datos de la app
 * y actua como punto de acceso principal de la app la app a los datos almacenados
 *
 * La database class debe sastifacer las siguientes condiciones:
 *
 * 1. Debe ser una anotacion @Database que incluye una lista de todas
 * las entidades asociadas a la base de datos
 * 2. La clase debe ser una clase abstracta que extienda de RoomDatabase
 * 3. Para cada DAO asociado con la base de datos, la database class debe definir
 * un metodo abstracto que tiene cero argumentos y devuelve el DAO
 */

@Database(
    entities = [
        BookEntity::class,
        ChapterEntity::class,
        VerseEntity::class,
        TitleEntity::class,
        ConcordanceEntity::class
    ],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {
    // DAOs
    abstract fun libroDao(): BookDao
    abstract fun capituloDao(): ChapterDao

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
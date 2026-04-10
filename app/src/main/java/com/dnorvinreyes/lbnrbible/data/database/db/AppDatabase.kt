package com.dnorvinreyes.lbnrbible.data.database.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dnorvinreyes.lbnrbible.data.database.dao.CapituloDao
import com.dnorvinreyes.lbnrbible.data.database.dao.LibroDao
import com.dnorvinreyes.lbnrbible.data.database.entity.Capitulo
import com.dnorvinreyes.lbnrbible.data.database.entity.Concordancia
import com.dnorvinreyes.lbnrbible.data.database.entity.Libro
import com.dnorvinreyes.lbnrbible.data.database.entity.Titulo
import com.dnorvinreyes.lbnrbible.data.database.entity.Versiculo

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
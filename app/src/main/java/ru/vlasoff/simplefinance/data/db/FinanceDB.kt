package ru.vlasoff.simplefinance.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import ru.vlasoff.simplefinance.domain.entities.Expose
import ru.vlasoff.simplefinance.domain.entities.Income
import ru.vlasoff.simplefinance.utils.DB_NAME

@Database(entities = [Income::class, Expose::class], version = 1)
abstract class FinanceDB : RoomDatabase() {
    abstract fun incomesDao(): IncomesDao
    abstract fun exposesDao(): ExposesDao

    companion object {

        @Volatile private var instance: FinanceDB? = null

        fun getInstance(context: Context): FinanceDB {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): FinanceDB {
            return Room.databaseBuilder(
                context,
                FinanceDB::class.java,
                DB_NAME
            ).build()
        }
    }
}
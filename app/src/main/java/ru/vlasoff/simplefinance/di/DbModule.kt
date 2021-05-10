package ru.vlasoff.simplefinance.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.vlasoff.simplefinance.data.db.FinanceDB
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Provides
    @Singleton
    fun provideDb(@ApplicationContext context: Context) = FinanceDB.getInstance(context)

    @Provides
    fun provideIncomeDao(db: FinanceDB) = db.incomesDao()

    @Provides
    fun provideExposeDao(db: FinanceDB) = db.exposesDao()

}
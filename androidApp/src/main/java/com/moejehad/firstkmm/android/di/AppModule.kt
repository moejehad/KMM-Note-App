package com.moejehad.firstkmm.android.di

import android.app.Application
import com.moejehad.firstkmm.data.local.DatabaseDriverFactory
import com.moejehad.firstkmm.data.note.SqlDelightNoteDataSource
import com.moejehad.firstkmm.database.NoteDatabase
import com.moejehad.firstkmm.domain.note.NoteDataSource
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSqlDriver(app: Application): SqlDriver {
        return DatabaseDriverFactory(app).createDriver()
    }


    @Provides
    @Singleton
    fun provideNoteDataSource(driver: SqlDriver): NoteDataSource {
        return SqlDelightNoteDataSource(NoteDatabase(driver))
    }

}
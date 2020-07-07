package test.task.targsoft.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import test.task.targsoft.internal.Constant.DATABASE_NAME

@Database(entities = [BreedsEntity::class], version = 1)
abstract class BreedsDatabase : RoomDatabase() {

    abstract fun breedsDao() : BreedsDao

    companion object {

        @Volatile
        private var instance : BreedsDatabase? = null

        private val LOCK = Any()

        private fun buildDatabase (context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                BreedsDatabase::class.java,
                DATABASE_NAME
            ).fallbackToDestructiveMigration().build()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }
    }

}
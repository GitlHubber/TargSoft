package test.task.targsoft.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Single


@Dao
interface BreedsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBreeds(breeds: List<BreedsEntity>)

    @Query("SELECT * FROM breed")
    fun queryBreeds() : Single<List<BreedsEntity>>

}
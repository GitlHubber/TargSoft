package test.task.targsoft.data.network

import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query
import test.task.targsoft.model.Breed
import test.task.targsoft.model.BreedItem

interface IApi {

    @GET("v1/breeds")
    fun getBreeds(): Flowable<Breed>

}
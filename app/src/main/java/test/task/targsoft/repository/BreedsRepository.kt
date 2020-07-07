package test.task.targsoft.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber
import test.task.targsoft.BreedsApplication
import test.task.targsoft.data.database.toBreedItemList
import test.task.targsoft.data.database.toBreedsEntityList
import test.task.targsoft.data.network.IApi
import test.task.targsoft.di.DaggerAppComponent
import test.task.targsoft.internal.Constant.LIMIT
import test.task.targsoft.internal.Constant.PAGE
import test.task.targsoft.model.Breed
import test.task.targsoft.model.BreedItem
import javax.inject.Inject

class BreedsRepository {

    @Inject
    lateinit var iApiService : IApi

    private val _breeds by lazy { MutableLiveData<List<BreedItem>>() }
    val breeds : LiveData<List<BreedItem>>
        get() = _breeds

    private val _isInProgress by lazy { MutableLiveData<Boolean>() }
    val isInProgress : LiveData<Boolean>
        get() = _isInProgress

    private val _isError by lazy { MutableLiveData<Boolean>() }
    val isError : LiveData<Boolean>
        get() = _isError

    init {
        DaggerAppComponent.create().inject(this)
    }

    private fun insertBreeds() : Disposable {
        return iApiService.getBreeds()
            .subscribeOn(Schedulers.io())
            .subscribeWith(subscribeToDatabase())
    }

    private fun subscribeToDatabase() : DisposableSubscriber<Breed> {
        return object : DisposableSubscriber<Breed>() {
            override fun onComplete() {
                Log.v("insertBreeds()", "insert success")
                getBreedsQuery()
            }

            override fun onNext(t: Breed?) {
                if (t != null) {
                    val entityList = t.toList().toBreedsEntityList()
                    BreedsApplication.databese.apply {
                        breedsDao().insertBreeds(entityList)
                    }
                }

            }

            override fun onError(t: Throwable?) {
                _isInProgress.postValue(true)
                Log.e("insertBreeds()", "Breeds error: ${t?.message}")
                _isError.postValue(true)
                _isInProgress.postValue(false)
            }
        }
    }

    private fun getBreedsQuery() : Disposable {
        return BreedsApplication.databese.breedsDao()
            .queryBreeds()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    breedsEntityList ->
                    _isInProgress.postValue(true)
                    if (breedsEntityList != null && breedsEntityList.isNotEmpty()) {
                        _isError.postValue(false)
                        _breeds.postValue(breedsEntityList.toBreedItemList())
                    } else {
                        insertBreeds()
                    }
                    _isInProgress.postValue(false)
                },
                {
                    _isInProgress.postValue(true)
                    Log.e("getBreedsQuery()", "Database error: ${it.message}")
                    _isError.postValue(true)
                    _isInProgress.postValue(false)
                }
            )
    }

    fun fetchBreedsFromDatabase() : Disposable = getBreedsQuery()

}
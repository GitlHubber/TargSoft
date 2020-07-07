package test.task.targsoft.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import test.task.targsoft.di.DaggerAppComponent
import test.task.targsoft.repository.BreedsRepository
import javax.inject.Inject

class BreedsViewModel : ViewModel() {

    @Inject
    lateinit var repository : BreedsRepository

    private val compositeDisposable by lazy { CompositeDisposable() }

    init {
        DaggerAppComponent.create().inject(this)
        compositeDisposable.add(repository.fetchBreedsFromDatabase())
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}
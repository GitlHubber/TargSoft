package test.task.targsoft

import android.app.Application
import test.task.targsoft.data.database.BreedsDatabase

class BreedsApplication : Application() {

    companion object {
        lateinit var instanse : BreedsApplication
        lateinit var databese: BreedsDatabase
    }

    init {
        instanse = this
    }

    override fun onCreate() {
        super.onCreate()
        databese = BreedsDatabase.invoke(this)
    }
}
package test.task.targsoft.di

import dagger.Module
import dagger.Provides
import test.task.targsoft.data.network.IApi
import test.task.targsoft.data.network.IApiService
import test.task.targsoft.model.BreedItem
import test.task.targsoft.repository.BreedsRepository
import test.task.targsoft.view.adapter.BreedsAdapter
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideApi() : IApi = IApiService.getClient()

    @Provides
    fun provideBreedsRepository() = BreedsRepository()

    @Provides
    fun provideListData() = ArrayList<BreedItem>()

    @Provides
    fun provideBreedsAdapter(breeds : ArrayList<BreedItem>) : BreedsAdapter = BreedsAdapter(breeds)
}
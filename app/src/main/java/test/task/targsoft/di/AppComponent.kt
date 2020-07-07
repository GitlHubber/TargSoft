package test.task.targsoft.di

import dagger.Component
import test.task.targsoft.view.ui.MainActivity
import test.task.targsoft.repository.BreedsRepository
import test.task.targsoft.viewmodel.BreedsViewModel
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject (breedsRepository : BreedsRepository)

    fun inject (viewModel : BreedsViewModel)

    fun inject (mainActivity : MainActivity)

}
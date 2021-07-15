package br.com.labdev.technicalworkcentral.di

import br.com.labdev.technicalworkcentral.data.Cache
import br.com.labdev.technicalworkcentral.data.repository.UserRepository
import br.com.labdev.technicalworkcentral.ui.details.DetailsViewModel
import br.com.labdev.technicalworkcentral.ui.documentregistration.DocumentRegistrationViewModel
import br.com.labdev.technicalworkcentral.ui.home.viewmodel.HomeViewModel
import br.com.labdev.technicalworkcentral.ui.login.LoginViewModel
import br.com.labdev.technicalworkcentral.ui.profile.ProfileViewModel
import br.com.labdev.technicalworkcentral.ui.register.RegisterViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val detailsModule = module {
    viewModel { DetailsViewModel() }
}

val documentRegisterModule = module {
    viewModel { DocumentRegistrationViewModel() }
}

val homeModule = module {
    viewModel { HomeViewModel() }
}

val loginModule = module {
    viewModel { LoginViewModel(repository = get()) }
}

val profileModule = module {
    viewModel { ProfileViewModel() }
    single { UserRepository(cache = get()) }
    single { Cache(androidContext()) }
}

val registerModule = module {
    viewModel { RegisterViewModel(repository = get()) }
}
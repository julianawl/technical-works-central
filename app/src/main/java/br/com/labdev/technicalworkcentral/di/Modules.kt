package br.com.labdev.technicalworkcentral.di

import br.com.labdev.technicalworkcentral.ui.details.DetailsViewModel
import br.com.labdev.technicalworkcentral.ui.documentregistration.DocumentRegistrationViewModel
import br.com.labdev.technicalworkcentral.ui.home.viewmodel.HomeViewModel
import br.com.labdev.technicalworkcentral.ui.login.LoginViewModel
import br.com.labdev.technicalworkcentral.ui.profile.ProfileViewModel
import br.com.labdev.technicalworkcentral.ui.register.RegisterViewModel
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
    viewModel { LoginViewModel() }
}

val profileModule = module {
    viewModel { ProfileViewModel() }
}

val registerModule = module {
    viewModel { RegisterViewModel() }
}
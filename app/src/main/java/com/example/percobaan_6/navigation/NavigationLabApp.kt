package com.example.percobaan_6.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.percobaan_6.data.repository.StudentLocalDataSource
import com.example.percobaan_6.data.source.DefaultStudentRepository
import com.example.percobaan_6.ui.detil.DetilViewModel
import com.example.percobaan_6.ui.home.HomeViewModel
import com.example.percobaan_6.ui.screen.AboutScreen
import com.example.percobaan_6.ui.screen.DetilScreen
import com.example.percobaan_6.ui.screen.HomeScreen
import com.example.percobaan_6.ui.screen.ProfileScreen

@Composable
fun NavigationLabApp(modifier: Modifier = Modifier) {
    val dataSource = remember { StudentLocalDataSource() }
    val repository = remember { DefaultStudentRepository(dataSource) }
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = routes.HOME,
        modifier = modifier
    ) {
        composable(routes.HOME) {
            val homeViewModel: HomeViewModel = viewModel(
                factory = HomeViewModel.factory(repository)
            )

            HomeScreen(
                uiState = homeViewModel.uiState,
                onOpenDetail = { id ->
                    navController.navigate(routes.detil(id))
                },
                onOpenProfile = {
                    navController.navigate(routes.PROFILE)
                },
                onOpenAbout = {
                    navController.navigate(routes.ABOUT)
                }
            )
        }

        composable(
            route = routes.DETIL,
            arguments = listOf(
                navArgument("studentId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val studentId =
                backStackEntry.arguments?.getInt("studentId") ?: -1

            val viewModel: DetilViewModel = viewModel(
                factory = DetilViewModel.factory(repository)
            )

            LaunchedEffect(studentId) {
                viewModel.loadStudent(studentId)
            }

            DetilScreen(
                uiState = viewModel.uiState,
                onBack = { navController.popBackStack() }
            )
        }

        composable(routes.PROFILE) {
            ProfileScreen(
                onBack = { navController.popBackStack() }
            )
        }

        composable(routes.ABOUT) {
            AboutScreen(
                onBack = { navController.popBackStack() }
            )
        }
    }
}

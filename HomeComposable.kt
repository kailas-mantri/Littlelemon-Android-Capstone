package com.example.littlelemon;

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview;
import androidx.navigation.NavHostController
import com.example.littlelemon.data.MenuDatabase

@Composable
fun HomeComposable (navController: NavHostController, database: MenuDatabase){

    val menuItems by database.menuDao().getAllMenuItems().observeAsState(emptyList())

    Column {
        TopAppBarComposable(navController = navController,true)
        HeroSection(menuItems)
    }
}

@Composable
@Preview
fun HomeScreenPreview(){
    //Home(navController = rememberNavController(), database = MenuDatabase());
}
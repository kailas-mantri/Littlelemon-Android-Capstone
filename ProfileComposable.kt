package com.example.littlelemon

import android.content.SharedPreferences
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.edit
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.ui.theme.LittleLemonColor
import com.example.littlelemon.ui.theme.LittleLemonTheme

@Composable
fun ProfileComposable (navController: NavHostController,
                       sharedPreferences: SharedPreferences?){

    LittleLemonTheme{
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Little Lemon Logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 20.dp)
            )

            Column (modifier = Modifier
                .padding(start = 10.dp, end = 10.dp, top = 16.dp, bottom = 16.dp)
                .fillMaxSize()
                , verticalArrangement = Arrangement.SpaceBetween
            ){

                Row (){
                    Column() {
                        Text(text = "Personal information",
                            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp))

                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = sharedPreferences?.getString("firstName","").toString(),
                            onValueChange = {},
                            readOnly = true,
                            label = { Text("First name")}
                        )

                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth().padding(top = 10.dp, bottom = 10.dp),
                            value = sharedPreferences?.getString("lastName","").toString(),
                            onValueChange = {},
                            readOnly = true,
                            label = { Text("Last name") }
                        )

                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = sharedPreferences?.getString("email","").toString(),
                            onValueChange = {},
                            readOnly = true,
                            label = { Text("Email address") }
                        )
                    }
                }


                Button(
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = LittleLemonColor.yellow,
                        contentColor = Color.Black),
                    onClick = {

                        sharedPreferences?.edit(commit = true) {
                            putString("email", "");
                            putString("firstName", "");
                            putString("lastName", "");
                        }

                        navController?.navigate(Onboarding.route);
                    }
                ) {
                    Text("Log out")
                }
            }
        }
    }
}

@Composable
@Preview
fun ProfileScreenPreview(){
    ProfileComposable(navController = rememberNavController(), null);
}
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
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
fun OnboardingComposable(navController: NavHostController,
                         sharedPreferences: SharedPreferences?) {

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

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
            Row (modifier = Modifier
                .background(LittleLemonColor.green)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(top = 20.dp, bottom = 20.dp),
                horizontalArrangement = Arrangement.Center
            ){
                Text(text = "Let's get to know you",
                    fontSize = 24.sp,
                    color = Color.White)
            }

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
                            value = firstName,
                            onValueChange = {firstName = it },
                            label = { Text("First name")}
                        )

                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth().padding(top = 10.dp, bottom = 10.dp),
                            value = lastName,
                            onValueChange = {lastName = it },
                            label = { Text("Last name") }
                        )

                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = email,
                            onValueChange = {email = it },
                            label = { Text("Email address") }
                        )
                    }
                }


                Button(
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = LittleLemonColor.yellow,
                                                        contentColor = Color.Black),
                    onClick = {

                        if(!email.isBlank()
                            && !firstName.isBlank()
                            && !lastName.isBlank()){

                            sharedPreferences?.edit(commit = true) {
                                putString("email", email);
                                putString("firstName", firstName);
                                putString("lastName", lastName);
                            }

                            navController?.navigate(Home.route);
                        }
                    }
                ) {
                    Text("Register")
                }
            }



        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingPreview() {
    OnboardingComposable(navController = rememberNavController(), null)
}
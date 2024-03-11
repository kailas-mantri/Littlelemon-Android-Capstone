package com.example.littlelemon

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.littlelemon.data.MenuItem
import com.example.littlelemon.ui.theme.LittleLemonColor

@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun MenuItemComposable(dish: MenuItem) {
    Card(onClick = {}, colors = CardDefaults.cardColors(
        containerColor = Color.White)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)){
            Column(modifier = Modifier.fillMaxWidth(0.8f)) {
                Text(
                    text = dish.title,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier
                        .padding(top = 5.dp, bottom = 5.dp),
                    color = Color.Black
                )
                Text(
                    text = dish.description,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(top = 5.dp, bottom = 5.dp)
                        .fillMaxWidth(0.75f)

                )
                Text(
                    text = "$${dish.price}",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold
                )
            }
            GlideImage(
                model = dish.image,
                contentDescription = "Dish image",
                modifier = Modifier.clip(RoundedCornerShape(10.dp)).fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
        }
    }
    Divider(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp),
        thickness = 1.dp,
        color = Color.LightGray
    )
}
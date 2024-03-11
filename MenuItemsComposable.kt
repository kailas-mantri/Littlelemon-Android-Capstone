package com.example.littlelemon

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import com.example.littlelemon.data.MenuItem

@Composable
fun MenuItemsComposable(dishes: List<MenuItem> = listOf()) {
    Column {
        LazyColumn{
            itemsIndexed(dishes){ _,
                                  dish -> MenuItemComposable(dish)
            }
        }
    }
}
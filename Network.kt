package com.example.littlelemon.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName(value = "Menu")
class MenuNetworkdata(
    val menu: List<MenuItemNetwork>
)


@Serializable
class  MenuItemNetwork (
    val id: Int,
    val title: String,
    val description : String,
    val price: Double,
    val image: String,
    val category: String
)
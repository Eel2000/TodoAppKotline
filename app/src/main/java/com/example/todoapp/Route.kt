package com.example.todoapp

sealed class Route(val route:String) {
    object Home:Route("Home")
    object Add:Route("AddNewMemo")
}
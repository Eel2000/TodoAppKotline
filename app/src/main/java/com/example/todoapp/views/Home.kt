package com.example.todoapp.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.viewModels.MemoViewModel
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import java.util.Date

@Composable
fun HomePage(vm: MemoViewModel){

    Surface(modifier = Modifier.fillMaxSize(),
    color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            LazyColumn(modifier = Modifier.fillMaxHeight()){
                items(vm.memories){
                   CardMemo(title = it.title, it.date)
                }
            }
        }
    }
}

@Composable
fun CardMemo(title: String,date: Date){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable { },
        elevation = 10.dp,
        shape = AbsoluteCutCornerShape(
            0,
            20,
            0,
            0
        ),
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(15.dp), horizontalAlignment = Alignment.Start) {
                Text(
                    text = title,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "$date",
                    textAlign = TextAlign.Right,
                    fontWeight = FontWeight.Light
                )
            }

            IconButton(
                modifier = Modifier.align(Alignment.Top),
                onClick = { /*TODO*/ }
            ) {
                Icon(imageVector = Icons.Filled.Close, contentDescription = null)
            }
        }
    }
}

package com.example.todoapp.views

import android.widget.Toast
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
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.models.Memo
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
                   CardMemo(it,vm)
                }
            }
        }
    }
}

@Composable
fun CardMemo(memo: Memo, vm: MemoViewModel){
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        elevation = 10.dp,
        shape = AbsoluteCutCornerShape(
            0,
            10,
            0,
            0
        ),
        backgroundColor = Color.Yellow
    ) {
        Column(
            modifier = Modifier.padding(15.dp),
            horizontalAlignment = Alignment.Start
        ) {
                Text(
                    text = memo.title,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )

                Text(text = memo.content)

               Row(
                   horizontalArrangement = Arrangement.End,
                   modifier = Modifier.fillMaxWidth()
               ){
                   Text(
                       text = "${memo.date}",
                       textAlign = TextAlign.Right,
                       fontWeight = FontWeight.Light,
                       modifier = Modifier.padding(0.dp,12.dp,5.dp,0.dp)
                   )
                       IconButton(
                           onClick = {
                               vm.removeMemo(memo)
                               Toast.makeText(context,"Memo deleted successfully",Toast.LENGTH_SHORT).show()
                             },
                       ) {
                           Icon(imageVector = Icons.Filled.Delete, contentDescription = null)
                       }
               }
            }
    }
}

package com.example.todoapp.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.rounded.Done
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.todoapp.models.Memo
import com.example.todoapp.viewModels.MemoViewModel
import java.util.*

@Composable
fun NewMemo(navController: NavController, vm :MemoViewModel){
val scaffoldState: ScaffoldState = rememberScaffoldState()
    var title by remember {
        mutableStateOf("")
    }
    var content by remember {
        mutableStateOf("")
    }
    Scaffold(
        scaffoldState=scaffoldState,
        topBar = {
            TopAppBar(
                title ={ Text(text = "new memo")},
                navigationIcon = {
                       IconButton(onClick = { navController.popBackStack() }) {
                           Icon(imageVector = Icons.Filled.ArrowBack,
                               contentDescription = "backIconButton")
                       }
                }
            )
        },
        floatingActionButton={
                Column(verticalArrangement = Arrangement.SpaceBetween) {
                    FloatingActionButton(
                        modifier = Modifier.paddingFromBaseline(0.dp,5.dp),
                        onClick = {
                            vm.addMemo(Memo(UUID.randomUUID(), title,content, date = Date()))
                            title="";
                            content=""

                        },
                        contentColor = Color.White,
                        backgroundColor = MaterialTheme.colors.primary
                    ) {
                        Icon(imageVector = Icons.Rounded.Done, contentDescription = "saveButton")
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    FloatingActionButton(
                        onClick = {
                            title="";
                            content=""
                        },
                        contentColor = Color.White,
                        backgroundColor = MaterialTheme.colors.error
                    ) {
                        Icon(imageVector = Icons.Filled.Delete,
                            contentDescription = "discardOrDeleteButton")
                    }
                }
        },
        floatingActionButtonPosition = FabPosition.End
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            TextField(
                value = title,
                onValueChange = { title = it},
                label = { Text(text = "tile")},
                textStyle = TextStyle(Color.Black, fontWeight = FontWeight.ExtraBold)
            )

            TextField(
                value = content,
                label={ Text(text = "Description")},
                onValueChange = { content = it },
                maxLines = 120,
                modifier = Modifier.padding(20.dp),
                textStyle = TextStyle(color = Color.Black, fontWeight = FontWeight.Light)
            )
        }
    }
}

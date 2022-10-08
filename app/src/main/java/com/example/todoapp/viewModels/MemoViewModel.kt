package com.example.todoapp.viewModels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.todoapp.models.Memo
import java.util.UUID

class MemoViewModel:ViewModel(){
    private  val _memories = mutableStateListOf<Memo>()

    val memories:List<Memo>get() = _memories

    fun addMemo(memo: Memo){
        _memories.add(memo);
    }

    fun removeMemo(memo:Memo){
        _memories.remove(memo);
    }
}
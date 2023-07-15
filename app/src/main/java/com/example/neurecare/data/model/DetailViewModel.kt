//package com.example.neurecare.data.model
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.neurecare.common.UiState
//import com.example.neurecare.data.repository.DataProgram
//import com.example.neurecare.data.repository.ProgramRepository
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.catch
//import kotlinx.coroutines.launch
//import javax.inject.Inject
//
//
//@HiltViewModel
//class DetailViewModel @Inject constructor(
//    private val neureRepository: ProgramRepository
//): ViewModel(){
//
//    private val _uiState:MutableStateFlow<UiState<DataProgram>> = MutableStateFlow(UiState.Loading)
//    val uiState = _uiState
//
//
//    private fun getProgramById(id:Int) = viewModelScope.launch {
//        neureRepository.getProgramById(id)
//            .catch {
//                _uiState.value = UiState.Error(it.message.toString())
//            }
//            .collect {
//                _uiState.value = UiState.Success(it)
//            }
//    }
//
//
//    fun updateProgram(id:Int, newState:Boolean) = viewModelScope.launch {
//        neureRepository.updateProgram(id, !newState)
//            .collect{isUpdate ->
//                if(isUpdate) getProgramById(id)
//            }
//    }
//}
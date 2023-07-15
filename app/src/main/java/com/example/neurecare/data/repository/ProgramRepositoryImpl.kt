//package com.example.neurecare.data.repository
//
//import com.example.neurecare.data.datadummy.DataProgram
//import com.example.neurecare.data.datadummy.Program
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.flow
//import kotlinx.coroutines.flow.flowOf
//import javax.inject.Inject
//import javax.inject.Singleton
//
//
//@Singleton
// class ProgramRepositoryImpl @Inject constructor(): ProgramRepository{
// private val dummyProgram = mutableListOf<Program>()
//
//
// init {
//     if (dummyProgram.isEmpty()){
//         dummyProgram.addAll(DataProgram.dummyProgram)
//     }
// }
// override fun getProgram() = flow{
//     emit(dummyProgram)
// }
//
// override fun getProgramById(id: Int): Flow<Program> {
// return flowOf(dummyProgram.first { it.id == id })
// }
//
//// override fun updateProgram(id: Int, newState: Boolean): Flow<Boolean> {
////
////  val index = dummyProgram.indexOfFirst { it.id == id }
////  val result = if (index >= 0) {
////      dummyProgram[index].newState = newState
////  }
//// }
//
//}
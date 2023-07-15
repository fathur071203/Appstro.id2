package com.example.neurecare.data.repository

import com.example.neurecare.data.datadummy.DataProgram
import com.example.neurecare.data.datadummy.Program
import kotlinx.coroutines.flow.Flow

interface ProgramRepository{

    fun getProgram(): Flow<List<Program>>

    fun getProgramById(id: Int): Flow<Program>

//    fun getGerakan(Gerakan: String): Flow<NeureRepo>
//
//    fun getDurasi(Durasi: String): Flow<NeureRepo>
//
//    fun updateProgram(id: Int, newState:Boolean): Flow<Boolean>

}
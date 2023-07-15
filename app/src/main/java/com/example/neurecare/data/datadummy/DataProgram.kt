package com.example.neurecare.data.datadummy



object DataProgram {
    val dummyProgram = listOf(
        Program(
            id = 1,
            JProgram = "Latihan tubuh bagian atas",
            movement = "Memutar pergelangan tangan\n" +
                    "Menggerakkan jari telunjuk\n" +
                    "Menggerakkan semua jari bersamaan\n" +
                    "Berdiri dan jongkok",
            duration = "20 Menit"
        ),
        Program(
            id = 2,
            JProgram = "Latihan tubuh bagian bawah",
            movement = "Memutar pergelangan tangan\n" +
                    "Menggerakkan jari telunjuk",
            duration = "10 Menit"
        )
    )
}
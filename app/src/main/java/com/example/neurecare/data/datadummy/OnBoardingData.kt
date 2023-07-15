package com.example.neurecare.data.datadummy

import com.example.neurecare.R


class OnBoardingData(val icon: Int, val title: String, val description: String)

val dummyOnBoarding = listOf(
    OnBoardingData(
        R.drawable.intro1,
        "Jadwal Rehabilitasi",
        "Dapatkan jadwal latihan dan temu rutin untuk rehabilitasi anda",
    ),
    OnBoardingData(
        R.drawable.intro2,
        "Reahabilitasi Mandiri Berbasis Komputer Vision",
        "Dapatkan paket rehabilitasi termonitoring dengan teknologi pose detection yang akan dilaporakan pada terapis anda"
    ),
    OnBoardingData(
        R.drawable.intro3,
        "Resep Gerakan Rehabilitasi",
        "Dapatkan resep gerakan rehabilitasi yang disesuikan dengan keadaan anda",
    ),
    OnBoardingData(
        R.drawable.intro4,
        "Konsultasi Online",
        "Lakukan konsultasi mengenai kendala selama rehabilitasi dengan terapis anda"
    ),
    OnBoardingData(
        R.drawable.intro5,
        "Pola Makan",
        "Dapatkan rekomendasi makanan yang sesuai dengan kebutuhan gizi anda untuk mendukung kegiatan rehabilitasi"
    ),
    OnBoardingData(
        R.drawable.intro6,
        "Mari Kembalikan Kemampuan Fisik Anda",
        "NueReCare Apps"
    )
)

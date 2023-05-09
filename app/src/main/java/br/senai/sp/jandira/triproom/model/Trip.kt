package br.senai.sp.jandira.triproom.model


import br.senai.sp.jandira.triproom.R
import java.time.LocalDate

data class Trip(
    var id: Long = 0,
    var location: String = "",
    var description: String = "",
    var startDate: LocalDate = LocalDate.of(2000,1,1),
    var endDate: LocalDate = LocalDate.of(2000,1,0),
    var image: Int = R.drawable.no_photography_24
)

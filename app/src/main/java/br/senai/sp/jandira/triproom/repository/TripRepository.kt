package br.senai.sp.jandira.triproom.repository

import br.senai.sp.jandira.triproom.model.Trip
import java.time.LocalDate

class TripRepository {

    companion object{
        fun getTrips(): List<Trip>{
            return  listOf(
                Trip(
                    id = 1,
                    location = "Jandira",
                    description = "Cidade muito bonita, com muitas opções de passeios.",
                    startDate = LocalDate.of(2023,4,21),
                    endDate = LocalDate.of(2023,4,23)
                ),
                Trip(
                    id = 1,
                    location = "São Roque",
                    description = "cidade bem maneirinha",
                    startDate = LocalDate.of(2023,4,21),
                    endDate = LocalDate.of(2023,4,23)
                ),
                Trip(
                    id = 1,
                    location = "Rio de Janeiro",
                    description = "Cidade muito bonita, muitas quebradas",
                    startDate = LocalDate.of(2023,4,21),
                    endDate = LocalDate.of(2023,4,23)
                )
            )
        }
    }
}
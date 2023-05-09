package br.senai.sp.jandira.triproom.gui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.triproom.ui.theme.TripRoomTheme
import br.senai.sp.jandira.triproom.R
import br.senai.sp.jandira.triproom.model.Category
import br.senai.sp.jandira.triproom.model.Trip
import br.senai.sp.jandira.triproom.repository.CategoryRepository
import br.senai.sp.jandira.triproom.repository.TripRepository

class LoggedActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TripRoomTheme {
                loggedScreen(
                    CategoryRepository.getCategories(),
                    TripRepository.getTrips()
                )
            }
        }
    }
}


@Composable
fun loggedScreen(
    categories: List<Category>,
    trips: List<Trip>

) {
    val context = LocalContext.current
    Surface(modifier = Modifier.fillMaxSize()){
    //column principal. que abriga tudo
        Column(modifier = Modifier.fillMaxSize()){

    //card  ue tem a foto de paris
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
                shape = RoundedCornerShape(0.dp)
            ){
                Image(
                    painter =painterResource(id = R.drawable.paris),
                    contentDescription = "lago",
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop

                )
            }
            Text(
                text =stringResource(id = R.string.categories),
                color =Color(56,54,54),
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp)
            )
            LazyRow(){
                items(categories){
                    Card(
                        modifier = Modifier
                            .size(width = 109.dp, height = 100.dp)
                            .padding(vertical = 8.dp, horizontal = 4.dp),
                        backgroundColor = Color(207,6,240)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center) {
                            Image(
                                painter = it.categoryIcon,
                                contentDescription = it.categoryName
                            )
                            Text(
                                text = "${it.categoryName}",
                                fontSize = 14.sp,
                                color = Color.White
                            )
                        }
                    }
                }
            }
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp),
                placeholder = {
                    Text(text = stringResource(id = R.string.search))
                },
                trailingIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = ""
                        )
                    }
                }
            )
            Text(
                text = stringResource(id = R.string.past_trips),
                fontSize = 14.sp,
                color = Color(80,84,84),
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            )
            LazyColumn(){
                items(trips){
                    Card(
                        modifier = Modifier.fillMaxWidth().padding(16.dp),
                        backgroundColor = Color.Cyan
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Image(
                                painter = painterResource(id = R.drawable.no_photography_24),
                                contentDescription = ""
                            )
                            Text( "${it.location}, ${it.startDate.year}")
                            Text( "${it.description}")
                            Text(
                                "${it.startDate} - ${it.endDate}",
                                textAlign = TextAlign.End,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun loggedScreen() {
        loggedScreen(
            CategoryRepository.getCategories(),
            TripRepository.getTrips()
        )
}


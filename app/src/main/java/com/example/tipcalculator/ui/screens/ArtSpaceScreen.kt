package com.example.tipcalculator.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tipcalculator.R
import com.example.tipcalculator.ui.model.Artwork

@Composable
fun ArtSpaceScreen(modifier: Modifier = Modifier) {
    val artList = remember {
        listOf(
            Artwork(
                title = "Fine Line",
                artist = "Harry Styles",
                year = "2019",
                imageRes = R.drawable.fine_line
            ),
            Artwork(
                title = "Harry's House",
                artist = "Harry Styles",
                year = "2022",
                imageRes = R.drawable.harrys_house
            ),
            Artwork(
                title = "Kiss All The Time. Disco, Occasionally",
                artist = "Harry Styles",
                year = "2026",
                imageRes = R.drawable.kiss_all_the_time
            )
        )
    }

    var currentIndex by remember { mutableStateOf(0) }
    val currentArtwork = artList[currentIndex]

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF8FAFC))
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(vertical = 16.dp)
                .shadow(elevation = 8.dp, shape = RoundedCornerShape(16.dp)),
            color = Color.White,
            shape = RoundedCornerShape(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = currentArtwork.imageRes),
                    contentDescription = currentArtwork.title,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(180.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFECEFF1))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = currentArtwork.title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1E293B)
                )
                Row {
                    Text(
                        text = currentArtwork.artist,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF0284C7)
                    )
                    Text(
                        text = " (${currentArtwork.year})",
                        color = Color(0xFF64748B)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Botón Anterior
            Button(
                onClick = {
                    currentIndex = if (currentIndex > 0) currentIndex - 1 else artList.size - 1
                },
                modifier = Modifier.width(130.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text("Anterior")
            }

            // Botón Siguiente
            Button(
                onClick = {
                    currentIndex = (currentIndex + 1) % artList.size
                },
                modifier = Modifier.width(130.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text("Siguiente")
            }
        }
    }
}
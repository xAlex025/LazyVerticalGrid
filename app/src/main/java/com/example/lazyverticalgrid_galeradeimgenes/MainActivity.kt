package com.example.lazyverticalgrid_galeradeimgenes

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lazyverticalgrid_galeradeimgenes.ui.theme.LazyVerticalGridGaleríaDeImágenesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GaleriaDeImagenes()
        }
    }
}

@Composable
fun GaleriaDeImagenes() {
    val imagenes = listOf(
        ElementoDeImagen(R.drawable.cat, "Gato"),
        ElementoDeImagen(R.drawable.dog, "Perro"),
        ElementoDeImagen(R.drawable.lion, "León"),
        ElementoDeImagen(R.drawable.elephant, "Elefante"),
        ElementoDeImagen(R.drawable.giraffe, "Jirafa"),
        ElementoDeImagen(R.drawable.penguin, "Pingüino"),
        ElementoDeImagen(R.drawable.tiger, "Tigre"),
        ElementoDeImagen(R.drawable.zebra, "Cebra")
    )
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize()
            .systemBarsPadding(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(imagenes) { imagen ->
            TarjetaDeImagen(imagen)
        }
    }
}

@Composable
fun TarjetaDeImagen(imagen: ElementoDeImagen) {
    val contexto = LocalContext.current
    Column(
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                Toast.makeText(contexto, " ${imagen.titulo}", Toast.LENGTH_SHORT).show()
            }
            ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imagen.idRecurso),
            contentDescription = imagen.titulo,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = imagen.titulo,
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )
    }
}

data class ElementoDeImagen(
    val idRecurso: Int,
    val titulo: String
)

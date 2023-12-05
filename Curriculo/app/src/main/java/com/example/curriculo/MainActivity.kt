package com.example.curriculo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CurriculumVitaeApp()
        }
    }
}

@Composable
fun CurriculumVitaeApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "perfil") {
        composable("perfil") { PerfilScreen(navController) }
        composable("experiencia") { ExperienciaScreen() }
        composable("contato") { ContatoScreen() } // Adicionando a rota para a tela de contato
    }
}

@Composable
fun PerfilScreen(navController: NavHostController) {
    BackgroundImage {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Álvaro Jorge",
                fontWeight = FontWeight.Bold,
                fontSize = 35.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .shadow(elevation = 4.dp,
                        shape = RoundedCornerShape(15.dp),)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Curriculo",
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier.shadow(
                    elevation = 0.1.dp,
                    shape = RoundedCornerShape(15.dp)
                )
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { navController.navigate("experiencia") },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF808080)),
                modifier = Modifier.shadow(
                    elevation = 0.1.dp,
                    shape = RoundedCornerShape(5.dp)
                )
            ) {
                Text(text = "Conheça mais sobre mim", color = Color.White)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { navController.navigate("contato") },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF808080)),
                modifier = Modifier.shadow(
                    elevation = 0.1.dp,
                    shape = RoundedCornerShape(5.dp)
                )
            ) {
                Text(text = "Entre em contato", color = Color.White)
            }
        }
    }
}



@Composable
fun ExperienciaScreen() {
    BackgroundImage {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Habilidades", fontWeight = FontWeight.ExtraBold, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "• Estudante de Ciência da Computação na UNICAP\n")
            Text(text = "• C/C++, JAVA, js, HTML, CSS, SQL(Cursando)\n")
            Text(text = "• Inglês Avançado\n")
            Text(text= "• Freelancer a 9 meses\n")
        }
    }
}

@Composable
fun ContatoScreen() {


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Contato", fontWeight = FontWeight.Bold, fontSize = 24.sp)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "• Telefone: (81) 998991188\n")
            Text(text = "• email: alvarocarrazzoni@gmail.com\n")
            Text(text = "• endereço: Av Rui Barbosa 845\n")

    }
}




@Composable
fun BackgroundImage(content: @Composable () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.marble),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
        content()
    }
}
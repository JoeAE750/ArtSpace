package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpace()
                }
            }
        }
    }
}

@Composable
fun ArtSpace(){

    var currentArt by remember { mutableStateOf(1) }

    Column(horizontalAlignment = Alignment.CenterHorizontally){

        when(currentArt){
            1 -> ArtImageAndInfo(R.drawable.pastel_blue_sea,stringResource(R.string.title1),stringResource(R.string.artist1))
            2 -> ArtImageAndInfo(R.drawable.the_colors_of_life,stringResource(R.string.title2),stringResource(R.string.artist2))
            3 -> ArtImageAndInfo(R.drawable.big_sky_longhorn,stringResource(R.string.title3),stringResource(R.string.artist3))
            4 -> ArtImageAndInfo(R.drawable.la_collina_dei_papaveri,stringResource(R.string.title4),stringResource(R.string.artist4))
        }


        Row(verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.Center){
            Button(
                onClick = {
                    if(currentArt==1){
                        currentArt = 4
                    }else{
                        currentArt--
                    }
                }, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF244367), contentColor = Color(0XFFFFFFFF)),modifier = Modifier.padding(end= 15.dp)
            ) {
                Text(text = stringResource(R.string.previous))
            }
            Button(
                onClick = {
                    if(currentArt==4){
                        currentArt = 1
                    }else{
                        currentArt++
                    }
                }, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF244367), contentColor = Color(0XFFFFFFFF)),
            ) {
                Text(text = stringResource(R.string.next), textAlign = TextAlign.Center, modifier = Modifier.width(50.dp))
            }
        }
    }
}


@Composable
fun ArtImageAndInfo(imageid: Int, titleid: String, artistid: String){
    Column( modifier = Modifier.padding(top=50.dp,bottom=100.dp)){
        Image(painter = painterResource(imageid), contentDescription = titleid, modifier = Modifier.padding(40.dp))
        Box(modifier = Modifier.background(color = Color(0xFF54B1D8)).align(Alignment.CenterHorizontally).width(270.dp).height(50.dp)){
            Text(text = titleid, modifier = Modifier, textAlign = TextAlign.Justify, fontSize = 20.sp, fontWeight = FontWeight.ExtraLight)
            Text(text = artistid, modifier = Modifier.padding(0.dp,30.dp,0.dp,0.dp), textAlign = TextAlign.Justify, fontSize = 10.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview(){
    ArtSpace()
}

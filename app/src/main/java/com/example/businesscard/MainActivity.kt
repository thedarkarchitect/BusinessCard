package com.example.businesscard


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

private val androidGreen : Int = "#3DDC84".toColorInt()

@Composable
fun BusinessCardApp(modifier: Modifier = Modifier){
    Column (
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ContactDetails()
        Spacer(modifier = Modifier.height(300.dp))
        ContactInformation()
    }
}

@Composable
fun ContactDetails(modifier: Modifier = Modifier){

    Column (
        modifier = modifier.padding(top=50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(painter = painterResource(id = R.drawable.androidlogo)
            , contentDescription = "Logo")
        Text(text = stringResource(R.string.name))
        Text(text = stringResource(R.string.description), color = Color(androidGreen))
    }
}

@Composable
fun ContactInformation( modifier: Modifier = Modifier){
    Column (
        modifier = modifier
    ) {
        InfoRow(number = 1, text = "first")
        Spacer(modifier = modifier.height(10.dp))

        InfoRow(number = 2, text = "second")
        Spacer(modifier = modifier.height(10.dp))

        InfoRow(number = 3, text = "third")
    }
}

@Composable
fun InfoRow(number: Int ,  text : String, modifier: Modifier = Modifier){

    Row(
        modifier = modifier
    ){

        when (number){
            1 -> Icon(imageVector = Icons.Default.Phone , contentDescription = null, tint = Color(androidGreen))
            2 -> Icon(imageVector = Icons.Default.Share , contentDescription = null, tint = Color(androidGreen))
            else -> Icon(imageVector = Icons.Default.Email , contentDescription = null, tint = Color(androidGreen))

        }

        Spacer(modifier = modifier.width(10.dp))

        when(text){
                "first" -> Text(text = "+256 703326527")
                "second" -> Text(text = "@Android dev")
                else ->  Text(text = "horisroman@gmail.com")
        }

    }
}


@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}

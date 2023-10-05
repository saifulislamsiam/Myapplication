package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    createBizcard()
                }
            }
        }
    }
}
@Preview
@Composable
fun createBizcard() {
    val buttonClickedState = remember {
        mutableStateOf(false)
    }
    val contactInfoButtonClickedState = remember {
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(390.dp)
                .padding(1.dp),
            // Shape = RoundedCornerShape(15.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            colors = CardDefaults.cardColors(containerColor = White),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier.height(800.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Createimageprofile()
                Divider(
                    thickness = 0.5.dp,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f)
                )
                myinfo()
                Button(
                    onClick =
                    {
                        //Log.d("Clicked","CreatBizCard:Clicked")}
                    buttonClickedState.value = !buttonClickedState.value
                    }
                )
                {
                    Text(
                        text = "Protfolio",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                if (buttonClickedState.value) {
                    Content()
                } else {
                    Box {
                    }
                }
                Button(onClick = {
                    contactInfoButtonClickedState.value = !contactInfoButtonClickedState.value
                }
                ) {
                    Text(text = "Contact Information", style = MaterialTheme.typography.bodyLarge)
                }
                if (contactInfoButtonClickedState.value) {
                    ContactInformation()
                } else {
                    Box { }
                }
            }
        }
    }
}
@Preview
@Composable
fun Content()
{
   Box(modifier = Modifier
       .fillMaxHeight()
       .fillMaxWidth()
       .padding(5.dp)){
       Surface(modifier = Modifier
           .padding(3.dp)
           .fillMaxWidth()
           .fillMaxHeight(),
           shape = RoundedCornerShape(CornerSize(6.dp)),
       border = BorderStroke(width = 2.dp,color=Color.LightGray)
       ) {
           Portfolio(data= listOf(" Project 1"," Project 2"," project 3"," project 4"," project 5"," project 6"))
       }
   }
}
@Composable
fun Portfolio(data: List<String>) {
    LazyColumn{
        items(data){
            item ->
            //Text(item)
            Card(modifier = Modifier
                .padding(13.dp)
                .fillMaxWidth(),shape= RectangleShape) {
                Row(modifier = Modifier
                    .padding(1.dp)
                    //.background(MaterialTheme.colorScheme.surface)
                    .padding(1.dp))
                {
                    //Createimageprofile(modifier = Modifier.size(100.dp))
                    Createimageprofile2(modifier = Modifier.size(100.dp))
                    Column(modifier = Modifier
                        .padding(7.dp)
                        .align(alignment = Alignment.CenterVertically)){
                        Text(text=item, fontWeight = FontWeight.Bold)
                        Text(text = "Good Project..", style = MaterialTheme.typography.bodySmall)

                    }
                }

            }
        }
    }
}
@Composable
private fun myinfo() {
    Column(modifier = Modifier.padding(3.dp))
    {
        Text(
            text = "Saiful Islam Rumi",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "I am a Programmer",
            modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = "@saifulislam",
            modifier = Modifier.padding(1.dp),
            style = MaterialTheme.typography.bodyLarge
        )

    }
}
@Composable
private fun Createimageprofile(modifier: Modifier=Modifier) {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        shadowElevation = 4.dp,
        //scaleType="center",
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
    )
    {
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "profile image",
            modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )
    }
}
@Composable
private fun Createimageprofile2(modifier: Modifier=Modifier) {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        shadowElevation = 4.dp,
        //scaleType="center",
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
    )
    {
        Image(
            painter = painterResource(id = R.drawable.profile2_image),
            contentDescription = "profile2 image",
            modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )
    }
}
@Composable
fun ContactInformation()
{
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        Text(text = "Contact Information",
            style=MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Email: saifulislamsiam066.com",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(text="Phone: 01833722662",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(text="Address: Rongipara,Agrabad,Chittagong,Bangladesh",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        createBizcard()
    }
}




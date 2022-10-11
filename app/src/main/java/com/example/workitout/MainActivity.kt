package com.example.workitout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.workitout.data.Workout
import com.example.workitout.data.workouts
import com.example.workitout.ui.theme.WorkItOutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorkItOutTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    WorkoutApp()
                }
            }
        }
    }
}

@Composable
fun WorkoutApp() {
    Scaffold(
        topBar = {
            WorkoutTopAppBar()
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(4.dp)
        ) {
            items(workouts) {
                WorkoutCard(workout = it)
            }
        }
    }
}

@Composable
fun WorkoutCard(workout: Workout, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }

    Card(modifier = modifier.padding(8.dp), elevation = 4.dp) {
        Column(
            modifier = Modifier.animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
        ) {
            Image(
                painter = painterResource(id = workout.imageResourceId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .fillMaxWidth()
                    .height(194.dp)
            )
            Row {
                Text(
                    text = stringResource(id = workout.name),
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.h3
                )
                Spacer(modifier = Modifier.weight(1f))
                WorkoutIcon(
                    expanded = expanded
                ) { expanded = !expanded }
            }
            if (expanded) {
                Text(
                    text = stringResource(id = workout.description),
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Composable
private fun WorkoutIcon(
    expanded: Boolean,
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            tint = MaterialTheme.colors.secondary,
            contentDescription = stringResource(R.string.expand_button_content_description)
        )
    }
}

@Composable
private fun WorkoutTopAppBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .background(color = MaterialTheme.colors.background)
            .fillMaxWidth()
            .height(56.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.h1
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultLightThemePreview() {
    WorkItOutTheme {
        WorkoutApp()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultDarkThemePreview() {
    WorkItOutTheme(darkTheme = true) {
        WorkoutApp()
    }
}
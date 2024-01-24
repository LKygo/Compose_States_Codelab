package com.kygoinc.composestatescodelab

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WellnessScreen() {


    LazyColumn() {
        items(wellnessList.size) { item ->

            var _checked by rememberSaveable { mutableStateOf(false) }


            Surface (modifier = Modifier
                .padding(4.dp)
                .padding(horizontal = 4.dp),
                shadowElevation = 8.dp
            ){
                WellnessCounter(
                    wellnessList[item],
                    checked = _checked,
                    onCheckChange = { _checked = !_checked },
                    onClear = { wellnessList.removeAt(item) }
                )
            }

        }
    }
}

val wellnessList = mutableStateListOf<String>(
    "Meditation",
    "Yoga",
    "Walking",
    "Running",
    "Cycling",
    "Gym",
    "Swimming",
    "Dancing",
    "Reading",
    "Writing",
    "Drawing",
    "Painting",
    "Cooking",
    "Gardening",
    "Cleaning",
    "Listening to music",
    "Playing music",
    "Singing",
    "Watching TV",
    "Watching movies",
    "Playing games",
    "Talking to friends",
    "Talking to family",
    "Talking to colleagues",
    "Talking to strangers",
    "Talking to pets",
    "Talking to yourself",
    "Playing with pets",
    "Playing with kids",
    "Playing with friends",
    "Playing with family",
    "Playing with colleagues",
    "Playing with strangers",
    "Playing with yourself",
    "Eating",
    "Drinking",
    "Sleeping",
    "Bathing",
    "Brushing teeth",
    "Shaving",
    "Washing face",
    "Washing hands",
    "Washing hair",
    "Washing body",
    "Washing clothes",
    "Washing dishes",
    "Washing car",
    "Washing bike",
    "Washing scooter",
    "Washing shoes",
    "Washing socks",
    "Washing underwear",
    "Washing bedsheets",
    "Washing pillow covers",
    "Washing curtains",
    "Washing towels",
    "Washing blankets",
    "Washing carpets",
    "Washing rugs",
    "Washing furniture",
    "Washing walls",
    "Washing windows",
    "Washing doors",
    "Washing mirrors",
    "Washing utensils",
    "Washing cutlery",
    "Washing appliances",
    "Washing electronics",
    "Washing gadgets",
    "Washing toys",
    "Washing tools",
    "Washing equipment",
    "Washing machines",
    "Washing vehicles",
    "Washing instruments",
    "Washing instruments",
    "Washing tools",
    "Washing equipment",
    "Washing machines",
    "Washing vehicles",
    "Washing instruments",
    "Washing tools",
    "Washing equipment",
    "Washing machines",
    "Washing vehicles",
    "Washing instruments",
)

private data class WellnessTask(val name: String, var checked: Boolean)

@Composable
fun WellnessCounter(
    taskName: String, checked: Boolean, onCheckChange: (Boolean) -> Unit, onClear: () -> Unit
) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 16.dp)
                .background(color = MaterialTheme.colorScheme.surface),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = taskName, modifier = Modifier.fillMaxWidth(0.8f), style = TextStyle(
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontWeight = FontWeight(400)
                )
            )

            Checkbox(
                checked = checked, onCheckedChange = onCheckChange
            )

            IconButton(
                onClick = onClear,
                modifier = Modifier,
            ) {
                Icon(Icons.Default.Clear, contentDescription = "Clear")
            }
        }

}


@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun WellnessScreenPreview() {
    WellnessScreen()
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF, widthDp = 360)
@Composable
fun WellnessCounterPreview() {
    WellnessCounter("", checked = false, onCheckChange = {}, onClear = {})
}
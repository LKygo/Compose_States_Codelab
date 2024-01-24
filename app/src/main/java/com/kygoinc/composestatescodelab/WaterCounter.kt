package com.kygoinc.composestatescodelab

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WaterCounter() {

    var count by rememberSaveable { mutableIntStateOf(0) }
    Surface(
        modifier = Modifier
            .padding(8.dp),
        shadowElevation = 14.dp
    )
    {
        Column (
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(modifier = Modifier.padding(8.dp))
            Text(
                text = if (count > 0) "You have taken $count glasses of water today" else "Take a glass of water to start counting",
                style = TextStyle(
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Button(
                    onClick = { count++ },
                    modifier = Modifier
                        .padding(16.dp)
                        .wrapContentHeight(),
                    enabled = count < 10,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    )
                ) {
                    Text(text = "Add a glass")
                }


                FilledTonalButton(
                    onClick = { count = 0 },
                    modifier = Modifier
                        .padding(16.dp)
                        .wrapContentHeight(),
                    enabled = count > 0,

                ) {
                    Text(text = "Reset")
                }
            }

        }
    }
}


@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun WaterCounterPreview() {
    WaterCounter()
}
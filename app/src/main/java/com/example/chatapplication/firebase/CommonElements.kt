package com.example.chatapplication.firebase

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatapplication.ui.theme.Back
import com.example.chatapplication.ui.theme.Gray
import com.example.chatapplication.ui.theme.Secondary


@Composable
fun Alert(
    isDialogOpen: MutableState<Boolean>,
    text: String,
    confirmButtonColor: Color,
    callback: () -> Unit
) {
    if (isDialogOpen.value) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Back)
        ) {
            AlertDialog(
                onDismissRequest = { isDialogOpen.value = false },
                confirmButton = {
                    Button(
                        onClick = {
                            callback()
                            isDialogOpen.value = false
                        },
                        colors = ButtonDefaults.buttonColors(confirmButtonColor)
                    ) { Text(text = "Yes") }
                },
                dismissButton = {
                    Button(
                        onClick = {
                            isDialogOpen.value = false
                        },
                        colors = ButtonDefaults.buttonColors(Gray)
                    ) { Text(text = "Cancel") }
                },
                containerColor = Secondary,
                title = { Text(text, color = com.example.chatapplication.ui.theme.Text, fontSize = 18.sp,  modifier = Modifier.padding(top = 12.dp, start = 8.dp, end = 8.dp)) })
        }
    }
}

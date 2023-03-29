package com.example.intents

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp

@Composable
fun Btn(title: String, context: Context){
  Button(onClick = { Operacion.onCall(context) },
  modifier = Modifier
    .fillMaxWidth()
    .padding(10.dp)
  ) {
    Text(title)
  }
}

@Composable
fun Btn_Ubicar(title: String, context: Context){
  Button(onClick = { Operacion.onUbicar(context) },
    modifier = Modifier
      .fillMaxWidth()
      .padding(10.dp)
  ) {
    Text(title)
  }
}

@Composable
fun Btn_Foto(title: String
             , context: Context
             , resultLauncher: ActivityResultLauncher<Intent>){
  Button(onClick = { Operacion.onFoto(context = context
    ,resultLauncher) },
    modifier = Modifier
      .fillMaxWidth()
      .padding(10.dp)
  ) {
    Text(title)
  }
}

@Composable
fun Foto(bitmap: Bitmap?) {
  bitmap?.let{foto ->
    Image(bitmap = foto.asImageBitmap()
      ,contentDescription = "Foto"
    , modifier = Modifier.height(85.dp))
  }
}
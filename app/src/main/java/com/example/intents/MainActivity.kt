package com.example.intents

import android.app.Activity
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.intents.ui.theme.IntentsTheme

class MainActivity : ComponentActivity() {

  //lateinit var bitmap:Bitmap

  private var bitmap by mutableStateOf<Bitmap?>(null)

  var resultLauncher = registerForActivityResult(
    ActivityResultContracts.StartActivityForResult()
  ) { result ->
    if (result.resultCode == Activity.RESULT_OK) {
      val extras = result.data?.extras
      bitmap = extras?.get("data") as Bitmap
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      IntentsTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize()
          , color = MaterialTheme.colors.background) {
          Column(modifier = Modifier.fillMaxWidth()){
            Btn(
              title = getString(R.string.custom_call)
              , baseContext)
            Btn_Ubicar(
              title = getString(R.string.custom_location)
              , baseContext)
            Btn_Foto(
              title = getString(R.string.custom_camera)
              , baseContext,resultLauncher)
            Foto(bitmap)
          }
        }
      }
    }
  }
}
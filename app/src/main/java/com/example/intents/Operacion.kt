package com.example.intents

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher

object Operacion {

  fun onCall(context: Context){
    Toast.makeText(context
      ,"estamos en onCall"
      ,Toast.LENGTH_SHORT).show()
    val numero:Uri = Uri.parse("tel:952952952")
    var intent = Intent(Intent.ACTION_DIAL,numero)
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    context.startActivity(intent)
  }

  fun onUbicar(context: Context){
    val location = Uri.parse("geo:0.0?q=" +
        "Universidad+Privada+Tacna,+Granada,+Tacna")
    val intent = Intent(Intent.ACTION_VIEW,location)
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    context.startActivity(intent)
  }

  fun onFoto(context: Context
             , resultLauncher: ActivityResultLauncher<Intent>) {
    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
    resultLauncher.launch(intent)
  }
}
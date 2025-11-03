package com.earsync.app

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { HelloMicApp() }
    }
}

@Composable
fun HelloMicApp() {
    val context = androidx.compose.ui.platform.LocalContext.current

    var hasMicPermission by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(
                context, Manifest.permission.RECORD_AUDIO
            ) == PackageManager.PERMISSION_GRANTED
        )
    }

    val requestPermissionLauncher =
        rememberLauncherForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            hasMicPermission = isGranted
            // TODO: hook up to your recorder start/stop later
        }

    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Hello World 👋")
            Spacer(Modifier.height(16.dp))
            if (hasMicPermission) {
                Text("Microphone permission: GRANTED")
                Spacer(Modifier.height(8.dp))
                Button(onClick = { /* TODO: start using audio later */ }) {
                    Text("Stub: Use Microphone")
                }
            } else {
                Text("Microphone permission: NOT GRANTED")
                Spacer(Modifier.height(8.dp))
                Button(onClick = {
                    requestPermissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
                }) {
                    Text("Request Microphone Permission")
                }
            }
        }
    }
}

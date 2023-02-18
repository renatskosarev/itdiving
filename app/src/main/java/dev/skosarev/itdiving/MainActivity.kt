package dev.skosarev.itdiving

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    private var cameraButton: MaterialButton? = null
    private var microphoneButton: MaterialButton? = null
    private var reactionsButton: MaterialButton? = null
    private var exitButton: MaterialButton? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cameraButton = findViewById(R.id.btn_camera)
        microphoneButton = findViewById(R.id.btn_microphone)
        reactionsButton = findViewById(R.id.btn_reactions)
        exitButton = findViewById(R.id.btn_exit)

        exitButton?.setOnClickListener {
            finish()
            exitProcess(0)
        }
    }
}
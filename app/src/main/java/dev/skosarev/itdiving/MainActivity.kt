package dev.skosarev.itdiving

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.constraintlayout.helper.widget.Flow
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import com.google.android.material.button.MaterialButton
import com.google.android.material.imageview.ShapeableImageView
import jp.wasabeef.glide.transformations.BlurTransformation
import jp.wasabeef.glide.transformations.ColorFilterTransformation
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    private var cameraButton: MaterialButton? = null
    private var microphoneButton: MaterialButton? = null
    private var reactionsButton: MaterialButton? = null
    private var exitButton: MaterialButton? = null
    private var messagesButton: MaterialButton? = null
    private var usersButton: MaterialButton? = null
    private var randomSortButton: MaterialButton? = null

    private var userCard1: ShapeableImageView? = null
    private var userCard2: ShapeableImageView? = null
    private var userCard3: ShapeableImageView? = null
    private var userCard4: ShapeableImageView? = null
    private var cardFlow: Flow? = null

    private var cameraIconState: Boolean = true
    private var microphoneIconState: Boolean = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        supportActionBar?.hide()

        cameraButton = findViewById(R.id.btn_camera)
        microphoneButton = findViewById(R.id.btn_microphone)
        reactionsButton = findViewById(R.id.btn_reactions)
        exitButton = findViewById(R.id.btn_exit)
        messagesButton = findViewById(R.id.btn_messages)
        usersButton = findViewById(R.id.btn_users)
        randomSortButton = findViewById(R.id.btn_sort)

        userCard1 = findViewById(R.id.user_card_1)
        userCard2 = findViewById(R.id.user_card_2)
        userCard3 = findViewById(R.id.user_card_3)
        userCard4 = findViewById(R.id.user_card_4)
        cardFlow = findViewById(R.id.card_flow)


        cameraButton?.setOnClickListener {
            if (cameraIconState) {
                cameraButton?.setIconResource(R.drawable.videocam_slash_alt_28)
                cameraButton?.setIconTintResource(R.color.background)
                cameraButton?.backgroundTintList = ColorStateList.valueOf(Color.WHITE)
            } else {
                cameraButton?.setIconResource(R.drawable.videocam_28)
                cameraButton?.setIconTintResource(R.color.white)
                cameraButton?.backgroundTintList = ColorStateList.valueOf(0x19191a)
            }
            cameraIconState = !cameraIconState
        }

        microphoneButton?.setOnClickListener {
            if (microphoneIconState) {
                microphoneButton?.setIconResource(R.drawable.microphone_slash_28)
                microphoneButton?.setIconTintResource(R.color.background)
                microphoneButton?.backgroundTintList = ColorStateList.valueOf(Color.WHITE)
            } else {
                microphoneButton?.setIconResource(R.drawable.microphone_alt_28)
                microphoneButton?.setIconTintResource(R.color.white)
                microphoneButton?.backgroundTintList = ColorStateList.valueOf(0x19191a)
            }
            microphoneIconState = !microphoneIconState
        }

        reactionsButton?.setOnClickListener {
            AlertDialog.Builder(this).setTitle("Привет").setMessage("Прекрасного дня! ❤️").show()
        }

        exitButton?.setOnClickListener {
            Toast.makeText(applicationContext, "До свидания!", Toast.LENGTH_SHORT).show()
            finish()
            exitProcess(0)
        }

        messagesButton?.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse("sms:")))
        }

        usersButton?.setOnClickListener {
            val intent = Intent(this, UsersActivity::class.java)
            startActivity(intent)
        }

        Glide.with(this)
            .load(R.drawable.user_1)
            .apply(bitmapTransform(MultiTransformation(BlurTransformation(25, 2), ColorFilterTransformation(Color.argb(90, 0, 0, 0)))))
            .into(userCard1!!)

        Glide.with(this)
            .load(R.drawable.user_2)
            .apply(bitmapTransform(MultiTransformation(BlurTransformation(25, 2), ColorFilterTransformation(Color.argb(90, 0, 0, 0)))))
            .into(userCard2!!)

        Glide.with(this)
            .load(R.drawable.user_3)
            .apply(bitmapTransform(MultiTransformation(BlurTransformation(25, 2), ColorFilterTransformation(Color.argb(90, 0, 0, 0)))))
            .into(userCard3!!)

        Glide.with(this)
            .load(R.drawable.user_4)
            .apply(bitmapTransform(MultiTransformation(BlurTransformation(25, 2), ColorFilterTransformation(Color.argb(90, 0, 0, 0)))))
            .into(userCard4!!)
    }
}
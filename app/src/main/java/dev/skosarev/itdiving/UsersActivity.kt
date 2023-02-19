package dev.skosarev.itdiving

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class UsersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)

        supportActionBar?.setBackgroundDrawable(ColorDrawable(0xffffff));
        supportActionBar?.title = "Контакты"
        val text: Spannable = SpannableString(supportActionBar!!.title)
        text.setSpan(ForegroundColorSpan(Color.BLACK), 0, text.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        supportActionBar!!.title = text

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CustomRecyclerAdapter(getUserNames())
    }

    private fun getUserNames(): List<String> {
        return this.resources.getStringArray(R.array.users).toList()
    }
}
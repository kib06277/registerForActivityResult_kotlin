package com.example.registerforactivityresult_kotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

//第二個跳轉頁面
class ArcherActivity : AppCompatActivity() {

    //基本宣告
    lateinit var aaMbMain: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_archer)

        val name = intent.getStringExtra("name")
        Log.d("maho", "姓名: $name")

        findViewById() //程式和 xml 關聯
        initClickListener() //點擊事件
    }

    //程式和 xml 關聯
    fun findViewById(){
        aaMbMain = findViewById(R.id.aaMbMain)
    }

    private fun initClickListener() {
        aaMbMain.setOnClickListener {

            val intent = Intent().apply {
                this.putExtra("weapon", "Unlimited Blade Works")
            }

            setResult(RESULT_OK, intent)
            finish()
        }
    }
}
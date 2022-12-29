package com.example.registerforactivityresult_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.button.MaterialButton

//首頁
class MainActivity : AppCompatActivity() {

    //基本宣告
    lateinit var amMbSaber: MaterialButton
    lateinit var amMbArcher: MaterialButton

    //進入點
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //綁定畫面

        findViewById() //程式和 xml 關聯
        initClickListener() //點擊事件
    }

    //程式和 xml 關聯
    fun findViewById(){
        amMbSaber = findViewById(R.id.amMbSaber)
        amMbArcher = findViewById(R.id.amMbArcher)
    }

    //點擊事件
    private fun initClickListener() {
        amMbSaber.setOnClickListener {
            val intent = Intent(this, SaberActivity::class.java).apply {
                this.putExtra("name", "Arthur")
            }

            resultLauncher.launch(intent)
        }

        amMbArcher.setOnClickListener {
            val intent = Intent(this, ArcherActivity::class.java).apply {
                this.putExtra("name", "Emiya")
            }

            resultLauncher.launch(intent)
        }
    }

    //回傳處理
    private val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { activityResult ->
        if (RESULT_OK == activityResult.resultCode) {
            Log.d("maho", "回傳: ${activityResult.data?.getStringExtra("weapon")}")
        }
    }
}
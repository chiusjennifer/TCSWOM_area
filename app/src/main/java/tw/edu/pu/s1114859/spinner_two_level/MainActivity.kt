package tw.edu.pu.s1114859.spinner_two_level

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var spinner1: Spinner
    private lateinit var spinner2: Spinner
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val homebtn:ImageButton=findViewById(R.id.homeBtn)
        spinner1 = findViewById(R.id.spinner1)
        spinner2 = findViewById(R.id.spinner2)

        // 设置Spinner1的数据
        val items1 = arrayOf("大雅區", "北區", "北屯區","西區","西屯區","霧峰區")
        val adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items1)
        spinner1.adapter = adapter1
        // 设置Spinner2的初始数据
        val items2 = arrayOf("財團法人基督教惠明盲人福利基金會")
        val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items2)
        spinner2.adapter = adapter2

        // 监听Spinner1的选择事件
        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // 当Spinner1的选择发生变化时，更新Spinner2的内容或状态
                when (position) {
                    0 -> {
                        val items2 = arrayOf("財團法人基督教惠明盲人福利基金會")
                        val adapter2 = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_dropdown_item, items2)
                        spinner2.adapter = adapter2
                    }
                    1 -> {
                        val items2 = arrayOf("財團法人天才社會福利慈善事業基金會")
                        val adapter2 = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_dropdown_item, items2)
                        spinner2.adapter = adapter2
                    }
                    2 -> {
                        val items2 = arrayOf("財團法人瑪利亞社會福利基金會")
                        val adapter2 = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_dropdown_item, items2)
                        spinner2.adapter = adapter2
                    }
                    3 -> {
                        val items2= arrayOf("財團法人向上社會福利基金會","財團法人臺灣省私立臺中仁愛之家")
                        val adapter2 = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_dropdown_item, items2)
                        spinner2.adapter = adapter2
                    }
                    4 -> {
                        val items2= arrayOf("財團法人富宇社會福利慈善事業基金會")
                        val adapter2 = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_dropdown_item, items2)
                        spinner2.adapter = adapter2
                    }
                    5 -> {
                        val items2= arrayOf("財團法人台灣省私立正豐社會福利慈善事業基金會")
                        val adapter2 = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_dropdown_item, items2)
                        spinner2.adapter = adapter2
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // 可以不实现此方法，或者根据需要添加逻辑
            }
        }
        // 监听Spinner2的选择事件
        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // 当Spinner2的选择发生变化时，显示Toast
                val selectedItem = parent?.getItemAtPosition(position).toString()
                Toast.makeText(applicationContext, "您选择了：$selectedItem", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // 可以不实现此方法，或者根据需要添加逻辑
            }
        }
        homebtn.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
            finish()
        }

    }


}
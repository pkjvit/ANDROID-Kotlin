package com.pkj.wow.androidkotlin.kotlin.coroutines


import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.pkj.wow.androidkotlin.R
import kotlinx.coroutines.*
import kotlin.concurrent.thread

class CoroutinesActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines)
        initView()

        Log.d("PLOG", Thread.currentThread().name)
    }

    private fun initView() {
        val button = findViewById<Button>(R.id.counter_btn)
        val longRunningButton = findViewById<Button>(R.id.do_action_btn)
        val counterLabel = findViewById<TextView>(R.id.counter_tv)

        button.setOnClickListener {
            Log.d("PLOG", "${Thread.currentThread().name}")
            counterLabel.text = "${counterLabel.text.toString().toInt() + 1}"
        }

        longRunningButton.setOnClickListener{
//            usingThread()
            CoroutineScope(Dispatchers.IO).launch {
                Log.d("PLOG", "CoroutineScope - ${Thread.currentThread().name}")
            }

            MainScope().launch(context = Dispatchers.Default){
                Log.d("PLOG", "MainScope - ${Thread.currentThread().name}")
            }

            GlobalScope.launch(context = Dispatchers.Main){
                Log.d("PLOG", "GlobalScope - ${Thread.currentThread().name}")
            }

        }

        /*CoroutineScope(Dispatchers.Main).launch{
            task1()
        }

        CoroutineScope(Dispatchers.Main).launch{
            task2()
        }*/

        val job = CoroutineScope(Dispatchers.Main).launch {
            printData2()
        }


    }

    private suspend fun printData2(){
        CoroutineScope(Dispatchers.IO).launch {
            var git = async {
                getDataFromGithub()
            }
            Log.d("PLOG", "Git - ${git}")
            var lin = getDataFromLinkedIn()
            Log.d("PLOG", "IN - $lin, Git - ${git.await()}")
        }
    }
    private suspend fun printData(){
        var linkedInData = 0
        var githubData = 0
        val job = CoroutineScope(Dispatchers.IO).launch {
            linkedInData = getDataFromLinkedIn()
        }
        job.join()

        val data = CoroutineScope(Dispatchers.IO).async {
            getDataFromGithub()
        }

        Log.d("PLOG", "IN - $linkedInData, Git - ${data.await()}")

    }

    private suspend fun getDataFromLinkedIn():Int{
        delay(5000)
        return 91
    }

    private suspend fun getDataFromGithub():Int{
        delay(3000)
        return 23
    }

    private suspend fun task1(){
        Log.d("PLOG", "STARTING TASK1 - ${Thread.currentThread().name}")
        delay(1000)
        Log.d("PLOG", "ENDING TASK1 - ${Thread.currentThread().name}")
    }

    private suspend fun task2(){
        Log.d("PLOG", "STARTING TASK2 - ${Thread.currentThread().name}")
        delay(1000)
        Log.d("PLOG", "ENDING TASK2 - ${Thread.currentThread().name}")
    }

    private fun usingThread(){
        thread(true){
            executeLongRunningTask()
        }
    }

    private fun executeLongRunningTask(){
        for(i in 1..1000000000L){

        }
    }
}
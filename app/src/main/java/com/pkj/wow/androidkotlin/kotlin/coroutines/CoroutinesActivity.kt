package com.pkj.wow.androidkotlin.kotlin.coroutines


import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.pkj.wow.androidkotlin.R
import kotlinx.coroutines.*
import kotlin.concurrent.thread

class CoroutinesActivity : AppCompatActivity() {

    lateinit var viewModel: CoroutinesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines)

        viewModel = ViewModelProvider(this).get(CoroutinesViewModel::class.java)
        initView()
        
        lifecycleScope.launch {
            Log.d("PLOG", "CoroutinesActivity->onCreate: lifecycle scope: ${Thread.currentThread().name}")
        }

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

        longRunningButton.setOnClickListener {
//            usingThread()
            CoroutineScope(Dispatchers.IO).launch {
                Log.d("PLOG", "CoroutineScope - ${Thread.currentThread().name}")
            }

            MainScope().launch(context = Dispatchers.Default) {
                Log.d("PLOG", "MainScope - ${Thread.currentThread().name}")
            }

            GlobalScope.launch(context = Dispatchers.Main) {
                Log.d("PLOG", "GlobalScope - ${Thread.currentThread().name}")
            }

        }


        /*CoroutineScope(Dispatchers.IO).launch {
            launch{execute()}
            executeNonSuspend()
        }*/


        var handler = CoroutineExceptionHandler { coroutineContext, throwable ->
            throwable.printStackTrace()
        }

        lifecycleScope.launch(handler) {
            launch {

                Log.d("PLOG", "CoroutinesActivity->initView: co1 started")
                launch {
                    Log.d("PLOG", "CoroutinesActivity->initView: co11 started")
                    throw Exception("co11 error")
                    Log.d("PLOG", "CoroutinesActivity->initView: co11 ended")
                }
                launch {
                    Log.d("PLOG", "CoroutinesActivity->initView: co12 started")
                    delay(1000)
                    Log.d("PLOG", "CoroutinesActivity->initView: co12 ended")
                }
                Log.d("PLOG", "CoroutinesActivity->initView: co1 ended")

            }
        }

        /*val handler = CoroutineExceptionHandler { coroutineContext, throwable ->
            Log.d("PLOG", "CoroutinesActivity->initView: ${throwable}")
        }
        CoroutineScope(Dispatchers.Main + handler).launch {
            supervisorScope {
                launch {
                    delay(2000)
                    throw Exception("Coroutine 1 failed")
                }
                launch {
                    delay(3000)
                    Log.d("PLOG", "CoroutinesActivity->initView: Coroutine 2 success")
                }
            }
        }*/

    }


    private fun executeNonSuspend(){
        Log.d("PLOG", "CoroutinesActivity->executeNonSuspend: S")
        Log.d("PLOG", "CoroutinesActivity->executeNonSuspend: E")
    }

    private suspend fun execute(){
        Log.d("PLOG", "CoroutinesActivity->execute: S")
        delay(2000)
        Log.d("PLOG", "CoroutinesActivity->execute: E")
    }

}
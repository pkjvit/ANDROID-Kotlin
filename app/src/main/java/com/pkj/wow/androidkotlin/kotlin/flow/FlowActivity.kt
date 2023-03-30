package com.pkj.wow.androidkotlin.kotlin.flow

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.pkj.wow.androidkotlin.R
import kotlinx.coroutines.launch

class FlowActivity: AppCompatActivity() {

    private val viewModel : FlowViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        viewModel = ViewModelProvider(this).get(FlowViewModel::class.java)

        val counter = findViewById<TextView>(R.id.counter)

        lifecycleScope.launch{
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.countDownFlow.collect{ count->
                    Log.d("PLOG", "FlowActivity->onCreate: countDownFlow : $count")
                    counter.text = count.toString()
                }
            }
        }

    }
}
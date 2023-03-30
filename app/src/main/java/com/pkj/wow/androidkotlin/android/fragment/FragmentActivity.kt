package com.pkj.wow.androidkotlin.android.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.HandlerThread
import androidx.recyclerview.widget.RecyclerView
import com.pkj.wow.androidkotlin.R

/*

commit, commitnow(), commitAllowStateLoss(), executePendingTransaction()
https://medium.com/@bherbst/the-many-flavors-of-commit-186608a015b1
 */
class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)


    }
}
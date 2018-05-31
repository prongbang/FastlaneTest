package com.touchtechnologies.fastlanetest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.touchtechnologies.fastlanetest.utils.StringUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRevert.setOnClickListener {

            tvOutput.text = StringUtil.revert(etMessage.text.toString())

        }

    }

}

package com.uuthman.common.androidtest

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import dagger.hilt.android.testing.HiltAndroidRule
import org.junit.After
import org.junit.Before
import org.junit.Rule


abstract class TodoAndroidTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    protected lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
        hiltRule.inject()
    }

    @After
    fun tearDown() {

    }

}
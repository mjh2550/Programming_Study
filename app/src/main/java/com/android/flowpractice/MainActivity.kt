package com.android.flowpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
class MainActivity : AppCompatActivity() {
    private val TAG = this.javaClass.simpleName

    private lateinit var viewModel: GithubViewModel
    private lateinit var viewModelFactory: GithubViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*CoroutineScope(Dispatchers.IO).launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                flowOfStrings.collect { data ->
                    Log.e(TAG, "flowOfStrings : $data")
                }
                printNumbers().collect { data ->
                    Log.e(TAG, ">> printNumbers() : $data")
                }
            }
        }*/

        viewModelFactory = GithubViewModelFactory(GithubRepository())
        viewModel = ViewModelProvider(this, viewModelFactory)[GithubViewModel::class.java]

        getGithubRepositories("retrofit")
    }

    private fun getGithubRepositories(query: String) {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.apply {
                    requestGithubRepositories(query)
                    githubRepositories.collect {
                        when (it) {
                            is ApiState.Success -> {
                                it.data?.let { data ->
                                    Log.e(TAG, "data - incomplete_results : ${data.incompleteResults}")
                                    val list = data.items
                                    for (i in list.indices) {
                                        Log.e(TAG, "license : ${list[i].license}")
                                        Log.d(TAG, list[i].fullName)
                                    }
                                }
                                mGithubRepositories.value = ApiState.Loading()
                            }
                            is ApiState.Error -> {
                                Log.e(TAG, "## 에러 : ${it.message}")
                                mGithubRepositories.value = ApiState.Loading()
                            }
                            is ApiState.Loading -> {}
                        }
                    }
                }
            }
        }
    }

    private val flowOfStrings = flow {
        for (number in 0..10) {
            emit("Emitting: $number")
        }
    }

    private fun printNumbers(): Flow<Int> = flow {
        for (i in 1..10) {
            emit(i) // emit(value: Int)
            Log.e(TAG, "$i emit됨")
        }
    }
}
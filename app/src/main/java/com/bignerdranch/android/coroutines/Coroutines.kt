package com.bignerdranch.android.coroutines

import kotlinx.coroutines.*
import kotlin.concurrent.thread


suspend fun main() =coroutineScope {  // Execute in main thread

    println("Main progrmam start ${Thread.currentThread().name}")

//thread{ // create a background thread (worker thread)
//
//    println("fake work start ${Thread.currentThread().name}")
//
//    Thread.sleep(1000) // pretend doing some work mny be file upload
//
//    println("fake work finshed ${Thread.currentThread().name}")
//
//}

    launch{ // create a coroutine in the  background thread (worker thread)

        println("fake work start ${Thread.currentThread().name}")

        //Thread.sleep(1000) // pretend doing some work mny be file upload & not good it will block entire thread
         delay(1000) // suspend fun , t1 is free (not blocking)
        println("fake work finshed ${Thread.currentThread().name}") // after delay ethier t1 or some other thread

    }

   // Thread.sleep(2000) //block the main thread and wait for coroutine to finish(not a right way )

    runBlocking { // create a coroutine that block the main thread
        delay(1000)// only called from suspend fun or from  inside  coroutine
    }

    println("Main progrmam ends ${Thread.currentThread().name}")

}
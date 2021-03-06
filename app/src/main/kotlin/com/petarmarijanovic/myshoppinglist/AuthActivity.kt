package com.petarmarijanovic.myshoppinglist

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.petarmarijanovic.myshoppinglist.screen.onboarding.OnBoardingActivity
import javax.inject.Inject

abstract class AuthActivity : AppCompatActivity() {
  
  @Inject
  lateinit var firebaseAuth: FirebaseAuth
  
  private val authStateListener: FirebaseAuth.AuthStateListener = FirebaseAuth.AuthStateListener {
    if (it.currentUser == null) {
      finish()
      startActivity(Intent(this, OnBoardingActivity::class.java))
    }
  }
  
  override fun onStart() {
    super.onStart()
    firebaseAuth.addAuthStateListener(authStateListener)
  }
  
  override fun onStop() {
    firebaseAuth.removeAuthStateListener(authStateListener)
    super.onStop()
  }
}

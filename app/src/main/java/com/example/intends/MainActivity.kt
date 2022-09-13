package com.example.intends

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.intends.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

private lateinit var binding: ActivityMainBinding
private lateinit var firebaseAuth:FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        val email:String = intent.getStringExtra("USER_EMAIL").toString()

        binding.email.setText(email)

        binding.signout.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            intent.putExtra("LAST_USER_LOGGED", email)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            firebaseAuth.signOut()
            finish()
        }


    }
}
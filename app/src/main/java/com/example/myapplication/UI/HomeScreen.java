package com.example.myapplication.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.example.myapplication.R;

public class HomeScreen extends AppCompatActivity {

    Animation anim;
    LottieAnimationView lottieAnimationView;

    TextView tvBankTitle;
    Button btnAllUsers, btnAllTransactions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);



        anim = AnimationUtils.loadAnimation(this, R.anim.animation);

        btnAllUsers = findViewById(R.id.all_users);
        btnAllTransactions = findViewById(R.id.all_transactions);
        tvBankTitle = findViewById(R.id.bank_title);
        lottieAnimationView=findViewById(R.id.lottie);


        tvBankTitle.setAnimation(anim);
        btnAllUsers.setAnimation(anim);
        btnAllTransactions.setAnimation(anim);
        lottieAnimationView.setAnimation(anim);
    }

   public void showAllUsers(View view) {
        Intent intent = new Intent(this, UsersList.class);
        startActivity(intent);
    }

    public void showAllTransactions(View view) {
        Intent intent = new Intent(this, TransactionHistory.class);
        startActivity(intent);
    }
}
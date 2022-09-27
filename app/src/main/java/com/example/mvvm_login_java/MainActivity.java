package com.example.mvvm_login_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mvvm_login_java.databinding.ActivityMainBinding;
import com.example.mvvm_login_java.viewModel.LoginViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        LoginViewModel obj = new LoginViewModel();

        activityMainBinding.setViewModel(new LoginViewModel());
        activityMainBinding.executePendingBindings();



        activityMainBinding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, obj.getToastMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @BindingAdapter("toastMessage")
    public static void runMe(View view, String message) {
        if (message != null) {
            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
        }
    }
}
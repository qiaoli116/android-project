package com.holmesglen.lab05multiscreenapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.holmesglen.lab05multiscreenapp.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

    }

    @Override
    public void onBackPressed() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("message", "Detail Screen Finished");
        setResult(RESULT_OK, resultIntent);
        super.onBackPressed();
    }
}

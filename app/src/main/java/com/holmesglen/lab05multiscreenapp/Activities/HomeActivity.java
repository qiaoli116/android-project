package com.holmesglen.lab05multiscreenapp.Activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.holmesglen.lab05multiscreenapp.PhoneBookDB.PhonebookDb;
import com.holmesglen.lab05multiscreenapp.R;


public class HomeActivity extends AppCompatActivity {

    public enum RequestCode{ 
        VIEW_DETAIL_REQUEST_CODE
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final EditText edtContactId = findViewById(R.id.edit_home_id);
        Button btnSubmit = findViewById(R.id.btn_show_detail);

        btnSubmit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(edtContactId.getText().toString());
                if(id > 0 && id < PhonebookDb.getInstance().getNumberOfContact()){
                    Intent intent = new Intent(HomeActivity.this, DetailActivity.class);
                    intent.putExtra("index_of_contact", id);
                    startActivityForResult(intent, RequestCode.VIEW_DETAIL_REQUEST_CODE.ordinal());
                    //startActivityForResult(intent, 0);
                }
            }
        });
        // start code
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RequestCode.VIEW_DETAIL_REQUEST_CODE.ordinal()){
            if(data != null && data.hasExtra("message")){
                String message = data.getStringExtra("message");
                Toast.makeText(getApplicationContext(),
                        "Message: " + message,
                        Toast.LENGTH_LONG).show();
            }else {
                // no message returned
            }
        } else {
            // the return code does not match
        }
    }
}

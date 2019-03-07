package com.gla.task7march;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText3;
    EditText editText4;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = editText3.getText().toString().trim();
                String pass = editText4.getText().toString().trim();
                SharedPreferences sharedPreferences = getSharedPreferences("com.gla.task7march",MODE_PRIVATE);
                String s_user=sharedPreferences.getString("user", "user");
                String s_pass=sharedPreferences.getString("pass","");
                if(user.equals(s_user)&& pass.equals(s_pass))
                {
                    Toast.makeText(MainActivity.this, "Passed", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("com.gla.task7march",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user","aastha.sanger_mca18@gla.ac.in");
        editor.putString("pass","12345");
        editor.apply();

    }

}

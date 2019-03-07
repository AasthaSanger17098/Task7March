package com.gla.task7march;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("com.gla.task7march",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("aastha.sanger+mca18@gla.ac.in",editText3.getText().toString().trim());
        editor.putString("123456",editText4.getText().toString().trim());
        editor.putBoolean("bool",true);
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("com.gla.task7march",MODE_PRIVATE);
        String s1 = sharedPreferences.getString("aastha.sanger+mca18@gla.ac.in","UserName");
        String s2 = sharedPreferences.getString("123456","Password");
        Boolean remember = sharedPreferences.getBoolean("bool",false);
        Toast.makeText(this, "bool: "+remember, Toast.LENGTH_SHORT).show();
        editText3.setText(s1);
        editText4.setText(s2);

    }
}

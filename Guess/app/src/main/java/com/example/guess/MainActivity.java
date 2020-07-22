package com.example.guess;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomNumber;
    public void randomnumber(){
        Random rand = new Random();
        int randomNumber = rand.nextInt(20) ;
        System.out.print(randomNumber);
    }
    public void guess(View view){
        EditText editText=(EditText) findViewById(R.id.editText);
        int guessValue = Integer.parseInt(editText.getText().toString());
        String message;
        if(guessValue > randomNumber){
            message = "lower";

        }
        else if(guessValue < randomNumber) {
            message="higher";
        }
        else{
            message="You got it!!";
             randomnumber();
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        Log.i("Entered Value",editText.getText().toString());
        Log.i("Random Number",Integer.toString(randomNumber));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            randomnumber();

    }
}

package com.example.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    class Number{
        int number;
        boolean isSquare()
        {
            double squareRoot = Math.sqrt(number);
            if (squareRoot == Math.floor(squareRoot)){
                return true;
            }else
            {
                return false;
            }
        }
        boolean isTriangular(){
            int x =1;
            int triangularNumber = 1;
            while(triangularNumber < number){
                x++;
                triangularNumber = triangularNumber + x;
            }
            if (triangularNumber == number){
                return true;
            }
            else {
                return false;
            }
        }
    }

    public void test (View view){
        Log.i("Info","pressed");
        EditText editText = (EditText)findViewById(R.id.editText);
        String message;
        if(editText.getText().toString().isEmpty()) {
        message="PLease enter a number";

        }
        else {
            Number myNumber = new Number();
            myNumber.number = Integer.parseInt(editText.getText().toString());
            message = editText.getText().toString();
            if (myNumber.isSquare() && myNumber.isTriangular()) {
                message += "is Square and triangular";
            } else if (myNumber.isSquare()) {
                message += " is Square";
            } else if (myNumber.isTriangular()) {
                message += " is Triangular";
            } else {
                message += " is Nothing";
            }
        }
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

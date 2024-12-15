package com.niquewrld.calculatorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    EditText etInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etInput = findViewById(R.id.editTextNumber);
    }

    public void Input(View view){
        Button btn = findViewById(view.getId());
        String btnText = String.valueOf(btn.getText());
        String currText = String.valueOf(etInput.getText());
        String newText = currText + btnText;
        etInput.setText(newText);
    }

    public void Calculate(View view) {
        String equation = etInput.getText().toString();

        try {
            Expression expression = new ExpressionBuilder(equation).build();
            double result = expression.evaluate();
            etInput.setText(String.valueOf(result));
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Invalid equation", Toast.LENGTH_SHORT).show();
        }
    }

    public void Clear(View view) {
        etInput.setText(null);
    }

    public void Delete(View view) {
        String currText = String.valueOf(etInput.getText());
        if(currText.length() > 0) {
            String newText = currText.substring(0, currText.length() - 1);
            etInput.setText(newText);
        }
    }

}
package com.example.chartsy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    ArrayList<EditText> inputs;
    float[] results;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputs = new ArrayList<>();
        results = new float[6];
        inputs.add((EditText)findViewById(R.id.cat1_input));
        inputs.add((EditText)findViewById(R.id.cat2_input));
        inputs.add((EditText)findViewById(R.id.cat3_input));
        inputs.add((EditText)findViewById(R.id.cat4_input));
        inputs.add((EditText)findViewById(R.id.cat5_input));
        inputs.add((EditText)findViewById(R.id.cat6_input));


    }

    public void calculate(View view) {
        int sum = 0;
        for(EditText i : inputs){
            sum += Integer.parseInt(i.getText().toString());
        }
        int j = 0;
        for(EditText n : inputs){
            float percent = (float)(Integer.parseInt(n.getText().toString())) / sum;
            percent *= 100;
            results[j] = percent;
            j++;
        }
        String msg = "Sum "+ sum;
        String r = Arrays.toString(results);
        Toast.makeText(this, r,
            Toast.LENGTH_LONG).show();

        Intent barsActivity = new Intent(getBaseContext(), Bars.class);
        barsActivity.putExtra("Results", results);
        startActivity(barsActivity);
    }
}

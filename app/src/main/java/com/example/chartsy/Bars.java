package com.example.chartsy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;

public class Bars extends AppCompatActivity {


  BarChart barChart;
  float[] results;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_bars);

    results = getIntent().getFloatArrayExtra("Results");
    barChart = (BarChart)findViewById(R.id.barchart);
    setUp();
  }

  protected void setUp(){
    barChart.setDrawBarShadow(false);

    barChart.setDrawValueAboveBar(true);
    barChart.setPinchZoom(false);
    barChart.setDrawGridBackground(true);
    ArrayList<BarEntry> barEntries = new ArrayList<>();

    for(int i =0; i < results.length; i++){
      barEntries.add(new BarEntry(i+1, results[i]));
    }

    BarDataSet barDataSet = new BarDataSet(barEntries, "Categories");
    barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);

    BarData data = new BarData(barDataSet);
    data.setBarWidth(0.9f);
    barChart.setData(data);

  }
}

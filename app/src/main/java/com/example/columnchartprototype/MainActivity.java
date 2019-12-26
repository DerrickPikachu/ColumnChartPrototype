package com.example.columnchartprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import java.util.ArrayList;

import lecho.lib.hellocharts.model.Column;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SubcolumnValue;
import lecho.lib.hellocharts.view.ColumnChartView;

public class MainActivity extends AppCompatActivity {

    ColumnChartView columnChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        columnChart = findViewById(R.id.chart);

        ArrayList<Column> columns = new ArrayList<>();
        ArrayList<SubcolumnValue> subColumn = new ArrayList<>();
        ArrayList<SubcolumnValue> subColumn2 = new ArrayList<>();
        subColumn.add(new SubcolumnValue(100, Color.RED));
        subColumn2.add(new SubcolumnValue(50, Color.BLUE));


        for (int i=0; i<10; i++) {
            Column column;
            if (i % 2 == 0) {
                column = new Column(subColumn2);
            }
            else {
                column = new Column(subColumn);
            }
            column.setHasLabels(true);
            columns.add(column);
        }

        ColumnChartData data = new ColumnChartData(columns);
        columnChart.setColumnChartData(data);
    }
}

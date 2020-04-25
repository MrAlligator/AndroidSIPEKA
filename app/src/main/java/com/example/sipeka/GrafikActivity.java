package com.example.sipeka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class GrafikActivity extends AppCompatActivity implements OnItemSelectedListener {

    private BarChart mBarChart;
    private Spinner opsi;
    int currentItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafik);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mBarChart = findViewById(R.id.chart);
        opsi = findViewById(R.id.opsi);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.grafik, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        opsi.setAdapter(adapter);

        opsi.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        if(currentItem==position) {
            createChart();
        }else {
            createChart2();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void createChart2() {
        float groupSpace = 0.04f;
        float barSpace = 0.02f;
        float barWidth = 0.3f;
        float tahunAwal = 2016f;

        // Data-data yang akan ditampilkan di Chart
        List<BarEntry> usia20 = new ArrayList<BarEntry>();
        usia20.add(new BarEntry(2016, 1500000));
        usia20.add(new BarEntry(2017, 1430000));
        usia20.add(new BarEntry(2018, 1750000));
        usia20.add(new BarEntry(2019, 1390000));

        List<BarEntry> usia40 = new ArrayList<BarEntry>();
        usia40.add(new BarEntry(2016, 1500000));
        usia40.add(new BarEntry(2017, 1430000));
        usia40.add(new BarEntry(2018, 1750000));
        usia40.add(new BarEntry(2019, 1390000));

        List<BarEntry> usia60 = new ArrayList<BarEntry>();
        usia60.add(new BarEntry(2016, 1500000));
        usia60.add(new BarEntry(2017, 1430000));
        usia60.add(new BarEntry(2018, 1750000));
        usia60.add(new BarEntry(2019, 1390000));

        // Pengaturan atribut bar, seperti warna dan lain-lain
        BarDataSet dataSet1 = new BarDataSet(usia20, "Usia 0 - 25");
        dataSet1.setColor(ColorTemplate.JOYFUL_COLORS[0]);

        BarDataSet dataSet2 = new BarDataSet(usia40, "Usia 26 - 50");
        dataSet2.setColor(ColorTemplate.JOYFUL_COLORS[1]);

        BarDataSet dataSet3 = new BarDataSet(usia60, "Usia > 50");
        dataSet3.setColor(ColorTemplate.JOYFUL_COLORS[2]);

        // Membuat Bar data yang akan di set ke Chart
        BarData barData = new BarData(dataSet1, dataSet2, dataSet3);

        // Pengaturan sumbu X
        XAxis xAxis = mBarChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM.BOTTOM);
        xAxis.setCenterAxisLabels(true);

        // Agar ketika di zoom tidak menjadi pecahan
        xAxis.setGranularity(1f);

        // Diubah menjadi integer, kemudian dijadikan String
        // Ini berfungsi untuk menghilankan koma, dan tanda ribuah pada tahun
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return String.valueOf((int) value);
            }
        });

        //Menghilangkan sumbu Y yang ada di sebelah kanan
        mBarChart.getAxisRight().setEnabled(false);

        // Menghilankan deskripsi pada Chart
        mBarChart.getDescription().setEnabled(false);

        // Set data ke Chart
        // Tambahkan invalidate setiap kali mengubah data chart
        mBarChart.setData(barData);
        mBarChart.getBarData().setBarWidth(barWidth);
        mBarChart.getXAxis().setAxisMinimum(tahunAwal);
        mBarChart.getXAxis().setAxisMaximum(tahunAwal + mBarChart.getBarData().getGroupWidth(groupSpace, barSpace) * 4);
        mBarChart.groupBars(tahunAwal, groupSpace, barSpace);
        mBarChart.setDragEnabled(true);
        mBarChart.invalidate();
    }

    private void createChart() {
        float groupSpace = 0.08f;
        float barSpace = 0.02f;
        float barWidth = 0.45f;
        float tahunAwal = 2016f;

        // Data-data yang akan ditampilkan di Chart
        List<BarEntry> dataPerempuan = new ArrayList<BarEntry>();
        dataPerempuan.add(new BarEntry(2016, 600000));
        dataPerempuan.add(new BarEntry(2017, 500000));
        dataPerempuan.add(new BarEntry(2018, 650000));
        dataPerempuan.add(new BarEntry(2019, 700000));

        List<BarEntry> dataLakilaki = new ArrayList<BarEntry>();
        dataLakilaki.add(new BarEntry(2016, 500000));
        dataLakilaki.add(new BarEntry(2017, 430000));
        dataLakilaki.add(new BarEntry(2018, 750000));
        dataLakilaki.add(new BarEntry(2019, 600000));

        // Pengaturan atribut bar, seperti warna dan lain-lain
        BarDataSet dataSet1 = new BarDataSet(dataPerempuan, "Perempuan");
        dataSet1.setColor(ColorTemplate.JOYFUL_COLORS[0]);

        BarDataSet dataSet2 = new BarDataSet(dataLakilaki, "Laki - Laki");
        dataSet2.setColor(ColorTemplate.JOYFUL_COLORS[1]);

        // Membuat Bar data yang akan di set ke Chart
        BarData barData = new BarData(dataSet1, dataSet2);

        // Pengaturan sumbu X
        XAxis xAxis = mBarChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM.BOTTOM);
        xAxis.setCenterAxisLabels(true);

        // Agar ketika di zoom tidak menjadi pecahan
        xAxis.setGranularity(1f);

        // Diubah menjadi integer, kemudian dijadikan String
        // Ini berfungsi untuk menghilankan koma, dan tanda ribuah pada tahun
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return String.valueOf((int) value);
            }
        });

        //Menghilangkan sumbu Y yang ada di sebelah kanan
        mBarChart.getAxisRight().setEnabled(false);

        // Menghilankan deskripsi pada Chart
        mBarChart.getDescription().setEnabled(false);

        // Set data ke Chart
        // Tambahkan invalidate setiap kali mengubah data chart
        mBarChart.setData(barData);
        mBarChart.getBarData().setBarWidth(barWidth);
        mBarChart.getXAxis().setAxisMinimum(tahunAwal);
        mBarChart.getXAxis().setAxisMaximum(tahunAwal + mBarChart.getBarData().getGroupWidth(groupSpace, barSpace) * 4);
        mBarChart.groupBars(tahunAwal, groupSpace, barSpace);
        mBarChart.setDragEnabled(true);
        mBarChart.invalidate();
    }
}

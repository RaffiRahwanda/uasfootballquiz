package com.example.footballquiz;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HasilKuis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_kuis);

        //Melakukan inisialisasi pada TextView hasil dan komponennya
        TextView hasil = (TextView) findViewById(R.id.hasil);
        //Melakukan inisialisasi pada TextView nilai dan komponennya
        TextView nilai = (TextView) findViewById(R.id.nilai);

        //Menampilkan jumlah jawaban benar dan jawaban salah pada TextView hasil
        hasil.setText("Jawaban Benar :"+MainActivity.benar+"\nJawaban Salah :"+MainActivity.salah);
        //Menampilkan Score pada TextView nilai
        nilai.setText(""+MainActivity.hasil);
    }

    //Membuat method ulangi agar user dapat mengerjakan kuis kembali
    //Kode ini dipanggil ketika user menekan tombol Ulangi Kuis
    public void ulangi(View view){
        finish();
        Intent a = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(a);
    }
}
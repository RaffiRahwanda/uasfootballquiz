package com.example.footballquiz;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Deklarasi variable dengan jenis TextView
    TextView kuis;
    //Deklarasi variable RadioGroup
    RadioGroup rg;
    //Deklarasi variable RadioButton
    RadioButton PilihanA, PilihanB, PilihanC, PilihanD;
    int nomor = 0;
    public static int hasil, benar, salah;

    //menyimpan pertanyaan kuis didalam array pertanyaan_kuis
    String[] pertanyaan_kuis = new String[]{
            "1. Tahun berapa turnamen pertama Euro digelar ",
            "2. Final Euro terbaru, yang diselenggarakan pada tahun 2016 dimenangkan oleh",
            "3. Berapa tahun sekali diadakannya kejuaraan Sepakbola Euro",
            "4. Klub mana yang paling banyak menjuarai Liga Champions",
            "5. Yang menjadi pemain terbaik di Liga Champions yang diadakan pada tahun 2020-2021",

    };

    //menyimpan pilihan jawaban didalam array pilihan_jawaban
    String[] pilihan_jawaban = new String[]{
            "1955", "1960", "1965", "1970",
            "Spanyol", "Portugal", "Jerman", "Perancis",
            "2 Tahun sekali", "3 Tahun sekali", "4 Tahun sekali", "5 Tahun sekali",
            "Barcelona", "Bayern Munchen", "Manchester United", "Real Madrid",
            "Kevin De Bruyne", "N'Golo Kante", "Toni Kroos", "Neymar Jr"
    };

    //menyimpan jawaban yang benar didalam array jawaban_benar
    String[] jawaban_benar = new String[]{
            "1960",
            "Portugal",
            "4 Tahun sekali",
            "Real Madrid",
            "N'Golo Kante"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Melakukan inisialisasi pada TextView dan komponennya
        kuis = (TextView) findViewById(R.id.kuis);
        //Melakukan inisialisasi pada RadioGroup dan komponennya
        rg = (RadioGroup) findViewById(R.id.pilihan);
        //Melakukan inisialisasi pada RadioButton dan komponennya
        PilihanA = (RadioButton) findViewById(R.id.pilihanA);
        PilihanB = (RadioButton) findViewById(R.id.pilihanB);
        PilihanC = (RadioButton) findViewById(R.id.pilihanC);
        PilihanD = (RadioButton) findViewById(R.id.pilihanD);

        kuis.setText(pertanyaan_kuis[nomor]);
        PilihanA.setText(pilihan_jawaban[0]);
        PilihanB.setText(pilihan_jawaban[1]);
        PilihanC.setText(pilihan_jawaban[2]);
        PilihanD.setText(pilihan_jawaban[3]);
        //Mengecek score benar/salah yang didapat dari RadioGroup mulai dari 0
        rg.check(0);
        benar = 0;
        salah = 0;
    }

    //Membuat method next untuk melanjutkan ke pertanyaan berikutnya
    public void next(View view) {
        if (PilihanA.isChecked() || PilihanB.isChecked() || PilihanC.isChecked() || PilihanD.isChecked()) {

            RadioButton jawaban_user = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
            String ambil_jawaban_user = jawaban_user.getText().toString();
            rg.check(0);
            if (ambil_jawaban_user.equalsIgnoreCase(jawaban_benar[nomor])) benar++;
            else salah++;
            nomor++;

            //membuat kondisi apakah nomor berkurang sesuai jumlah pertanyaan_kuis
            if (nomor < pertanyaan_kuis.length) {
                kuis.setText(pertanyaan_kuis[nomor]);
                PilihanA.setText(pilihan_jawaban[(nomor * 4) + 0]);
                PilihanB.setText(pilihan_jawaban[(nomor * 4) + 1]);
                PilihanC.setText(pilihan_jawaban[(nomor * 4) + 2]);
                PilihanD.setText(pilihan_jawaban[(nomor * 4) + 3]);

            } else {
                //hasil jawaban yang dipilih benar dikali 20
                hasil = benar * 20;
                Intent selesai = new Intent(getApplicationContext(), HasilKuis.class);
                startActivity(selesai);
            }
        }
        /*User harus memilih salah satu jawaban yang ada pada opsi pilihan jawaban untuk
        dapat melanjutkan ke soal berikutnya, apabila belum menjawab maka akan tampil
        pemberitahuan "Kamu Jawab Dulu"*/
        else {
            Toast.makeText(this,"Kamu Jawab Dulu",Toast.LENGTH_LONG).show();
        }
    }
}
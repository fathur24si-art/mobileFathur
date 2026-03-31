package com.example.fathur_carry// Nama package Anda

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivityLog"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        val etAlas = findViewById<EditText>(R.id.et_alas_segitiga)
        val etTinggi = findViewById<EditText>(R.id.et_tinggi_segitiga)
        val btnHitungSegitiga = findViewById<Button>(R.id.btn_hitung_segitiga)

        val etSisi = findViewById<EditText>(R.id.et_sisi_kubus)
        val btnHitungKubus = findViewById<Button>(R.id.btn_hitung_kubus)

        val tvHasil = findViewById<TextView>(R.id.tv_hasil)


        btnHitungSegitiga.setOnClickListener {
            val alasStr = etAlas.text.toString()
            val tinggiStr = etTinggi.text.toString()

            // Validasi agar tidak error jika input kosong
            if (alasStr.isEmpty() || tinggiStr.isEmpty()) {
                Toast.makeText(this, "Alas dan Tinggi tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                Log.e(TAG, "Error: Input segitiga kosong!") // Contoh log error
                return@setOnClickListener
            }

            val alas = alasStr.toDouble()
            val tinggi = tinggiStr.toDouble()

            // Rumus Luas Segitiga
            val luas = 0.5 * alas * tinggi

            val hasilTeks = "Luas Segitiga: $luas"
            tvHasil.text = hasilTeks

            // Mengirim hasil ke Logcat untuk belajar debugging
            Log.d(TAG, "Tombol Segitiga diklik. Alas: $alas, Tinggi: $tinggi. Hasil: $luas")
        }

        // --- Logika Tombol Hitung Volume Kubus ---
        btnHitungKubus.setOnClickListener {
            val sisiStr = etSisi.text.toString()

            if (sisiStr.isEmpty()) {
                Toast.makeText(this, "Panjang sisi tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                Log.e(TAG, "Error: Input kubus kosong!")
                return@setOnClickListener
            }

            val sisi = sisiStr.toDouble()

            // Rumus Volume Kubus
            val volume = sisi * sisi * sisi

            val hasilTeks = "Volume Kubus: $volume"
            tvHasil.text = hasilTeks

            // Mengirim hasil ke Logcat
            Log.d(TAG, "Tombol Kubus diklik. Sisi: $sisi. Hasil Volume: $volume")
        }
    }
}
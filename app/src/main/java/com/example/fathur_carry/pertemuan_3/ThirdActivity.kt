package com.example.fathur_carry.pertemuan_3

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
// Import ini otomatis dibuat berdasarkan nama file activity_third.xml
import com.example.fathur_carry.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {


    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityThirdBinding.inflate(layoutInflater)


        setContentView(binding.root)


        binding.btnKirim.setOnClickListener {
            val nomor = binding.inputNoTujuan.text.toString()

            if (nomor.isNotEmpty()) {
                Toast.makeText(this, "Pesan berhasil dikirim ke: $nomor", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Input tidak boleh kosong!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
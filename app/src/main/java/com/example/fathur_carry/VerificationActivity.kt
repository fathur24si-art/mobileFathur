package com.example.fathur_carry

import android.content.Intent
import android.os.Bundle
import android.view.animation.OvershootInterpolator
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fathur_carry.databinding.ActivityVerificationBinding

class VerificationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVerificationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ==========================================
        // BAGIAN 1: PERSIAPAN ANIMASI (PENTING!)
        // ==========================================
        // Sembunyikan semua elemen (transparansi 0) dan geser posisinya

        // Ikon mengecil ke 0
        binding.ivPhoneIcon.alpha = 0f
        binding.ivPhoneIcon.scaleX = 0f
        binding.ivPhoneIcon.scaleY = 0f

        // Judul & Subjudul geser ke kanan
        binding.tvTitle.alpha = 0f
        binding.tvTitle.translationX = 100f
        binding.tvSubTitle.alpha = 0f
        binding.tvSubTitle.translationX = 100f

        // Input Layout geser ke kiri
        binding.inputLayout.alpha = 0f
        binding.inputLayout.translationX = -100f

        // Tombol geser ke bawah
        binding.btnKirim.alpha = 0f
        binding.btnKirim.translationY = 100f


        // ==========================================
        // BAGIAN 2: MENJALANKAN ANIMASI (GAME VIBES)
        // ==========================================
        // Gunakan OvershootInterpolator untuk efek memantul

        // 1. Animasi Ikon (Pop Up) - Paling Pertama
        binding.ivPhoneIcon.animate()
            .alpha(1f)
            .scaleX(1f)
            .scaleY(1f)
            .setDuration(700)
            .setInterpolator(OvershootInterpolator())
            .start()

        // 2. Animasi Judul (Slide in from Right)
        binding.tvTitle.animate()
            .alpha(1f)
            .translationX(0f)
            .setDuration(600)
            .setStartDelay(200) // Sedikit delay setelah ikon
            .setInterpolator(OvershootInterpolator())
            .start()

        // 3. Animasi Subjudul (Slide in from Right)
        binding.tvSubTitle.animate()
            .alpha(1f)
            .translationX(0f)
            .setDuration(600)
            .setStartDelay(300) // Delay lebih lama
            .setInterpolator(OvershootInterpolator())
            .start()

        // 4. Animasi Input Layout (Slide in from Left)
        binding.inputLayout.animate()
            .alpha(1f)
            .translationX(0f)
            .setDuration(600)
            .setStartDelay(500) // Delay muncul setelah teks
            .setInterpolator(OvershootInterpolator())
            .start()

        // 5. Animasi Tombol (Slide up from Bottom) - Paling Terakhir
        binding.btnKirim.animate()
            .alpha(1f)
            .translationY(0f)
            .setDuration(600)
            .setStartDelay(700) // Delay terlama
            .setInterpolator(OvershootInterpolator())
            .start()

        // ==========================================
        // BAGIAN 3: LOGIKA KLIK (TETAP SAMA)
        // ==========================================

        binding.btnKirim.setOnClickListener {
            val nomor = binding.etPhoneNumber.text.toString()

            if (nomor.isNotEmpty()) {
                val intent = Intent(this, SuccessActivity::class.java)
                intent.putExtra("NOMOR_HP", nomor)
                startActivity(intent)
                // Kita tidak menggunakan finish() di sini agar user bisa kembali
            } else {
                Toast.makeText(this, "Wajib isi nomor HP, Bos!", Toast.LENGTH_SHORT).show()
                binding.etPhoneNumber.error = "Nomor HP kosong"
            }
        }
    }
}
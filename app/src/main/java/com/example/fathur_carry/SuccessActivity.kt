package com.example.fathur_carry

import android.content.Intent
import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.example.fathur_carry.databinding.ActivitySuccessBinding

class SuccessActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuccessBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuccessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nomorDikirim = intent.getStringExtra("NOMOR_HP")

        if (nomorDikirim != null) {
            binding.tvSubtext.text = "Kode akses berhasil dikirim ke:\n$nomorDikirim"
        }

        // ==========================================
        // BAGIAN ANIMASI (GAME VIBES)
        // ==========================================

        // 1. Sembunyikan semua elemen (set transparansi ke 0 dan geser ke bawah)
        binding.ivSuccessIcon.alpha = 0f
        binding.ivSuccessIcon.scaleX = 0f
        binding.ivSuccessIcon.scaleY = 0f

        binding.tvTitle.alpha = 0f
        binding.tvTitle.translationY = 50f

        binding.tvSubtext.alpha = 0f
        binding.tvSubtext.translationY = 50f

        binding.btnSelesai.alpha = 0f
        binding.btnSelesai.translationY = 100f

        // 2. Jalankan animasi dengan gaya "Overshoot" (memantul/melewati batas sedikit)

        // Animasi Bintang (Muncul & Membesar)
        binding.ivSuccessIcon.animate()
            .alpha(1f)
            .scaleX(1f)
            .scaleY(1f)
            .setDuration(800)
            .setInterpolator(OvershootInterpolator())
            .start()

        // Animasi Judul (Meluncur ke atas)
        binding.tvTitle.animate()
            .alpha(1f)
            .translationY(0f)
            .setDuration(600)
            .setStartDelay(300) // Delay agar muncul berurutan
            .setInterpolator(OvershootInterpolator())
            .start()

        // Animasi Subteks (Meluncur ke atas)
        binding.tvSubtext.animate()
            .alpha(1f)
            .translationY(0f)
            .setDuration(600)
            .setStartDelay(450)
            .setInterpolator(OvershootInterpolator())
            .start()

        // Animasi Tombol (Meluncur dari bawah dengan pantulan kuat)
        binding.btnSelesai.animate()
            .alpha(1f)
            .translationY(0f)
            .setDuration(600)
            .setStartDelay(600)
            .setInterpolator(OvershootInterpolator())
            .start()


        binding.btnSelesai.setOnClickListener {
            val intent = Intent(this, VerificationActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}
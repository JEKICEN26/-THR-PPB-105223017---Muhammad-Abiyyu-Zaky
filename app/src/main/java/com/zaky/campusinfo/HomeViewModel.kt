package com.zaky.campusinfo

import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    // Menyediakan data pengumuman (minimal 5 data statis)
    val announcements = listOf(
        Announcement(1, "Libur Idul Fitri 1446 H", "25 Mar 2026", "Akademik", "Pemberitahuan libur hari raya Idul Fitri untuk seluruh civitas akademika Universitas Pertamina."),
        Announcement(2, "Rapat Koordinasi Divisi Informasi & Publikasi HMIK", "26 Mar 2026", "Organisasi", "Diharapkan kehadiran seluruh anggota divisi untuk membahas timeline proker bulan depan."),
        Announcement(3, "Pendaftaran Kepanitiaan Ospek Mahasiswa Baru", "28 Mar 2026", "Kemahasiswaan", "Ayo berkontribusi menyambut mahasiswa baru! Pendaftaran panitia Ospek telah dibuka."),
        Announcement(4, "Jadwal Pengisian KRS Semester 6", "02 Apr 2026", "Akademik", "Batas waktu pengisian Kartu Rencana Studi (KRS) untuk semester 6. Pastikan tidak terlambat!"),
        Announcement(5, "Pendaftaran Turnamen Basket Kampus", "05 Apr 2026", "Olahraga", "Segera daftarkan tim basket terbaikmu untuk ajang turnamen rektor cup tahun ini.")
    )
}
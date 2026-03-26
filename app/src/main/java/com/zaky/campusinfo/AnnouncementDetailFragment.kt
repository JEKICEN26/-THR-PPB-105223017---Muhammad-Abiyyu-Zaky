package com.zaky.campusinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.zaky.campusinfo.databinding.FragmentAnnouncementDetailBinding

class AnnouncementDetailFragment : Fragment() {

    private var _binding: FragmentAnnouncementDetailBinding? = null
    private val binding get() = _binding!!

    // Inisialisasi ViewModel untuk mengambil data statis
    private val viewModel: HomeViewModel by viewModels()

    // Menerima Safe Args
    private val args: AnnouncementDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Terapkan View Binding
        _binding = FragmentAnnouncementDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Ambil ID dari Safe Args
        val announcementId = args.announcementId

        // 2. Cari data pengumuman berdasarkan ID
        val announcement = viewModel.announcements.find { it.id == announcementId }

        // 3. Tampilkan data ke layar jika ditemukan
        announcement?.let {
            binding.tvDetailTitle.text = it.title
            binding.tvDetailDate.text = it.date
            binding.tvDetailCategory.text = it.category
            binding.tvDetailDescription.text = it.description
        }

        // 4. Tombol Back mengembalikan ke HomeFragment
        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Null-kan binding untuk mencegah memory leak
        _binding = null
    }
}
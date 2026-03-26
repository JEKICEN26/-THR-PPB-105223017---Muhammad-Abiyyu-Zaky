package com.zaky.campusinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.zaky.campusinfo.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    // Terapkan View Binding di semua Fragment [cite: 28]
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    // ViewModel hanya diinisialisasi sekali [cite: 29]
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup Adapter dan aksi klik
        val adapter = AnnouncementAdapter { announcementId ->
            // Kirim announcementId (Int) menggunakan Safe Args [cite: 26]
            val action = HomeFragmentDirections.actionHomeFragmentToAnnouncementDetailFragment(announcementId)
            findNavController().navigate(action)
        }

        binding.rvAnnouncements.layoutManager = LinearLayoutManager(requireContext())
        binding.rvAnnouncements.adapter = adapter

        // HomeFragment menampilkan minimal 5 data pengumuman (data statis di ViewModel)
        adapter.submitList(viewModel.announcements)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Null-kan binding di onDestroyView() untuk menghindari memory leak [cite: 29]
        _binding = null
    }
}
package com.example.tour.service;

import com.example.tour.model.Tour;
import com.example.tour.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class TourService {

    private final String uploadDirectory = System.getProperty("user.dir") + "/uploads";

    @Autowired
    private TourRepository tourRepository;

    public List<Tour>getAllTours() {
        return tourRepository.findAll();
    }

    public Optional<Tour>getTourById(Long id) {
        return tourRepository.findById(id);
    }

    public Tour saveTour(Tour tour, MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            Path filePath = Paths.get(uploadDirectory, fileName);
			Files.write(filePath, file.getBytes());
			tour.setImagePath("/uploads/" + fileName);  // Save the image path
        }
        return tourRepository.save(tour);
    }

    public void deleteTour(Long id) {
    	tourRepository.deleteById(id);
    }
}

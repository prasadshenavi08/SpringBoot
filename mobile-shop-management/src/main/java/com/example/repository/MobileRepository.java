package com.example.repository;

import com.example.model.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MobileRepository extends JpaRepository<Mobile, Long> {
    
    // Custom query to find mobiles by brand
    List<Mobile> findByBrand(String brand);
    
    // Custom query to get only available mobiles
    List<Mobile> findByAvailable(boolean available);
}

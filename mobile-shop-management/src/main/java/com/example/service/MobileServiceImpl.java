package com.example.service;

import com.example.model.Mobile;
import com.example.model.Order;
import com.example.model.User;
import com.example.repository.MobileRepository;
import com.example.repository.OrderRepository;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MobileServiceImpl implements MobileService {

    @Autowired
    private MobileRepository mobileRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    // Add a new mobile
    @Override
    public Mobile addMobile(Mobile mobile) {
        return mobileRepository.save(mobile);
    }

    // Get all mobiles
    @Override
    public List<Mobile> getAllMobiles() {
        return mobileRepository.findAll();
    }

    // Update mobile details
    @Override
    public Mobile updateMobile(Long id, Mobile mobile) {
        Optional<Mobile> existingMobile = mobileRepository.findById(id);
        if (existingMobile.isPresent()) {
            Mobile updatedMobile = existingMobile.get();
            updatedMobile.setBrand(mobile.getBrand());
            updatedMobile.setModel(mobile.getModel());
            updatedMobile.setPrice(mobile.getPrice());
            updatedMobile.setCondition(mobile.getCondition());
            updatedMobile.setAvailable(mobile.isAvailable());
            return mobileRepository.save(updatedMobile);
        }
        return null; // Mobile not found
    }

    // Delete a mobile
    @Override
    public String deleteMobile(Long id) {
        if (mobileRepository.existsById(id)) {
            mobileRepository.deleteById(id);
            return "Mobile deleted successfully!";
        } else {
            return "Mobile not found!";
        }
    }

    // Place an order
    @Override
    public String placeOrder(Long mobileId) {
        Optional<Mobile> mobileOpt = mobileRepository.findById(mobileId);
        if (mobileOpt.isPresent() && mobileOpt.get().isAvailable()) {
            Mobile mobile = mobileOpt.get();
            mobile.setAvailable(false); // Mark as sold
            mobileRepository.save(mobile);

            // Dummy user for now (in a real system, fetch logged-in user)
            User user = userRepository.findByUsername("testuser").orElse(null);
            if (user == null) {
                return "User not found!";
            }

            Order order = new Order(user, mobile, LocalDateTime.now(), "Pending");
            orderRepository.save(order);
            return "Order placed successfully!";
        } else {
            return "Mobile not available!";
        }
    }
}

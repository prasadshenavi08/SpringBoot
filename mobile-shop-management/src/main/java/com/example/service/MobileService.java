package com.example.service;

import com.example.model.Mobile;
import java.util.List;

public interface MobileService {
    Mobile addMobile(Mobile mobile);
    List<Mobile> getAllMobiles();
    Mobile updateMobile(Long id, Mobile mobile);
    String deleteMobile(Long id);
    String placeOrder(Long mobileId);
}

package com.iocl.Dispatch_Portal_Application.ServiceLayer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iocl.Dispatch_Portal_Application.Entity.MstCourier;
import com.iocl.Dispatch_Portal_Application.Repositaries.MstCourierRepository;

@Service
public class MstCourierService {

	@Autowired
    private MstCourierRepository mstCourierRepository;

    public List<MstCourier> findAll() {
        return mstCourierRepository.findAll();
    }

    public Optional<MstCourier> findById(String courierCode) {
        return mstCourierRepository.findById(courierCode);
    }

    public MstCourier save(MstCourier mstCourier) {
        return mstCourierRepository.save(mstCourier);
    }

    public void deleteById(String courierCode) {
        mstCourierRepository.deleteById(courierCode);
    }

}


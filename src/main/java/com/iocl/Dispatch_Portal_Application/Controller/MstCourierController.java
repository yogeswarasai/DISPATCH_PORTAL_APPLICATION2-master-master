package com.iocl.Dispatch_Portal_Application.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iocl.Dispatch_Portal_Application.Entity.MstCourier;
import com.iocl.Dispatch_Portal_Application.ServiceLayer.MstCourierService;


@RestController
@RequestMapping("/couriers")
public class MstCourierController {

	
	@Autowired
    private MstCourierService mstCourierService;

    @GetMapping
    public List<MstCourier> getAllCouriers() {
        return mstCourierService.findAll();
    }
	
    @GetMapping("/{courierCode}")
    public ResponseEntity<MstCourier> getCourierById(@PathVariable String courierCode) {
        Optional<MstCourier> courier = mstCourierService.findById(courierCode);
        return courier.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public MstCourier createCourier(@RequestBody MstCourier mstCourier) {
        return mstCourierService.save(mstCourier);
    }

    @PutMapping("/{courierCode}")
    public ResponseEntity<MstCourier> updateCourier(@PathVariable String courierCode, @RequestBody MstCourier mstCourier) {
        if (!mstCourierService.findById(courierCode).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        mstCourier.setCourierCode(courierCode);
        return ResponseEntity.ok(mstCourierService.save(mstCourier));
    }

    @DeleteMapping("/{courierCode}")
    public ResponseEntity<Void> deleteCourier(@PathVariable String courierCode) {
        if (!mstCourierService.findById(courierCode).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        mstCourierService.deleteById(courierCode);
        return ResponseEntity.noContent().build();
    }
}
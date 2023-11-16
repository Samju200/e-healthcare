//package com.samju.hospital.controller;
//
//import com.samju.hospital.entity.Doctor;
//import com.samju.hospital.service.DoctorService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/doctors")
//public class DoctorController {
//    @Autowired
//    private DoctorService doctorService;
//    @PostMapping
//    public ResponseEntity<Doctor> createDoctor(@RequestBody Map<String, String> payload) {
//        return new ResponseEntity<Doctor>(doctorService.createDoctorReport(payload.get("fullName"),payload.get("phoneNumber"),
//                payload.get("department"), payload.get("reports"), payload.get("registrationNumber")),
//                HttpStatus.OK);
//    }
//}
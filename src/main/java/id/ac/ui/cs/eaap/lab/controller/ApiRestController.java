package id.ac.ui.cs.eaap.lab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.ac.ui.cs.eaap.lab.service.KamarService;
import id.ac.ui.cs.eaap.lab.service.LokasiService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api")
public class ApiRestController {

    @Autowired
    LokasiService lokasiService;

    @Autowired
    KamarService kamarService;    


    @GetMapping("/kamar/tersedia")
    public ResponseEntity getKamarTersedia() {
        log.info("api get kamar tersedia");
        ResponseEntity responseEntity = ResponseEntity.ok("TODO");
        return responseEntity;
    }

    @GetMapping("/statistics")
    public ResponseEntity getLocationStatistics() {
        log.info("api location statistics");
        ResponseEntity responseEntity = ResponseEntity.ok("TODO");
        return responseEntity;
    }
}

package id.ac.ui.cs.eaap.lab.controller;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.ac.ui.cs.eaap.lab.model.BaseResponseDTO;
import id.ac.ui.cs.eaap.lab.model.KamarModel;
import id.ac.ui.cs.eaap.lab.model.LokasiModel;
import id.ac.ui.cs.eaap.lab.model.ResponseStat;
import id.ac.ui.cs.eaap.lab.service.KamarService;
import id.ac.ui.cs.eaap.lab.service.ListService;
import id.ac.ui.cs.eaap.lab.service.LokasiService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api")
public class ApiRestController {

    private final LokasiService lokasiService;
    private final KamarService kamarService;
    public ApiRestController(LokasiService lokasiService, KamarService kamarService) {
        this.lokasiService = lokasiService;
        this.kamarService = kamarService;
    }  


    @GetMapping("/kamar/tersedia")
    public ResponseEntity<?> getKamarTersedia() {
        log.info("api get kamar tersedia");

        List<KamarModel> a = kamarService.getTersedia();

        var response = new BaseResponseDTO<List<KamarModel>>();
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("Success");
        response.setData(a);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/statistics")
    public ResponseEntity<?> getLocationStatistics() {
        log.info("api location statistics");
        List<LokasiModel> a = lokasiService.findAll();
        var b = new ArrayList<ResponseStat>();

        
        for(LokasiModel lokasi : a){
            List<KamarModel> disewakan = kamarService.getDiSewakan(lokasi.getLokasiId()); 
            int jumlahSewa = disewakan.size();
            long jumlahUangSewa = 0;
            for(KamarModel kamar : disewakan){
                jumlahUangSewa += kamar.getHargaSewa();
            }
            ResponseStat c = new ResponseStat();
            c.setNamaLokasi(lokasi.getNamaLokasi());
            c.setKamarDisewakan(jumlahSewa);
            c.setTotalUangSewa(jumlahUangSewa);
            c.setTotalUangSewaTahunan(jumlahUangSewa*12);
            

            b.add(c);
            
        }
        var response = new BaseResponseDTO<List<ResponseStat>>();
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("Success");
        response.setData(b);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

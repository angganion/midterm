package id.ac.ui.cs.eaap.lab.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.eaap.lab.model.KamarModel;
import id.ac.ui.cs.eaap.lab.repository.KamarDb;

@Service
public class KamarService {

    @Autowired
    KamarDb kamarDb;

    public List<KamarModel> findAll() {
        return kamarDb.findAll();
    }

    public KamarModel addKamar(KamarModel a){
        return kamarDb.save(a);
    }

    public List<KamarModel> getLokasi(Long a){
        return kamarDb.getLokasi(a);
    }

    public KamarModel getKamarById(Long id){
        return kamarDb.findById2(id);
    }

    public KamarModel updateStatus(KamarModel a){
        KamarModel x = kamarDb.findById2(a.getKamarId());
        x.setStatus(a.getStatus());
        return kamarDb.save(x);

    }

    public List<KamarModel> getTersedia(){
        return kamarDb.getTersedia();
    }
    

}


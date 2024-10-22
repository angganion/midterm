package id.ac.ui.cs.eaap.lab.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.eaap.lab.model.LokasiModel;
import id.ac.ui.cs.eaap.lab.repository.LokasiDb;


@Service
public class LokasiService {

    @Autowired
    private LokasiDb lokasiDb;

    public List<LokasiModel> findAll() {
        return lokasiDb.findAll();
    }
}


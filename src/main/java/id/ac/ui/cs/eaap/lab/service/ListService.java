package id.ac.ui.cs.eaap.lab.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListService {

    public List<String> getStatusOptionsList() {
        List<String> optionList = new ArrayList<>(List.of("tersedia", "disewakan", "tidak tersedia"));
        return optionList;
    }

    public List<String> getKotaOptionsList() {
        List<String> optionList = new ArrayList<>(List.of("Depok", "Jakarta Pusat", "Bandung", "Semarang", "Yogyakarta"));
        return optionList;
    }
}

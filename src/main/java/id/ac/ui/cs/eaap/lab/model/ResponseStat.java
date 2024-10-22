package id.ac.ui.cs.eaap.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseStat {

    String namaLokasi;
    int kamarDisewakan;
    long totalUangSewa;
    long totalUangSewaTahunan;
    
}

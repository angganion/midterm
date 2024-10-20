package id.ac.ui.cs.eaap.lab.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lokasi")
public class LokasiModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lokasi_seq")
    @SequenceGenerator(name = "lokasi_seq", sequenceName = "lokasi_seq", allocationSize = 100, initialValue = 1000)
    @Column(name = "lokasi_id")
    private long lokasiId;
    @Column(name = "nama_lokasi")
    private String namaLokasi;
    @Column(name = "alamat")
    private String alamat;
    @Column(name = "kota")
    private String kota;
}

package id.ac.ui.cs.eaap.lab.model;

import java.io.Serializable;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "kamar")
public class KamarModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kamar_seq")
    @SequenceGenerator(name = "kamar_seq", sequenceName = "kamar_seq", allocationSize = 1, initialValue = 1000)
    @Column(name = "kamar_id")
    private long kamarId;
    @Column(name = "nomor_kamar")
    private String nomorKamar;
    @Column(name = "lantai")
    private String lantai;
    @Column(name = "harga_sewa")
    private int hargaSewa;
    @Column(name = "status")
    private String status;

    // Relasi dengan LokasiModel
    @ManyToOne
    @JoinColumn(name = "kamar_lokasi_id", referencedColumnName = "lokasi_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    LokasiModel lokasiModel;
}

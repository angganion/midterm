package id.ac.ui.cs.eaap.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import id.ac.ui.cs.eaap.lab.model.KamarModel;
import id.ac.ui.cs.eaap.lab.model.LokasiModel;

import java.util.List;

@Repository
public interface KamarDb extends JpaRepository<KamarModel, Long> {

    @Query(value = "SELECT * FROM kamar WHERE kamar_lokasi_id = :nik", nativeQuery = true)
    List<KamarModel> getLokasi(Long nik);

    @Query(value = "SELECT * FROM kamar WHERE kamar_id = :nik", nativeQuery = true)
    KamarModel findById2(Long nik);

    @Query(value = "SELECT * FROM kamar WHERE status LIKE 'tersedia' ", nativeQuery = true)
    List<KamarModel> getTersedia();

    @Query(value = "SELECT * FROM kamar WHERE status LIKE 'disewakan' AND kamar_lokasi_id = :id ", nativeQuery = true)
    List<KamarModel> getSewa(Long id);

    
}

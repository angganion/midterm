package id.ac.ui.cs.eaap.lab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import id.ac.ui.cs.eaap.lab.model.LokasiModel;

@Repository
public interface LokasiDb extends JpaRepository<LokasiModel, Long> {

    @Query(value = "SELECT * FROM lokasi WHERE lokasi_id = :nik", nativeQuery = true)
    LokasiModel findById2(Long nik);

    @Query(value = "SELECT * FROM lokasi WHERE lokasi.nama_lokasi ILIKE %:nik% ", nativeQuery = true)
    List<LokasiModel> search(String nik);

    
}

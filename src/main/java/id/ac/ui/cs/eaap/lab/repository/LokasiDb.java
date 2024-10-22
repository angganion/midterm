package id.ac.ui.cs.eaap.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import id.ac.ui.cs.eaap.lab.model.LokasiModel;

@Repository
public interface LokasiDb extends JpaRepository<LokasiModel, Long> {

    
}

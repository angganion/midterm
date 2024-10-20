package id.ac.ui.cs.eaap.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.ac.ui.cs.eaap.lab.model.DummyModel;

@Repository
public interface DummyRepository extends JpaRepository<DummyModel, Long> {

}

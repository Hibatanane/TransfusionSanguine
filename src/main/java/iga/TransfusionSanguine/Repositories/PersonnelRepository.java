package iga.TransfusionSanguine.Repositories;

import iga.TransfusionSanguine.Entities.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin("*")
public interface PersonnelRepository extends JpaRepository<Personnel,Integer> {
}

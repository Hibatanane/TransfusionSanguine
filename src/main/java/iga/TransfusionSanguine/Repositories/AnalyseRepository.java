package iga.TransfusionSanguine.Repositories;

import iga.TransfusionSanguine.Entities.Admin;
import iga.TransfusionSanguine.Entities.Analyse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
@CrossOrigin("*")
public interface AnalyseRepository extends JpaRepository<Analyse,Integer>
{
    Analyse findByDonIdDon(long idDon);
}

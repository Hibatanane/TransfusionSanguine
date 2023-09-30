package iga.TransfusionSanguine.Repositories;

import iga.TransfusionSanguine.Entities.Rdv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
public interface RdvRepository extends JpaRepository<Rdv, Integer> {

    @Query(value = "Select r From Rdv  r where r.donneurRdv.idPersonne=:idDonneur")
    List<Rdv> findRdvByIdDonneur(@Param("idDonneur") long idDonneur);

}

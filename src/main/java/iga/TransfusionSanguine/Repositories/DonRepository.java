package iga.TransfusionSanguine.Repositories;

import iga.TransfusionSanguine.Entities.Admin;
import iga.TransfusionSanguine.Entities.Don;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
@CrossOrigin("*")
public interface DonRepository extends JpaRepository<Don,Long>
{


    @Query("SELECT d.dateDn, d.quantiteDn, d.centre.nomC , d.idDon  FROM Don d WHERE d.donneurDon.idPersonne = :id")
    List<Object[]>findDonDetailsByIdDonneur(@Param("id") long id);


}


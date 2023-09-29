package iga.TransfusionSanguine.Repositories;

import iga.TransfusionSanguine.Entities.Admin;
import iga.TransfusionSanguine.Entities.Receveur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin("*")
public interface ReceveurRepository extends JpaRepository<Receveur,Integer>
{
    @Modifying
    @Transactional
    @Query(value = "insert  INTO Receveur (idPersonne) Values (:idPersonne)",nativeQuery = true)
    public void insererReceveur(@Param("idPersonne")long idPersonne);
}

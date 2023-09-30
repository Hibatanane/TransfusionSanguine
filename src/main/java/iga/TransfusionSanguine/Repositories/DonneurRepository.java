package iga.TransfusionSanguine.Repositories;

import iga.TransfusionSanguine.Entities.Admin;
import iga.TransfusionSanguine.Entities.Donneur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin("*")
public interface DonneurRepository extends JpaRepository<Donneur,Integer>
{
    @Modifying
    @Transactional
    @Query(value = "insert  INTO Donneur (idPersonne) Values (:idPersonne)",nativeQuery = true)
    public void insererDonneur(@Param("idPersonne")long idPersonne);

    @Query("Select d from Donneur d where d.idPersonne=:idPersonne")
    Donneur findByIdPersonne(@Param("idPersonne") long idPersonne);


}

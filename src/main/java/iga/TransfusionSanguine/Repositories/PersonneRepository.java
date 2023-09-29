package iga.TransfusionSanguine.Repositories;

import iga.TransfusionSanguine.Entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Integer> {
    @Query(value = "SELECT verified FROM personne WHERE mail= :mail", nativeQuery = true)
    int isVerified(@Param("mail") String mail);

    @Query(value = "SELECT mail FROM personne WHERE mail = :mail", nativeQuery = true)
    String isEmailExist(@Param("mail") String mail);

 Personne findByMail(String mail);
    @Modifying
    @Query(value = "INSERT INTO personne (nomP,prenom,mail,mdp,adresseP,dateP,latitude,longitude,num,sexe,ville,typePersonne,estPersonnel,estResponsable,estAdmin) VALUES" + "(:nomP,:prenom,:mail,:mdp,:adresseP,:dateP,:latitude,:longitude,:num,:sexe,:ville,:typePersonne,:estPersonnel,:estResponsable,:estAdmin)", nativeQuery = true)
    @Transactional
    void registerUser(@Param("nomP") String nomP,
                      @Param("prenom") String prenom,
                      @Param("mail") String mail,
                      @Param("mdp") String mdp,
                      @Param("adresseP") String adresseP,
                      @Param("dateP") LocalDate dateP,
                      @Param("latitude") Double latitude,
                      @Param("longitude") Double longitude,
                      @Param("num") String num,
                      @Param("sexe") String sexe,
                      @Param("ville") String ville,
                      @Param("typePersonne") String typePersonne,
                      @Param("estPersonnel") boolean estPersonnel,
                      @Param("estResponsable") boolean estResponsable,
                      @Param("estAdmin") boolean estAdmin
    );


    @Query(value="SELECT p from Personne p where p.mail=:mail")
    Personne getUser(@Param("mail") String mail);

}

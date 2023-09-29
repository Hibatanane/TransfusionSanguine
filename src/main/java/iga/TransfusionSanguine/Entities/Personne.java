package iga.TransfusionSanguine.Entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPersonne")
    private long idPersonne;
    @Column(length = 15)
    private String nomP;
    @Column(length = 15)
    private String prenom;
    private LocalDate dateP;
    @Column(length = 50)
    private String adresseP;
    @Column(length = 5)
    private String groupe;

    private String num;
    @Column(unique = true)
    @Email
    private String mail;

    @Column(length = 5)
    private String sexe;

    private double longitude;
    private double latitude;
    @Column(length = 20)
    private String ville;

    private String mdp;

    private boolean estPersonnel;
//donneur ou receveur
    @Column(length = 10)
    private String typePersonne;

    private boolean estAdmin;
    private boolean estResponsable;

}

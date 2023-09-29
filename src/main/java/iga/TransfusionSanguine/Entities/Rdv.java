package iga.TransfusionSanguine.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Rdv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idRdv;
    private LocalTime heureRdv;
    private LocalDate dateRdv;
    @Column(length = 10)
    private String confirmation;
    @Column(length = 30)
    private String centreAffecte;


    //----------------------------------------------------------//
    //      Relation entre Donneur-Rdv : Prendre   //

    @ManyToOne
    @JoinColumn(name = "idDonneur")
    private Donneur donneurRdv;

    @ManyToOne
    @JoinColumn(name="idPersonnel")
    private Personnel personnel;
}

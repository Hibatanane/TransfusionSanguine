package iga.TransfusionSanguine.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Collecte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCollecte;
    private LocalDate dateCo;
    @Column(length = 30)
    private String lieuCo;
    // statutCo --> pour montrer l'etat d'une collecte : terminé , en cours , prévu pour une date ..
    @Column(length = 15)
    private String statutCo;


    //      Relation entre Donneur-Collecte : Participer   //
    @ManyToMany
    @JoinTable(name = "participerCollecte",
            joinColumns = @JoinColumn(name = "idCollecte"),
            inverseJoinColumns = @JoinColumn(name = "idDonneur"))
    private List<Donneur> donneurs = new ArrayList<>();


    //  Centre-Collecte : Organiser //
    @ManyToOne
    @JoinColumn(name = "idCentre")
    private Centre centre;

    //  Don-Collecte : Inclure //

    @OneToMany(mappedBy = "collecte")
    private List<Don> dons;

}

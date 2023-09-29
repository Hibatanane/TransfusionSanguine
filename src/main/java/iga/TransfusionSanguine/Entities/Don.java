package iga.TransfusionSanguine.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Don {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDon;
    private LocalDate dateDn;
    private int quantiteDn;
    @Column(length = 10)
    private String typeDn;
    private boolean estStocke;

    //---------------------------------------------------//
    //     Relation entre Donneur-Don : Faire   //
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDonneur", nullable = false)
    private Donneur donneurDon;

    //  Centre-Don : Recevoir //
    @ManyToOne
    @JoinColumn(name = "idCentre")
    private Centre centre;

    //  Analyse-Don : Traiter //
    @OneToMany(mappedBy = "don")
    private List<Analyse> analyses;

    //       Collecte - Don : Inclure //
    @ManyToOne
    @JoinColumn(name = "idCollecte")
    private Collecte collecte;

}

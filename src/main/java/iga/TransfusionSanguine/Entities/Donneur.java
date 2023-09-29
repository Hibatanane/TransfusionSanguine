package iga.TransfusionSanguine.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Donneur extends Personne {


    //----------------------------------------------------//
    //     Relation entre Donneur-Don : Faire   //
    @OneToMany(mappedBy = "donneurDon", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Don> dons = new ArrayList<>();


    //      Relation entre Donneur-Rdv : Prendre   //
    @OneToMany(mappedBy = "donneurRdv", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rdv> rdvs = new ArrayList<>();

    //      Relation entre Donneur-Collecte : Participer   //
    @ManyToMany(mappedBy = "donneurs")
    private  List<Collecte> collectes = new ArrayList<>();


}

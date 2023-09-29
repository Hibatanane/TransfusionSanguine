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

public class Personnel extends Personne {
    @Column(length = 10)
    private String poste;

    //----------------------------------------------------//
    //  Personnel-Rdv : Gerer
    @OneToMany(mappedBy = "personnel", cascade = CascadeType.ALL)
    private List<Rdv> rdvList = new ArrayList<>();

    //  Personnel-Centre : Travailler
    @ManyToOne
    @JoinColumn(name="idCentre")
    private Centre centre;



}

package iga.TransfusionSanguine.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Receveur extends Personne {

    private boolean enUrgence;

    //----------------------------------------------------------//
    // Receveur - Centre : Demander//

    @ManyToMany(mappedBy = "receveurs")
    private List<Centre> centres;

    //  Receveur - Transfusion : Beneficier  //
    @OneToMany(mappedBy = "receveur")
    private List<Transfusion> transfusions;


}

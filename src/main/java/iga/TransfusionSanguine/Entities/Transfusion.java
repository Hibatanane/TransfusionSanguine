package iga.TransfusionSanguine.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Transfusion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTransfusion;
    private LocalDate dateT;
    private int quantiteT;
    //Pour montrer si un receveur est inscrit ou pas ;
    @Column(length = 10)
    private String etatReceveur;

    //----------------------------------------------//
    // Transfusion-Receveur : Beneficier

    @ManyToOne
    @JoinColumn(name="idReceveur")
    private Receveur receveur;


}

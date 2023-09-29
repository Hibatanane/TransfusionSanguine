package iga.TransfusionSanguine.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Analyse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAnalyse;
    private float hematies;
    private float hemoglobine;
    private float hematocrite;
    private float vgm;
    private float tcmh;
    private float ccmh;
    private float leucocytes;
    private float polynucleEosi;
    private float polynucleBaso;
    private float polynucleNeutro;
    private float lymphocytes;
    private float monocytes;
    @Column(length = 10)
    private String compatibilite;
    private LocalDate dateAnalyse;

    //--------------------------------------------------//
    // Analyse - Don : Traiter //

    @ManyToOne
    @JoinColumn(name = "idDon")
    private Don don;
}

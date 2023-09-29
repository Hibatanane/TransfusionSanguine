package iga.TransfusionSanguine.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idStock;
    @Column(length = 5)
    private String groupeS;
    private int quantiteS;
    private LocalDate datePremption;
    private LocalDate dateReception;
    private int Sachets;

//-----------------------------------------------------//
    // Centre - Stock : Posséder  //
    @ManyToOne
    @JoinColumn(name = "idCentre")
    private Centre centre;
}

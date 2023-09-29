package iga.TransfusionSanguine.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Centre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCentre;
    @Column(length = 30)
    private String nomC;
    @Column(length = 70)
    private String adresseC;
    private String numC;
    @Email
    @Pattern(regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])){4,12}$", message = "Veuillez une adresse correcte")
    private String mailC;
    private double latitudeC;
    private double longitude;
    //-----------------------------------------//
    //  Centre-Personnel : Travailler //
    @OneToMany(mappedBy = "centre")
    private List<Personnel> personnels;

    //  Centre-Receveur : Demander //
    @ManyToMany
    @JoinTable(
            name = "demande_sang",
            joinColumns = @JoinColumn(name = "idCentre"),
            inverseJoinColumns = @JoinColumn(name = "idReceveur"))
    private List<Receveur> receveurs;

    //  Centre-Collecte : Organiser //
    @OneToMany(mappedBy = "centre")
    private List<Collecte> collectes;

    //  Centre-Stock : Posséder //
    @OneToMany(mappedBy = "centre")
    private List<Stock> stocks = new ArrayList<>();

    //  Centre-Don : Recevoir //
    @OneToMany(mappedBy = "centre")
    private List<Don> dons;




}

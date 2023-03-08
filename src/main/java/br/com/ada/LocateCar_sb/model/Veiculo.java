package br.com.ada.LocateCar_sb.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_veiculo")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String modelo;
    private String marca;
    @Column(unique = true)
    private String placa;
    private String tipo;
    private Boolean disponivel;

}

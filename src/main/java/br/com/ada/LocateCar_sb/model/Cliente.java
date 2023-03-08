package br.com.ada.LocateCar_sb.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_cliente")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String cpf;
    private String email;
    private Boolean maiorDeIdade;
}

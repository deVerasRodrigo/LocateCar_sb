package br.com.ada.LocateCar_sb.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotEmpty(message = "Obigatório o preenchimento do modelo")
    private String modelo;
    @NotEmpty(message = "Obigatório o preenchimento da marca")
    private String marca;

    @Column(unique = true)
    @NotEmpty(message = "Obrigatório o preenchimento da placa")
    @Size(min = 7, message = "Placa deve conter no minimo 7 caracteres")
    private String placa;
    @NotEmpty(message = "Obigatório o preenchimento do tipo")
    private String tipo;
    @NotNull(message = "Selecione uma opção")
    private Boolean disponivel;

}

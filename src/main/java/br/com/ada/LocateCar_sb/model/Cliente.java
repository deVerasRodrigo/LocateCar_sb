package br.com.ada.LocateCar_sb.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

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
    @NotEmpty(message = "Obrigatório preenchimento do nome")
    private String nome;
    @Column(unique = true)
    @CPF(message = "CPF inválido")
    @NotEmpty(message = "Obrigatório preenchimento do CPF")
    private String cpf;
    @NotEmpty(message = "Obrigatório preenchimento do e-mail")
    @Email(message = "E-mail inválido")
    private String email;

    @NotNull(message = "Selecione uma opção")
    private Boolean maiorDeIdade;
}

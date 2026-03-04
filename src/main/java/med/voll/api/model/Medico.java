package med.voll.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.dto.MedicoDTO;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;

    public Medico(MedicoDTO dadosParaCadastro) {
        this.nome = dadosParaCadastro.nome();
        this.email = dadosParaCadastro.email();
        this.telefone = dadosParaCadastro.telefone();
        this.crm = dadosParaCadastro.crm();
        this.especialidade = dadosParaCadastro.especialidade();
        this.endereco = new Endereco(dadosParaCadastro.endereco());

    }
}

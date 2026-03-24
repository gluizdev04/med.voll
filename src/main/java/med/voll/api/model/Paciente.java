package med.voll.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.dto.DadosAtualizarPaciente;
import med.voll.api.dto.PacienteDTO;

@Entity(name = "Paciente")
@Table(name = "pacientes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    @Embedded
    private Endereco endereco;
    private boolean ativo;

    public Paciente(PacienteDTO dadosPaciente) {
        this.nome = dadosPaciente.nome();
        this.email = dadosPaciente.email();
        this.telefone = dadosPaciente.telefone();
        this.cpf = dadosPaciente.cpf();
        this.endereco = new Endereco(dadosPaciente.endereco());
    }

    public void alterarDados(DadosAtualizarPaciente dadosAtualizarPaciente) {
        if (dadosAtualizarPaciente.nome() != null) {
            this.nome = dadosAtualizarPaciente.nome();
        }
        if (dadosAtualizarPaciente.enderecoDTO() != null) {
            this.endereco.atualizarInformacoes(dadosAtualizarPaciente.enderecoDTO());
        }
        if (dadosAtualizarPaciente.telefone() != null) {
            this.telefone = dadosAtualizarPaciente.telefone();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}

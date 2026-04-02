package med.voll.api.dto;

import med.voll.api.model.Endereco;
import med.voll.api.model.Paciente;

public record DadosDetalhamentoPeciantes(
        Long id,
        String nome,
        String email,
        String cpf,
        String telefone,
        Endereco endereco
) {
    public DadosDetalhamentoPeciantes(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone(), paciente.getEndereco());
    }

}

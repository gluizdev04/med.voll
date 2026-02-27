package med.voll.api.dto;

import med.voll.api.model.Especialidade;

public record UsuarioDTO(String nome, String email, String crm, Especialidade especialidade, EnderecoDTO endereco) {
}

package med.voll.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarPaciente(@NotNull Long id,
                                     String nome,
                                     String telefone,
                                     @Valid
                                     EnderecoDTO enderecoDTO) {
}

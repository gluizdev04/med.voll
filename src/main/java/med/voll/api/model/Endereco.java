package med.voll.api.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.dto.EnderecoDTO;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;
    private String numero;

    public Endereco(EnderecoDTO endereco) {
        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
        this.complemento = endereco.complemento();
        this.numero = endereco.numero();
    }

    public void atualizarInformacoes(@Valid EnderecoDTO dadosEndereco) {

        if (dadosEndereco.logradouro() != null) {
            this.logradouro = dadosEndereco.logradouro();
        }
        if (dadosEndereco.bairro() != null) {
            this.bairro = dadosEndereco.bairro();
        }
        if (dadosEndereco.cep() != null) {
            this.cep = dadosEndereco.cep();
        }
        if (dadosEndereco.cidade() != null) {
            this.cidade = dadosEndereco.cidade();
        }
        if (dadosEndereco.uf() != null) {
            this.uf = dadosEndereco.uf();
        }
        if (dadosEndereco.complemento() != null) {
            this.complemento = dadosEndereco.complemento();
        }
        if (dadosEndereco.numero() != null) {
            this.numero = dadosEndereco.numero();
        }
    }
}

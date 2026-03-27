package med.voll.api.service;

import med.voll.api.dto.DadosAtualizarMedico;
import med.voll.api.dto.DadosCadastroMedico;
import med.voll.api.dto.DadosListagemMedico;
import med.voll.api.model.Medico;
import med.voll.api.repository.MedicoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {
    private MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public Medico cadastrarMedico(DadosCadastroMedico dadosParaCadastro) {
        var medico = new Medico(dadosParaCadastro);
        medicoRepository.save(medico);
        return medico;
    }

    public Page<DadosListagemMedico> mostrarMedicos(Pageable paginacao) {
        return medicoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    public Medico atualizarDados(DadosAtualizarMedico dadosAtualizarMedico) {
        var medico = medicoRepository.getReferenceById(dadosAtualizarMedico.id());
        medico.alterarDados(dadosAtualizarMedico);
        return medico;
    }

    public void deletarMedico(Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.excluir();
    }
}

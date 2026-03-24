package med.voll.api.service;

import med.voll.api.dto.DadosAtualizarPaciente;
import med.voll.api.dto.DadosListagemPaciente;
import med.voll.api.dto.PacienteDTO;
import med.voll.api.model.Paciente;
import med.voll.api.repository.PacienteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository){
        this.pacienteRepository = pacienteRepository;
    }

    public void cadastrarPaciente(PacienteDTO dadosPaciente){
        pacienteRepository.save(new Paciente(dadosPaciente));
    }

    public Page<DadosListagemPaciente> listarPacientes(Pageable paginacao) {
        return pacienteRepository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);
    }

    public void atualizarDados(DadosAtualizarPaciente dadosAtualizarPaciente) {
        var paciente = pacienteRepository.getReferenceById(dadosAtualizarPaciente.id());
        paciente.alterarDados(dadosAtualizarPaciente);
    }

    public void inativarPaciente(Long id) {
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.excluir();
    }
}

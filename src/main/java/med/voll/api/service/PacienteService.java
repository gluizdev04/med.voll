package med.voll.api.service;

import med.voll.api.dto.PacienteDTO;
import med.voll.api.model.Paciente;
import med.voll.api.repository.PacienteRepository;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {
    PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository){
        this.pacienteRepository = pacienteRepository;
    }

    public void cadastrarPaciente(PacienteDTO dadosPaciente){
        pacienteRepository.save(new Paciente(dadosPaciente));
    }
}

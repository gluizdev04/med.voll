package med.voll.api.service;

import med.voll.api.dto.MedicoDTO;
import med.voll.api.model.Medico;
import med.voll.api.repository.MedicoRepository;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {
    private MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public void cadastrarMedico(MedicoDTO dadosParaCadastro) {
        medicoRepository.save(new Medico(dadosParaCadastro));
    }
}

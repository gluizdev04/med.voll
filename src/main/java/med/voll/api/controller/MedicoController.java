package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.dto.MedicoDTO;
import med.voll.api.service.MedicoService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadastrar")
public class MedicoController {
    private MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @PostMapping("/medico")
    @Transactional
    public void cadastrar(@RequestBody @Valid MedicoDTO dadosParaCadastro) {
        medicoService.cadastrarMedico(dadosParaCadastro);
    }
}

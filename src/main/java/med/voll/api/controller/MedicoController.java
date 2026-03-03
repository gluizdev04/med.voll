package med.voll.api.controller;

import med.voll.api.dto.MedicoDTO;
import med.voll.api.service.MedicoService;
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
    public void cadastrar(@RequestBody MedicoDTO dadosParaCadastro) {
        medicoService.cadastrarMedico(dadosParaCadastro);
    }
}

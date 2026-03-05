package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.dto.PacienteDTO;
import med.voll.api.service.PacienteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }

    @PostMapping("/cadastrar")
    public void cadastrarPaciente(@RequestBody @Valid PacienteDTO dadosPaciente){
        pacienteService.cadastrarPaciente(dadosPaciente);
    }
}

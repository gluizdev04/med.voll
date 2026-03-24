package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.dto.DadosAtualizarPaciente;
import med.voll.api.dto.DadosListagemPaciente;
import med.voll.api.dto.PacienteDTO;
import med.voll.api.service.PacienteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public void cadastrarPaciente(@RequestBody @Valid PacienteDTO dadosPaciente) {
        pacienteService.cadastrarPaciente(dadosPaciente);
    }

    @GetMapping
    public Page<DadosListagemPaciente> listarPacientes(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return pacienteService.listarPacientes(paginacao);
    }

    @PutMapping
    @Transactional
    public void atualizarPaciente(@RequestBody @Valid DadosAtualizarPaciente dadosAtualizarPaciente) {
        pacienteService.atualizarDados(dadosAtualizarPaciente);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void inativarPaciente(@PathVariable Long id) {
        pacienteService.inativarPaciente(id);
    }
}

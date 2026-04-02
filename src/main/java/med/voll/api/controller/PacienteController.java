package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.dto.DadosAtualizarPaciente;
import med.voll.api.dto.DadosDetalhamentoPeciantes;
import med.voll.api.dto.DadosListagemPaciente;
import med.voll.api.dto.PacienteDTO;
import med.voll.api.model.Paciente;
import med.voll.api.service.PacienteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarPaciente(@RequestBody @Valid PacienteDTO dadosParaCadastro, UriComponentsBuilder uriBuilder) {
        var paciente = pacienteService.cadastrarPaciente(dadosParaCadastro);
        var uri = uriBuilder.path("paciente/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoPeciantes(paciente));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPaciente>> listarPacientes(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = pacienteService.listarPacientes(paginacao);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarPaciente(@RequestBody @Valid DadosAtualizarPaciente dadosAtualizarPaciente) {
        var paciente = pacienteService.atualizarDados(dadosAtualizarPaciente);
        return ResponseEntity.ok(new DadosDetalhamentoPeciantes(paciente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity inativarPaciente(@PathVariable Long id) {
        pacienteService.inativarPaciente(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPacientePorId(@PathVariable Long id) {
        var dadosDetalhamentoPeciantes = pacienteService.buscarPacientePorId(id);
        return ResponseEntity.ok(dadosDetalhamentoPeciantes);
    }
}

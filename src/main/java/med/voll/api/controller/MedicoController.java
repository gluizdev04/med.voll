package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.dto.DadosAtualizarMedico;
import med.voll.api.dto.DadosCadastroMedico;
import med.voll.api.dto.DadosDetalhamentoMedicos;
import med.voll.api.dto.DadosListagemMedico;
import med.voll.api.model.Medico;
import med.voll.api.repository.MedicoRepository;
import med.voll.api.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/medico")
public class MedicoController {
    private MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dadosParaCadastro, UriComponentsBuilder uriBuilder) {
        var medico = medicoService.cadastrarMedico(dadosParaCadastro);

        var uri = uriBuilder.path("medico/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedicos(medico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> mostrarMedicos(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = medicoService.mostrarMedicos(paginacao);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarDadosMedico(@RequestBody @Valid DadosAtualizarMedico dadosAtualizarMedico) {
        var medico = medicoService.atualizarDados(dadosAtualizarMedico);
        return ResponseEntity.ok(new DadosDetalhamentoMedicos(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarMedico(@PathVariable Long id) {
        medicoService.deletarMedico(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarMedicoPorId(@PathVariable Long id) {
        var medico = medicoService.buscarMedico(id);
        return ResponseEntity.ok(medico);
    }
}

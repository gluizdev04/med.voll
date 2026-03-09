package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.dto.DadosCadastroMedico;
import med.voll.api.dto.DadosListagemMedico;
import med.voll.api.service.MedicoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dadosParaCadastro) {
        medicoService.cadastrarMedico(dadosParaCadastro);
    }

    @GetMapping
    public Page<DadosListagemMedico> mostrarMedicos(Pageable paginacao){
        return medicoService.mostrarMedicos(paginacao);
    }
}

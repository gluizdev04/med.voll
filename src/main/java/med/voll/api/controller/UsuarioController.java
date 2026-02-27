package med.voll.api.controller;

import med.voll.api.dto.UsuarioDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadastrar")
public class UsuarioController {

    @PostMapping("/medico")
    public void cadastrar(@RequestBody UsuarioDTO json) {
        System.out.println(json);
    }
}

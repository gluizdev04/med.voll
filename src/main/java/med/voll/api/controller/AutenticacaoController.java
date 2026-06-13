package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.dto.DadosLogin;
import med.voll.api.infra.security.TokenService;
import med.voll.api.model.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    private AuthenticationManager authenticationManager;
    private TokenService tokenService;

    public AutenticacaoController(AuthenticationManager authenticationManager, TokenService tokenService){
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosLogin dadosLogin) {
        var token = new UsernamePasswordAuthenticationToken(dadosLogin.login(), dadosLogin.senha());
        var authentication = authenticationManager.authenticate(token);

        return ResponseEntity.ok(tokenService.gerarToken((Usuario) authentication.getPrincipal()));
    }

}

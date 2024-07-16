package br.com.forumhub.controller;

import br.com.forumhub.dto.LoginResponseDTO;
import br.com.forumhub.dto.LoginUserDTO;
import br.com.forumhub.model.Usuario;
import br.com.forumhub.service.AuthenticationService;
import br.com.forumhub.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {

    @Autowired
    TokenService tokenService;

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> authenticate(@RequestBody @Valid LoginUserDTO loginUserDto) {
        Usuario usuarioAutenticado = authenticationService.authenticate(loginUserDto);

        String jwtToken = tokenService.gerarToken(usuarioAutenticado);

        LoginResponseDTO loginResponse = new LoginResponseDTO(jwtToken, tokenService.getExpiracaoToken());

        return ResponseEntity.ok(loginResponse);
    }
}

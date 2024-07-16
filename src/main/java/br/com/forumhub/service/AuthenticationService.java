package br.com.forumhub.service;

import br.com.forumhub.dto.LoginUserDTO;
import br.com.forumhub.model.Usuario;
import br.com.forumhub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    UsuarioRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    public Usuario authenticate(LoginUserDTO input) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(input.email(), input.password());
        authenticationManager.authenticate(authenticationToken);

        return repository.findByEmail(input.email())
                .orElseThrow();
    }
}

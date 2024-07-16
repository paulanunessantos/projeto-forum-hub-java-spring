package br.com.forumhub.controller;

import br.com.forumhub.dto.CreateTopicoDTO;
import br.com.forumhub.dto.GetTopicoDTO;
import br.com.forumhub.model.Curso;
import br.com.forumhub.model.Topico;
import br.com.forumhub.model.Usuario;
import br.com.forumhub.repository.CursoRepository;
import br.com.forumhub.repository.TopicoRepository;
import br.com.forumhub.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/topicos")
public class TopicoController {

    private final TopicoRepository topicoRepository;
    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;

    public TopicoController(TopicoRepository topicoRepository,
                            UsuarioRepository usuarioRepository, CursoRepository cursoRepository) {
        this.topicoRepository = topicoRepository;
        this.usuarioRepository = usuarioRepository;
        this.cursoRepository = cursoRepository;
    }

    @PostMapping
    public ResponseEntity<Topico> createTopico(@RequestBody @Valid CreateTopicoDTO dto) {
        Usuario autor = usuarioRepository.findById(dto.getAutorId()).orElseThrow();
        Curso curso = cursoRepository.findById(dto.getCursoId()).orElseThrow();
        Topico topico = buildTopico(dto, autor, curso);
        topicoRepository.save(topico);
        return ResponseEntity.ok(topico);
    }

    @GetMapping
    public ResponseEntity<List<GetTopicoDTO>> findTopicos() {
        List<Topico> topicos = topicoRepository.findAll();
        List<GetTopicoDTO> responses = new ArrayList<>();

        for (Topico topico : topicos) {
            responses.add(buildGetTopicoDTO(topico));
        }

        return ResponseEntity.ok(responses);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GetTopicoDTO> findTopicoById(@PathVariable Long id) {
        Topico topico = topicoRepository.findById(id).orElseThrow();
        GetTopicoDTO dto = buildGetTopicoDTO(topico);

        return ResponseEntity.ok(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> updateTopico(@PathVariable Long id, @RequestBody @Valid CreateTopicoDTO dto) {
        Topico topico = topicoRepository.findById(id).orElseThrow();
        Usuario autor = usuarioRepository.findById(dto.getAutorId()).orElseThrow();
        Curso curso = cursoRepository.findById(dto.getCursoId()).orElseThrow();

        Optional.ofNullable(dto.getMensagem()).ifPresent(t -> topico.setMensagem(t));
        Optional.ofNullable(dto.getTitulo()).ifPresent(t -> topico.setTitulo(t));
        topico.setCurso(curso);
        topico.setAutor(autor);

        topicoRepository.save(topico);
        return ResponseEntity.ok(topico.getTitulo());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletTopicoById(@PathVariable Long id) {
        Topico topico = topicoRepository.findById(id).orElseThrow();

        topicoRepository.delete(topico);
        return ResponseEntity.ok(topico.getTitulo());
    }

    private Topico buildTopico(CreateTopicoDTO dto, Usuario autor, Curso curso) {
        Topico topico = new Topico();
        topico.setTitulo(dto.getTitulo());
        topico.setMensagem(dto.getMensagem());
        topico.setAutor(autor);
        topico.setCurso(curso);
        return topico;
    }

    private GetTopicoDTO buildGetTopicoDTO(Topico topico) {
        GetTopicoDTO dto = new GetTopicoDTO();
        dto.setCurso(topico.getCurso());
        dto.setAutor(topico.getAutor());
        dto.setMensagem(topico.getMensagem());
        dto.setTitulo(topico.getTitulo());
        dto.setDataCriacao(topico.getDataCriacao());
        dto.setStatus(topico.isStatus());
        return dto;
    }
}

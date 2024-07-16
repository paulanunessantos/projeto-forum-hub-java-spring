package br.com.forumhub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateTopicoDTO {

    @NotBlank(message = "Por favor insira um título válida")
    private String titulo;

    @NotBlank(message = "Por favor insira uma mensagem válida")
    private String mensagem;

    @NotNull(message = "Curso não pode ser nulo")
    private Long cursoId;

    @NotNull(message = "Autor não pode ser nulo")
    private Long autorId;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }
}

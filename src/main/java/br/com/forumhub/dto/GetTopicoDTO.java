package br.com.forumhub.dto;

import br.com.forumhub.model.Curso;
import br.com.forumhub.model.Usuario;

import java.time.LocalDateTime;

public class GetTopicoDTO {

    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private boolean status;
    Usuario autor;
    Curso curso;

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

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("GetTopicoDTO{");
        sb.append("titulo='").append(titulo).append('\'');
        sb.append(", mensagem='").append(mensagem).append('\'');
        sb.append(", dataCriacao=").append(dataCriacao);
        sb.append(", status=").append(status);
        sb.append(", usuario=").append(autor);
        sb.append(", curso=").append(curso);
        sb.append('}');
        return sb.toString();
    }
}

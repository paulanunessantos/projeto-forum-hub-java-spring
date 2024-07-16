package br.com.forumhub.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "resposta")
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String mensagem;

    @CreationTimestamp
    private LocalDateTime dataCriacao;

    @Column(columnDefinition = "TEXT")
    private String solucao;

    @ManyToOne
    private Topico topico;

    @ManyToOne
    private Usuario autor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }

    public Topico getTopico() {
        return topico;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Resposta{");
        sb.append("id=").append(id);
        sb.append(", mensagem='").append(mensagem).append('\'');
        sb.append(", dataCriacao=").append(dataCriacao);
        sb.append(", solucao='").append(solucao).append('\'');
        sb.append(", topico=").append(topico);
        sb.append(", autor=").append(autor);
        sb.append('}');
        return sb.toString();
    }
}

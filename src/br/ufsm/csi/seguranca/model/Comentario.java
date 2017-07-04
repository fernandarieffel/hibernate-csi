package br.ufsm.csi.seguranca.model;

import javax.persistence.*;

/**
 * Created by Rieffel on 03/07/2017.
 */
@Entity
@Table(name = "COMENTARIO")
public class Comentario {

    private Long id;
    private String nome;
    private String texto;
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_POST")
    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Id
    @GeneratedValue
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "NOME")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "TEXTO")
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}

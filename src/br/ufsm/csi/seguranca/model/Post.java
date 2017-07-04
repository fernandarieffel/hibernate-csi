package br.ufsm.csi.seguranca.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Rieffel on 03/07/2017.
 */
@Entity
@Table(name = "POST")
public class Post {

    private Long id;
    private String titulo;
    private String texto;
    private Usuario usuario;
    private Collection<Comentario> comentarios;

    @Id
    @GeneratedValue
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "TITULO")
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Column(name = "TEXTO")
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USUARIO")
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @OneToMany(mappedBy = "post")
    public Collection<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(Collection<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
}

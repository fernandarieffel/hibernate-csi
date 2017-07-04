package br.ufsm.csi.seguranca.controller;

import br.ufsm.csi.seguranca.dao.HibernateDAO;
import br.ufsm.csi.seguranca.model.Post;
import br.ufsm.csi.seguranca.model.Usuario;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Controller
public class PostController {

    @Autowired
    private HibernateDAO hibernateDAO;

    @Transactional
    @RequestMapping("novo-post.priv")
    public String redirectNovoPost(HttpSession sessao, Post post, Model model) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        return "novo-post";
    }

    @Transactional
    @RequestMapping("salvar-novo-post.priv")
    public String novoPost(HttpSession sessao, Post post, Model model) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        Usuario usuario = (Usuario) sessao.getAttribute("usuario");
        if(usuario != null) {
            System.out.println("Usuario Logado: ");
            post.setUsuario(usuario);
            hibernateDAO.criaObjeto(post);
        }

        return "novo-post";
    }
}

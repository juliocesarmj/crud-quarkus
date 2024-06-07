package br.com.juliomoraes.service;

import br.com.juliomoraes.entity.Usuario;
import br.com.juliomoraes.exception.ObjetoNaoEncontradoException;
import br.com.juliomoraes.repositorio.UsuarioRepositorio;
import jakarta.enterprise.context.Dependent;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@Dependent
public class UsuarioService {

    UsuarioRepositorio repositorio;

    public UsuarioService(UsuarioRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Transactional
    public Usuario novoUsuario(Usuario usuario) {
        repositorio.persist(usuario);
        return usuario;
    }

    public List<Usuario> listarUsuarios(Integer page, Integer pageSize) {
        return repositorio.findAll()
                .page(page, pageSize)
                .list();
    }

    public Usuario buscarUsuario(UUID usuarioId) {
        return repositorio.findByIdOptional(usuarioId).orElseThrow(ObjetoNaoEncontradoException::new);
    }

    @Transactional
    public Usuario atualizarUsuario(UUID usuarioId, Usuario usuario) {
        Usuario usuarioAtual = buscarUsuario(usuarioId);
        usuarioAtual.setNome(usuario.getNome());
        usuarioAtual.setDataNascimento(usuario.getDataNascimento());
        repositorio.persist(usuarioAtual);
        return usuarioAtual;
    }

    @Transactional
    public void excluirUsuario(UUID usuarioId) {
        repositorio.delete(buscarUsuario(usuarioId));
    }
}

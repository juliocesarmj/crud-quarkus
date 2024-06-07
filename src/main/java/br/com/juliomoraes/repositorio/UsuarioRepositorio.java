package br.com.juliomoraes.repositorio;

import br.com.juliomoraes.entity.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.Dependent;

import java.util.UUID;

@Dependent
public class UsuarioRepositorio implements PanacheRepositoryBase<Usuario, UUID> {
}

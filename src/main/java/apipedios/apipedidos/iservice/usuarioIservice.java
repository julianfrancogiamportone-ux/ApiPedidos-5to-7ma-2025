
package com.apipedidos.service;

import com.apipedidos.entity.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioIService {
    List<Usuario> getAllUsuarios();
    Optional<Usuario> getUsuarioById(Long id);
    Usuario createUsuario(Usuario usuario);
    Usuario updateUsuario(Long id, Usuario usuarioDetails);
    void deleteUsuario(Long id);
}


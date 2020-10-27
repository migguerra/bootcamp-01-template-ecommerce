package br.com.zup.mercadolivro.ecommerce.usuario;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CadastroUsuarioController {

	@PersistenceContext
	private EntityManager manager;

	@PostMapping(value = "/Usuarios")
	@Transactional
	public String cadastraUsuario(@RequestBody @Valid NovoUsuarioRequest dadosUsuario) {
		Usuario cadastroUsuario = dadosUsuario.gerarNovoUsuario();
		manager.persist(cadastroUsuario);
		return cadastroUsuario.toString();
	}

}

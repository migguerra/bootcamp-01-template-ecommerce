package br.com.zup.mercadolivro.ecommerce.usuario;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Email
	private String login;

	@NotBlank
	@Length(min = 6)
	private String senha;

	// @NotNull
	// @CreationTimestamp
	// conferir validador e colocar anotaçao em cima da data
	private LocalDate instanteCriaCadastro;

	public LocalDate getInstanteCriaCadastro() {
		return instanteCriaCadastro;
	}

	public void setInstanteCriaCadastro(LocalDate instanteCriaCadastro) {
		this.instanteCriaCadastro = instanteCriaCadastro;
	}

	public Usuario(@NotBlank @Email String login, @NotBlank String senha, LocalDate instanteCriaCadastro) {
		this.login = login;
		// falta o hash da senha
		this.senha = new BCryptPasswordEncoder().encode(senha);

		this.instanteCriaCadastro = instanteCriaCadastro;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + ", senha=" + senha + ", instanteCriaCadastro="
				+ instanteCriaCadastro + "]";
	}

}

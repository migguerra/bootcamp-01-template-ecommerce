package br.com.zup.mercadolivro.ecommerce.usuario;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.sun.istack.NotNull;

public class NovoUsuarioRequest {

	@NotBlank
	@Email
	private String login;

	@NotBlank
	@Length(min = 6)
	private String senha;

	// @NotNull
	// @CreationTimestamp
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate instanteCriaCadastro;

	@Deprecated
	public NovoUsuarioRequest() {
		// TODO Auto-generated constructor stub
	}

	public NovoUsuarioRequest(@NotBlank @Email String login, @NotBlank String senha,
			@NotNull @FutureOrPresent LocalDate instanteCriaCadastro) {
		this.login = login;
		this.senha = senha;
		this.instanteCriaCadastro = instanteCriaCadastro;
	}

	public Usuario gerarNovoUsuario() {
		Usuario novoUsuario = new Usuario(this.login, this.senha, this.instanteCriaCadastro);
		return novoUsuario;
	}

	public LocalDate getInstanteCriaCadastro() {
		return instanteCriaCadastro;
	}

	public void setInstanteCriaCadastro(LocalDate instanteCriaCadastro) {
		this.instanteCriaCadastro = instanteCriaCadastro;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}

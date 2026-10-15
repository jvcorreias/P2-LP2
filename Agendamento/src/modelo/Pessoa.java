package modelo;

import java.time.LocalDate;

public abstract class Pessoa {

	private String nome;
	private LocalDate dataNascimento;

	public Pessoa(String nome, LocalDate dataNascimento) {
		if(nome != null && dataNascimento != null) {
			this.nome = nome;
			this.dataNascimento = dataNascimento;
		}
	}

	
	public String obterDados() {
		return "Nome: " + this.nome + ", Data de Nascimento: " + this.dataNascimento;
	}

	public abstract void obterIdentificacao();
	
	
}

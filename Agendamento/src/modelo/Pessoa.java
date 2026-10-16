package modelo;

public abstract class Pessoa {

	private String nome;
	private Data dataNascimento;

	public Pessoa(String nome, Data dataNascimento) {
		if (nome != null && !nome.isBlank()) {
			this.nome = nome;
		}
		if (dataNascimento != null && Data.agora().compareTo(dataNascimento) >= 0) {
			this.dataNascimento = dataNascimento;
		}
	}

	
	public String obterDados() {
		return "Nome: " + this.nome + ", Data de Nascimento: " + this.dataNascimento;
	}

	public int calcularIdade() {
		return Data.agora().ano() - dataNascimento.ano();
	}

	@Override
	public String toString() {
		return nome + " - " + dataNascimento;
	}
}

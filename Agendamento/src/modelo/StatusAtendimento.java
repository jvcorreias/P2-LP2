package modelo;

public enum StatusAtendimento implements Comparable<StatusAtendimento> {
	PENDENTE("Pendente"),
	EM_ANDAMENTO("Em Andamento"),
	REALIZADA("Realizada"),
	CANCELADA("Cancelada");

	private String nome;

	private StatusAtendimento(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome;
	}
}

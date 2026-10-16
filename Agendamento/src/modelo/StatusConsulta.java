package modelo;

public enum StatusConsulta implements Comparable<StatusConsulta> {
	PENDENTE("Pendente"),
	REALIZADA("Realizada"),
	CANCELADA("Cancelada");

	private String nome;

	private StatusConsulta(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome;
	}
}

package modelo;

public enum Estado {
	VALIDA("Válida"),
	REPROVADA("Reprovada"),
	CONCLUIDA("Concluída"),
	CANCELADA("Cancelada");
	
	private String nome;
	
	private Estado(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return nome;
	}
}

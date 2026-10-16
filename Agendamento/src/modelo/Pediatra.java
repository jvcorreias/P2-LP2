package modelo;

public class Pediatra extends Medico {
	private final int limiteConsultas = 15;

	public Pediatra(String nome, Data dataNascimento, String CRM) {
	       super(nome, dataNascimento, CRM);
	}	
}

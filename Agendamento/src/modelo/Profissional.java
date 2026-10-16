package modelo;

import java.util.ArrayList;

public abstract class Profissional extends Pessoa {

	private String CRM;
	private final int cargaMaxima;
	
	public Profissional(String nome, Data dataNascimento, String CRM) {
		super(nome, dataNascimento);
		if(CRM != null && !CRM.isBlank()) {
			this.CRM = CRM;
		}
	}

	public abstract boolean adicionarConsulta(Consulta consulta);
	
	public abstract boolean estaDisponivel(Consulta consulta) {

	public abstract boolean ehQualificado(Paciente paciente);

	public void obterIdentificacao() {
		System.out.printf("%s, CRM: %s, Especialidade: %s\n", this.obterDados(), this.CRM, this.especialidade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Profissional outro = (Profissional) obj;
		if (!CRM.equals(outro.CRM)) return false;
		return true;
	}
	
	@Override
	public String toString() {
		return super.toString() + " - CRM: " + CRM;
	}
}

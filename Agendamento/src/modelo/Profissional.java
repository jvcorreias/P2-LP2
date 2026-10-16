package modelo;

import java.util.ArrayList;

public abstract class Profissional extends Pessoa {

	protected String CRM;
	protected final int cargaMaxima;
	protected ArrayList<Atendimento> atendimento = new ArrayList<>();
	
	public Profissional(String nome, Data dataNascimento, String CRM) {
		super(nome, dataNascimento);
		if(CRM != null && !CRM.isBlank()) {
			this.CRM = CRM;
		}
	}

	public abstract boolean adicionarAtendimento(Atendimento novoAtendimento);
	
	public abstract boolean estaDisponivel(Atendimento novoAtendimento);

	public abstract boolean ehQualificado(Paciente paciente);

	public abstract boolean realizarAtendimento(boolean modificador);

	public void obterIdentificacao() {
		System.out.printf("%s, CRM: %s, Especialidade: %s\n", this.obterDados(), this.CRM, this.especialidade);
	}

	public boolean estaAtendendo() {
		for (Atendimento atendimento : atendimentos) {
			if (atendimento.emAndamento()) {
				return true;
			}
		}
		return false;
	}

	protected Atendimento atendimentoAFinalizar() {
		for (Atendimento atendimento : atendimentos) {
			if (atendimento.emAndamento()) {
				return atendimento;
			}
		}
		return null;
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

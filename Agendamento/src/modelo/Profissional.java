package modelo;

import java.util.ArrayList;

public abstract class Profissional extends Pessoa {

	protected final int cargaMaxima;
	protected ArrayList<Atendimento> atendimento = new ArrayList<>();
	
	public Profissional(String nome, Data dataNascimento) {
		super(nome, dataNascimento);
	}

	public abstract boolean adicionarAtendimento(Atendimento novoAtendimento);
	
	public abstract boolean estaDisponivel(Atendimento novoAtendimento);

	public abstract boolean ehQualificado(Paciente paciente);

	public abstract String realizarAtendimento();

	public void obterIdentificacao() {
		System.out.printf("%s, Especialidade: %s\n", this.obterDados(), this.especialidade);
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
	public String toString(){
		return this.nome;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Profissional outro = (Profissional) obj;
		return true;
	}
}

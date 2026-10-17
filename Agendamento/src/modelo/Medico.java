package modelo;

import java.util.ArrayList;

public final class Medico extends Profissional {
	private final int cargaMaxima = 10;

	public Geriatra(String nome, Data dataNascimento, String CRM) {
		super(nome, dataNascimento);
		if(CRM != null && !CRM.isBlank()) {
			this.CRM = CRM;
		}
		if(especialidade != null && !especialidade.isBlank()) {
			this.especialidade = especialidade;
		}
	}

	@Override
	public boolean adicionarAtendimento(Atendimento atendimento) {
		if (atendimento != null && !atendimentos.contains(atendimento) && estaDisponivel(atendimento)) {
			atendimentos.add(atendimento);
			return true;
		}
		return false;
	}

	@Override
	public boolean estaDisponivel(Atendimento novoAtendimento) {
		int cargaDia = novoAtendimento.getCarga();

		for (Atendimento atendimento : atendimentos) {
			if (atendimento.temMesmaData(novoAtendimento)) {
				atendimentosDia += atendimento.getCarga();
			}
		}

		return cargaDia <= cargaMaxima;
	}


	@Override
	public String realizarAtendimento() {
		return "Médico(a) " + nome + " (CRM: " + CRM + ") atendendo na área de " + especialidade + ".";
	}
}

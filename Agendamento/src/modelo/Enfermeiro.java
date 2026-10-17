package modelo;

import java.util.ArrayList;

public final class Enfermeiro extends Profissional {
	private final int cargaMaxima = 15;

	public Enfermeiro(String nome, Data dataNascimento, String COREN) {
		super(nome, dataNascimento);
		if(COREN != null && !COREN.isBlank()) {
			this.COREN = COREN;
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
		return "Enfermeiro(a) " + nome + " (COREN: " + CRM + ") realizando triagem/vacinação.";
	}
}

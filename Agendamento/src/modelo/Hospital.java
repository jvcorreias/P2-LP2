package modelo;

import java.util.ArrayList;

public class Hospital {
	private String identificador;
	private ArrayList<Setor> setores = new ArrayList<>();

	public Hospital(String identificador) {
		if (identificador != null && !identificador.isBlank()) {
			this.identificador = identificador;
		}
	}

	public boolean cadastrarMedico(Medico medico) {
		for (Setor setor : setores) {
			if (setor.medicoValido(medico)) {
				return setor.adicionarMedico(medico);
			}
		}
		return false;
	}

	private Setor obtemSetor(Especialidade especialidade) {
		if (especialidade == null) return null;
		for (Setor setor : setores) {
			if (setor.atendeEspecialidade(especialidade)) {
				return setor;
			}
		}
		return null;
	}

	public boolean criarSetor(Especialidade especialidade) {
		if (especialidade != null) {
			Setor alvo = new Setor(especialidade);
			if (!setores.contains(alvo)) {
				setores.add(alvo);
				return true;
			}
		}
		return false;
	}

	public boolean removerSetor(Especialidade especialidade) {
		return setores.remove(obtemSetor(especialidade));
	}

	public Consulta gerarConsulta(Paciente paciente, Especialidade especialidade, Data data) {
		Setor setor = obtemSetor(especialidade);
		if (setor == null) return null;

		Medico medico = obtemSetor(especialidade).obterMedicoDisponivel(data);
		if (medico != null) {
			Consulta novaConsulta = new Consulta(paciente, medico, data);
			medico.adicionarConsulta(novaConsulta);
			return novaConsulta;
		}
		return null;
	}

	@Override
	public String toString() {
		return identificador;
	}
}

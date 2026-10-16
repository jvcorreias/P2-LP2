package modelo;

import java.util.ArrayList;

public class Hospital {
	private String identificador;
	private ArrayList<Medico> medicos = new ArrayList<>();

	public Hospital(String identificador) {
		if (identificador != null && !identificador.isBlank()) {
			this.identificador = identificador;
		}
	}

	public boolean cadastrarMedico(Medico medico) {
		if (medico != null && !medicos.contains(medico)) {
			medicos.add(medico);
			return true;
		}
		return false;
	}

	public Consulta gerarConsulta(Paciente paciente, Especialidade especialidade, Data data) {
		for (Medico medico : medicos) {
			if (medico.ehQualificado(especialidade) && medico.estaDisponivel(data)) {
				Consulta novaConsulta = new Consulta(paciente, medico, data);
				medico.adicionarConsulta(novaConsulta);
				return novaConsulta;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return identificador;
	}
}

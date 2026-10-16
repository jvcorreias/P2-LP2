package modelo;

import java.util.ArrayList;

public class Hospital {
	private String identificador;
	private ArrayList<Paciente> pacientes = new ArrayList<>();
	private ArrayList<Medico> medicos = new ArrayList<>();

	public Hospital(String identificador) {
		if (identificador != null && !identificador.isBlank()) {
			this.identificador = identificador;
		}
	}

	public boolean cadastrarPaciente(Paciente paciente) {
		if (paciente != null && !pacientes.contains(paciente)) {
			pacientes.add(paciente);
			return true;
		}
		return false;
	}

	public Paciente obterPaciente(int id) {
		if (0 <= id && id <= pacientes.size()) {
			return pacientes.get(id);
		}
		return null;
	}

	public boolean cadastrarMedico(Medico medico) {
		if (medico != null && !medicos.contains(medico)) {
			medicos.add(medico);
			return true;
		}
		return false;
	}

	public boolean gerarConsulta(Paciente paciente, Data data) {
		if (paciente == null || data == null) return false;

		for (Medico medico : medicos) {
			if (medico.estaDisponivel(data) && medico.ehQualificado(paciente)) {
				Consulta novaConsulta = new Consulta(paciente, medico, data);
				if (paciente.adicionarConsulta(novaConsulta)) {
					medico.adicionarConsulta(novaConsulta);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return identificador;
	}
}

package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Posto {
	private String nome;

	private ArrayList<Paciente> pacientes = new ArrayList<>();
	private ArrayList<Profissional> profissionais = new ArrayList<>();
	private ArrayList<Consulta> consultas = new ArrayList<>();


	public Posto(String nome) {
		if (identificador != null && !identificador.isBlank()) {
			this.nome = nome;
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

	public boolean cadastrarProfissional(Profissional profissional) {
		if (profissional != null && !profissionais.contains(profissional)) {
			profissionais.add(profissional);
			return true;
		}
		return false;
	}

	public boolean gerarConsulta(Paciente paciente, Data data) {
		if (paciente == null || data == null) return false;

		for (Profissional profissional : profissionais) {
			if (profissional instanceof Enfermeiro && profissional.estaDisponivel(data)) {
				Consulta novaConsulta = new Consulta(paciente, profissional, data);
				if (paciente.adicionarConsulta(novaConsulta)) {
					profissional.adicionarConsulta(novaConsulta);
					this.consultas.adicionarConsulta(novaConsulta);
					return true;
				}
			}
		}
		return false;
	}

	public List<Consulta> getAgendaOrdenada(){
		Collections.sort(consultas);
		return consultas;
	}

	@Override
	public String toString() {
		return nome;
	}
}

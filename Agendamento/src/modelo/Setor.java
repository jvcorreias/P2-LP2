package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

class Setor {

	private final Especialidade especialidade;
	private ArrayList<Medico> medicos = new ArrayList<>();

	Setor(Especialidade especialidade) {
		if (especialidade != null) {
			this.especialidade = especialidade;
		}
		else {
			this.especialidade = null;
		}
	}

	boolean medicoValido(Medico medico) {
		if (medico != null) {
			return medico.ehQualificado(especialidade);
		}
		return false;
	}
	
	boolean adicionarMedico(Medico medico) {
		if(medico != null && medicoValido(medico) && !medicos.contains(medico)) {
			medicos.add(medico);
			System.out.println("Medico Adicionado");
			return true;
		}
		return false;
	}

	boolean removerMedico(Medico medico) {
		if(medicos.remove(medico)) {
			System.out.println("Medico Removido");
			return true;
		}
		return false;
	}
	
	boolean atendeEspecialidade(Especialidade especialidade) {
		return this.especialidade.equals(especialidade);
	}
	
	Medico obterMedicoDisponivel(Data data) {
		if (data == null) return null;

		for(Medico medico: medicos) {
			if(medico.estaDisponivel(data)) {
				return medico;
			}
		}
		return null;
	}
}

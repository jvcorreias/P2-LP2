package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Setor {

	private final Especialidade especialidade;
	private ArrayList<Medico> medicos = new ArrayList<>();

	public Setor(Especialidade especialidade) {
		if (especialidade != null) {
			this.especialidade = especialidade;
		}
		else {
			this.especialidade = null;
		}
	}

	public boolean medicoValido(Medico medico) {
		if (medico != null) {
			return medico.ehQualificado(especialidade);
		}
		return false;
	}
	
	public boolean adicionarMedico(Medico medico) {
		if(medico != null && medicoValido(medico) && !medicos.contains(medico)) {
			medicos.add(medico);
			System.out.println("Medico Adicionado");
			return true;
		}
		return false;
	}

	public boolean removerMedico(Medico medico) {
		if(medicos.remove(medico)) {
			System.out.println("Medico Removido");
			return true;
		}
		return false;
	}
	
	public boolean atendeEspecialidade(Especialidade especialidade) {
		return this.especialidade.equals(especialidade);
	}
	
	public Medico obterMedicoDisponivel(Data data) {
		if (data == null) return null;

		for(Medico medico: medicos) {
			if(medico.estaDisponivel(data)) {
				return medico;
			}
		}
		return null;
	}
}

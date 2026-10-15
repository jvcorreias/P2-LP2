package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Setor {

	private Especialidade especialidade;
	private ArrayList<Medico> medicos;
	
	public void adicionarMedico(Medico m) {
		if(!medicos.contains(m) && m!=null) {
			medicos.add(m);
			System.out.println("Medico Adicionado");
		}
	}
	public void removerMedico(Medico m) {
		if(medicos.contains(m) && m!=null) {
			medicos.remove(m);
			System.out.println("Medico Removido");
		}
	}
	
	public boolean atendeEspecialidade(Especialidade e) {
		return this.especialidade == e;
	}
	
	public Medico obterMedicoDisponivel(LocalDate dia) {
		for(Medico m: medicos) {
			if(m.estaDisponivel(dia)) {
				return m;
			}
		}
		return null;
	}
	
	
	
}

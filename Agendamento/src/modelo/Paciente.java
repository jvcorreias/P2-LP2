package modelo;

import java.util.Collections;
import java.util.ArrayList;

public class Paciente extends Pessoa implements Priorizavel{

	private ArrayList<Consulta> consultas = new ArrayList<>();
	private Triagem ultimaTriagem;
	
	public Paciente(String nome, Data dataNascimento) {
		super(nome, dataNascimento);
	}

	public boolean agendarConsulta(Hospital hospital, Especialidade especialidade, Data data){
		Consulta consulta = hospital.gerarConsulta(this, especialidade, data);
		if (consulta != null && !consultas.contains(consulta)) {
			consultas.add(consulta);
			Collections.sort(consultas);
			return true;
		}
		return false;
	}
	public boolean cancelarConsulta(int id) {
		if (1 <= id && id <= consultas.size()) {
			Consulta alvo = consultas.get(id-1);
			if (alvo.possivel()) {
				alvo.cancelar();
			}
			consultas.remove(alvo);
			return true;
		}
		return false;
	}

	private Consulta proximaConsulta() {
		if (consultas.size() > 0 && consultas.get(0).possivel()) {
			return consultas.get(0);
		}
		return null;
	}

	public boolean irAProximaConsulta() {
		if (proximaConsulta() != null) {
			return proximaConsulta().realizar();
		}
		return false;
	}
	public boolean irAConsulta(int id) {
		if (id <= 0 || consultas.size() <= id) return false;

		for (int i = 1; i < id; i++) {
			cancelarConsulta(i-1);
		}

		Consulta alvo = consultas.get(id-1);
		if (alvo != null && alvo.possivel()) {
			return alvo.realizar();
		}
		return false;
	}
	
	public void realizarTriagem(int sintomasPreocupantes, ClassificacaoRisco classificacao) {
		ultimaTriagem = new Triagem(this, sintomasPreocupantes, classificacao);
	}

	public void obterIdentificacao() {
		System.out.println("%s, ");
	}
	
	public void exibirConsultas() {
		System.out.println("Consultas:");
		for (int i = 0; i < consultas.size(); i++) {
			System.out.print("\t" + (i+1) + ". ");
			System.out.println(consultas.get(i));
		}
	}

	@Override
	public int calcularPrioridade(){
		int pontosIdade = 0;

		if(this.idade >= 60){
			pontosIdade += 5;
		} else if(this.idade <= 12){
			pontosIdade += 5;
		}
		return pontosIdade;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}

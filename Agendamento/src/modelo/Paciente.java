package modelo;

import java.util.Collections;
import java.util.ArrayList;

public class Paciente extends Pessoa implements Imprimivel{

	private ArrayList<Atendimento> atendimentos = new ArrayList<>();
	private Triagem ultimaTriagem;
	
	public Paciente(String nome, Data dataNascimento) {
		super(nome, dataNascimento);
	}

	public boolean adicionarAtendimento(Atendimento novoAtendimento) {
		if (novoAtendimento != null && !atendimentos.contains(novoAtendimento)) {
			atendimentos.add(atendimento);
			Collections.sort(atendimentos);
			return true;
		}
		return false;
	}

	public boolean agendarConsulta(Hospital hospital, Data data) {
		return hospital.gerarConsulta(this, data);
	}

	public boolean cancelarAtendimento(int id) {
		if (1 <= id && id <= atendimento.size()) {
			Atendimento alvo = atendimentos.get(id-1);
			if (alvo.possivel()) {
				alvo.cancelar();
			}
			atendimentos.remove(alvo);
			Collections.sort(atendimentos);
			return true;
		}
		return false;
	}

	private Atendimento proximoAtendimento() {
		if (atendimentos.size() > 0 && atendimentos.get(0).possivel()) {
			return atendimentos.get(0);
		}
		return null;
	}

	public boolean iniciarProximoAtendimento() {
		if (proximoAtendimento() != null) {
			if(proximoAtendimento().iniciar()) {
				Collections.sort(atendimentos);
				return true;
			}
		}
		return false;
	}
	
	public void realizarTriagem(int sintomasPreocupantes, ClassificacaoRisco classificacao) {
		ultimaTriagem = new Triagem(this, sintomasPreocupantes, classificacao);
	}

	public void exibirAtendimentos() {
		System.out.println("Atendimentos:");
		for (int i = 0; i < atendimentos.size(); i++) {
			System.out.print("\t" + (i+1) + ". ");
			System.out.println(atendimentos.get(i));
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
		return this.nome();
	}
}

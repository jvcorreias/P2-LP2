package modelo;

public class Consulta extends Atendimento {
	public Consulta(Paciente paciente, Profissional profissional, Data data) {
		super(paciente, profissional, data);
	}

//	@Override
//	public boolean inciar() {
//		if (possivel()) {
//			return profissional.realizarConsulta();
//		}
//		return false;
//	}
//
//	@Override
//	public boolean finalizar() {
//		if (possivel()) {
//			status = StatusAtendimento.REALIZADO;
//			return true;
//		}
//		return false;
//	}
}

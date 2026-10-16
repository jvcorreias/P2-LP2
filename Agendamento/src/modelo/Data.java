package modelo;

import java.time.LocalDate;

public class Data implements Comparable<Data> {
	private int ano;
	private int mes;
	private int dia;

	public Data(int dia, int mes, int ano) {
		this.ano = ano;
		if (1 <= mes && mes <= 12) {
			this.mes = mes;
		}
		if (ehValida(dia, mes, ano)) {
			this.dia = dia;
		}
	}

	public static boolean ehAnoBissexto(int ano) {
		return ano % 4 == 0;
	}
	public boolean ehAnoBissexto() {
		return ehAnoBissexto(ano);
	}

	public static boolean ehValida(int dia, int mes, int ano) {
		switch (mes) {
		// verifica meses com 31 dias
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			if (dia <= 31) return true;
			break;
		// verifica meses com 30 dias
		case 4:
		case 6:
		case 9:
		case 11:
			if (dia <= 30) return true;
			break;
		// verifica fevereiro
		case 2:
			if (ehAnoBissexto(ano) && dia <= 29) return true;
			if (!ehAnoBissexto(ano) && dia <= 28) return true;
			break;
		default:
			return false;				// mês inválido
		}
		return false;					// dia inválido
	}

	public static Data agora() {
		LocalDate agora = LocalDate.now();
		return new Data(agora.getDayOfMonth(), agora.getMonthValue(), agora.getYear());
	}

	@Override
	public String toString() {
		return dia + "/" + mes + "/" + ano;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Data outra = (Data) obj;
		if (ano != outra.ano) return false;
		if (mes != outra.mes) return false;
		if (dia != outra.dia) return false;
		return true;
	}

	@Override
	public int compareTo(Data outra) {
		// compara ano
		if (ano < outra.ano) return -1;
		if (ano > outra.ano) return 1;

		// ano igual, compara mes
		if (mes < outra.mes) return -1;
		if (mes > outra.mes) return 1;

		// ano e mes iguais, compara dia
		if (dia < outra.dia) return -1;
		if (dia > outra.dia) return 1;

		// ano, mes e dia iguais
		return 0;
	}
}

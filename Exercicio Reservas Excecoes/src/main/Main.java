package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import entidades.Reserva;
import excecoes.ExcecaoDominio;

public class Main {

	public static void main(String[] args) {
		
		/* Um programa simples de reservas, recebe número do quarto data de entrada e saída */
		/* Exercício em java para treinamento de exceções personalizadas de forma profissional */
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.println("Número do quarto: ");
			int numeroQuarto = sc.nextInt();
			System.out.println("Data de entrada (dd/MM/yyyy): ");
			Date dataEntrada = sdf.parse(sc.next());
			System.out.println("Data de saída (dd/MM/yyyy): ");
			Date dataSaida = sdf.parse(sc.next());
			Reserva reserva = new Reserva(numeroQuarto, dataEntrada, dataSaida);
			System.out.println(reserva);
			System.out.println();
			System.out.println("Insira as novas datas para atualização");
			System.out.println("Data de entrada (dd/MM/yyyy): ");
			Date dataEntradaNova = sdf.parse(sc.next());
			System.out.println("Data de saída (dd/MM/yyyy): ");
			Date dataSaidaNova = sdf.parse(sc.next());
			reserva.atualizarDatas(dataEntradaNova, dataSaidaNova);
			System.out.println(reserva);
		}
		catch(ParseException e) {
			System.out.println("Formato de data inválido.");
		}
		catch(ExcecaoDominio e) {
			System.out.println("Erro na reserva: "+e.getMessage());
		}
		catch(InputMismatchException e) {
			System.out.println("Por favor, digite as informações corretamente.");
		}
		
		sc.close();

	}

}

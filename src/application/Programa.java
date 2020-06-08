 package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reserva;
import model.exceptions.DomainException;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			Scanner sc = new Scanner(System.in);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
		try {	
			System.out.print("Numero do Quarto");
			int numQuarto = sc.nextInt();
			System.out.print("Data do Checkin DD/MM/YYYY :");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Data do Checkout DD/MM/YYYY :");
			Date checkout = sdf.parse(sc.next());
		 
			Reserva reserva = new Reserva(numQuarto, checkin, checkout);
			System.out.println(" Reserva : " + reserva);
			
			System.out.println();
			System.out.println(" Entra com os dados para atualizar a reserva : ");
		    System.out.print("Data do Checkin DD/MM/YYYY :");
			checkin = sdf.parse(sc.next());
			System.out.print("Data do Checkout DD/MM/YYYY :");
			checkout = sdf.parse(sc.next());
			
			reserva.atualizacaoReserva(checkin, checkout);
			System.out.println(" Reserva : " + reserva);
		}
		catch(ParseException e) {
			System.out.println(" Formato da Data Invalido");			
		}
		catch (DomainException e) {
			System.out.println("error na reserva : " + e.getMessage());
		}
		catch( RuntimeException e ) {
			System.out.println(" Erro não esperado");
		}
		sc.close();
	}

}


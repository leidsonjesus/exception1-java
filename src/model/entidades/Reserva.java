package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reserva {
	
	private Integer numQuarto;
	private Date checkin;
	private Date checkout;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
		
	}

	public Reserva(Integer numQuarto, Date checkin, Date checkout) {
		if (checkout.before(checkin)) {
			throw new DomainException(" Da data checkout deve ser maior que a data chekcin");
		}
		this.numQuarto = numQuarto;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getNumQuarto() {
		return numQuarto;
	}

	public void setNumQuarto(Integer numQuarto) {
		this.numQuarto = numQuarto;
	}

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}

	public long duracao() {
		long diff =  checkin.getTime() - checkout.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void atualizacaoReserva(Date checkin, Date checkout) {
		Date dtnow = new Date();
	
		if (checkin.before(dtnow) ||checkout.before(dtnow)) {
			throw new DomainException("E possivel atualizar reserva somente para datas futuras");
		}
		
		if (checkout.before(checkin)) {
			throw new DomainException(" Da data checkout deve ser maior que a data chekcin");
		}
		this.checkin = checkin;
		this.checkout = checkout;
		
	}
	
	@Override
	public String toString() {
		return "Quarto" +
				numQuarto +
				", Checking" +
				sdf.format(checkin) +
				", Checkout" +
				sdf.format(checkout) +
				", " +
				duracao() +
				" noites";
				
				
	}
	
	
}

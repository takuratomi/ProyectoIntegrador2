package co.edu.usbcali.dto;

import java.sql.Date;

public class serviciosDTO {

	
	private int padreId;
	
	private long valor;
	
	private Date fechaFin;
	
	private long cuenta;
	
	public String generarFactura(int padreid, long valor, Date fechaFin, long cuenta) {
	
		System.out.println("Datos \n" + "Id padre: \n" + padreid + "Valor; \n" + valor 
				+ "Fecha maxima de pago: \n"+ fechaFin + "Cuenta: " + cuenta);
		
		return "Datos \n" + "Id padre: \n" + padreid + "Valor; \n" + valor 
					+ "Fecha maxima de pago: \n"+ fechaFin + "Cuenta: " + cuenta;
		
	}

	public int getPadreId() {
		return padreId;
	}

	public void setPadreId(int padreId) {
		this.padreId = padreId;
	}

	public long getValor() {
		return valor;
	}

	public void setValor(long valor) {
		this.valor = valor;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public long getCuenta() {
		return cuenta;
	}

	public void setCuenta(long cuenta) {
		this.cuenta = cuenta;
	}
	
	
	
}

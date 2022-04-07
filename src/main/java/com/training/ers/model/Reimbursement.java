package com.training.ers.model;

import java.util.Arrays;
import java.util.Objects;


public class Reimbursement implements Comparable<Reimbursement>{
	
	private int reimburseId;
	private String employeename;
	private int reimburseHotel;
	private int reimburseAirplaneticket;
	private int reimburseRentCar;
	private String status;
	//private String attachedfilename;
	//private byte[ ] filecontent;
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reimbursement(int reimburseId, String employeename, int reimburseHotel, int reimburseAirplaneticket,
			int reimburseRentCar, String status) {
		super();
		this.reimburseId = reimburseId;
		this.employeename = employeename;
		this.reimburseHotel = reimburseHotel;
		this.reimburseAirplaneticket = reimburseAirplaneticket;
		this.reimburseRentCar = reimburseRentCar;
		this.status = status;
	}
	/**
	 * @return the reimburseId
	 */
	public int getReimburseId() {
		return reimburseId;
	}
	/**
	 * @param reimburseId the reimburseId to set
	 */
	public void setReimburseId(int reimburseId) {
		this.reimburseId = reimburseId;
	}
	/**
	 * @return the employeename
	 */
	public String getEmployeename() {
		return employeename;
	}
	/**
	 * @param employeename the employeename to set
	 */
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	/**
	 * @return the reimburseHotel
	 */
	public int getReimburseHotel() {
		return reimburseHotel;
	}
	/**
	 * @param reimburseHotel the reimburseHotel to set
	 */
	public void setReimburseHotel(int reimburseHotel) {
		this.reimburseHotel = reimburseHotel;
	}
	/**
	 * @return the reimburseAirplaneticket
	 */
	public int getReimburseAirplaneticket() {
		return reimburseAirplaneticket;
	}
	/**
	 * @param reimburseAirplaneticket the reimburseAirplaneticket to set
	 */
	public void setReimburseAirplaneticket(int reimburseAirplaneticket) {
		this.reimburseAirplaneticket = reimburseAirplaneticket;
	}
	/**
	 * @return the reimburseRentCar
	 */
	public int getReimburseRentCar() {
		return reimburseRentCar;
	}
	/**
	 * @param reimburseRentCar the reimburseRentCar to set
	 */
	public void setReimburseRentCar(int reimburseRentCar) {
		this.reimburseRentCar = reimburseRentCar;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		return Objects.hash(employeename, reimburseAirplaneticket, reimburseHotel, reimburseId, reimburseRentCar,
				status);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		return Objects.equals(employeename, other.employeename)
				&& reimburseAirplaneticket == other.reimburseAirplaneticket && reimburseHotel == other.reimburseHotel
				&& reimburseId == other.reimburseId && reimburseRentCar == other.reimburseRentCar
				&& Objects.equals(status, other.status);
	}
	@Override
	public String toString() {
		return "Reimbursement [reimburseId=" + reimburseId + ", employeename=" + employeename + ", reimburseHotel="
				+ reimburseHotel + ", reimburseAirplaneticket=" + reimburseAirplaneticket + ", reimburseRentCar="
				+ reimburseRentCar + ", status=" + status + "]";
	}
	@Override
	public int compareTo(Reimbursement o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	

}

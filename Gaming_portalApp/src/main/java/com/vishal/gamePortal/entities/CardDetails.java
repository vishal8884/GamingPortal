package com.vishal.gamePortal.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CardDetails {

	@Id
	private long id;
	private String cardNumber;
	private String CVV;
	private String expiryDate;
	
	public CardDetails()
	{
		
	}
	
	
	
	public CardDetails(long id, String cardNumber, String cVV, String expiryDate) {
		super();
		this.id = id;
		this.cardNumber = cardNumber;
		this.CVV = cVV;
		this.expiryDate = expiryDate;
	}

    

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCVV() {
		return CVV;
	}
	public void setCVV(String cVV) {
		CVV = cVV;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	@Override
	public String toString() {
		return "CardDetails [id=" + id + ", cardNumber=" + cardNumber + ", CVV=" + CVV + ", expiryDate=" + expiryDate
				+ "]";
	}
	
	
	
}

package com.ntl.frs.bean;

public class PaymentBean {

	private String creditCard;
	private String validFrom;
	private String validTo;
	private int balance;
	private String userId;
	/**
	 * 
	 */
	public PaymentBean() {
		super();
	}
	
	
	
	




	/**
	 * @param creditCard
	 * @param validFrom
	 * @param validTo
	 * @param balance
	 * @param userId
	 */
	public PaymentBean(String creditCard, String validFrom, String validTo, int balance, String userId) {
		super();
		this.creditCard = creditCard;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.balance = balance;
		this.userId = userId;
	}








	/**
	 * @return the creditCard
	 */
	public String getCreditCard() {
		return creditCard;
	}
	/**
	 * @param creditCard the creditCard to set
	 */
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	/**
	 * @return the validFrom
	 */
	public String getValidFrom() {
		return validFrom;
	}
	/**
	 * @param validFrom the validFrom to set
	 */
	public void setValidFrom(String validFrom) {
		this.validFrom = validFrom;
	}
	/**
	 * @return the validTo
	 */
	public String getValidTo() {
		return validTo;
	}
	/**
	 * @param validTo the validTo to set
	 */
	public void setValidTo(String validTo) {
		this.validTo = validTo;
	}
	/**
	 * @return the balance
	 */
	public int getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
}

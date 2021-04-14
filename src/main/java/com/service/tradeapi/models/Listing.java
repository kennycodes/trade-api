package com.service.tradeapi.models;

import java.util.Date;

public class Listing {
	

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getStartPrice() {
		return startPrice;
	}
	public void setStartPrice(double startPrice) {
		this.startPrice = startPrice;
	}
	public double getBuyNowPrice() {
		return buyNowPrice;
	}
	public void setBuyNowPrice(double buyNowPrice) {
		this.buyNowPrice = buyNowPrice;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getIsReserveMet() {
		return isReserveMet;
	}
	public void setIsReserveMet(Date isReserveMet) {
		this.isReserveMet = isReserveMet;
	}
	public Date getHasReserve() {
		return hasReserve;
	}
	public void setHasReserve(Date hasReserve) {
		this.hasReserve = hasReserve;
	}
	public Date getHasBuyNow() {
		return hasBuyNow;
	}
	public void setHasBuyNow(Date hasBuyNow) {
		this.hasBuyNow = hasBuyNow;
	}
	public String getListingId() {
		return ListingId;
	}
	public void setListingId(String listingId) {
		ListingId = listingId;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	
	private String ListingId; 
    private String Title; 
    private String category; 
    private double startPrice; 
    private double buyNowPrice;
    private Date startDate;
    private Date endDate;
    private Date isReserveMet;
    private Date hasReserve;
    private Date hasBuyNow;
	
	

}

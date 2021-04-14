package com.service.tradeapi.models;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CategoryListing {
	
	@JsonProperty("TotalCount")
	private int totalCount; 
//	public List<Listing> getList() {
//		return List;
//	}
//	public void setList(List<Listing> list) {
//		List = list;
//	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	
	


	
//	private List<Listing> List;
	
	
	
}

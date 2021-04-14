package com.service.tradeapi;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.service.tradeapi.models.CategoryListing;
import com.service.tradeapi.models.Listing;

import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient;
@RestController
public class TradeAPIService {
	
	@Autowired
    private RestTemplate restTemplate;
	
	 @Autowired
	 WebClient.Builder webClientBuilder;

	private static Map < String, Listing > listingCatalog = new HashMap <> (); 
	protected Logger logger = Logger.getLogger(TradeAPIService.class.getName());
	
	@PostMapping("/listing")
	public String createListing(@RequestBody Listing listing) {
		listingCatalog.put(listing.getListingId(), listing);
		return "Listing added successfully"; 
	}
	
	@PutMapping("/listing")
	public String updateListing(@RequestBody Listing listing) {
		listingCatalog.put(listing.getListingId(), listing);
		return "Listing updated successfully"; 
	}
		
	@GetMapping("/listing")
	public String getNoReserveInTradeAuctionListings(@RequestParam("category") String category, @RequestParam("sort_by") String sortBy, @RequestParam("order_by") String orderBy) {
		String sortOption = "";
		switch(sortBy.concat(orderBy)) {
		  case "Title":
			  sortOption = "TitleAsc";
		    break;
		  case "ExpiryAsc":
			  sortOption = "ExpiryAsc";
		    break;
		  case "ExpiryDesc":
			  sortOption = "ExpiryDesc";
		    break;
		  case "PriceAsc":
			  sortOption = "PriceAsc";
		    break;
		  case "PriceDesc":
			  sortOption = "PriceDesc";
		    break;
		}
		
		logger.info("web-service getNoReserveInTradeAuctionListings() invoked: " + sortOption);
//		CategoryListing categoryListing = restTemplate.getForObject("http://api.tmsandbox.co.nz/v1/Listings/Latest.json?listed_as=Auctions&sort_order=ExpiryAsc", 
//				CategoryListing.class);
		
//		CategoryListing categoryListing  = webClientBuilder.build().get().uri("http://api.tmsandbox.co.nz/v1/Listings/Latest.json?listed_as=Auctions&sort_order=ExpiryAsc")
//				.retrieve().bodyToMono(CategoryListing.class).block();
		
//		CategoryListing categoryListing = webClientBuilder.build().get()
//        .uri("http://api.tmsandbox.co.nz/v1/Listings/Latest.json?listed_as=Auctions&sort_order=ExpiryAsc")
//        .retrieve()
//        .onStatus(HttpStatus::is4xxClientError, response -> Mono.empty())
//        .bodyToMono(CategoryListing.class)
//        .onErrorResume(e -> Mono.empty())
//        .doOnError(e -> logger.info("Error on fetching user details {}"+ e))
//        .filter(response -> !Objects.isNull(response.getData()))
//        .map(response -> response.getData())
//        .block();
		
		WebClient webClient = WebClient.builder()
				.clientConnector(new ReactorClientHttpConnector(
                        HttpClient.create().followRedirect(true)
                ))
//				.defaultHeaders(httpHeaders -> {
//			          httpHeaders.addAll(createHeaders());
//			        })
				.build();
		
		String categoryListing = webClient.get()
		                               .uri("http://api.tmsandbox.co.nz/v1/Listings/Latest.json?listed_as=Auctions&sort_order=ExpiryAsc")
		                               .retrieve()
		                               .bodyToMono(String.class)
		                               .onErrorResume(e -> Mono.empty())
		                               .doOnError(e -> logger.info("Error on fetching user details {}"+ e))
		                               .block();
		
		
		logger.info("web-service getNoReserveInTradeAuctionListings() returns: " + categoryListing);
		return categoryListing; 
	}
	
//	private HttpHeaders createHeaders() {
//	    HttpHeaders headers = new HttpHeaders();
//	   
//	    headers.add(HttpHeaders.HOST, "http://anypoint.com");
//	    
//	    return headers;
//	}
		
	@GetMapping("/listingOne")
	public List<Listing>  getExpiringAuctionListings(@RequestParam("category") String category, @RequestParam("order_by") String orderBy) {
		logger.info("web-service getExpiringAuctionListings() invoked: ");
		return new ArrayList<Listing>(listingCatalog.values()); 
	}
	
	@GetMapping("/listingTwo")
	public List<Listing>  getSpecialListing(@RequestBody Listing listing) {
		logger.info("web-service getSpecialListing() invoked: ");
		return new ArrayList<Listing>(listingCatalog.values()); 
	}
}

package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.model.ClaimModel;

@RestController
@RequestMapping("/service")
public class ClaimsRestService {

	@Autowired
	private ClaimsBusinessServiceInterface service;
	
	@GetMapping(path="/getjson", produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<ClaimModel> getOrderAsJson() {
		return service.getClaims();
	}
	
	/* TODO: add ClaimList.java
	@GetMapping(path="/getxml", produces= {MediaType.APPLICATION_XML_VALUE})
	public OrderList getOrderAsXml() {
		OrderList list = new OrderList();
		list.setOrders(service.getOrders());
		return list;
	}
	*/
}

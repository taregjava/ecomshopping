package com.shopme.customer;

import com.shopme.common.entity.Country;
import com.shopme.common.entity.Customer;
import com.shopme.dto.ApiResponse;
import com.shopme.dto.CustomerDto;
import com.shopme.dto.RequestWrapperDTO;
import com.shopme.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerRestController {

	@Autowired private CustomerService service;
	
	@PostMapping("/customers/check_unique_email")
	public String checkDuplicateEmail(String email) {
		return service.isEmailUnique(email) ? "OK" : "Duplicated";
	}

	/*@RequestMapping("/api/v1/customer")
	@PostMapping("/")
	public ApiResponse<?> saveCustemer(@RequestBody CustomerDto dto){
		*//*List<Country> listCountries = service.listAllCountries();
		customer.setCountry(listCountries.get(customer.getCountry().getId()));*//*
		service.registerCustomerDto(dto);
       *//* Customer customer= new Customer();
		dto = CustomerMapper.mapToCustomerBuilder(customer);*//*

		return new ApiResponse<>(7,dto);
	}*/
	@RequestMapping("/api/v1/customer")
	@PostMapping("/")
	public ResponseEntity<RequestWrapperDTO> addCustomer(@RequestBody CustomerDto customerDto) {
		return new ResponseEntity<>(service.registerCustomerDto(customerDto), HttpStatus.OK);
	}
	/*@RequestMapping("/api/v1/customer")
	@PostMapping("/")
	public ApiResponse<?> saveCustemer(@RequestBody Customer customer){
		List<Country> listCountries = service.listAllCountries();
		customer.setCountry(listCountries.get(customer.getCountry().getId()));
		service.registerCustomer(customer);
		return new ApiResponse<>(customer.getId(),customer);
	}*/
	/*   CardDetailsEntity cardDetails = CardDetailsMapperUtils.mapToCardDetailsEntity(dto);

                supplierRepository.saveAll(cardDetails.getSuppliers());

                cardDetailsRepository.save(cardDetails);

                if (ObjectUtils.isNotEmpty(cardDetails)) {
                    return CommonRequestWrapperUtil.buildRequestWrapper(
                            dto, CardDetailsConstants.CREDIT_CARD, CardDetailsMapperUtils.mapToCardDetailsBuilder(cardDetails),
                            CardDetailsConstants.CREDIT_CARD, CommonUtils.getStatus(HttpStatus.OK));*/
}

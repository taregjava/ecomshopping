package com.shopme.mapper;

import com.shopme.common.entity.Country;
import com.shopme.common.entity.Customer;
import com.shopme.common.entity.product.Product;
import com.shopme.dto.CustomerDto;
import com.shopme.dto.ProductDTO;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
public class CustomerMapper {

    private CustomerMapper() {
    }

    public static CustomerDto mapToCustomerBuilder(Customer entity) {

        return CustomerDto.builder()
                .countryId(entity.getCountry().getId().toString())
                .email(entity.getEmail())
                .enabled(entity.isEnabled())
                .firstname(entity.getFirstName())
                .fullname(entity.getFullName())
                .build();
    }

    public static Customer mapToCustomerEntity(CustomerDto dto) {

        Customer entity = new Customer();

            entity.setFirstName(dto.getFirstname());


            entity.setLastName(dto.getLastname());


            entity.setPhoneNumber(dto.getPhoneNumber());
        if (StringUtils.isNotBlank(dto.getFullname())) {
            entity.setFirstName(dto.getFullname());
        }
        if (StringUtils.isNotBlank(dto.getAddressLine1())) {
            entity.setAddressLine1(dto.getAddressLine1());
        }
        if (StringUtils.isNotBlank(dto.getAddressLine2())) {
            entity.setAddressLine2(dto.getAddressLine2());
        }
        if (StringUtils.isNotBlank(dto.getCity())) {
            entity.setCity(dto.getCity());
        }
        if (StringUtils.isNotBlank(dto.getPassword())) {
            entity.setPassword(dto.getPassword());
        }
        if (StringUtils.isNotBlank(dto.getState())) {
            entity.setState(dto.getState());
        }
        if (StringUtils.isNotBlank(dto.getPostalCode())) {
            entity.setPostalCode(dto.getPostalCode());
        }
        if (StringUtils.isNotBlank(dto.getEmail())) {
            entity.setEmail(dto.getEmail());
        }
        /*if(!StringUtils.isEmpty(dto.getCurrencyId())){
			CurrencyEntity currencyEntity = new CurrencyEntity();
			currencyEntity.setCurrencyId(dto.getCurrencyId());
			entity.setCurrency(currencyEntity);
		}*/
        if (!StringUtils.isEmpty(dto.getCountryId())) {
            Country country= new Country();
            country.setId(Integer.valueOf(dto.getCountryId()));
            entity.setCountry(country);
        }

        entity.setEnabled(dto.isEnabled());
        return entity;
    }
       /* if (StringUtils.isNotBlank(dto.getCardNickName())) {
            boolean validNickName = CreditCardHelper.isValidNickName(dto.getCardNickName());
            if (validNickName) {
                entity.setCardNickName(dto.getCardNickName());
            }else {
                throw new FopUncheckedException(
                        String.format(Error.ERROR_INVALID_NICKNAME.getDescription(), Domain.CARDETAILS.getDescription()),
                        Error.ERROR_INVALID_NICKNAME.getCode());
            }
        }*/
       /* if (StringUtils.isNotBlank(dto.getCardNumber())) {
            entity.setCardNumber(CreditCardHelper.encodeString(dto.getCardNumber()));
        }*/


}
package com.shopme.util;




import com.shopme.constant.EcommerceConstant;
import com.shopme.dto.MultiParam;
import com.shopme.dto.RequestWrapperDTO;
import com.shopme.dto.StatusResponse;
import org.apache.commons.collections4.map.HashedMap;
import org.springframework.data.domain.Page;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommonUtils {
    private CommonUtils() {
    }

    public static <T, U> RequestWrapperDTO mapToWrapper(@Nullable T request, @Nullable U response) {
        RequestWrapperDTO dto = new RequestWrapperDTO();
        dto.setRequest(request);
        dto.setResponse(response);
        dto.setStatus(Stream.of(new StatusResponse(EcommerceConstant.SUCCESS_CODE, EcommerceConstant.SUCCESS_CODE_DESC))
                .collect(Collectors.toList()));
        dto.setTimeStamp(LocalDateTime.now());
        return dto;
    }

    public static <T, U, W> RequestWrapperDTO mapToWrapper(@Nullable T request, @Nullable U response, @Nullable W pageDetails) {
        RequestWrapperDTO dto = new RequestWrapperDTO();
        dto.setRequest(request);
        dto.setResponse(response);
        dto.setPageDetails(pageDetails);
        dto.setStatus(Stream.of(new StatusResponse(EcommerceConstant.SUCCESS_CODE, EcommerceConstant.SUCCESS_CODE_DESC))
                .collect(Collectors.toList()));
        dto.setTimeStamp(LocalDateTime.now());
        return dto;
    }

    public static String getDateTime() {
        LocalDateTime dt = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return dt.format(format);
    }

    public static Map<String, Object> buildForObjectMapper(String key, Object value) {
        Map<String, Object> map = new HashedMap<>();
        map.put(key, value);
        return map;
    }

    public static Map<String, Object> buildListForObjectMapper(List<MultiParam> params) {
        return params.stream().collect(Collectors.toMap(MultiParam::getKey, MultiParam::getValue));
    }

    public static <T> PageDetailsBuilder buildPageDetailsBuilder(Page<T> page) {
        return PageDetailsBuilder.builder().pageNumber(page.getPageable().getPageNumber())
                .numberOfElements(page.getNumberOfElements()).pageSize(page.getSize()).totalElements(page.getTotalElements()).totalPages(page.getTotalPages())
                .build();
    }
}
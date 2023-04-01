package com.shopme.util;


import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class PageDetailsBuilder {
    private long totalElements;
    private int totalPages;
    private int numberOfElements;
    private int pageSize;
    private int pageNumber;
}
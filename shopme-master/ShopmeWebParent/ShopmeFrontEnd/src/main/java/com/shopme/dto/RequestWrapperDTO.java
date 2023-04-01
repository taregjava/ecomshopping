package com.shopme.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RequestWrapperDTO<T, U, W> {
    private T request;
    private U response;
    private W pageDetails;
    private List<StatusResponse> errors;
    private List<StatusResponse> status;
    private LocalDateTime timeStamp;
}
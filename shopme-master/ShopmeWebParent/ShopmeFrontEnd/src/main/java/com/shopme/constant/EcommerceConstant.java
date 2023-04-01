package com.shopme.constant;

public class EcommerceConstant {

    public static final String ERROR_OCCURRED = "Error occurred while ";
    public static final String PLACE_HOLDER = "%s";
    public static final String CREATE_ERROR = ERROR_OCCURRED + "adding " + PLACE_HOLDER;
    public static final String READ_ERROR = ERROR_OCCURRED + "finding " + PLACE_HOLDER;
    public static final String UPDATE_ERROR = ERROR_OCCURRED + "updating " + PLACE_HOLDER;
    public static final String DELETE_ERROR = ERROR_OCCURRED + "removing " + PLACE_HOLDER;
    public static final String RECORD_DOES_NOT_EXIST = "Record does not exist";
    public static final String RECORD_ALREADY_EXISTS = "Record already exists";
    public static final String NO_RECORDS_FOUND = "No records found";
    public static final String INVALID_REQUEST = "Invalid request";
    public static final String INVALID_JSON = "Unable to Parse JSON please provide a valid JSON";
    public static final String REMOVED = "Removed " + PLACE_HOLDER;
    public static final String GENERAL_ERROR = "Something went wrong. Please try again.";

    public static final String CREATE_ERROR_CODE = "ERR_AR_MS_01";
    public static final String UPDATE_ERROR_CODE = "ERR_AR_MS_02";
    public static final String DELETE_ERROR_CODE = "ERR_AR_MS_03";
    public static final String RECORD_DOES_NOT_EXIST_CODE = "ERR_AR_MS_04";
    public static final String RECORD_ALREADY_EXISTS_CODE = "ERR_AR_MS_05";
    public static final String NO_RECORDS_FOUND_CODE = "ERR_AR_MS_06";
    public static final String INVALID_REQUEST_CODE = "ERR_AR_MS_07";
    public static final String GENERAL_ERROR_CODE = "ERR_AR_MS_08";
    public static final String INVALID_JSON_CODE = "ERR_AR_MS_09";

    public static final String SUCCESS_OCCURED = "Successfully ";
    public static final String CREATE_SUCCESS = SUCCESS_OCCURED + "added " + PLACE_HOLDER;
    public static final String UPDATE_SUCCESS = SUCCESS_OCCURED + "updated " + PLACE_HOLDER;
    public static final String DELETE_SUCCESS = SUCCESS_OCCURED + "deleted " + PLACE_HOLDER;

    public static final String SUCCESS_CODE = "200";
    public static final String SUCCESS_CODE_DESC = "OK";

    public static final String MSG_FIELD = "Message";


    public static final String PAGE_FIELD = "Page";
    public static final String SIZE_FIELD = "Size";


    public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";



    public static final String CODE = "code";


    public static final Integer DEFAULT_PAGE_SIZE = 10;
    public static final Integer DEFAULT_PAGE = 0;


}

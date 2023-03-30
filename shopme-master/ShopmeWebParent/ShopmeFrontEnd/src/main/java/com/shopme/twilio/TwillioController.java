package com.shopme.twilio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import javax.validation.Valid;

@RestController
@RequestMapping("/sms")
public class TwillioController {

    private final twilioService service;

    public TwillioController(twilioService service) {
        this.service = service;
    }

    @PostMapping
    public void sendSms( @RequestBody SmsRequest smsRequest) {
        service.sendSms(smsRequest);
    }

}

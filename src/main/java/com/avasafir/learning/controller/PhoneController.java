package com.avasafir.learning.controller;

import com.avasafir.learning.domain.Phone;
import com.avasafir.learning.serveice.PhoneService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/phones")
public class PhoneController {
    private final PhoneService phoneService;

    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updatePhone(@RequestBody Phone phone){
        phoneService.updatePhone();
    }

}

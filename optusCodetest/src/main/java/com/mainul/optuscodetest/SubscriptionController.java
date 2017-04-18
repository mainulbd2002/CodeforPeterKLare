/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mainul.optuscodetest;

import com.mainul.optuscodetest.stringmanipulator.IStringTrunctor;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 *
 * @author Mainul
 */
@Controller
public class SubscriptionController {
    
    private static final String FILLER_STR = " ... (truncated) ... ";
    @Autowired
    IStringTrunctor strTrunctor;
    
    @RequestMapping(value="/subscribe", method=RequestMethod.GET)
    public String subscribe(HttpServletRequest request){
        
        String orderDetails = getOrderDetails(request);
        String truncateOrderDetails = truncate(orderDetails);
        log(truncateOrderDetails);
        
        return "subscription_view";
    }

    private void log(String truncateOrderDetails) {
           // Complete logging through file 
    }

    public String truncate(String orderDetails) {
        return strTrunctor.shortenStringWithMark(orderDetails, FILLER_STR, 30);
    }
    
    private String getOrderDetails(HttpServletRequest request){
        return "76543213456789098765432134567898765432145678987654321345437876";
    }
    
}

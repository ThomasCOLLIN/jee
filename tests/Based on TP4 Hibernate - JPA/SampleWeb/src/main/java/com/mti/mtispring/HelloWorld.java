/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtispring;

import javax.jws.WebService;

/**
 *
 * @author REMI
 */
@WebService(endpointInterface = "com.mti.mtispring.HelloService")
public class HelloWorld implements HelloService {

    /**
     * This is a sample web service operation
     */
    public String hello(String txt) {
        return "Hello " + txt + " !";
    }
}

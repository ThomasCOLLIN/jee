/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtispring;

import com.mti.mtispring.db.daos.PeopleDAO;
import com.mti.mtispring.db.entities.People;
import java.util.List;
import javax.jws.WebService;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author REMI
 */
@WebService(endpointInterface = "com.mti.mtispring.HelloService")
public class HelloWorld implements HelloService {

    /**
     * This is a sample web service operation
     */
    @Override
    @Transactional(readOnly=true)
    public String hello(String txt) {
        PeopleDAO dao = new PeopleDAO();
        List<People> list = dao.findAll();
        return list.get(0).toString();
    }
}

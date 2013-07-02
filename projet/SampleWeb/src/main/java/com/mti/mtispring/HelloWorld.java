/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtispring;

import com.mti.mtispring.db.daos.PeopleDAO;
import com.mti.mtispring.db.entities.People;
import java.util.List;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    PeopleDAO dao;
    
    @Override
    @Transactional(readOnly=true)
    public String hello(String txt) {
        if (txt.equals("add")) {
            People p = new People();
            p.setLogin("chaill_k");
            dao.persist(p);
            return "added";
        } else if (txt.equals("del")) {
            List<People> list = dao.findAll();
            dao.remove(list.get(0));
            return "Deleted";
        } else {
            List<People> list = dao.findAll();
            String s = "";
            for (People e : list) {
                s += e.getLogin() + " ";
            }
            return s;
        }
    }
}

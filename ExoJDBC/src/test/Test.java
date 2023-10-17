package test;

import java.util.Date;
import beans.DevData;
import service.DevDataService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lachgar
 */
public class Test {
    public static void main(String[] args) {
        DevDataService cs = new DevDataService();
        DevData c = new DevData("rami", "ali", new Date());
        //cs.create(c);
        
      //  System.out.println(cs.findById(2));
        cs.delete(cs.findById(2));
        for(DevData cc : cs.findAll())
            System.out.println(cc);
    }
}

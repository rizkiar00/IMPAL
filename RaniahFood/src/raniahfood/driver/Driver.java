/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raniahfood.driver;

import java.sql.SQLException;
import raniahfood.controller.*; 
import raniahfood.database.Database; 
import raniahfood.model.*; 
import java.sql.SQLException;
/**
 *
 * @author THOSIBA
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Database db = new Database(); 
        raniahfood app = new raniahfood(); 
        new Controller(app,db); 
    }
    
}

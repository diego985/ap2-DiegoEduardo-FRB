/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frb.edu.br.diego.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Diego
 */
public abstract class DaoUtil {
    private Connection cx = null;
    
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        if(this.cx == null){
            String url = "jdbc:mysql://localhost:3306/ap2_arleys?zeroDateTimeBehavior=convertToNull";
            String psw = "";
            String usr = "root";
            String drive = "com.mysql.jdbc.Driver";
            
            Class.forName(drive);
            cx = DriverManager.getConnection(url, usr, psw);
        }
        return cx;
    }
    public void getFechaConnection() throws SQLException{
        if(this.cx != null){
            this.cx.close();
            this.cx = null;
        }
    }
    
    public Statement getStatement() throws ClassNotFoundException, SQLException{
        return this.getConnection().createStatement();
    }
    
    public PreparedStatement getPreparedStatement(String sql) throws ClassNotFoundException, SQLException{
        return this.getConnection().prepareStatement(sql);
    }
    
}
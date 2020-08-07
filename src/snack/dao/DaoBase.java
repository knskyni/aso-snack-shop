package snack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DaoBase {
    protected Connection con = null;

    public void connect() throws Exception {
        if(con != null) return;

        InitialContext context = null;
        try {
            String jndi = "java:comp/env/jdbc/MySQL";
            context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup(jndi);
            con = dataSource.getConnection();
        } catch(NamingException e) {
            e.printStackTrace();
            throw e;
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void close() {
        if(con != null) {
            try {
                con.close();
                con = null;
            } catch (SQLException e) {
                System.out.println("closeに失敗しました");
            }
        }
    }

    public Connection getConnection() {
        return con;
    }

    public void beginTransaction() throws SQLException {
        if(con != null) con.setAutoCommit(false);
    }

    public void commit() throws SQLException {
        if(con != null){
            try {
                con.commit();
            } finally{
                con.setAutoCommit(true);
            }
        }
    }

    public void rollback() {
        if(con != null){
            try {
                con.rollback();
            }catch(SQLException e){
                System.out.println("rollebackに失敗しました：");
            } finally{
                try{
                    con.setAutoCommit(true);
                }catch(SQLException e){
                    System.out.println("setAutoCommitに失敗しました：");
                }
            }
        }
    }
    protected int getOrderId(String orders) throws SQLException{
         if(con == null) return 0;

         int orderId = 0;

         PreparedStatement ps = null;
         ResultSet rs = null;

         ps = con.prepareStatement("SELECT last_insert_id() AS orderId FROM " + orders + ";");

         rs = ps.executeQuery();

         while(rs.next()) {
             orderId = rs.getInt("orderId");
         }
         return orderId;
    }
}

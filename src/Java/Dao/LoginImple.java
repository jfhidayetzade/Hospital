/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java.Dao;

import Java.Jdbc.Utilty;
import Java.Model.Login;
import Java.Model.Role;
import Java.Model.Soreness;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class LoginImple implements LoginDao {

    @Override
    public Login login(String username, String password) throws Exception {
        Login login = new Login();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT L.ID,L.USERNAME,L.PASSWORD,L.NAME,L.SURNAME, R.ROLE_NAME FROM LOGINN L\n" +
                "INNER JOIN ROLE R ON L.ROLE_ID=R.ID\n" +
                "WHERE L.ACTIVE=1 AND R.ACTIVE=1 AND L.USERNAME=? AND L.PASSWORD=?";
        try {
            c = DBhelper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                rs = ps.executeQuery();
                if (rs.next()) {
                    login.setId(rs.getLong("ID"));
                    login.setUsername(rs.getString("USERNAME"));
                    login.setName(rs.getString("NAME"));
                    login.setSurname(rs.getString("SURNAME"));
                    Role role = new Role();
                    role.setRole_name(rs.getString("ROLE_NAME"));
                    login.setRole(role);

                } else {
                    login = null;
                }
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utilty.close(c, ps, rs);
        }

        return login;
    }

    @Override
    public boolean addRegister(Login login) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO LOGINN (ID, USERNAME,PASSWORD,NAME,SURNAME,ROLE_ID )\n"
                + "           VALUES(loginn_SEQ.NEXTVAL, ?,?,?,?,?)";
        try {
            c = DBhelper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, login.getUsername());
                ps.setString(2, login.getPassword());
                ps.setString(3, login.getName());
                ps.setString(4, login.getSurname());
                ps.setLong(5, login.getRole().getId());
                ps.execute();
                result = true;
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utilty.close(c, ps, null);
        }
        return result;
    }

    @Override
    public List<Login> getloginlist() throws Exception {
        List<Login> logins = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM R, ID,  USERNAME, PASSWORD, NAME,SURNAME FROM LOGINN\n"
                + "WHERE ACTIVE=1";
        try {
            c = DBhelper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Login login = new Login();
                    login.setR(rs.getLong("R"));
                    login.setId(rs.getLong("ID"));
                    login.setUsername(rs.getString("USERNAME"));
                    login.setPassword(rs.getString("PASSWORD"));
                    login.setName(rs.getString("NAME"));
                    login.setSurname(rs.getString("SURNAME"));
                    logins.add(login);
                }
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utilty.close(c, ps, rs);
        }
        return logins;
    }

    
    @Override
    public boolean deleteLogin(long deleteLoginId) {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE LOGINN SET ACTIVE=0"
                + "WHERE ID=?";
        try {
            c = DBhelper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, deleteLoginId);
                ps.executeUpdate();
                result = true;
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                Utilty.close(c, ps, null);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public Login getloginById(long loginId) throws Exception {
        Login login = new Login();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM R, ID, USERNAME,  NAME, SURNAME FROM LOGINN\n"
                + "WHERE ACTIVE=1 AND ID=?";
        try {
            c = DBhelper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, loginId);
                rs = ps.executeQuery();
                if (rs.next()) {
                    login.setR(rs.getLong("R"));
                    login.setId(rs.getShort("ID"));
                    login.setUsername(rs.getString("USERNAME"));
                    login.setName(rs.getString("NAME"));
                    login.setSurname(rs.getString("SURNAME"));

                }
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utilty.close(c, ps, rs);
        }

        return login;
    }

    @Override
    public boolean updatelogin(Login login, long loginId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "update loginn set USERNAME=?, name=?, surname=?\n"
                + "where id=?";
        try {
            c = DBhelper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, login.getUsername());
                ps.setString(2, login.getName());
                ps.setString(3, login.getSurname());
                ps.setLong(4, loginId);
                ps.executeUpdate();
                result = true;
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                Utilty.close(c, ps, null);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return result;
    }

    @Override
    public List<Login> searchLoginData(String keyword) throws Exception {
        List<Login> logins = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM R, ID, USERNAME, NAME, SURNAME FROM LOGINN\n"
                + "WHERE ACTIVE=1 AND (LOWER (USERNAME) LIKE LOWER ('%" + keyword + "%') OR "
                + " LOWER (NAME) LIKE LOWER ('%" + keyword + "%') OR LOWER (SURNAME) LIKE LOWER ('%" + keyword + "%') )";
        try {
            c = DBhelper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Login login = new Login();
                    login.setR(rs.getLong("R"));
                    login.setId(rs.getLong("ID"));
                    login.setUsername(rs.getString("USERNAME"));
                    login.setName(rs.getString("NAME"));
                    login.setSurname(rs.getString("SURNAME"));
                    logins.add(login);
                }
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utilty.close(c, ps, rs);
        }
        return logins;
    }

}

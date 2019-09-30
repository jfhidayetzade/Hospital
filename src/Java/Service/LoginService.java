/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java.Service;

import Java.Model.Login;
import java.util.List;

/**
 *
 * @author User
 */
public interface LoginService {
    
        Login login(String username, String password) throws Exception;
        boolean addRegister(Login login) throws Exception;
        List<Login> getloginlist () throws Exception;
        boolean deleteLogin(long deleteLoginId);
        Login getloginById (long loginId) throws Exception;
        boolean updatelogin (Login login, long loginId) throws Exception;
        List<Login> searchLoginData(String keyword) throws Exception;
}

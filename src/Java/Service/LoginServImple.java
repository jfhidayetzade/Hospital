/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java.Service;

import Java.Dao.LoginDao;
import Java.Model.Login;
import java.util.List;

/**
 *
 * @author User
 */
public class LoginServImple implements LoginService{
    
    private LoginDao loginDao;

    public LoginServImple(LoginDao loginDao) {
        this.loginDao = loginDao;
    }
    

    @Override
    public Login login(String username, String password) throws Exception {
        return loginDao.login(username, password);
    }

    @Override
    public boolean addRegister(Login login) throws Exception {
        return loginDao.addRegister(login);
    }

    @Override
    public List<Login> getloginlist() throws Exception {
        return loginDao.getloginlist();
    }

    @Override
    public boolean deleteLogin(long deleteLoginId) {
        return loginDao.deleteLogin(deleteLoginId);
    }

    @Override
    public Login getloginById(long loginId) throws Exception {
        return loginDao.getloginById(loginId);
    }

    @Override
    public boolean updatelogin(Login login, long loginId) throws Exception {
        return loginDao.updatelogin(login, loginId);
    }

    @Override
    public List<Login> searchLoginData(String keyword) throws Exception {
        return loginDao.searchLoginData(keyword);
    }

    

    

  
   
}

package snack.model;

import snack.bean.UserBean;
import snack.dao.UserDao;

public class UserModel {

    public UserBean auth(String email, String password) {
        UserDao userDao = new UserDao();
        UserBean userInfo = null;
        try {
            userDao.connect();
            userInfo = userDao.auth(email, password);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            userDao.close();
        }
      
        return userInfo;
    }
  
    public UserBean authAdmin(String email,String password) {
        UserBean userBean = null;
        UserDao userDao = new UserDao();
        try{
            userDao.connect();
            userBean = userDao.authAdmin(email,password);
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            userDao.close();
        }
        return userBean;
    }

    public boolean insert(UserBean userbean) {
        UserDao userDao = new UserDao();
      
        try {
            userDao.connect();
            return userDao.insert(userbean);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally {
            userDao.close();
        }
    }
  
    public UserBean show(int id) {

        UserDao userDao = new UserDao();
        UserBean userInfo = null;

        try {
            userDao.connect();
            userInfo = userDao.show(id);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            userDao.close();
        }
        return userInfo;
    }

    public UserBean update(UserBean userUpdateInfo) {

        UserDao userDao = new UserDao();
        UserBean userInfoBean = null;

        try {
            userDao.connect();
            userInfoBean = userDao.update(userUpdateInfo);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            userDao.close();
        }
        return userInfoBean;
    }
}

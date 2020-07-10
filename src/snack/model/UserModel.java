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
}

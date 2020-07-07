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
}

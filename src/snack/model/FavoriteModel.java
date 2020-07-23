package snack.model;

import snack.dao.FavoriteDao;

public class FavoriteModel {
    public int action(int userId, int itemId) {
        FavoriteDao favDao = new FavoriteDao();
        boolean exist = false;
        int result = -1;

        try {
            favDao.connect();
            exist = favDao.exist(userId, itemId); // 存在するならtrue, 存在しないならfalse

            if(exist) {
                boolean action = favDao.delete(userId, itemId);
                result = action ? 0 : -1;
            } else {
                boolean action = favDao.create(userId, itemId);
                result = action ? 1 : -1;
            }

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            favDao.close();
        }

        return result;
    }
}

package snack.model;

import snack.bean.NewsBean;
import snack.dao.NewsDao;

public class NewsModel {

    public boolean create(NewsBean news) {
        NewsDao newsDao = new NewsDao();
        boolean result = false;

        try {
            newsDao.connect();
            result = newsDao.create(news);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            newsDao.close();
        }

        return result;
    }

    public NewsBean show(int id) {
        NewsBean newsBean = null;
        NewsDao newsDao = new NewsDao();

        try {
            newsDao.connect();
            newsBean = newsDao.show(id);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            newsDao.close();
        }

        return newsBean;
    }

    public boolean update(NewsBean news) {
        NewsDao newsDao = new NewsDao();
        boolean result = false;

        try {
            newsDao.connect();
            result = newsDao.update(news);
        } catch(Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
            newsDao.close();
        }

        return result;
    }

}

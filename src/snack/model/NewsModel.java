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

}

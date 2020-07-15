package snack.model;

import java.util.ArrayList;
import java.util.List;

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
    public List<NewsBean> list(){
        List<NewsBean> news = new ArrayList<NewsBean>();
        NewsDao newsDao = new NewsDao();
        try {
            newsDao.connect();
            news = newsDao.list();
        }catch(Exception e) {

            e.printStackTrace();
        }finally {
            newsDao.close();
        }
        return news;
    }
}

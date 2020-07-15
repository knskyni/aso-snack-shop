package snack.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import snack.bean.NewsBean;

public class NewsDao extends DaoBase {

    public boolean create(NewsBean news) {
        if(con == null) {
            return false;
        }

        PreparedStatement stmt = null;
        int result = 0;

        try {
            stmt = con.prepareStatement("INSERT INTO `news` (`created_at`, `updated_at`, `subject`, `content`) VALUES (?, ?, ?, ?)");

            stmt.setTimestamp(1, new java.sql.Timestamp(new java.util.Date().getTime()));
            stmt.setTimestamp(2, new java.sql.Timestamp(new java.util.Date().getTime()));
            stmt.setString(3, news.getSubject());
            stmt.setString(4, news.getContent());

            result = stmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return (result == 1) ? true : false;
    }
    public List<NewsBean> list(){
        if( con == null ){
            return null;
        }
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<NewsBean> news = new ArrayList<NewsBean>();
        try{
            stmt = con.prepareStatement("SELECT id, updated_at, subject FROM news  ORDER BY updated_at DESC");
            rs = stmt.executeQuery();
            while( rs.next() ) {
                NewsBean newsBean = new NewsBean();
                newsBean.setId(rs.getInt("id"));
                newsBean.setUpdatedAt(rs.getDate("updated_at"));
                newsBean.setSubject(rs.getString("subject"));
                news.add(newsBean);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return news;
    }
    public NewsBean show(int id){
        if( con == null ){
            return null;
        }
        PreparedStatement stmt = null;
        ResultSet rs = null;
        NewsBean newsBean = new NewsBean();
        try{
            stmt = con.prepareStatement("SELECT updated_at, subject, content FROM news  WHERE id =?");
            stmt.setInt(1,id);
            rs = stmt.executeQuery();
            while( rs.next() ) {
                newsBean.setUpdatedAt(rs.getDate("updated_at"));
                newsBean.setSubject(rs.getString("subject"));
                newsBean.setContent(rs.getString("content"));
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return newsBean;
    }

}

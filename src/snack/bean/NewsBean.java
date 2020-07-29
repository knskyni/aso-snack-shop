package snack.bean;

import java.io.Serializable;
import java.util.Date;

public class NewsBean implements Serializable{

    //NewsBeanのすべての値
    private int id;
    private Date createdAt;
    private Date updatedAt;
    private String subject;
    private String content;

    //すべての値のgetter&setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }


}

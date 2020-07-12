package snack.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PurchaseBean implements Serializable{

    private int id;
    private List<ItemBean> items;
    private Date createdAt;
    private int totalPrice;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public List<ItemBean> getItems() {
        return items;
    }
    public void setItems(List<ItemBean> items) {
        this.items = items;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public int getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }




}

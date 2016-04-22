package com.gourderwa.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

/**
 * 订单
 *
 * @author Wei.Li on 2016/4/21.
 */
@Entity
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue
    @Column(insertable = false, updatable = false)
    private int id;

    /**
     * 用户 id
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usersId", insertable = false, updatable = false, nullable = false)
    private Users users;

    /**
     * 糖果 id
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "candyId", insertable = false, updatable = false, nullable = false)
    private Candy candy;
    /**
     * 订单类型 糖果定制1 or 正常购买2
     */
    @Column(length = 1, nullable = false)
    private int type;
    /**
     * 用户价格
     */
    @Column(length = 8, scale = 2, nullable = false)
    private double userPrice;

    /**
     * 邮费
     */
    @Column(length = 8, scale = 2)
    private double postage;

    /**
     * 订单状态
     */
    @Column(length = 20)
    private State state;

    /**
     * 驳回理由
     */
    @Column(length = 1000)
    private String reasonRejection;

    /**
     * 下单时间
     */
    @Column(length = 32)
    private String orderTime;

    /**
     * 用户留言
     */
    @Column(length = 1000)
    private String guestBook;

    public Order() {
    }

    public Order(Users users, Candy candy, int type, double userPrice, double postage,
                 State state, String reasonRejection, String orderTime, String guestBook) {
        this.users = users;
        this.candy = candy;
        this.type = type;
        this.userPrice = userPrice;
        this.postage = postage;
        this.state = state;
        this.reasonRejection = reasonRejection;
        this.orderTime = orderTime;
        this.guestBook = guestBook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Candy getCandy() {
        return candy;
    }

    public void setCandy(Candy candy) {
        this.candy = candy;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getUserPrice() {
        return userPrice;
    }

    public void setUserPrice(double userPrice) {
        this.userPrice = userPrice;
    }

    public double getPostage() {
        return postage;
    }

    public void setPostage(double postage) {
        this.postage = postage;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getReasonRejection() {
        return reasonRejection;
    }

    public void setReasonRejection(String reasonRejection) {
        this.reasonRejection = reasonRejection;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getGuestBook() {
        return guestBook;
    }

    public void setGuestBook(String guestBook) {
        this.guestBook = guestBook;
    }

    enum State {

        /**
         * 用户下单
         */
        UserOrder,
        /**
         * 卖家驳回
         */
        SellerRejected,
        /**
         * 等待发货
         */
        WaitingForDelivery,
        /**
         * 已发货
         */
        AlreadyShipped,
        /**
         * 已签收
         */
        AlreadySign

    }

}

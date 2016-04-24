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
@Table(name = "orderForm")
public class OrderForm {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private int orderFormId;

    /**
     * 用户 id
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private Users users;

    /**
     * 糖果 id
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "candyId")
    private Candy candy;

    /**
     * 订单数量
     */
    @Column(length = 8)
    private double num;

    /**
     * 订单地址
     */
    @Column(length = 1000)
    private String address;

    /**
     * 订单状态
     */
    @Column(length = 20)
    private State state;

    /**
     * 卖家反馈信息
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

    public OrderForm() {
    }

    public OrderForm(Users users, Candy candy, double num,
                     String address,
                     State state, String reasonRejection, String orderTime, String guestBook) {
        this.users = users;
        this.candy = candy;
        this.num = num;
        this.address = address;
        this.state = state;
        this.reasonRejection = reasonRejection;
        this.orderTime = orderTime;
        this.guestBook = guestBook;
    }

    public int getOrderFormId() {
        return orderFormId;
    }

    public void setOrderFormId(int orderFormId) {
        this.orderFormId = orderFormId;
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

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public enum State {

        /**
         * 卖家驳回
         */
        SellerRejected("卖家驳回"),
        /**
         * 等待发货
         */
        WaitingForDelivery("等待发货"),
        /**
         * 已发货
         */
        AlreadyShipped("已发货"),
        /**
         * 已签收
         */
        AlreadySign("已签收");

        private String describe;

        State(String describe) {
            this.describe = describe;
        }

        public String getDescribe() {
            return describe;
        }

        public void setDescribe(String describe) {
            this.describe = describe;
        }
    }

}

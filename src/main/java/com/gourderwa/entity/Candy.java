package com.gourderwa.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

/**
 * 糖果
 *
 * @author Wei.Li on 2016/4/21.
 */
@Entity
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "candy")
public class Candy {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private int candyId;

    @Column(length = 30)
    private String candyName;
    /**
     * 用户 id
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private Users users;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "candyCategoryId", updatable = false, nullable = false)
    private CandyCategory candyCategory;

    /**
     * 糖果状态
     */
    @Column
    private State state;

    /**
     * 糖果图片
     */
    @Column(length = 1000)
    private String image;

    /**
     * 库存
     */
    @Column(length = 8)
    private int stock;

    /**
     * 销量
     */
    @Column(length = 8)
    private int salesVolume;

    /**
     * 邮费
     */
    @Column(length = 8, scale = 2)
    private double postage;

    public Candy() {
    }

    public Candy(String candyName, Users users, CandyCategory candyCategory, State state, String image) {
        this.candyName = candyName;
        this.users = users;
        this.candyCategory = candyCategory;
        this.state = state;
        this.image = image;
    }

    public Candy(String candyName, Users users, CandyCategory candyCategory, State state, String image,
                 int stock, int salesVolume, double postage) {
        this.candyName = candyName;
        this.users = users;
        this.candyCategory = candyCategory;
        this.state = state;
        this.image = image;
        this.stock = stock;
        this.salesVolume = salesVolume;
        this.postage = postage;
    }


    public int getCandyId() {
        return candyId;
    }

    public void setCandyId(int candyId) {
        this.candyId = candyId;
    }

    public String getCandyName() {
        return candyName;
    }

    public void setCandyName(String candyName) {
        this.candyName = candyName;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public CandyCategory getCandyCategory() {
        return candyCategory;
    }

    public void setCandyCategory(CandyCategory candyCategory) {
        this.candyCategory = candyCategory;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(int salesVolume) {
        this.salesVolume = salesVolume;
    }

    public double getPostage() {
        return postage;
    }

    public void setPostage(double postage) {
        this.postage = postage;
    }

    public enum State {

        /**
         * 审核中
         */
        Audi("审核中"),
        /**
         * 售货中
         */
        SaleIn("售货中"),
        /**
         * 下架
         */
        UnShelve("下架");


        private String describe;

        State(String describe) {
            this.describe = describe;
        }

        public String getDescribe() {
            return describe;
        }
    }
}

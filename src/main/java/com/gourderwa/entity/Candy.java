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
    @GeneratedValue
    @Column
    private int candyId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", updatable = false, nullable = false)
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
    private String[] images;

    /**
     * 库存
     */
    @Column(length = 8, columnDefinition = "0")
    private int stock;

    /**
     * 销量
     */
    @Column(length = 8, columnDefinition = "0")
    private int salesVolume;

    /**
     * 邮费
     */
    @Column(length = 8, scale = 2)
    private double postage;

    public Candy() {
    }

    public Candy(CandyCategory candyCategory, State state, String[] images,
                 int stock, int salesVolume, double postage) {
        this.candyCategory = candyCategory;
        this.state = state;
        this.images = images;
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

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
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

    enum State {

        /**
         * 审核中
         */
        Audit,
        /**
         * 售货中
         */
        SaleIn,
        /**
         * 卖家生产
         */
        SellerProduction,
        /**
         * 下架
         */
        OffSshelf

    }
}

package com.gourderwa.model;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

/**
 * @author HuKaiMo on 2016/4/21.
 */
@Entity
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "candy")
public class Candy {

    @Id
    @GeneratedValue
    @Column
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private CandyCategory candyCategory;

    /**
     * 糖果状态
     */
    @Column
    private boolean available;

    /**
     * 糖果图片
     */
    @Column(length = 1000)
    private String[] images;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CandyCategory getCandyCategory() {
        return candyCategory;
    }

    public void setCandyCategory(CandyCategory candyCategory) {
        this.candyCategory = candyCategory;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
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
        OffSshelf,
        /**
         * 审核中
         */
        Audit

    }
}

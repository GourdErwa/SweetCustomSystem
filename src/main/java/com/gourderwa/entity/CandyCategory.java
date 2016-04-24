package com.gourderwa.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

/**
 * 糖果分类
 *
 * @author Wei.Li on 2016/4/21.
 */
@Entity
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "candyCategory")
public class CandyCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private int candyCategoryId;

    @Column(length = 32, unique = true, nullable = false)
    private String candyCategoryName;

    public CandyCategory() {
    }

    public CandyCategory(String candyCategoryName) {
        this.candyCategoryName = candyCategoryName;
    }

    public int getCandyCategoryId() {
        return candyCategoryId;
    }

    public void setCandyCategoryId(int candyCategoryId) {
        this.candyCategoryId = candyCategoryId;
    }

    public String getCandyCategoryName() {
        return candyCategoryName;
    }

    public void setCandyCategoryName(String candyCategoryName) {
        this.candyCategoryName = candyCategoryName;
    }
}

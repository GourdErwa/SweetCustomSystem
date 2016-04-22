package com.gourderwa.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    @Column
    private int id;

    @Column(length = 32, unique = true, nullable = false)
    private String candyCategoryName;

    public CandyCategory() {
    }

    public CandyCategory(String candyCategoryName) {
        this.candyCategoryName = candyCategoryName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCandyCategoryName() {
        return candyCategoryName;
    }

    public void setCandyCategoryName(String candyCategoryName) {
        this.candyCategoryName = candyCategoryName;
    }
}

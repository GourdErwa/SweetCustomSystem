package com.gourderwa.model;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

/**
 * @author HuKaiMo on 2016/4/21.
 */
@Entity
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "candyCategory")
public class CandyCategory {

    @Id
    @Column
    private int id;

    @Column(length = 32)
    private int candyCategoryName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCandyCategoryName() {
        return candyCategoryName;
    }

    public void setCandyCategoryName(int candyCategoryName) {
        this.candyCategoryName = candyCategoryName;
    }
}


package com.moringaschool.e_store.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Rating {

    @SerializedName("rate")
    @Expose
    private Double rate;
    @SerializedName("count")
    @Expose
    private Integer count;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Rating() {
    }

    /**
     * 
     * @param rate
     * @param count
     */
    public Rating(Double rate, Integer count) {
        super();
        this.rate = rate;
        this.count = count;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}

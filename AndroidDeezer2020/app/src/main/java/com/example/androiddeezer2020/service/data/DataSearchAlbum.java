package com.example.androiddeezer2020.service.data;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataSearchAlbum {

    @SerializedName("data")
    @Expose
    private List<Album> data = null;
    @SerializedName("total")
    @Expose
    private Integer total;
    /*@SerializedName("next")
    @Expose
    private String next;*/

    public List<Album> getData() {
        return data;
    }

    public void setData(List<Album> data) {
        this.data = data;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    /*public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }*/

}
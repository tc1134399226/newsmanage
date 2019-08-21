package com.qf.sysuser.dto;

import lombok.Data;

import java.util.ArrayList;


@Data
public class UserIdsDTO {
    private ArrayList<Integer> userids;

    public ArrayList<Integer> getUserids() {
        return userids;
    }

    public void setUserids(ArrayList<Integer> userids) {
        this.userids = userids;
    }
}

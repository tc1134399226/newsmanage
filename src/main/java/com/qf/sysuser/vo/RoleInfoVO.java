package com.qf.sysuser.vo;

import lombok.Data;

@Data
public class RoleInfoVO {
    int roleid;
    String rolename;
    String shortname;
    boolean selected;
}

package com.mmc.bean;

import lombok.Data;

import javax.persistence.Id;

/**
 * @description: 作品信息
 * @author: mmc
 * @create: 2020-01-15 16:44
 **/
@Data
public class Work {

    @Id
    private Integer id;

    private String theme;

    private String workno;
    private Integer workSize;
    private String layout;
    private Integer sortNum;

}

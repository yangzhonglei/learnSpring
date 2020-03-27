package com.yzl.study.spingboot.model;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author evanYang
 * @version 1.0
 * @date 08/27/2019 14:50
 */
@Data
@Table(name="user")
public class UserModel  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "JDBC")
    private Integer id;
    @Column
    private String userName;
    @Column
    private String userPhone;

}
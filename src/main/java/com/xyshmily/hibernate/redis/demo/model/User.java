package com.xyshmily.hibernate.redis.demo.model;

import lombok.Data;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by xyshmily on 2017/11/30.
 */
@Data
@Entity
@Table(name = "t_user")
@org.hibernate.annotations.Cache(region = "common", usage = CacheConcurrencyStrategy.READ_WRITE)
public class User implements Serializable {

    private static final long serialVersionUID = -281066218676472922L;

    @Id
    @GeneratedValue(generator = "systemUUID")
    @GenericGenerator(name = "systemUUID", strategy = "uuid2")
    private String id;

    private String name;

    private String address;
}

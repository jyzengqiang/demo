package com.example.demo.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Administrator on 2017/11/29.
 */
@Entity
@Table(name = "t_user")
public class User  implements Serializable{
    @Id
    String id;
    String name;
    String username;
    String zoneId;
    Date times;
    String types;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public Date getTimes() {
        return times;
    }

    public void setTimes(Date times) {
        this.times = times;
    }
}

package com.cm.userApp.userRestApi;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String uid;
    private String name;

    private String phone;


}

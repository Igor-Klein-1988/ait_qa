package com.ait.demowebshop.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {
    private String email;
    private String password;
    private String gender;
    private String firstName;
    private String lastName;
}

package com.frog.frogbanchan.controller.users;

import com.frog.frogbanchan.domain.Users;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter @Setter @ToString
@SuppressWarnings("serial")
public class UserForm implements Serializable {

    private Users user;

//    @NotEmpty
    private String confirmPassword;
    private String residentNo1;
    private String residentNo2;

    public UserForm() {
    }
    public UserForm(Users user) {
        this.user = user;
    }

//    @AssertTrue
    public boolean isSamePasswordConfirmPassword() {
        if (user.getPassword() == null || confirmPassword == null)
            return false;
        return user.getPassword().equals(confirmPassword);
    }

    public boolean hasPassword() {
        return user.getPassword() != null && user.getPassword().trim().length() > 0;
    }

}

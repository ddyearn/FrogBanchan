package com.frog.frogbanchan.controller.party;

import com.frog.frogbanchan.domain.Apply;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter @Setter @ToString
@SuppressWarnings("serial")
public class ApplyForm implements Serializable {

    private Apply apply;

    public ApplyForm() {}
    public ApplyForm(Apply apply) {
        this.apply = apply;
    }

}
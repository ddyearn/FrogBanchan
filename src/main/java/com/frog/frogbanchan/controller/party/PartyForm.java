package com.frog.frogbanchan.controller.party;

import com.frog.frogbanchan.domain.Party;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter @Setter @ToString
@SuppressWarnings("serial")
public class PartyForm implements Serializable {

    private Party party;

    public PartyForm() {}
    public PartyForm(Party party) {
        this.party = party;
    }

}
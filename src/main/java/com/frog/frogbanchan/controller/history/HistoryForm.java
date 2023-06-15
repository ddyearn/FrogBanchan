package com.frog.frogbanchan.controller.history;

import com.frog.frogbanchan.domain.History;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter @Setter @ToString
@SuppressWarnings("serial")
public class HistoryForm implements Serializable {

    private History history;

    public HistoryForm() {}
    public HistoryForm(History history) {
        this.history = history;
    }

}

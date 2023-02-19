package org.olegmell.domain;

import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
public class Request {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String text;
    private String tag;

    public Request() {
    }

    public Request(String text, String tag) {
        this.text = text;
        this.tag = tag;
    }
}

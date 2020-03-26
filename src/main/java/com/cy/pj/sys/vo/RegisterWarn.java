package com.cy.pj.sys.vo;

import java.io.Serializable;

public class RegisterWarn implements Serializable {
    private static final long serialVersionUID = 5180275670725633298L;
    private String message;

    public RegisterWarn() {
    }

    public RegisterWarn(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "RegisterWarn{" +
                "message='" + message + '\'' +
                '}';
    }
}

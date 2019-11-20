package com.dmspallas.webservices.restfulwebservices.hello;

public class HelloWorldBean {

    public String message;

    public HelloWorldBean(String message) {
        this.message = message;

    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String toString() {
        return String.format("hello world bean[message=%s]" + message);
    }
}

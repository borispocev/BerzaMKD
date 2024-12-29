package com.example.demo.exceptions;

public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException() {
        super("User not found");
    }
}

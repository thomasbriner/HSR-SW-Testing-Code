package ch.hsr.testing.unittest.address.dependencyexample.impl;

import ch.hsr.testing.unittest.address.dependencyexample.api.AuthenticationInformation;

public class AuthenticationInformationImpl implements AuthenticationInformation {

    private String user;
    private String password;

    public AuthenticationInformationImpl(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public String getUser() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }
}

package com.tom.tcc.backend.security.service;

import java.util.concurrent.atomic.AtomicBoolean;

import org.springframework.stereotype.Service;

@Service
public class FeatureFlagService {

    private final AtomicBoolean isSignInEnabled = new AtomicBoolean(true);
    private final AtomicBoolean isSignUpEnabled = new AtomicBoolean(true);

    public void setSignInEnabled(boolean isEnabled) {
        this.isSignInEnabled.set(isEnabled);
    }

    public boolean isSignInEnabled() {
        return this.isSignInEnabled.get();
    }
    
    public void setSignUpEnabled(boolean isEnabled) {
        this.isSignUpEnabled.set(isEnabled);
    }

    public boolean isSignUpEnabled() {
        return this.isSignUpEnabled.get();
    }
}
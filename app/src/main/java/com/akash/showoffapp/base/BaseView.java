package com.akash.showoffapp.base;

public interface BaseView {
    void showToast(String message);
    void showLoader(String title, String message);
    void hideLoader();
}

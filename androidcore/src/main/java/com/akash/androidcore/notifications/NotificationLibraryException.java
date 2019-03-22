package com.akash.androidcore.notifications;

public class NotificationLibraryException extends RuntimeException {

    public NotificationLibraryException() {
        this("Error creating notification channel");
    }


    public NotificationLibraryException(String message) {
        super(message);
    }


    public NotificationLibraryException(String message, Throwable cause) {
        super(message, cause);
    }


}

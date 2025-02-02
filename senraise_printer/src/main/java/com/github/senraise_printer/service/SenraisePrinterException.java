package com.github.senraise_printer.service;

import android.os.RemoteException;

public class SenraisePrinterException extends RemoteException {
    public SenraisePrinterException(String message) {
        super(message);
    }
}
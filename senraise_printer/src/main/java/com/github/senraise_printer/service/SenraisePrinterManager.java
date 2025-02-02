package com.github.senraise_printer.service;

import android.content.Context;
import android.content.Intent;

public class SenraisePrinterManager {
    private SenraisePrinterManager() {
    }

    public static SenraisePrinterManager getInstance() {
        return SingletonContainer.instance;
    }

    public boolean bindService(Context mContext, SenraiseCallback callback) throws SenraisePrinterException {
        if (mContext != null && callback != null) {
            Intent intent = new Intent();
            intent.setClassName(
                    "recieptservice.com.recieptservice",
                    "recieptservice.com.recieptservice.service.PrinterService"
            );
            return mContext.getApplicationContext().bindService(intent, callback, 1);
        } else {
            throw new SenraisePrinterException("parameter must be not null!");
        }
    }

    public void unBindService(Context mContext, SenraiseCallback callback) throws SenraisePrinterException {
        if (mContext != null && callback != null) {
            mContext.getApplicationContext().unbindService(callback);
        } else {
            throw new SenraisePrinterException("parameter must be not null!");
        }
    }


    private static class SingletonContainer {
        private static final SenraisePrinterManager instance = new SenraisePrinterManager();

        private SingletonContainer() {
        }
    }
}

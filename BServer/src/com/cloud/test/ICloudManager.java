package com.cloud.test;

import android.os.IInterface;
import android.os.RemoteException;

public interface ICloudManager extends IInterface {
	static final java.lang.String DESCRIPTOR = "com.cloud.test.BServer";
	public void print(String str) throws RemoteException ;
	public int add(int a, int b) throws RemoteException ;
    static final int TRANSACTION_print = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    static final int TRANSACTION_add = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
}

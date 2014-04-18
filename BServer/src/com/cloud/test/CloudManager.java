/*
 **
 ** Copyright 2007, The Android Open Source Project
 **
 ** Licensed under the Apache License, Version 2.0 (the "License");
 ** you may not use this file except in compliance with the License.
 ** You may obtain a copy of the License at
 **
 **     http://www.apache.org/licenses/LICENSE-2.0
 **
 ** Unless required by applicable law or agreed to in writing, software
 ** distributed under the License is distributed on an "AS IS" BASIS,
 ** WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 ** See the License for the specific language governing permissions and
 ** limitations under the License.
 */

package com.cloud.test;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public class CloudManager extends Binder implements ICloudManager { 
	

	public CloudManager() {
		this.attachInterface(this, DESCRIPTOR);
	}

	@Override
	public IBinder asBinder() {
		return this;
	}

	public static com.cloud.test.ICloudManager asInterface(
			android.os.IBinder obj) {
		if ((obj == null)) {
			return null;
		}
		android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
		if (((iin != null) && (iin instanceof com.cloud.test.ICloudManager))) {
			return ((com.cloud.test.ICloudManager) iin);
		}
		return null;
	}

	@Override
	protected boolean onTransact(int code, Parcel data, Parcel reply, int flags)
			throws RemoteException {
		switch (code) {
		case INTERFACE_TRANSACTION: {
			reply.writeString(DESCRIPTOR);
			return true;
		}
		case TRANSACTION_print: {
			data.enforceInterface(DESCRIPTOR);
			String str = data.readString();
			print(str);
			reply.writeNoException();
			return true;
		}
		case TRANSACTION_add: {
			data.enforceInterface(DESCRIPTOR);
			int a = data.readInt();
			int b = data.readInt();
			int c = add(a, b);
			reply.writeNoException();
			reply.writeInt(c);
			return true;
		}
		}
		return super.onTransact(code, data, reply, flags);
	}

	@Override
	public void print(String str) {
		System.out.println(str);
	}

	@Override
	public int add(int a, int b) {
		return a + b;
	}

}

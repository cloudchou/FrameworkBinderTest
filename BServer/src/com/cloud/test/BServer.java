package com.cloud.test;

import android.os.Looper;
import android.os.ServiceManager;

public class BServer {

	public static void main(String[] args) {
		System.out.println("Cloud Manager Service Starts");
		Looper.prepareMainLooper();
		android.os.Process
				.setThreadPriority(android.os.Process.THREAD_PRIORITY_FOREGROUND);
		ServiceManager.addService("CloudService", new CloudManager());
		Looper.loop();
	}

}

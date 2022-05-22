package com.axonactive.remote_proxy;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyRemoteClient {
    public MyRemoteClient() {
    }

    public void connect() {
        try {
            // Locate the registry
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

            // get the rerefence of exported object from RMI registry
            MyRemote fromServer = (MyRemote) registry.lookup("sayHello");

            System.out.println(fromServer.sayHello());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MyRemoteClient().connect();
    }
}

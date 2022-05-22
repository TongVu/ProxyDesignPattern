package com.axonactive.remote_proxy;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote{
    public MyRemoteImpl() throws RemoteException {
    }

    @Override
    public String sayHello() throws RemoteException {
        return "sayHello from MyRemoteImplementation";
    }

    public static void main(String[] args) throws RemoteException {
        try{
            // set hostname for the server using javaProperty
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            MyRemote service = new MyRemoteImpl();
            MyRemote stub1 = (MyRemote) UnicastRemoteObject.exportObject(service, 0);

            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);
            registry.rebind("sayHello", stub1);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}

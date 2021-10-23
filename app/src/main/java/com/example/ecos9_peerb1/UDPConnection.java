package com.example.ecos9_peerb1;

import android.util.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPConnection extends Thread{

    private DatagramSocket socket;
    IObserver observer;

    @Override
    public void run() {
        try {
            //1. Escucha
            socket = new DatagramSocket(9000);
            //recibe el msg del puerto
            reciveMsg();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void reciveMsg(){
        while (true) {
            //2. Esperar mensajes: Datagramas
            byte[] buffer = new byte[100];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            Log.e(">>","Esperando datagrama");

            //3. Esperando datagrama
            try {
                socket.receive(packet);
                String msg = new String(packet.getData()).trim();
                //envia msg a la actividad
                observer.notifyMsg(msg);
                Log.e(">>>","Datagrama recibido:" + msg);

            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void sendMsg(String msg) {

        new Thread(
                () -> {

                    try {
                        //4. datagrama de envio
                        InetAddress ip = InetAddress.getByName("10.0.2.2");
                        DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.getBytes().length, ip, 5000);
                        socket.send(packet);


                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
        ).start();
    }

    public IObserver getObserver() {
        return observer;
    }

    public void setObserver(IObserver observer) {
        this.observer = observer;

    }

}

package org.xkg.hellojava.datagram;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author : Xiangkui Guo
 * @date : 2018/12/29
 */
public class DReceiver {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(3000);
        byte[] buf = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buf, 1024);
        while (true){

            ds.receive(dp);
            String str = new String(dp.getData(), 0, dp.getLength());
            System.out.println(str);
            if (str.equals("stop"))
                break;
        }

        ds.close();
    }
}

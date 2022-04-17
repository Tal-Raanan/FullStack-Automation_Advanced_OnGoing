package extensions;

import io.qameta.allure.Step;
import utilities.CommonOps;
import java.io.*;
import java.net.*;

public class ClientServerActions extends CommonOps {

    @Step("Open Socket")
    public static Socket openSocket(String ip, String port) throws IOException {
        socket = new Socket(ip, Integer.parseInt(port));
        System.out.println("Configured IP is: " + ip);
        System.out.println("Configured Port number is: " + port);
        logger.info("Configured IP is: " + ip);
        logger.info("Configured Port number is: " + port);

//server response
//        ServerSocket ss = new ServerSocket(port);
//        s = ss.accept();
//
//        System.out.println("Connection Established");
//        logger.info("Connection Established Successfully");
        return socket;
    }

    @Step("Sending Data Form Client To Server")
    public static void clientOutputMessage (String ip, String port, String msg) throws IOException {

        PrintWriter pr = new PrintWriter(socket.getOutputStream());
        pr.println(msg);
        pr.flush();
        logger.info("Sending message to Server: "+msg);

//Server side for receiving messages
//        InputStreamReader in = new InputStreamReader(s.getInputStream());
//        BufferedReader bf = new BufferedReader(in);
//        String str = bf.readLine();
//        System.out.println("Client: "+ str);
    }

    @Step("Receiving Data Form Client To Server")
    public static void clientInputMessage (String ip, String port, String msg) throws IOException {

        InputStreamReader in = new InputStreamReader(socket.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        String str = bf.readLine();
        System.out.println("Server: "+ str);
        logger.info("Received message from Server: "+str);

//Server side: Sending a message
//        PrintWriter pr = new PrintWriter(s.getOutputStream());
//        pr.println("yes");
//        pr.flush();
    }

    @Step("Close Socket")
    public static void closeSocket(){
        try {
        socket.close();
            System.out.println("Socket is Now Closed");
            logger.info("Socket is Now Closed");
        }
        catch (Exception e) {
            System.out.println("An Error Occurred While Closing The DB, See Details" + e);
            logger.error("An Error Occurred While Closing The DB, See Details" + e);
        }
    }
}
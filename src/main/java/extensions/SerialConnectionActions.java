package extensions;

import com.fazecast.jSerialComm.SerialPort;
import io.qameta.allure.Step;
import utilities.CommonOps;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SerialConnectionActions extends CommonOps {

        @Step("Set Serial Connection")
        public static void setSerialConnection(String COMPort, String BaudRate, String DataBits, String StopBits, String Parity, String ReadTimeout, String WriteTimeout) throws IOException {
            serialPort = SerialPort.getCommPort(COMPort);
            serialPort.setComPortParameters(Integer.parseInt(BaudRate), Integer.parseInt(DataBits), Integer.parseInt (StopBits), Integer.parseInt (Parity));
            serialPort.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, Integer.parseInt(ReadTimeout), Integer.parseInt(WriteTimeout));
            //The TIMEOUT_WRITE_BLOCKING mode specifies that a corresponding write call will block until all data bytes have been successfully written to the output serial device.
        }

        @Step("Open Serial Port")
        public static void openSerialPort (String COMPort){
            try {
                serialPort.openPort(); //Should return "True"
                InputStream comPortInput = serialPort.getInputStream();
                OutputStream comPortOutput = serialPort.getOutputStream();
                comPortInput.skip(comPortInput.available()); // to flush away any data leftover in th buffer
                System.out.println("Port " +COMPort + " " + "is Now Open");
                logger.info("Port " +COMPort + " " + "is Now Open");
            }
            catch (Exception e){
                System.out.println("Failed to Open Communication Port "+COMPort);
                logger.info(("Failed to Open Communication Port "+COMPort));
                            }
        }

//        @Step("Sending Data") //Should be written
//        public static void sendingData(String msg) throws Exception{
//                serialPort.getOutputStream();
//                serialPort.getOutputStream().flush();
//                System.out.println("Sent Message: " + msg);

//    }

        @Step("Close Serial Port")
        public static void closeSerialPort (String COMPort){
            try {
                serialPort.closePort(); //Should return "True"
                System.out.println("Port " +COMPort + " " + "is Now Close");
                logger.info("Port " +COMPort + " " + "is Now Close");
            }
            catch (Exception e){
                System.out.println("Failed to Close Communication Port "+COMPort);
                logger.info(("Failed to Close Communication Port "+COMPort));
            }
        }
}
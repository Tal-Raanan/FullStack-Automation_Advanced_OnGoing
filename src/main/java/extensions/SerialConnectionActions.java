package extensions;

import com.fazecast.jSerialComm.SerialPort;
import io.qameta.allure.Step;
import utilities.CommonOps;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Timer;

public class SerialConnectionActions extends CommonOps {

        @Step("Set Serial Connection")
        public static void setSerialConnection(String COMPort, String BaudRate, String DataBits, String StopBits, String Parity, String ReadTimeout, String WriteTimeout) throws IOException {
            serialPort = SerialPort.getCommPort(COMPort);
            serialPort.setComPortParameters(Integer.parseInt(BaudRate), Integer.parseInt(DataBits), Integer.parseInt (StopBits), Integer.parseInt (Parity));
            serialPort.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, Integer.parseInt(ReadTimeout), Integer.parseInt(WriteTimeout));
            //The TIMEOUT_WRITE_BLOCKING mode specifies that a corresponding write call will block until all data bytes have been successfully written to the output serial device.
            System.out.println("Serial Connection Was Set To: " + "COMPort= "+COMPort+"; " + "BaudRate = "+BaudRate+"; ");
            logger.info("Serial Connection Was Set To: " + "COMPort= "+COMPort+"; " + "BaudRate = "+BaudRate+"; ");
        }

        @Step("Open Serial Port")
        public static void openSerialPort (String COMPort) throws IOException {
            if (serialPort.openPort()){     //Should return "True"
                InputStream comPortInput = serialPort.getInputStream();
                OutputStream comPortOutput = serialPort.getOutputStream();
                comPortInput.skip(comPortInput.available()); // to flush away any data leftover in th buffer
                System.out.println("Port " +COMPort + " " + "is Now Open");
                logger.info("Port " +COMPort + " " + "is Now Open");

            } else {
                System.out.println("Failed to Open Communication Port "+COMPort);
                logger.info("Failed to Open Communication Port "+COMPort);
            }
        }

        @Step("Send Data Bytes")
        public static void sendDataBytes(int x) throws Exception {
            for (Integer i = 0; i < x; ++i) {
                serialPort.getOutputStream().write(i.byteValue());
                serialPort.getOutputStream().flush();
                System.out.println("Sent Number: " + i);
                Thread.sleep(1000);
            }
        }

        @Step("Receive Data")
        public static void receiveData(String ReadTimeout, String WriteTimeout) {
            long timeStart = System.currentTimeMillis();

            serialPort.setComPortParameters(9600, Byte.SIZE, SerialPort.ONE_STOP_BIT, SerialPort.NO_PARITY);
            serialPort.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, Integer.parseInt(ReadTimeout), Integer.parseInt(WriteTimeout)); // 0, 0

            Timer timer = new Timer();
            TimerScheduleHandler timeSchedule = new TimerScheduleHandler(timeStart);

            serialPort.addDataListener(timeSchedule);

            System.out.println("Listen " + timeSchedule.getListeningEvents());
            timer.schedule(timeSchedule, 0, 1000);
        }

        @Step("Close Serial Port")
        public static void closeSerialPort (String COMPort){
            if (serialPort.closePort()) { // //Should return "True")
                System.out.println("Port " +COMPort + " " + "is Now Close");
                logger.info("Port " +COMPort + " " + "is Now Closed");
            } else {
                System.out.println("Failed to Close Communication Port "+COMPort);
                logger.info("Failed to Close Communication Port "+COMPort);
            }
        }
}
package extensions;

import utilities.CommonOps;
import java.util.TimerTask;
import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

public class TimerScheduleHandler extends TimerTask implements SerialPortDataListener {

    private final long timeStart;
    // constructor
    public TimerScheduleHandler(long timeStart) {
        this.timeStart = timeStart;
    }

    // Override run method in TimerTask
    @Override
    public void run(){
        System.out.println("Time elapsed: " + (System.currentTimeMillis() - this.timeStart) + "milliseconds");
    }

    // Listening for events
    @Override
    public int getListeningEvents() {
        return SerialPort.LISTENING_EVENT_DATA_RECEIVED;
    }

    // Printing event's data
    @Override
    public void serialEvent(SerialPortEvent serialPortEvent) {
        if (serialPortEvent.getEventType() == SerialPort.LISTENING_EVENT_DATA_RECEIVED){
            System.out.println("YES! Data Received!!!");
        }
    }

}

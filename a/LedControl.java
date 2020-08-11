package com.company;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;


public class LedControl {
    final GpioController gpio = GpioFactory.getInstance();
    GpioPinDigitalOutput myLed = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_16);

    public void turnOn(){

            myLed.high();

    }
    public  void turnOff(){
        myLed.low();
    }
}

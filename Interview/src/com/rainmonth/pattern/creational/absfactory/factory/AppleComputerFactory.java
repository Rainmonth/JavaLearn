package com.rainmonth.pattern.creational.absfactory.factory;

import com.rainmonth.pattern.creational.absfactory.component.cpu.A14Cpu;
import com.rainmonth.pattern.creational.absfactory.component.cpu.Cpu;
import com.rainmonth.pattern.creational.absfactory.component.mainboard.GigaByteMainBoard;
import com.rainmonth.pattern.creational.absfactory.component.mainboard.MainBoard;
import com.rainmonth.pattern.creational.absfactory.component.monitor.Monitor;
import com.rainmonth.pattern.creational.absfactory.component.monitor.RetinaMonitor;

public class AppleComputerFactory extends ComputerFactory {

    @Override
    public Cpu createCpu() {
        return new A14Cpu();
    }

    @Override
    public MainBoard createMainBoard() {
        return new GigaByteMainBoard();
    }

    @Override
    public Monitor createMonitor() {
        return new RetinaMonitor();
    }
}

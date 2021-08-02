package com.rainmonth.pattern.creational.absfactory.factory;

import com.rainmonth.pattern.creational.absfactory.component.cpu.Cpu;
import com.rainmonth.pattern.creational.absfactory.component.cpu.HuaweiCpu;
import com.rainmonth.pattern.creational.absfactory.component.mainboard.AsusMainBoard;
import com.rainmonth.pattern.creational.absfactory.component.mainboard.MainBoard;
import com.rainmonth.pattern.creational.absfactory.component.monitor.Monitor;
import com.rainmonth.pattern.creational.absfactory.component.monitor.PhilipsMonitor;

public class HuaweiComputerFactory extends ComputerFactory {

    @Override
    public Cpu createCpu() {
        return new HuaweiCpu();
    }

    @Override
    public MainBoard createMainBoard() {
        return new AsusMainBoard();
    }

    @Override
    public Monitor createMonitor() {
        return new PhilipsMonitor();
    }
}

package com.rainmonth.pattern.creational.absfactory.factory;

import com.rainmonth.pattern.creational.absfactory.component.cpu.Cpu;
import com.rainmonth.pattern.creational.absfactory.component.mainboard.MainBoard;
import com.rainmonth.pattern.creational.absfactory.component.monitor.Monitor;

/**
 * @author randy
 * @date 2021/7/12 5:29 下午
 */
public abstract class ComputerFactory {
    public abstract Cpu createCpu();

    public abstract MainBoard createMainBoard();

    public abstract Monitor createMonitor();

    public void computerInfo() {
        System.out.println("生产的电脑型号描述：CPU->" + createCpu().cpuName() +
                ", 主板->" + createMainBoard().mainBoardName() + ", 显示器->" + createMonitor().monitorName());
    }
}


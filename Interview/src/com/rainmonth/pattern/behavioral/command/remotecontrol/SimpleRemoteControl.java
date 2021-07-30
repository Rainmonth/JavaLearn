package com.rainmonth.pattern.behavioral.command.remotecontrol;

import com.rainmonth.pattern.behavioral.command.command.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * 控制终端
 */
public class SimpleRemoteControl {
    private final List<Command> commands;

    public SimpleRemoteControl() {
        commands = new ArrayList<Command>();
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void buttonWasPressed(int index) {
        commands.get(index).attack();
    }

    public int getCommandsSize() {
        return commands.size();
    }

    @Override
    public String toString() {

        StringBuffer stringBuff = new StringBuffer();
        stringBuff.append("\n------------Remote Control------------\n");

        for (int i = 0; i < commands.size(); i++) {
            stringBuff.append("[slot " + i + "]  " + commands.get(i).getClass().getName() + "\n");
        }
        return stringBuff.toString();
    }
}

package com.rainmonth.pattern.behavioral.command.command;

import com.rainmonth.pattern.behavioral.command.army.SonGoku;

public class SonGokuCommand implements Command{
    private SonGoku sonGoku;

    public SonGokuCommand(SonGoku sonGoku) {
        this.sonGoku = sonGoku;
    }

    @Override
    public void attack() {
        sonGoku.superSaiyan();
        sonGoku.kamehameha();
    }
}

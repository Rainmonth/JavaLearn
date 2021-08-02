package com.rainmonth.pattern.behavioral.command.command;

import com.rainmonth.pattern.behavioral.command.army.Knight;

/**
 * 骑士对应的命令
 */
public class KnightCommand implements Command{
	
    private final Knight knight;

    public KnightCommand(Knight knight) {
        this.knight = knight;
    }

    @Override
    public void attack() {
        knight.rideHorseAndAttack();
    }

}

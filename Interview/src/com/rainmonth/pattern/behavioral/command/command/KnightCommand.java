package com.rainmonth.pattern.behavioral.command.command;

import com.rainmonth.pattern.behavioral.command.army.Knight;

public class KnightCommand implements Command{
	
    private Knight knight;

    public KnightCommand(Knight knight) {
        this.knight = knight;
    }

    @Override
    public void attack() {
        knight.rideHorseAndAttack();
    }

}

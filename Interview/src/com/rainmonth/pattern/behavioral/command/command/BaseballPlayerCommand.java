package com.rainmonth.pattern.behavioral.command.command;

import com.rainmonth.pattern.behavioral.command.army.BaseballPlayer;

public class BaseballPlayerCommand implements Command{
    
    private BaseballPlayer baseballPlayer;
    
	public BaseballPlayerCommand(BaseballPlayer baseballPlayer){
	    this.baseballPlayer = baseballPlayer;
	}

    @Override
    public void attack() {
        baseballPlayer.swingBat();
    }
}

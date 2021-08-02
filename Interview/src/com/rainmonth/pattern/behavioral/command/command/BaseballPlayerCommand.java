package com.rainmonth.pattern.behavioral.command.command;

import com.rainmonth.pattern.behavioral.command.army.BaseballPlayer;

/**
 * 棒球运动员对应的命令
 */
public class BaseballPlayerCommand implements Command{
    
    private final BaseballPlayer baseballPlayer;
    
	public BaseballPlayerCommand(BaseballPlayer baseballPlayer){
	    this.baseballPlayer = baseballPlayer;
	}

    @Override
    public void attack() {
        baseballPlayer.swingBat();
    }
}

package com.javastudy.game.drawcard.model;

import com.yizhuoyan.util.ConsoleUtil;
import com.yizhuoyan.util.RandomUtil;

/**
 * 电脑玩家
 * @author Administrator
 *
 */
public class AIPlayer extends Player{
	
	public AIPlayer() {
		this.name="小爱";
	}
		
		
	
	/**
	 * 抽牌的行为
	 * 
	 * @param cards
	 */
	public void drawCard(Porker porker) {
		int index=RandomUtil.randomMinMax(0, porker.leftCardCount());
		this.handCard=porker.drawCard(index);
	//	this.handCard=card;
		
	}
		
}

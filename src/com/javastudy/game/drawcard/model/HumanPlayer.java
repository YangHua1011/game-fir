package com.javastudy.game.drawcard.model;

import com.yizhuoyan.util.ConsoleUtil;

public class HumanPlayer  extends Player{
	
	
	public HumanPlayer() {
	}
	/**
	  * 设置用户名
	 */
	public void setName() {
		String name;
		while(true) {
			name=ConsoleUtil.readString("请输入您的姓名>");
			if(name.length()==0) {
				System.out.println("你没有输入名字，请重新输入");
				continue;
			}
			break;
		}
		
		this.name=name;
	}
	

	/**
	  * 抽牌的行为
	 * 
	 * @param cards
	 */
	public void drawCard(Porker porker) {
		int index;
		while(true) {
			index=ConsoleUtil.readPositiveInt("请输入您要抽取的牌(1-52):1>");
			if(index>52) {
				System.out.println("输入错误，请输入1-52");
				continue;
			}
			break;
		}
		this.handCard = porker.drawCard(index-1);
		
		
	}
	
	public boolean isContinuePlay() {
		return ConsoleUtil.readBoolean("是否继续游戏?默认y是，其他否:y>", true);
	}
}

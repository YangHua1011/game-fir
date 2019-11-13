package com.javastudy.game.drawcard.model;

public abstract class Player {
	// 名字
	String name;
	// 当前手牌
	Card handCard;

	/**
	 * 展示手牌
	 * 
	 * @return
	 */
	public void showHandCard() {
		Card card=this.handCard;
		System.out.println(this.name+"的牌是:"+card.format());
	}
	
	public static void name() {
		System.out.println("");
	}
}

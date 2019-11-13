package com.javastudy.game.drawcard.model;

import java.util.Arrays;

/**
  * 游戏控制类
 * 
 * @author Administrator
 *
 */
public class Game {
	Porker porker;

	HumanPlayer humanPlayer;
	HumanPlayer humanPlayer2;

	AIPlayer aiPlayer;

	public Game() {
		// 创建参与游戏的对象
		this.porker = new Porker();
		this.humanPlayer = new HumanPlayer();
		this.aiPlayer = new AIPlayer();
		this.humanPlayer2 = new HumanPlayer();
	}

	/**
	 * 游戏开始
	 */
	public void start() {
		// 1 游戏说明
		welcome();
		//设置玩家姓名
		this.humanPlayer.setName();
		this.humanPlayer2.setName();
		System.out.println("正在创建扑克牌...");
		while (true) {
			// 3洗牌
			System.out.println("正在洗牌...");
			porker.shuffle();
			// 4抽牌
			
//			System.out.println(Arrays.toString(porker.cards));
			System.out.println("牌已经洗好，开始抽牌");
			humanPlayer.drawCard(porker);
			
			System.out.println("第二位玩家，开始抽牌");
			humanPlayer2.drawCard(porker);
			
			aiPlayer.drawCard(porker);
			System.out.println("电脑已经抽好了牌");
			// 5展示牌
			humanPlayer.showHandCard();
			humanPlayer2.showHandCard();
			aiPlayer.showHandCard();
			// 6比大小
			Card winResult = this.whoWin(this.humanPlayer.handCard,this.humanPlayer2.handCard);
			winResult = this.whoWin(winResult, aiPlayer.handCard);
			// 7显示结果
			if (winResult ==  aiPlayer.handCard) {
				System.out.println(this.aiPlayer.name + "赢了");
			} else if(winResult == this.humanPlayer.handCard){
				
				System.out.println(this.humanPlayer.name + "赢了");
			}else {
				System.out.println(this.humanPlayer2.name + "赢了");
			}

			// 8是否继续
			if (!this.humanPlayer.isContinuePlay()) {
				break;
			}
		}
		System.out.println("再见!");

	}

	private void welcome() {
		System.out.println("欢迎游戏");
		System.out.println("----------------");
	}

	private Card whoWin(Card one,Card other) {
		Card c1=this.humanPlayer.handCard;
		Card c2=this.aiPlayer.handCard;
		
		if (c1.compare(c2) > 0) {
			
			return c1;
		}else if (c1.compare(c2) < 0) {
			
			return c2;
		}
		return c1;
	}

}

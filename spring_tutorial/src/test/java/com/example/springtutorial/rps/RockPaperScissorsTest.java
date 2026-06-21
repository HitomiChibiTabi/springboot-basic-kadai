package com.example.springtutorial.rps;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RockPaperScissorsTest {
	// テスト対象クラスのオブジェクト
	private RockPaperScissors game;
	
	@BeforeEach
	void init() {
		// 初期化処理
		game = new RockPaperScissors();
	}
	
	@Test
	void testRockPaperScissors() {
		// 各テストケースを実施
		assertEquals("あいこ", game.judgeResult("グー", "グー"));
		assertEquals("勝ち", game.judgeResult("グー", "チョキ"));
		assertEquals("負け", game.judgeResult("グー", "パー"));
		assertEquals("無効試合", game.judgeResult("グー", "dummy"));
		assertEquals("負け", game.judgeResult("チョキ", "グー"));
		assertEquals("あいこ", game.judgeResult("チョキ", "チョキ"));
		assertEquals("勝ち", game.judgeResult("チョキ", "パー"));
		assertEquals("無効試合", game.judgeResult("チョキ", "dummy"));
		assertEquals("勝ち", game.judgeResult("パー", "グー"));
		assertEquals("負け", game.judgeResult("パー", "チョキ"));
		assertEquals("あいこ", game.judgeResult("パー", "パー"));
		assertEquals("無効試合", game.judgeResult("パー", "dummy"));
		assertEquals("無効試合", game.judgeResult("dummy", "dummy"));
	}

}

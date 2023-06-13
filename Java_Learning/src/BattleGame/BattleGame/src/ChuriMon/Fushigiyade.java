//--- パッケージ宣言 --------------------------
package ChuriMon;

//--- Hitokake 管理クラス --------------------------
public class Fushigiyade extends Monster3{
	Fushigiyade(){
		// super()が暗黙的に実行されている
		super.setCharacter("フシギヤデ");
	}
	
	Fushigiyade(String tr, String nm){
		super(tr, nm);
		super.setCharacter("フシギヤデ");
	}
	
	Fushigiyade(String tr, String nm, int startLv){
		super(tr, nm, startLv);
		super.setCharacter("フシギヤデ");
	}
	
	// --- メソッド --------------------------------
	// 引数(レベル)をもとに、superクラスのステータスを上昇させる
	public void levelUp(int up) {
		setLv(getLv() + 1 * up);
		setHp(getHp() + 31 * up);
		setAtk(getAtk() + 6 * up);
		setDef(getDef() +  7 * up);
		setSpd(getSpd() + 8 * up);
		setHpMax(getHp());
	}
}

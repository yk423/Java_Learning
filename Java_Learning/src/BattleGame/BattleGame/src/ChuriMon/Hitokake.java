//--- パッケージ宣言 --------------------------
package ChuriMon;

//--- Hitokake 管理クラス --------------------------
public class Hitokake extends Monster3{
	Hitokake(){
		// super()が暗黙的に実行されている
		super.setCharacter("ヒトカケ");
	}
	
	Hitokake(String tr, String nm){
		super(tr, nm);
		super.setCharacter("ヒトカケ");
	}
	
	Hitokake(String tr, String nm, int startLv){
		super(tr, nm, startLv);
		super.setCharacter("ヒトカケ");
	}
	
	// --- メソッド --------------------------------
	// 引数(レベル)をもとに、superクラスのステータスを上昇させる
	public void levelUp(int up) {
		setLv(getLv() + 1 * up);
		setHp(getHp() + 29 * up);
		setAtk(getAtk() + 8 * up);
		setDef(getDef() +  5 * up);
		setSpd(getSpd() + 9 * up);
		setHp(getHp());
	}
}

//--- パッケージ宣言 --------------------------
package ChuriMon;

import java.math.BigDecimal;
import java.math.RoundingMode;

//--- モンスター1 管理クラス --------------------------
public class Monster1{
	// --- フィールド --------------------------------
	String charactor = "(unknown)"; 	// 種族
	String trainer = "(wild)"; 			// トレーナー
	String name = "(noname)"; 			// 名前
	int lv = 1; 						// レベル
	int hp = 30; 						// hp
	int atk = 15; 						// こうげき
	int def = 10; 						// ぼうぎょ　
	int spd = 10; 						// すばやさ
	int hpMax = 30; 					// HP初期値
	String wazaNm = "たいあたり";			// わざ なまえ
	String wazaDmgRate = "1.0";			// わざ ダメージ倍率
	
	// --- toStringをオーバーライド Monster1のフィールドの値をすべて表示する----------
	public String toString(){
		String sepalater = " / ";
		String message = "charactor:" + this.charactor + sepalater +"trainer:" + this.trainer + sepalater + "name:" + this.name + sepalater + "¥n" 
				+ "lv:" + this.lv + sepalater + "hp:" + this.hp + sepalater + "atk:" + this.atk + sepalater + "def:" + this.def + sepalater + "spd:" + this.spd + sepalater + "¥n"
				+ "hpMax:" + this.hpMax + sepalater + "wazaNm:" + wazaNm + sepalater + "wazaDmgRate:" + wazaDmgRate;
		
		return message;
	}
	
	// --- モンスターのレベルをUpする -------------------------------------
	void levelUp(int upRate) {
		this.lv += upRate * 1;
		this.hpMax += upRate * 30;
		this.atk += upRate * 5;
		this.def += upRate * 5;
		this.spd += upRate * 5;
		this.hp += this.hpMax; // 更新後のhpMaxの値を代入する
	}
	
	// --- モンスターのわざに関する情報をセットする --------------------------
	void setWaza(String nm, String dmgRate) {
		// ダメージ倍率のバリデーションチェック
		String pattern = "^[0-9]+¥.[0-9]$";
		if (dmgRate.matches(pattern)) {
			this.wazaNm = nm;
			this.wazaDmgRate = dmgRate;
		} else {
			System.out.println("[ERROR]わざの設定に失敗しました");
		}
	}
	
	// --- ステータスを表示する ------------------------------------------
	String getStatus() {
		return this.name + "lv" + this.lv + "HP" + this.hp + "/" + this.hpMax;
	}
	
	// わざを使用して相手にダメージを与える ---------------------------------
	int useWaza() {
		BigDecimal wazaBigDecimal = new BigDecimal(wazaDmgRate);
		BigDecimal atkBigDecimal = new BigDecimal(atk);
		
		int dealingDamage = wazaBigDecimal.multiply(atkBigDecimal).setScale(0, RoundingMode.DOWN).intValue(); 
		
		return dealingDamage;
	}
	
	int damaged (int damagedPoint) {
		BigDecimal bdDamagedPoint = new BigDecimal(damagedPoint);
		BigDecimal bdDef = new BigDecimal(def); 
		BigDecimal bd1 = new BigDecimal("1");
		BigDecimal bd120 = new BigDecimal("120");
//		BigDecimal decimalPointTruncating = new BigDecimal("3"); // 小数点切り捨て桁指定
		
		BigDecimal damageSubtractRate = bd1.divide(bd1.add(bdDef.divide(bd120, 2, RoundingMode.DOWN)), 2, RoundingMode.DOWN); // ダメージ減算率計算
		
		int damage = (bdDamagedPoint.multiply(damageSubtractRate).setScale(0, RoundingMode.DOWN)).intValue(); // 実際に受けるダメージ
		
		if(this.hp > damage) {
			this.hp -= damage;
		} else {
			this.hp = 0;
		}
		
		return damage;
	}
}

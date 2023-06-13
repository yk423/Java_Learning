//--- パッケージ宣言 --------------------------
package ChuriMon;

import java.math.BigDecimal;
import java.math.RoundingMode;

//--- モンスター1 管理クラス --------------------------
public class Monster3 {
	// --- フィールド --------------------------------
	private String charactor; 	// 種族
	private String trainer ; 	// トレーナー
	private String name; 		// 名前
	private int lv; 			// レベル
	private int hp; 			// hp
	private int atk; 			// こうげき
	private int def;			// ぼうぎょ　
	private int spd; 			// すばやさ
	private int hpMax; 			// HP初期値
	private String wazaNm; 		// わざ なまえ
	private String wazaDmgRate; // わざ ダメージ倍率

	// --- コンストラクタ1 -----------------------------
	Monster3() {
		this.charactor = "(unknown)"; 	// 種族
		this.trainer= "(wild)"; 		// トレーナー
		this.name = "(noname)"; 		// 名前
		this.lv = 1; 					// レベル
		this.hp = 80; 					// hp
		this.atk = 15;					// こうげき
		this.def = 10; 					// ぼうぎょ　
		this.spd = 10; 					// すばやさ
		this.hpMax = 80; 				// HP初期値
		this.wazaNm = "たいあたり";		// わざ なまえ
		this.wazaDmgRate = "1.0";		// わざ ダメージ倍率
	}
	
	// --- コンストラクタ2 ------------------------------
	Monster3(String tr, String nm) {
		this();							// コンストラクタ1
		this.trainer= tr; 				// トレーナー
		this.name = nm;					// 名前
	}
		
	// --- コンストラクタ3 ------------------------------
	Monster3(String tr, String nm, int Lv) {
		this(tr, nm);					// コンストラクタ2		
		// レベルが1より大きい場合は、レベルUpメソッドでレベルに応じた値をセットする
		if(Lv > 1) {
			levelUp(Lv - 1);
		}
	}

	// --- toStringをオーバーライド Monster1のフィールドの値をすべて表示する----------
	public String toString() {
		String sepalater = " / ";
		String message = "charactor:" + this.charactor + sepalater + "trainer:" + this.trainer + sepalater + "name:" + this.name + sepalater + "¥n"
				+ "lv:" + this.lv + sepalater + "hp:" + this.hp + sepalater + "atk:" + this.atk + sepalater + "def:" + this.def + sepalater + "spd:" + "¥n"
				+ this.spd + sepalater + "hpMax:" + this.hpMax + sepalater + "wazaNm:" + wazaNm + sepalater + "wazaDmgRate:" + wazaDmgRate;

		return message;
	}

	// --- モンスターのレベルをUpする -------------------------------------
	public void levelUp(int upRate) {
		this.lv = lv + 1 * upRate;
		this.hpMax = hpMax + 30 * upRate;
		this.atk = atk + 5 * upRate;
		this.def = def +  5 * upRate;
		this.spd = spd +  5 * upRate;
		this.hp += this.hpMax; // 更新後のhpMaxの値を代入する
		
//		this.lv += upRate * 1;
//		this.hpMax += upRate * 30;
//		this.atk += upRate * 5;
//		this.def += upRate * 5;
//		this.spd += upRate * 5;
//		this.hp += this.hpMax; // 更新後のhpMaxの値を代入する
	}

	// --- モンスターのわざに関する情報をセットする --------------------------
	public void setWaza(String nm, String dmgRate) {
		// ダメージ倍率のバリデーションチェック
		String pattern = "^[0-9]+¥¥.[0-9]$";
		if (dmgRate.matches(pattern)) {
			this.wazaNm = nm;
			this.wazaDmgRate = dmgRate;
		} else {
			System.out.println("[ERROR]わざの設定に失敗しました");
		}
	}

	// --- ステータスを表示する ------------------------------------------
	public String getStatus() {
		return this.name + "lv" + this.lv + "HP" + this.hp + "/" + this.hpMax;
	}

	// わざを使用して相手にダメージを与える ---------------------------------
	public int useWaza() {
		BigDecimal wazaBigDecimal = new BigDecimal(wazaDmgRate);
		BigDecimal atkBigDecimal = new BigDecimal(atk);

		int dealingDamage = wazaBigDecimal.multiply(atkBigDecimal).setScale(0, RoundingMode.DOWN).intValue();

		return dealingDamage;
	}

	public int damaged(int damagedPoint) {
		BigDecimal bdDamagedPoint = new BigDecimal(damagedPoint);
		BigDecimal bdDef = new BigDecimal(def);
		BigDecimal bd1 = new BigDecimal("1");
		BigDecimal bd120 = new BigDecimal("120");

		BigDecimal damageSubtractRate = bd1.divide(bd1.add(bdDef.divide(bd120, 2, RoundingMode.DOWN)), 2,
				RoundingMode.DOWN); // ダメージ減算率計算

		int damage = (bdDamagedPoint.multiply(damageSubtractRate).setScale(0, RoundingMode.DOWN)).intValue(); // 実際に受けるダメージ

		if (this.hp > damage) {
			this.hp -= damage;
		} else {
			this.hp = 0;
		}

		return damage;
	}
	
	// --- getter --------------------------------------------------
	String getCharacter() {
		return this.charactor;
	}
	
	String getTrainer() {
		return this.trainer;
	}
	
	String getName() {
		return this.name;
	}
	
	int getLv() {
		return this.lv;
	}
	
	int getHp() {
		return this.hp;
	}
	
	int getAtk() {
		return this.atk;
	}
	
	int getDef() {
		return this.def;
	}
	
	int getSpd() {
		return this.spd;
	}
	
	int getHpMax() {
		return this.hpMax;
	}
	
	String getWazaNm() {
		return this.wazaNm;
	}
	
	String getWazaDmgRate() {
		return this.wazaDmgRate;
	}
	
	// --- setter --------------------------------------------------
	public void setCharacter(String setCh) {
		this.charactor = setCh;
	}
	
	public void setTrainer(String setTr) {
		this.trainer = setTr;
	}
	
	public void setName(String setNm) {
		this.name = setNm;
	}
	
	public void setLv(int setLv) {
		this.lv = setLv;
	}
	
	public void setHp(int setHp) {
		this.hp = setHp;
	}
	
	public void setAtk(int setAtk) {
		this.atk = setAtk;
	}
	
	public void setDef(int setDef) {
		this.def = setDef;
	}
	
	public void setSpd(int setSpd) {
		this.spd = setSpd;
	}
	
	public void setHpMax(int setHpMax) {
		this.hpMax = setHpMax;
	}
	
	public void setWazaNm(String setWazaNm) {
		this.wazaNm = setWazaNm;
	}
	
	public void setWazaDmgRate(String setWazaDmgRate) {
		this.wazaDmgRate = setWazaDmgRate;
	}
}

// --- パッケージ宣言 --------------------------
package ChuriMon;

// --- 検証用クラス ----------------------------
class TestMonster{
	public static void main(String[] args) {
		final int LEVEL_UP_PARM = 2; // レベルの上昇値
		
		// 検証クラスのインスタンス化
		Monster1 testMonster1 = new Monster1();
		
		// 検証対象メソッド実行前のフィールド確認
		System.out.println("\n=== 検証対象メソッド実行前 ===");
		System.out.println(testMonster1);
		
		// 検証対象メソッド実行
		testMonster1.levelUp(LEVEL_UP_PARM);
		
		// 検証対象メソッド実行後のフィールド確認
		System.out.println("\n=== 検証対象メソッド実行後 ===");
		System.out.println(testMonster1);
	}
}

// --- インポート ---------------------------------------------------
import java.util.Random;

// --- じゃんけんステータス管理class -----------------------------------
public class Ex03_03_03_Player {

    // --- フィールド -----------------------------------------------
    private String name; // プレイヤーの名前
    private String handStatus; // 何を出したか

    Ex03_03_03_Player(String nm) {
        this.name = nm; // コマンドライン引数から取得した名をセット
    }

    void makeHandStatus() {
        final String[] statusArray = { "グー", "チョキ", "パー" }; // じゃんけんの手を定義
        Random rnd = new Random(); // じゃんけん配列の値取得用疑似乱数

        this.handStatus = statusArray[rnd.nextInt(3)]; // じゃんけん配列の値をランダムに取り出す
    }

    // getter Name
    String getName() {
        return this.name;
    }

    // getter handStatus
    String getHandStatus() {
        return this.handStatus;
    }

}
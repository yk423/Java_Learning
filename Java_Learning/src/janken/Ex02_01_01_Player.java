// --- インポート ---------------------------------------------------

// --- じゃんけんステータス管理class -----------------------------------

import java.util.Random;

public class Ex02_01_01_Player {

    // --- フィールド -----------------------------------------------
    String name; // プレイヤーの名前
    String handStatus; // 何を出したか

    Ex02_01_01_Player(String hs) {
        this.name = hs;
    }

    void makeHandStatus() {
        final String[] statusArray = { "グー", "チョキ", "パー" }; // じゃんけんの手を定義
        Random rnd = new Random(); // じゃんけん配列の値取得用疑似乱数

        this.handStatus = statusArray[rnd.nextInt(3)]; // じゃんけん配列の値をランダムに取り出す
    }

}
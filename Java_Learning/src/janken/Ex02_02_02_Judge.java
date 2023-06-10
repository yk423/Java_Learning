
// --- インポート ---------------------------------------------------
// import java.util.Random;

// --- じゃんけんステータス管理class -----------------------------------
public class Ex02_02_02_Judge {

    // --- フィールド -----------------------------------------------
    String name; // プレイヤーの名前
    String handStatus; // 何を出したか

    // --- コンストラクタ --------------------------------------------
    Ex02_02_02_Judge(String nm) {
        this.name = nm;
    }

    // 審判のセリフを "審判「 " + " 」 "で囲む
    void judgeSays(String strMsg) {
        System.out.println(this.name + "「" + strMsg + "」");
    }

    // じゃんけんスタート
    void startJanken() {
        judgeSays("じゃんけん、ぽん");
    }

    // 手の判断
    void judgeHand(Ex02_02_02_Player player) {
        judgeSays(player.name + "さんの手は" + player.handStatus + "でした");
    }

    // 結果判定
    void judgeResult(Ex02_02_02_Player player1, Ex02_02_02_Player player2) {
        // じゃんけんの手
        final String STATS_GOO = "グー";
        final String STATS_SCISSORS = "チョキ";
        final String STATS_PAR = "パー";

        judgeSays("結果は、");

        // 判定
        if (player1.handStatus == player2.handStatus) {
            System.out.println("あいこ");

        } else if ((player1.handStatus == STATS_GOO && player2.handStatus == STATS_SCISSORS)
                || (player1.handStatus == STATS_SCISSORS && player2.handStatus == STATS_PAR)
                || (player1.handStatus == STATS_PAR && player2.handStatus == STATS_GOO)) {
            judgeSays(player1.name + "さんの勝ち"); // プレイヤー1が勝利

        } else if ((player2.handStatus == STATS_GOO && player1.handStatus == STATS_SCISSORS)
                || (player2.handStatus == STATS_SCISSORS && player1.handStatus == STATS_PAR)
                || (player2.handStatus == STATS_PAR && player1.handStatus == STATS_GOO)) {
            judgeSays(player2.name + "さんの勝ち"); // プレイヤー2が勝利

        } else {
            System.out.println("[ERROR]じゃんけんの判定が不正です"); // ERROR
        }

    }
}
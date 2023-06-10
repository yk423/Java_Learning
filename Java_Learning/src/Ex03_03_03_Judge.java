// --- じゃんけんステータス管理class -----------------------------------
public class Ex03_03_03_Judge {

    // --- フィールド -----------------------------------------------
    private String name; // プレイヤーの名前

    // --- コンストラクタ --------------------------------------------
    Ex03_03_03_Judge(String nm) {
        this.name = nm;
    }

    // 審判のセリフを "審判「 」 "で囲む
    void judgeSays(String strMsg) {
        System.out.println(this.name + "「" + strMsg + "」");
    }

    // じゃんけんスタート
    void startJanken() {
        judgeSays("じゃんけん、ぽん");
    }

    // 手の判断
    void judgeHand(Ex03_03_03_Player player) {
        judgeSays(player.getName() + "さんの手は" + player.getHandStatus() + "でした");
    }

    // 結果判定
    void judgeResult(Ex03_03_03_Player player1, Ex03_03_03_Player player2) {
        // じゃんけんの手
        final String STATS_GOO = "グー";
        final String STATS_SCISSORS = "チョキ";
        final String STATS_PAR = "パー";

        judgeSays("結果は、");

        // 判定
        if (player1.getHandStatus() == player2.getHandStatus()) {
            judgeSays("あいこです");

        } else if ((player1.getHandStatus().equals(STATS_GOO) && player2.getHandStatus().equals(STATS_SCISSORS))
                || (player1.getHandStatus().equals(STATS_SCISSORS) && player2.getHandStatus().equals(STATS_PAR))
                || (player1.getHandStatus().equals(STATS_PAR) && player2.getHandStatus().equals(STATS_GOO))) {
            judgeSays(player1.getName() + "さんの勝ち"); // プレイヤー1が勝利

        } else if ((player2.getHandStatus().equals(STATS_GOO) && player1.getHandStatus().equals(STATS_SCISSORS))
                || (player2.getHandStatus().equals(STATS_SCISSORS) && player1.getHandStatus().equals(STATS_PAR))
                || (player2.getHandStatus().equals(STATS_PAR) && player1.getHandStatus().equals(STATS_GOO))) {
            judgeSays(player2.getName() + "さんの勝ち"); // プレイヤー2が勝利

        } else {
            System.out.println("[ERROR]じゃんけんの判定が不正です"); // ERROR
        }
    }
}
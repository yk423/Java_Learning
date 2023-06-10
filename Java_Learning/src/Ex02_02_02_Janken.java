public class Ex02_02_02_Janken {
    public static void main(String[] args) {
        // シナリオ1
        String personStr1 = args[0]; // じゃんけんプレイヤー1をコマンドライン引数から取得
        String personStr2 = args[1]; // じゃんけんプレイヤー2をコマンドライン引数から取得
        String personStr3 = args[2]; // 審判をコマンドライン引数から取得 20230610 Kanebako Add 審判対応

        // シナリオ2
        Ex02_02_02_Player playerName1 = new Ex02_02_02_Player(personStr1); // プレイヤー1をインスタンス化
        Ex02_02_02_Player playerName2 = new Ex02_02_02_Player(personStr2); // プレイヤー2をインスタンス化
        Ex02_02_02_Player jadgeManager = new Ex02_02_02_Player(personStr3); // 審判をインスタンス化

        // シナリオ3
        System.out.println("\n------------- <勝負開始> -------------");

        playerName1.makeHandStatus();
        playerName2.makeHandStatus();

        System.out.println(jadgeManager.name + "「じゃんけん、ぽん」");
        System.out.println(jadgeManager.name + "「" + playerName1.name + "さんの手：" + playerName1.handStatus + "」");
        System.out.println(jadgeManager.name + "「" + playerName2.name + "さんの手：" + playerName2.handStatus + "」");

        // シナリオ4
        System.out.println("--------------- <勝敗> ---------------");

        // じゃんけんの手
        final String STATS_GOO = "グー";
        final String STATS_SCISSORS = "チョキ";
        final String STATS_PAR = "パー";

        System.out.println("結果は");

        if (playerName1.handStatus == playerName2.handStatus) {
            System.out.println("あいこ");

        } else if (playerName1.handStatus == STATS_GOO && playerName2.handStatus == STATS_SCISSORS) {
            System.out.println(jadgeManager.name + "「" + playerName1.name + "さんの勝ち」");

        } else if (playerName1.handStatus == STATS_SCISSORS && playerName2.handStatus == STATS_PAR) {
            System.out.println(jadgeManager.name + "「" + playerName1.name + "さんの勝ち」");

        } else if (playerName1.handStatus == STATS_PAR && playerName2.handStatus == STATS_GOO) {
            System.out.println(jadgeManager.name + "「" + playerName1.name + "さんの勝ち」");
        } else {
            System.out.println(jadgeManager.name + "「" + playerName2.name + "さんの勝ち」");
        }
    }

    // public static String jadgeWinRose(String p1Status, String p2Status) {
    // String result = "";

    // // じゃんけんの手
    // final String STATS_GOO = "グー";
    // final String STATS_SCISSORS = "チョキ";
    // final String STATS_PAR = "パー";

    // // 結果定義
    // final String p1Win = "p1Win";
    // final String p2Win = "p1Win";
    // final String draw = "draw";

    // if (p1Status == p2Status) {
    // result = draw;

    // } else if (p1Status == STATS_GOO && p2Status == STATS_SCISSORS) {
    // result = p1Win;

    // } else if (p1Status == STATS_SCISSORS && p2Status == STATS_PAR) {
    // result = p1Win;

    // } else if (p1Status == STATS_PAR && p2Status == STATS_GOO) {
    // result = p1Win;
    // } else {
    // result = p2Win;
    // }
    // }
}

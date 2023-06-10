public class Ex02_01_01_Janken {
    public static void main(String[] args) {
        // シナリオ1
        String personStr1 = args[0]; // じゃんけんプレイヤー1をコマンドライン引数から取得
        String personStr2 = args[1]; // じゃんけんプレイヤー2をコマンドライン引数から取得

        // シナリオ2
        Ex02_01_01_Player playerName1 = new Ex02_01_01_Player(personStr1); // プレイヤー1をインスタンス化
        Ex02_01_01_Player playerName2 = new Ex02_01_01_Player(personStr2); // プレイヤー2をインスタンス化

        // シナリオ3
        System.out.println("\n------------- <勝負開始> -------------");

        playerName1.makeHandStatus();
        playerName2.makeHandStatus();

        System.out.println("じゃんけん、ぽん");
        System.out.println(playerName1.name + "さんの手：" + playerName1.handStatus);
        System.out.println(playerName2.name + "さんの手：" + playerName2.handStatus);

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
            System.out.println(playerName1.name + "さんの勝ち");

        } else if (playerName1.handStatus == STATS_SCISSORS && playerName2.handStatus == STATS_PAR) {
            System.out.println(playerName1.name + "さんの勝ち");

        } else if (playerName1.handStatus == STATS_PAR && playerName2.handStatus == STATS_GOO) {
            System.out.println(playerName1.name + "さんの勝ち");
        } else {
            System.out.println(playerName2.name + "さんの勝ち");
        }
    }
}

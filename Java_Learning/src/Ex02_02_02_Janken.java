public class Ex02_02_02_Janken {
    public static void main(String[] args) {
        String personStr1 = args[0]; // じゃんけんプレイヤー1をコマンドライン引数から取得
        String personStr2 = args[1]; // じゃんけんプレイヤー2をコマンドライン引数から取得
        String personStr3 = args[2]; // 審判をコマンドライン引数から取得 20230610 Kanebako Add 審判対応

        Ex02_02_02_Player playerName1 = new Ex02_02_02_Player(personStr1); // プレイヤー1をインスタンス化
        Ex02_02_02_Player playerName2 = new Ex02_02_02_Player(personStr2); // プレイヤー2をインスタンス化
        Ex02_02_02_Judge jadgeManager = new Ex02_02_02_Judge(personStr3); // 審判をインスタンス化

        System.out.println("\n------------- <勝負開始> -------------");

        jadgeManager.startJanken(); // じゃんけんスタート

        // 出す手を決める
        playerName1.makeHandStatus();
        playerName2.makeHandStatus();

        // 各プレイヤーが出した手を伝える
        jadgeManager.judgeHand(playerName1);
        jadgeManager.judgeHand(playerName2);

        System.out.println("--------------- <勝敗> ---------------");

        jadgeManager.judgeResult(playerName1, playerName2); // 審判による結果判定
    }
}

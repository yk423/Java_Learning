// 演習：Ex1_10_1
/*class Session10_Ex {
    public static void main(String[] args) {
        // コマンドライン引数で好きな数字を1つ受け取る
        int receiveNumber = Integer.parseInt(args[0]);

        String display = "";
        String Marker = "＊";

        for (int i = 0; i < receiveNumber; i++) {
            display += Marker;
        }
        System.out.println(display);
    }
}*/

class Session10_Ex2 {
    public static void main(String[] args) {

        for (int i = 1; i <= 9; i++) {
            String display = "";

            for (int j = 1; j <= 9; j++) {
                display += i * j + " ";
            }
            System.out.println(display);
        }
    }
}
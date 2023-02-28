import java.io.*;

public class ParkingAnalyzer2 {
    Stats capacity = new Stats(); // 収容台数用
    Stats price = new Stats(); // 料金用

    void run(String[] args) throws IOException {
        for (Integer i = 0; i < args.length; i++) {
            this.readMethod(new File(args[i]));
        }
        // 出力
        System.out.println("収容可能台数（自転車）  " + capacity.string());
        System.out.println("駐輪代（自転車）／日    " + price.string());
    }

    /* 1行ずつ読み込む */
    void readMethod(File file) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;

        while ((line = in.readLine()) != null) {
            this.parse(line);
        }

        in.close();

    }

    /* 解析する */
    void parse(String line) {
        String[] items = line.split(",");
        if (!items[6].isEmpty()) {
            capacity.updata(Integer.valueOf(items[6]));
        }
        if (!items[11].isEmpty()) {
            if (items[11].equals("無料")) {
                price.updata(0);
            } else {
                price.updata(Integer.valueOf(items[11]));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ParkingAnalyzer2 app2 = new ParkingAnalyzer2();
        app2.run(args);
    }
}

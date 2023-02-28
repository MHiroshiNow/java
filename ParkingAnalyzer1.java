import java.io.*;

public class ParkingAnalyzer1 {
    void run(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("max: N/A, min: N/A, total: N/A, average: N/A");
        } else {
            for (Integer i = 0; i < args.length; i++) {

                this.readMethod(new File(args[i]));

            }
        }

    }

    void readMethod(File file) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        Integer max = Integer.MIN_VALUE; // 収容台数の最大値
        Integer min = Integer.MAX_VALUE; // 収容台数の最小値
        Integer sum = 0; // 収容台数の合計
        Integer row = 0; // 施設の数

        while ((line = in.readLine()) != null) {
            String[] items = line.split(","); // カンマで単語を分ける。
            // this.calc(items[6]);
            if (!items[6].isEmpty()) {
                Integer num = Integer.valueOf(items[6]);
                if (num >= max) {
                    max = num;
                }
                if (num <= min) {
                    max = num;
                }
                sum += num;
                row++;
            }
        }

        in.close();

        this.printer(max, min, sum, row);
    }

    void printer(Integer max, Integer min, Integer sum, Integer row) {
        System.out.printf("max: %d, min: %d, total: %d, average: %f%n", max, min, sum, (sum * 1.0) / row);
    }

    public static void main(String[] args) throws IOException {
        ParkingAnalyzer1 app1 = new ParkingAnalyzer1();
        app1.run(args);
    }
}

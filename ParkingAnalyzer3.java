import java.io.*;
import java.util.ArrayList;

public class ParkingAnalyzer3 {
    Stats capacity = new Stats(); // 収容台数用
    Stats price = new Stats(); // 料金用
    ArrayList<Parking> parkings = new ArrayList<>();

    void run(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("最寄り駅が指定されていません");
            return;
        }
        for (Integer i = 1; i < args.length; i++) {
            this.readMethod(args[0], new File(args[i]));
        }
        // 出力
        System.out.println("収容可能台数（自転車）  " + capacity.string());
        System.out.println("駐輪代（自転車）／日    " + price.string());
        if (parkings.size() > 0) {
            setCheapest();
            for (Parking p : parkings) {
                System.out.println(p.string());
            }
        }
    }

    /* 1行ずつ読み込む */
    void readMethod(String station, File file) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;

        while ((line = in.readLine()) != null) {
            this.parse(station, line);
        }

        in.close();

    }

    /* 解析する */
    void parse(String station, String line) {
        String[] items = line.split(",");
        if (!station.equals(items[3]))
            return; // 最寄り駅の記載がない場合次の行に行く
        String name = items[0];
        Integer capa = Integer.MAX_VALUE;
        Integer priceINT = Integer.MAX_VALUE;
        Double latitude = 0.0;
        Double longitude = 0.0;

        if (!items[6].isEmpty()) {
            capa = Integer.valueOf(items[6]);
            capacity.updata(capa);
        }
        if (!items[11].isEmpty()) {
            if (items[11].equals("無料")) {
                priceINT = 0;
            } else {
                priceINT = Integer.valueOf(items[11]);
            }
        }
        price.updata(priceINT);
        if (!items[21].isEmpty())
            latitude = Double.valueOf(items[21]);
        if (!items[22].isEmpty())
            longitude = Double.valueOf(items[22]);
        Parking p = new Parking();
        p.setFields(name, station, capa, priceINT, latitude, longitude);
        parkings.add(p);
    }

    void setCheapest() {
        Integer minPrice = Integer.MAX_VALUE;
        for (Parking p : parkings) {
            if (minPrice > p.priceOfDay) {
                minPrice = p.priceOfDay;
            }
        }

        for (Parking p : parkings) {
            if (minPrice.equals(p.priceOfDay)) {
                p.setNearest();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ParkingAnalyzer3 app3 = new ParkingAnalyzer3();
        app3.run(args);
    }
}

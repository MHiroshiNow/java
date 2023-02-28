public class Parking {
    Boolean isNearest = false;
    String nameOfParking; // 施設名
    String nearestStation; // 最寄り駅
    Integer capacity ; // 収容可能台数（自転車）
    Integer priceOfDay ; // 駐輪代／日
    Double latitude ; // 経度
    Double longitude ; // 緯度

    public void setFields(String name, String sta, Integer capa, Integer price, Double lati, Double longi) {
        nameOfParking = name;
        nearestStation = sta;
        capacity = capa;
        priceOfDay = price;
        latitude = lati;
        longitude = longi;
    }

    public void setNearest() {
        isNearest = true;
    }

    // public String string() {
    // return String.format("%s %s,%s,%d,%s,%f,%f", (isNearest ? "*" : "
    // "),nameOfParking, nearestStation, capacity,
    // (priceOfDay.equals(Integer.MAX_VALUE) ? "" : priceOfDay.toString()),latitude,
    // longitude);
    // }
    public String string() {
        String capaString = "";
        if (!capacity.equals(Integer.MAX_VALUE)) {
            capaString = capacity.toString();
        }
        if (isNearest) {
            if (priceOfDay.equals(Integer.MAX_VALUE)) {
                return String.format("* %s,%s,%s, ,%f,%f", nameOfParking, nearestStation, capaString, latitude,
                        longitude);

            } else {
                return String.format("* %s,%s,%s,%s,%f,%f", nameOfParking, nearestStation, capaString,
                        priceOfDay.toString(), latitude, longitude);

            }

        } else {
            if (priceOfDay.equals(Integer.MAX_VALUE)) {
                return String.format("  %s,%s,%s,,%f,%f", nameOfParking, nearestStation, capaString, latitude,
                        longitude);
            } else {
                return String.format("  %s,%s,%s,%s,%f,%f", nameOfParking, nearestStation, capaString,
                        priceOfDay.toString(), latitude, longitude);

            }
        }

    }
}

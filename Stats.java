public class Stats {

    Integer max = Integer.MIN_VALUE; // 収容台数の最大値
    Integer min = Integer.MAX_VALUE; // 収容台数の最小値
    Integer sum = 0; // 収容台数の合計
    Integer count = 0; // 施設の数

    public void updata(Integer value){
        if (value > max) {
            max = value;
        }
        if (value < min) {
            min = value;
        }
        sum += value;
        count++;
    }

    public Double avarage(){
        return (sum * 1.0) / count;
    }

    public String string() {
        if (count == 0) {
            return "max: N/A, min: N/A, total: N/A, average: N/A";
        }
        return String.format("max: %d, min: %d, total: %d, average: %f", max, min, sum, avarage());
    }
}


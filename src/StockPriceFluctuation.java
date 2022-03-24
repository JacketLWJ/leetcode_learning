import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author 罗文俊
 * 2022/1/23
 * https://leetcode-cn.com/problems/stock-price-fluctuation/
 */
public class StockPriceFluctuation {
    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(88, 9184);
        stockPrice.update(83, 343);
        stockPrice.update(87, 693);
        stockPrice.update(88, 7810);
        stockPrice.update(89, 624);
        stockPrice.update(86, 9963);
        stockPrice.update(88, 7345);
        stockPrice.update(83, 5533);
        stockPrice.update(85, 4908);
        stockPrice.update(85, 5125);
    }
}

class StockPrice {
    // TreeMap 实现按照时间戳->价格存储
    TreeMap<Integer, Integer> data = new TreeMap<>();
    // TreeSet 实现记录价格->价格出现的次数
    TreeMap<Integer, Integer> prices = new TreeMap<>();

    public StockPrice() {

    }

    public void update(int timestamp, int price) {
        Integer priceSt = data.get(timestamp);
        // 如果非空则出现了错误
        if (priceSt != null) {
            // 对价格出现次数减 1
            int times = prices.get(priceSt) - 1;
            if (times == 0) {
                // 如果移除后该价格出现次数为 0，则直接移除
                prices.remove(priceSt);
            } else {
                // 否则将新的次数保存
                prices.put(priceSt, times);
            }
        }
        // 出现该价格的次数增加
        prices.put(price, prices.getOrDefault(price, 0) + 1);
        // 更新或添加 (时间戳->价格)
        data.put(timestamp, price);
    }

    public int current() {
        return data.lastEntry().getValue();
    }

    public int maximum() {
        return prices.lastKey();
    }

    public int minimum() {
        return prices.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
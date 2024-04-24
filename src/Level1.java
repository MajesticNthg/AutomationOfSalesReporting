import java.util.*;

public class Level1 {
    public static String[] ShopOLAP(int N, String[] items) {
        String[] product = new String[N];
        Integer[] price = new Integer[N];

        for (int x = 0; x < N; x++) {
            String[] s = items[x].split(" ");
            product[x] = s[0];
            price[x] = Integer.valueOf(s[1]);
        }

        List<String> productList = new ArrayList<>(Arrays.asList(product));
        List<Integer> priceList = new ArrayList<>(Arrays.asList(price));

        for (int x = 0; x < productList.size(); x++) {
            for (int y = x + 1; y < productList.size(); y++) {
                if (productList.get(x).equals(productList.get(y))) {
                    priceList.set(x, priceList.get(x) + priceList.get(y));
                    priceList.remove(y);
                    productList.remove(y);
                    y--;
                }
            }
        }

        for (int x = 0; x < priceList.size(); x++) {
            for (int y = x + 1; y < priceList.size(); y++) {
                if (priceList.get(x).equals(priceList.get(y))) {
                    if (productList.get(x).compareTo(productList.get(y)) < 0) continue;
                    else
                        sort(productList, x, y);
                }
                if (priceList.get(x) < priceList.get(y)) {
                    int z1 = priceList.get(x);
                    priceList.set(x, priceList.get(y));
                    priceList.set(y, z1);
                    sort(productList, x, y);
                }
            }
        }

        ArrayList<String> correct = new ArrayList<String>();
        for (int x = 0; x < productList.size(); x++) {
            correct.add(productList.get(x) + " " + String.valueOf(priceList.get(x)));
        }

        String[] stringCorrect = correct.toArray(new String[0]);
        return stringCorrect;
    }

    public static List<String> sort(List<String> productList, int x, int y) {
        String z2 = productList.get(x);
        productList.set(x, productList.get(y));
        productList.set(y, z2);

        return productList;
    }
}



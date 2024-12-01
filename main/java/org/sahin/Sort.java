package org.sahin;

import java.util.Comparator;
import java.util.List;

public class Sort {
    public static List<Product> doSort(String type,String how,List<Product> products){
        switch (type) {
            case "isim":
                if (how.equalsIgnoreCase("artan"))
                    products.sort(Comparator.comparing(Product::getName));
                else
                    products.sort(Comparator.comparing(Product::getName).reversed());
                break;
            case "fiyat":
                if (how.equalsIgnoreCase("artan"))
                    products.sort(Comparator.comparingDouble(Product::getPrice));
                else
                    products.sort(Comparator.comparingDouble(Product::getPrice).reversed());
                break;
            case "stok":
                if (how.equalsIgnoreCase("artan"))
                    products.sort(Comparator.comparingInt(Product::getStock));
                else
                    products.sort(Comparator.comparingInt(Product::getStock).reversed());
                break;
            case "skor":
                if (how.equalsIgnoreCase("artan"))
                    products.sort(Comparator.comparingDouble(Product::getScore));
                else
                    products.sort(Comparator.comparingDouble(Product::getScore).reversed());
                break;
        }
        return products;
    }

}

package org.sahin;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        System.out.println("Kaç adet ürün gireceksiniz?");
        Scanner scanner = new Scanner(System.in);
        int productCount = scanner.nextInt();
        scanner.nextLine();
        String proName;
        double proPrice;
        int proStock;
        float proScore;
        for( int i =0;i<productCount;i++){
            System.out.print((i+1) +". Ürünün adını giriniz maksimum 20 karakter ");
            while (true) {
                proName = scanner.nextLine();
                if(proName.length()<=20)
                    break;
                else
                    System.out.println("Lütfen geçerli ürün ismi giriniz maksimum 20 karakter olmalı ");
            }
            System.out.print("Lütfen ürün fiyatını giriniz (1-100) =  ");
            while (true) {
                proPrice = scanner.nextDouble();
                if (proPrice>100)
                    System.out.println("Lütfen geçerli bir fiyat giriniz [1-100]");
                else
                    break;
            }
            System.out.print("Lütfen ürünün stok sayısnı giriniz =  ");
            while (true) {
                proStock = scanner.nextInt();
                if (proStock<1)
                    System.out.println("stoktaa olmayann ürünü ekleyemezsiniz ");
                else
                    break;
            }

            System.out.print("Lütfen ürünün skorunu giriniz=  ");
            while (true) {
                proScore = scanner.nextFloat();
                if (proScore<0 && proScore>5)
                    System.out.println("skor 1 ila 5 arasında olmalı");
                else
                    break;
            }

            products.add(new Product(proName, proPrice, proStock, proScore));
            scanner.nextLine();
        }

 System.out.println("hangi kritere göre sıralamak istersiniz? (isim, fiyat, stok, skor)");
        String filterType;
        while (true) {
            filterType=scanner.nextLine();
            if (filterType.equalsIgnoreCase("isim")||
                    filterType.equalsIgnoreCase("fiyat")||
                    filterType.equalsIgnoreCase("stok")||
                    filterType.equalsIgnoreCase("skor"))
                break;
            else
                System.out.print("Lütfen geçerli bir kriter giriniz (isim, fiyat, stok, skor) ");
        }
        System.out.println("nasıl filtrelensin (artan azalan)");
        String filterMethod;
        while (true) {
            filterMethod=scanner.nextLine();
            if (filterMethod.equalsIgnoreCase("artan")||
                    filterMethod.equalsIgnoreCase("azalan"))
                break;
            else
                System.out.print("Lütfen geçerli bir kriter giriniz (artan azalan) ");
        }
        List<Product> custumerFiltersP = new ArrayList<>();
        custumerFiltersP=Sort.doSort(filterType, filterMethod,products);
        for(int i=0; i<custumerFiltersP.size();i++){
            System.out.println("isim: "+custumerFiltersP.get(i).name+"  fiyat: "+custumerFiltersP.get(i).price+"  Skor: "+custumerFiltersP.get(i).score+ "  Stok: "+custumerFiltersP.get(i).stock);
        }
        Basket.basketing(custumerFiltersP);

    }
}
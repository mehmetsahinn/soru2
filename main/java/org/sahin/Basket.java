package org.sahin;

import java.util.*;

public class Basket {
    public static void basketing(List<Product> products){
        List<Product> orders = new ArrayList<>();
        List<Integer> ordersCount = new ArrayList<>();
        Boolean flag=false;

        Scanner scanner = new Scanner(System.in);
        outerLoop:
        while (true){
            System.out.println("Sepetinize ürün eklemek isterseniz ismini yazabilirsiniz. (Çıkmak 5'e basın)");
            String custumerIn=scanner.nextLine();
            for (Product i : products) {
                if(i.name.equalsIgnoreCase(custumerIn)){
                    orders.add(i);
                    System.out.print(i.name+" ürününden kaç adet eklemek istersiniz: ");
                    int a=scanner.nextInt();
                    if(a<=i.stock) {
                        i.setCount(a);
                        ordersCount.add(a);
                        System.out.println("Ürün eklendi.");
                        flag=true;
                    }else
                        System.out.print("Üzgünüz stoklarımız yeterli olmadığından ürününüzü ekleyemiyoruz");
                }else if(custumerIn.equalsIgnoreCase("5"))
                    break outerLoop;
            }
            if(!flag)
                System.out.print("Ürün ismi yanlış yada eksik.");
            scanner.nextLine();
        }
        System.out.println("Normal sepet tutarınız: ");
        double total=0;
        for(int i =0;i<orders.size();i++){
            System.out.println(orders.get(i).name+" fiyat: "+orders.get(i).price+
                    " adet: "+orders.get(i).count+" toplam: "+orders.get(i).price*orders.get(i).count);
            total=total+orders.get(i).price*orders.get(i).count;
        }
        System.out.println("Toplamda: "+total);
        System.out.println("İndiriminizle: ");
        double disTotal=0;
        //List<Product> discOrder = new ArrayList<>();
        orders=Sort.doSort("fiyat", "azalan",orders);
        for(int i =0;i<orders.size();i++){
            if(i==orders.size()-1){
                System.out.println(orders.get(i).name+" fiyat: "+orders.get(i).price+
                        " adet: "+orders.get(i).count+" toplam: "+orders.get(i).price*orders.get(i).count);
                disTotal=disTotal+orders.get(i).price*orders.get(i).count;
            }else{
                System.out.println(orders.get(i).name+
                        " fiyat: "+orders.get(i).price+" - "+orders.get(i+1).price+" = "+(orders.get(i).price-orders.get(i+1).price)+
                    " adet: "+orders.get(i).count+
                        " toplam: "+(orders.get(i).price-orders.get(i+1).price)*orders.get(i).count);
                disTotal=disTotal+(orders.get(i).price-orders.get(i+1).price)*orders.get(i).count;
            }
        }
        System.out.println("Toplamda: "+disTotal);





    }
}

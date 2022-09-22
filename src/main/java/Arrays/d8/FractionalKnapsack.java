package Arrays.d8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FractionalKnapsack {

    public static void main(String[] args) {
        int[] values = {100,60,120};
        int[] weights = {20,10,30};
        int W = 50;

        List<Item> items = new ArrayList<>();

        for (int i=0; i < values.length; i++){

            items.add(new Item(weights[i] , values[i], (values[i]/weights[i])));
        }

        Collections.sort(items, new ItemComparator());
        int i = 0;
        int totalValue = 0;
        while (W > 0 && i < items.size()){
            int itemWeight = items.get(i).weight;
            int allowedWeight =  itemWeight > W ? W : itemWeight;
            totalValue += (allowedWeight* items.get(i).valuePerUnit);

                W= W-allowedWeight;
            i++;
        }

        System.out.println(totalValue);
    }
}

class ItemComparator implements Comparator<Item>{
    @Override
    public int compare(Item item1, Item item2) {

        if(item1.valuePerUnit > item2.valuePerUnit){
            return -1;
        }
        return 1;
    }
}

class Item {
    int weight;
    int value;
    int valuePerUnit;

    Item(int weight, int value, int valuePerUnit){
        this.weight = weight;
        this.value = value;
        this.valuePerUnit =valuePerUnit;
    }
}

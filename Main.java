import java.util.*;

class Main {
  public static void main(String[] args) {
    Item i = new Item("4,12", 4, 12);
    Item i2 = new Item("10,4", 10, 4);
    Item i3 = new Item("2,1", 2, 1);
    Item i4 = new Item("1,1", 1, 1);
    Item i5 = new Item("2,2", 2, 2);
    ArrayList<Item> list = new ArrayList<Item>();
    
    list.add(i);
    list.add(i2);
    list.add(i3);
    list.add(i4);
    list.add(i5);
    int result = knapSack(15, list);
    System.out.println("result: " + result);
    int result2 = knapSackDynamic(15, list);
    System.out.println("result: " + result2);
  }

  public static int max(int a, int b) {
    return (a > b) ? a : b;
  }

  public static int knapSack(int totalWeight, ArrayList<Item> listItem) {
      return knapSackAux(totalWeight, listItem, listItem.size());
  }

  public static int knapSackAux(int totalWeight, ArrayList<Item> listItem, int n) {

    if (n == 0 || totalWeight == 0) {
        return 0;
    }

    if (listItem.get(n - 1).weight > totalWeight) {
      return knapSackAux(totalWeight, listItem, n - 1);
    }

    else {
      return max(listItem.get(n - 1).value + knapSackAux(totalWeight - listItem.get(n - 1).weight, listItem, n - 1), knapSackAux(totalWeight, listItem, n - 1));
    }
  }

  public static int knapSackDynamic(int totalWeight, ArrayList<Item> listItem) {
    int i, w;
    int K[][] = new int[listItem.size() + 1][totalWeight + 1];

    for (i = 0; i <= listItem.size(); i++) {
      for (w = 0; w <= totalWeight; w++) {
        if (i == 0 || w == 0)
          K[i][w] = 0;
        else if (listItem.get(i - 1).weight <= w)
          K[i][w] = max(listItem.get(i - 1).value + K[i - 1][w - listItem.get(i - 1).weight], K[i - 1][w]);
        else
          K[i][w] = K[i - 1][w];
      }
    }

    return K[listItem.size()][totalWeight];
  }
}

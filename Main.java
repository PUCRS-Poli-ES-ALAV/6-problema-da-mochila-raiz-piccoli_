import java.util.*;

class Main {

  public static int iteracoes = 0;

  public static void main(String[] args) {
    Item i = new Item(12, 4);
    Item i2 = new Item(4, 10);
    Item i3 = new Item(1, 2);
    Item i4 = new Item(1, 1);
    Item i5 = new Item(2, 2);

    ArrayList<Item> list = new ArrayList<Item>();
    list.add(i);
    list.add(i2);
    list.add(i3);
    list.add(i4);
    list.add(i5);

    iteracoes = 0;
    int result = knapSack(15, list);
    System.out.println("\nPrimeiro caso - Raiz: ");
    System.out.println("result: " + result);
    System.out.println("iteracoes: " + iteracoes);

    iteracoes = 0;
    int result2 = knapSackDynamic(15, list);
    System.out.println("\nPrimeiro caso - Dinamico: ");
    System.out.println("result: " + result2);
    System.out.println("iteracoes: " + iteracoes);

    ArrayList<Item> list2 = new ArrayList<Item>();
    list2.add(new Item(23,92));
    list2.add(new Item(31,57));
    list2.add(new Item(29,49));
    list2.add(new Item(44,68));
    list2.add(new Item(53,60));
    list2.add(new Item(38,43));
    list2.add(new Item(63,67));
    list2.add(new Item(85,84));
    list2.add(new Item(89,87));    
    list2.add(new Item(82,72));

    iteracoes = 0;
    result = knapSack(165, list2);
    System.out.println("\nSegundo caso - Raiz: ");
    System.out.println("result: " + result);
    System.out.println("iteracoes: " + iteracoes);

    iteracoes = 0;
    result2 = knapSackDynamic(165, list2);
    System.out.println("\nSegundo caso - Dinamico: ");
    System.out.println("result: " + result2);   
    System.out.println("iteracoes: " + iteracoes);

    
    ArrayList<Item> list3 = new ArrayList<Item>();
    list3.add(new Item(56,50));
    list3.add(new Item(59,50));
    list3.add(new Item(80,64));
    list3.add(new Item(64,46));
    list3.add(new Item(75,50));
    list3.add(new Item(17,5));

    iteracoes = 0;
    result = knapSack(190, list3);
    System.out.println("\nTerceiro caso - Raiz: ");
    System.out.println("result: " + result);
    System.out.println("iteracoes: " + iteracoes);

    iteracoes = 0;
    result2 = knapSackDynamic(190, list3);
    System.out.println("\nTerceiro caso - Dinamico: ");
    System.out.println("result: " + result2);
    System.out.println("iteracoes: " + iteracoes);
  }

  public static int max(int a, int b) {
    return (a > b) ? a : b;
  }

  public static int knapSack(int totalWeight, ArrayList<Item> listItem) {
      return knapSackAux(totalWeight, listItem, listItem.size());
  }

  public static int knapSackAux(int totalWeight, ArrayList<Item> listItem, int n) {
    iteracoes++;
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
      iteracoes++;
      for (w = 0; w <= totalWeight; w++) {
        iteracoes++;
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

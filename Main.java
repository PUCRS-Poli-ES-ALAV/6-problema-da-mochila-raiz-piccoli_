import java.util.*;

class Main {
  public static void main(String[] args) {
    Item i = new Item("4,12",4,12);
    Item i2 = new Item("10,4",10,4);
    Item i3 = new Item("2,1",2,1);
    ArrayList<Item> list = new ArrayList<Item>();
    list.add(i);
    list.add(i2);
    list.add(i3);
    knapsackProblem(list);
  }

  public static void knapsackProblem(ArrayList<Item> listItem) {
    Collections.sort(listItem, new Comparator<Item>() {
        @Override
        public int compare(Item item1, Item item2) {
            return Double.compare(item1.relationValueWeight, item2.relationValueWeight);
        }
    });

    for (Item item : listItem) {
      System.out.println(item.str());
    }     
  }
}

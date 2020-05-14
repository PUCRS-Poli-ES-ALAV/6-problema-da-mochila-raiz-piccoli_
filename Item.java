public class Item {
	
	public String name;
	public int value;
	public int weight;
	
	public Item(int weight, int value) {
		this.value = value;
		this.weight = weight;
	}
	
	public String str() {
		return  "[value = " + value + ", weight = " + weight + "]";
	}
}

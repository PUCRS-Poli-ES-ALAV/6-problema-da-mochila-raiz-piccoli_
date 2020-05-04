public class Item {
	
	public String name;
	public double value;
	public double weight;
  public double relationValueWeight;
	
	public Item(String name, double value, double weight) {
		this.name = name;
		this.value = value;
		this.weight = weight;
    this.relationValueWeight = value/weight;
	}
	
	public String str() {
		return name + " [value = " + value + ", weight = " + weight + ", relationValueWeight = " + relationValueWeight + "]";
	}
}

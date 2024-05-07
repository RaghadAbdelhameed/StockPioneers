//package Stock;

public abstract class Security {
    private String label; // security label 
    private String name; // security name
    
    Security()
    {
    	
    }
    
    public Security(String label, String name) {
        this.label = label;
        this.name = name;
    }
    
    public String getSymbol() {
        return label;
    }

    public void setSymbol(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // abstract methods to be implemented in all subclasses , each subclass has its own implementation for them
    public abstract double getCurrentPrice();
    public abstract void placeOrder(Transaction transaction);

}

package uoodle.base;

public class Car {
	protected int id;
	protected String name;
	protected String model;
	protected String year;
	
	   public Car() {
	    }
	 
	    public Car(int id) {
	        this.id = id;
	    }
	 
	    public Car(int id, String name, String model, String year) {
	        this(name, model, year);
	        this.id = id;
	    }
	     
	    public Car(String name, String model, String year) {
	        this.name = name;
	        this.model = model;
	        this.year = year;
	    }
	    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}

}

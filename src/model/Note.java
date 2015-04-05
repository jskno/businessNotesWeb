package model;

public class Note {
	
	private int id;
	private Customer customer;
	private Supplier supplier;
	private Product product;
	private String noteText;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getNoteText() {
		return noteText;
	}
	public void setNoteText(String noteText) {
		this.noteText = noteText;
	}
	@Override
	public String toString() {
		return "Note [customer=" + customer + ", supplier=" + supplier
				+ ", product=" + product + ", noteText=" + noteText + "]";
	}
	
	

}

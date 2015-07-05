package model;

import java.util.Date;

public class Note {
	
	private int id;
	private Customer customer;
	private Supplier supplier;
	private Product product;
	private String noteText;
	private String noteTitle;
	private Date noteDate;
	
	public Note() {
		
	}
	
	public Note(Customer customer, Supplier supplier, Product product,
			String noteTitle, String noteText, Date creationDate) {

		this.customer = customer;
		this.supplier = supplier;
		this.product = product;
		this.noteTitle = noteTitle;
		this.noteText = noteText;
		this.noteDate = creationDate;
	}
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
	public String getNoteTitle() {
		return noteTitle;
	}
	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}
	public Date getNoteDate() {
		return noteDate;
	}
	public void setNoteDate(Date noteDate) {
		this.noteDate = noteDate;
	}
	@Override
	public String toString() {
		return "Note [customer=" + customer + ", supplier=" + supplier
				+ ", product=" + product + ", noteText=" + noteText + "]";
	}
}

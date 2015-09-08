package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DDBBBusinessNote {
	
	private static final String SQL_INSERT_ALL = "insert into business_note (NOTE_ID, CUSTOMER_ID, SUPPLIER_ID, " +
			"PRODUCT_ID) values (?,?,?,?)";
	private static final String SQL_READ="SELECT * FROM businness_note WHERE NOTE_ID=?";
	private static final String SQL_DELETE="DELETE FROM businness_note WHERE NOTE_ID=?";
	
	private int noteId;
	private int customerId;
	private int supplierId;
	private int productId;
	
	private int noteIdNull;
	private int customerIdNull;
	private int supplierIdNull;
	private int productIdNull;
	
	public int getNoteId() {
		return noteId;
	}
	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	private int getNoteIdNull() {
		return noteIdNull;
	}
	public void setNoteIdNull() {
		this.noteIdNull = 2;
	}
	public boolean isNoteIdNull() {
		return getNoteIdNull() == 2;
	}
	private int getCustomerIdNull() {
		return customerIdNull;
	}
	public void setCustomerIdNull() {
		this.customerIdNull = 2;
	}
	public boolean isCustomerIdNull() {
		return getCustomerIdNull() == 2;
	}
	private int getSupplierIdNull() {
		return supplierIdNull;
	}
	public void setSupplierIdNull() {
		this.supplierIdNull = 2;
	}
	public boolean isSupplierIdNull() {
		return getSupplierIdNull() == 2;
	}
	private int getProductIdNull() {
		return productIdNull;
	}
	public void setProductIdNull() {
		this.productIdNull = 2;
	}
	public boolean isProductIdNull() {
		return getProductIdNull() == 2;
	}
	
	public void loadResult(ResultSet rs) throws SQLException {
		
		setNoteId(rs.getInt("NOTE_ID"));
		if(rs.wasNull()) {
			setNoteIdNull();
		}
		setCustomerId(rs.getInt("CUSTOMER_ID"));
		if(rs.wasNull()) {
			setCustomerIdNull();
		}
		setSupplierId(rs.getInt("SUPPLIER_ID"));
		if(rs.wasNull()) {
			setSupplierIdNull();
		}
		setProductId(rs.getInt("PRODUCT_ID"));
		if(rs.wasNull()) {
			setProductIdNull();
		}
	}
	
	public Integer insert(Connection connection) throws SQLException {
		
		Integer lastKey = null;
		final PreparedStatement ps = connection.prepareStatement(SQL_INSERT_ALL);
		int p=1;
		
		try
		{
			// SQL: NOTE_ID (INT):
			if (isNoteIdNull())
			{
				ps.setNull(p, java.sql.Types.NUMERIC);
			}
			else
			{
				ps.setInt(p, getNoteId());
			}
			p++;
			// SQL: CUSTOMER_ID (INT):
			if (isCustomerIdNull())
			{
				ps.setNull(p, java.sql.Types.NUMERIC);
			}
			else
			{
				ps.setInt(p, getCustomerId());
			}
			p++;
			// SQL: SUPPLIER_ID (INT):
			if (isSupplierIdNull())
			{
				ps.setNull(p, java.sql.Types.NUMERIC);
			}
			else
			{
				ps.setInt(p, getSupplierId());
			}
			p++;
			// SQL: PRODUCT_ID (INT):
			if (isProductIdNull())
			{
				ps.setNull(p, java.sql.Types.NUMERIC);
			}
			else
			{
				ps.setInt(p, getProductId());
			}
			ps.executeUpdate();
			
			lastKey = getNoteId();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ps.close();
		}
		return lastKey;
	}

	public static DDBBBusinessNote read(final Connection connection, int noteId)
			throws SQLException {
		
		final PreparedStatement ps = connection.prepareStatement(SQL_READ);
		ResultSet rs = null;
		int p = 1;
		try {
			ps.setInt(p, noteId);
			rs = ps.executeQuery();
			DDBBBusinessNote ddbbNote;
			if(rs.next()) {
				ddbbNote = new DDBBBusinessNote();
				ddbbNote.loadResult(rs);
			} else {
				ddbbNote = null;
			}
			return ddbbNote;
		} finally {
			if(rs != null) {
				rs.close();
			}
			ps.close();
		}
	}
	
	public boolean delete(final Connection connection)
			throws java.sql.SQLException {
		
		PreparedStatement ps=connection.prepareStatement(SQL_DELETE);
		int p=1;
		try	{
			ps.setInt(p++, getNoteId());
			//ps.setLong(p++, this.myOptimistLock);
					
			if (ps.executeUpdate() <= 0) {
				throw new SQLException();
			}
		} finally {
			ps.close();
		}
		return true;
	}
	
}

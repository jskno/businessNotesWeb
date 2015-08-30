package dao;

import java.util.List;

import persistence.DDBBSupplier;
import model.Supplier;

public interface SupplierDAO extends Dao {

	Supplier getSupplierById(int supplierId);

	List<Supplier> getSuppliersList();

	List<DDBBSupplier> getPersistenceCustomerList();

	void insertList(List<Supplier> suppliersList);

}

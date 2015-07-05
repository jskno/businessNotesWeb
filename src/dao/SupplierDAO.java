package dao;

import java.util.List;

import persistence.PersistenceSupplier;
import model.Supplier;

public interface SupplierDAO extends Dao {

	Supplier getSupplierById(int supplierId);

	List<Supplier> getSuppliersList();

	List<PersistenceSupplier> getPersistenceCustomerList();

}

package dao;

import java.util.List;

import model.Supplier;

public interface SupplierDAO extends Dao {

	Supplier getSupplierById(int supplierId);

	List<Supplier> getSuppliesList();

}

package dao;

import java.util.List;

import persistence.DDBBSupplier;
import model.SupplierVO;

public interface SupplierDAO extends DAO {

	SupplierVO getSupplierById(int supplierId);
	List<SupplierVO> getSuppliersList();
	List<DDBBSupplier> getPersistenceSuppliersList();
	void insertList(List<SupplierVO> suppliersList);
	SupplierVO getSupplierByTaxID(String taxID);
}

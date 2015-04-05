package dao;

import java.sql.Connection;

import model.Supplier;

public interface SupplierDAO extends Dao {

	Supplier getSupplierById(int supplierId, Connection connection);

}

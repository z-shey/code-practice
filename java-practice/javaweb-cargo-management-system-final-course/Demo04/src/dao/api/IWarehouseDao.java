package dao.api;

import vo.Warehouse;

import java.util.List;

public interface IWarehouseDao {
    Warehouse getWarehouseById(int warehouseId);
    List<Warehouse> getAllWarehouses();
    void addWarehouse(Warehouse warehouse);
    void updateWarehouse(Warehouse warehouse);
    void deleteWarehouse(int warehouseId);
}


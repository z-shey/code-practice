package dao.api;

import vo.Cargo;

import java.util.List;

public interface ICargoDao {
    Cargo getCargoById(int cargoId);
    List<Cargo> getAllCargo();
    List<Cargo> getCargoByWarehouseId(int warehouseId);
    void addCargo(Cargo cargo);
    void updateCargo(Cargo cargo);
    void deleteCargo(int cargoId);
}

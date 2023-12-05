package com.shey.service;


import com.shey.dao.CargoDao;
import com.shey.dao.CargoDaoImpl;
import com.shey.entity.Cargo;

import java.util.List;

public class CargoServiceImpl implements CargoService{
    private CargoDao cargoDao;

    public CargoServiceImpl() {
        this.cargoDao = new CargoDaoImpl();
    }

    @Override
    public List<Cargo> cargoList() {
        return cargoDao.cargoList();
    }

    @Override
    public boolean cargoAdd(Cargo cargo) {
        return false;
    }

    @Override
    public boolean cargoDelete(Cargo cargo) {
        return false;
    }

    @Override
    public boolean cargoUpdate(Cargo cargo) {
        return false;
    }

    @Override
    public Cargo getCargo(Integer cargoId) {
        return null;
    }

    @Override
    public Integer cargoCount() {
        return null;
    }
}

package com.shey.service;


import com.shey.entity.Cargo;

import java.util.List;

public interface CargoService {
    List<Cargo> cargoList();
    boolean cargoAdd(Cargo cargo);
    boolean cargoDelete(Cargo cargo);
    boolean cargoUpdate(Cargo cargo);
    Cargo getCargo(Integer cargoId);
    Integer cargoCount();
}

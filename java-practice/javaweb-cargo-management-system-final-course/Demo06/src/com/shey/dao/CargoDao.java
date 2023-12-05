package com.shey.dao;

import com.shey.entity.Cargo;
import com.shey.util.DBUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.util.List;

public interface CargoDao {
    default QueryRunner getQueryRunner() {
        return new QueryRunner(DBUtil.getDataSource());
    }

    List<Cargo> cargoList();

    boolean cargoAdd(Cargo cargo);

    boolean cargoDelete(Integer cargoId);

    boolean cargoUpdate(Cargo cargo);

    Cargo getCargo(Integer cargoId);

    Integer cargoCount();
}

package com.UniClinica.repository;

import com.UniClinica.models.Registro;
import org.springframework.data.repository.CrudRepository;

public interface RegistroRepository extends CrudRepository<Registro, String>{
    Registro findByCodigo(long codigo);
}

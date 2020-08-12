package Darcy.springframework.repositories;


import Darcy.springframework.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * spring5-recipe-app
 * Author: Darcy Xian  2020/8/711:44
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure,Long> {

    Optional<UnitOfMeasure> findByDescription (String descriptionsdfgsdf);

}



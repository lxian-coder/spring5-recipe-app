package Darcy.springframework.repositories;

import Darcy.springframework.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * spring5-recipe-app
 * Author: Darcy Xian  2020/8/711:38
 */

public interface CategoryRepository extends CrudRepository<Category,Long> {

    Optional<Category> findByDescription (String description);

}

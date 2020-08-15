package Darcy.springframework.repositories;

import Darcy.springframework.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 * Darcy Xian  15/8/20  11:13 am      spring5-recipe-app
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {
    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByDescription() throws Exception{
     Optional<UnitOfMeasure> savedUOM = unitOfMeasureRepository.findByDescription("Each");

     assertEquals("Each",savedUOM.get().getDescription());

    }
}
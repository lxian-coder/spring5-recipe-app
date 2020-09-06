package Darcy.springframework.servicesImpl;

import Darcy.springframework.commands.UnitOfMeasureCommand;
import Darcy.springframework.converters.UnitOfMeasureToUnitOfMeasureCommand;
import Darcy.springframework.domain.UnitOfMeasure;
import Darcy.springframework.repositories.UnitOfMeasureRepository;
import Darcy.springframework.services.UnitOfMeassureService;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;

/**
 * Darcy Xian  3/9/20  11:56 am      spring5-recipe-app
 */
public class UOMServiceImplTest extends TestCase {

    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand = new UnitOfMeasureToUnitOfMeasureCommand();
    UnitOfMeassureService service;

    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        service = new UOMServiceImpl(unitOfMeasureRepository, unitOfMeasureToUnitOfMeasureCommand);
    }
    @Test
    public void testListAllUoms() {
        //given
        Set<UnitOfMeasure> unitOfMeasures = new HashSet<>();
        UnitOfMeasure uom1 = new UnitOfMeasure();
        uom1.setId(1L);
        unitOfMeasures.add(uom1);

        UnitOfMeasure uom2 = new UnitOfMeasure();
        uom2.setId(2L);
        unitOfMeasures.add(uom2);

         when(unitOfMeasureRepository.findAll()).thenReturn(unitOfMeasures);
        //when
        Set<UnitOfMeasureCommand> commands = service.listAllUoms();

        //then
        assertEquals(2, commands.size());
        verify(unitOfMeasureRepository,times(1)).findAll();
    }
}
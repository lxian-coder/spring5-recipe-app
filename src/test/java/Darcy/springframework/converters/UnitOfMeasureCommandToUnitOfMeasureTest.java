package Darcy.springframework.converters;

import Darcy.springframework.commands.UnitOfMeasureCommand;
import Darcy.springframework.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Darcy Xian  21/8/20  5:10 pm      spring5-recipe-app
 */
public class UnitOfMeasureCommandToUnitOfMeasureTest {
    public UnitOfMeasureCommandToUnitOfMeasure converter;
    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = 1L;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureCommandToUnitOfMeasure();
    }

    @Test
    public void testNullParameter() throws Exception{
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception{
        assertNotNull(converter.convert(new UnitOfMeasureCommand()));
    }

    @Test
    public void convert() {
        // given
        UnitOfMeasureCommand command = new UnitOfMeasureCommand();
        command.setId(LONG_VALUE);
        command.setDescription(DESCRIPTION);

        // when
        UnitOfMeasure uom = converter.convert(command);

        // then
        assertNotNull(uom);
        assertEquals(LONG_VALUE,uom.getId());
        assertEquals(DESCRIPTION,uom.getDescription());
    }
}






























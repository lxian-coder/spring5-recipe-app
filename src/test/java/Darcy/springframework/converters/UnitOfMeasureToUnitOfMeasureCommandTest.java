package Darcy.springframework.converters;

import Darcy.springframework.commands.UnitOfMeasureCommand;
import Darcy.springframework.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Darcy Xian  21/8/20  10:11 pm      spring5-recipe-app
 */
public class UnitOfMeasureToUnitOfMeasureCommandTest {

    public static final String DESCRIPTION = "description";
    public static final Long ID = 1L;

    UnitOfMeasureToUnitOfMeasureCommand converter;
    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @Test
    public void testNullObjectConvert() throws Exception{
         assertNull(converter.convert(null));
    }
    @Test
    public void testEmptyObjectConvert() throws Exception{
        assertNotNull(converter.convert(new UnitOfMeasure()));
    }
    @Test
    public void testConvert() throws Exception{
        // given
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(ID);
        uom.setDescription(DESCRIPTION);
        // when
        UnitOfMeasureCommand uomc = converter.convert(uom);
       // then
      assertEquals(DESCRIPTION, uomc.getDescription());
      assertEquals(ID,uomc.getId());
    }
}
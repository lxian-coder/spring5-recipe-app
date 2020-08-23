package Darcy.springframework.converters;

import Darcy.springframework.commands.IngredientCommand;
import Darcy.springframework.domain.Ingredient;
import Darcy.springframework.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Darcy Xian  21/8/20  10:53 pm      spring5-recipe-app
 */
public class IngredientToIngredientCommandTest {

    public static final String DESCRIPTION = "description";
    public static final BigDecimal AMOUNT = new BigDecimal(12);
    public static final Long ID = 1L;
    public static final Long UOM_ID = 1L;
    IngredientToIngredientCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
    }

    @Test
    public void testNullObject(){
        assertNull(converter.convert(null));
    }
    @Test
    public void testEmptyObject(){
        assertNotNull(converter.convert(new Ingredient()));
    }
    @Test
    public void testCovertNullUOM() throws Exception{
        // given
        Ingredient ing =new Ingredient();
        ing.setId(ID);
        ing.setAmuont(AMOUNT);
        ing.setDescription(DESCRIPTION);
        ing.setUom(null);
        //when
        IngredientCommand inc = converter.convert(ing);
        //then
        assertEquals(ID,inc.getId());
        assertEquals(AMOUNT,inc.getAmount());
        assertEquals(DESCRIPTION,inc.getDescription());
        assertNull(inc.getUomC());

    }

    @Test
    public void convert() {
        // given
        Ingredient ing =new Ingredient();
     ing.setId(ID);
     ing.setAmuont(AMOUNT);
     ing.setDescription(DESCRIPTION);

     UnitOfMeasure UOM = new UnitOfMeasure();
     UOM.setId(UOM_ID);
     ing.setUom(UOM);
     // when
     IngredientCommand inc = converter.convert(ing);
     //then
    assertEquals(ID,inc.getId());
    assertEquals(AMOUNT,inc.getAmount());
    assertEquals(DESCRIPTION,inc.getDescription());
    assertNotNull(inc.getUomC());
    assertEquals(UOM_ID,inc.getId());

    }
}


























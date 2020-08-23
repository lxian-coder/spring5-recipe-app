package Darcy.springframework.converters;

import Darcy.springframework.commands.CategoryCommand;
import Darcy.springframework.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Darcy Xian  23/8/20  9:00 pm      spring5-recipe-app
 */
public class CategoryToCategoryCommandTest {
    public static final Long ID = 1L;
    public static final String DESCRIPTION = "description";
    CategoryToCategoryCommand converter;
    @Before
    public void setUp() throws Exception {
        converter = new CategoryToCategoryCommand();
    }
    @Test
    public void testNullObject(){
        assertNull(converter.convert(null));
    }
    @Test
    public void testEmptyObject(){
        assertNotNull(converter.convert(new Category()));
    }
    @Test
    public void convert() {
    // given
    Category category = new Category();
    category.setDescription(DESCRIPTION);
    category.setId(ID);

    // when
        CategoryCommand categoryCommand = converter.convert(category);

        //then
        assertNotNull(categoryCommand);
        assertEquals(ID,categoryCommand.getId());
        assertEquals(DESCRIPTION,categoryCommand.getDescription());
    }
}
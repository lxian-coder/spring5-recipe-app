package Darcy.springframework.converters;

import Darcy.springframework.commands.CategoryCommand;
import Darcy.springframework.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Darcy Xian  23/8/20  9:18 pm      spring5-recipe-app
 */
public class CategoryCommandToCategoryTest {

    public static final String DESCRIPTION = "description";
    public static final Long ID = 1L;

    CategoryCommandToCategory converter;

    @Before
    public void setUp() throws Exception {
        converter = new CategoryCommandToCategory();
    }
    @Test
    public void testNullObject() throws Exception{
       assertNull(converter.convert(null));
    }
    @Test
    public void testEmptyOjbect() throws Exception{
        assertNotNull(converter.convert(new CategoryCommand()));
    }
    @Test
    public void convert() {
        // when
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(ID);
        categoryCommand.setDescription(DESCRIPTION);
        // when
        Category category = converter.convert(categoryCommand);
        // then
        assertNotNull(category);
        assertEquals(ID,category.getId());
        assertEquals(DESCRIPTION,category.getDescription());
    }
}
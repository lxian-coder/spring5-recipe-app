package Darcy.springframework.domain;

import junit.framework.TestCase;
import org.junit.Before;



/**
 * Darcy Xian  13/8/20  12:36 pm      spring5-recipe-app
 */
public class CategoryTest extends TestCase {

    Category category;

    @Before
    public void setUp(){
        category = new Category();
    }

    public void testGetId() {
        Long idValue = 3L;
        category.setId(idValue);
        assertEquals(idValue,category.getId());

    }

    public void testGetDescription() {

    }
}
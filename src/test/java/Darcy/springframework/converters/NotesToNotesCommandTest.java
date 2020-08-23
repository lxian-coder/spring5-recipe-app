package Darcy.springframework.converters;

import Darcy.springframework.commands.NotesCommand;
import Darcy.springframework.domain.Notes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Darcy Xian  23/8/20  10:51 am      spring5-recipe-app
 */
public class NotesToNotesCommandTest {

    public static final Long ID =1L;
    public static final String RECIPE_NOTES = "recipeNotes";

    NotesToNotesCommand converter;
    @Before
    public void setUp() throws Exception {
    converter = new NotesToNotesCommand();
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }
    @Test
    public void testEmptyObject() throws Exception{
        assertNotNull(converter.convert(new Notes()));
    }
    @Test
    public void convert() {
        //given
        Notes notes = new Notes();
        notes.setRecipeNotes(RECIPE_NOTES);
        notes.setId(ID);

        //when
        NotesCommand notesCommand = converter.convert(notes);
        // then
        assertNotNull(notesCommand);
        assertEquals(ID,notesCommand.getId());
        assertEquals(RECIPE_NOTES,notesCommand.getRecipeNotes());
    }
}
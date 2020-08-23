package Darcy.springframework.converters;

import Darcy.springframework.commands.NotesCommand;
import Darcy.springframework.domain.Notes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Darcy Xian  23/8/20  11:14 am      spring5-recipe-app
 */
public class NotesCommandToNotesTest {

    public static final Long ID =1L;
    public static final String RECIPE_NOTES = "recipeNotes";
    NotesCommandToNotes converter;
    @Before
    public void setUp() throws Exception {
        converter = new NotesCommandToNotes();
    }

    @Test
    public void testNullObject() throws Exception{
        assertNull(converter.convert(null));
    }
    @Test
    public void testEmptyObject() throws Exception{
        assertNotNull(converter.convert(new NotesCommand()));
    }
    @Test
    public void convert() {
        //given
        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(ID);
        notesCommand.setRecipeNotes(RECIPE_NOTES);
        // when
        Notes notes = converter.convert(notesCommand);
        // then
        assertNotNull(notes);
        assertEquals(ID,notes.getId());
        assertEquals(RECIPE_NOTES,notes.getRecipeNotes());
    }
}
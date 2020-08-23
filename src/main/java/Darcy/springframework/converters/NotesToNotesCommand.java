package Darcy.springframework.converters;

import Darcy.springframework.commands.NotesCommand;
import Darcy.springframework.domain.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Darcy Xian  23/8/20  10:25 am      spring5-recipe-app
 */
@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {

     @Synchronized
     @Nullable
     @Override
    public NotesCommand convert(Notes source) {
        if(source != null){
            NotesCommand notesCommand = new NotesCommand();
            notesCommand.setRecipeNotes(source.getRecipeNotes());
            notesCommand.setId(source.getId());
            return notesCommand;
        }
        return null;
    }
}

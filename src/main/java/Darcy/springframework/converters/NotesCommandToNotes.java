package Darcy.springframework.converters;

import Darcy.springframework.commands.NotesCommand;
import Darcy.springframework.domain.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Darcy Xian  23/8/20  11:08 am      spring5-recipe-app
 */
@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {
    @Synchronized
    @Nullable
    @Override
    public Notes convert(NotesCommand source) {
        if(source != null){
            Notes notes = new Notes();
            notes.setRecipeNotes(source.getRecipeNotes());
            notes.setId(source.getId());
            return notes;
        }
        return null;
    }
}


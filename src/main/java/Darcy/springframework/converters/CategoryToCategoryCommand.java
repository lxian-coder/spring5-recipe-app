package Darcy.springframework.converters;

import Darcy.springframework.commands.CategoryCommand;
import Darcy.springframework.domain.Category;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Darcy Xian  23/8/20  8:55 pm      spring5-recipe-app
 */
@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {
    @Synchronized
    @Nullable
    @Override
    public CategoryCommand convert(Category source) {
        if(source != null){
            CategoryCommand categoryCommand = new CategoryCommand();
            categoryCommand.setDescription(source.getDescription());
            categoryCommand.setId(source.getId());
            return categoryCommand;
        }
        return null;
    }
}

package Darcy.springframework.converters;

import Darcy.springframework.commands.CategoryCommand;
import Darcy.springframework.domain.Category;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Darcy Xian  23/8/20  9:14 pm      spring5-recipe-app
 */
@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand,Category> {
   @Synchronized
   @Nullable
    @Override
    public Category convert(CategoryCommand source) {
       if(source != null){
           Category category = new Category();
           category.setId(source.getId());
           category.setDescription(source.getDescription());
           return category;
       }
        return null;
    }
}

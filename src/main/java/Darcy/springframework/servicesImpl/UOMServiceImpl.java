package Darcy.springframework.servicesImpl;

import Darcy.springframework.commands.UnitOfMeasureCommand;
import Darcy.springframework.converters.UnitOfMeasureToUnitOfMeasureCommand;
import Darcy.springframework.repositories.UnitOfMeasureRepository;
import Darcy.springframework.services.UnitOfMeassureService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Darcy Xian  3/9/20  11:43 am      spring5-recipe-app
 */
@Service
@AllArgsConstructor
public class UOMServiceImpl implements UnitOfMeassureService {

    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    @Override
    public Set<UnitOfMeasureCommand> listAllUoms() {
        return StreamSupport.stream(unitOfMeasureRepository.findAll()
                       .spliterator(),false)
                       .map(unitOfMeasureToUnitOfMeasureCommand::convert)
                       .collect(Collectors.toSet());
    }
}

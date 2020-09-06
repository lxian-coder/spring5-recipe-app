package Darcy.springframework.services;

import Darcy.springframework.commands.UnitOfMeasureCommand;

import java.util.Set;

/**
 * Darcy Xian  3/9/20  11:39 am      spring5-recipe-app
 */
public interface UnitOfMeassureService {
    Set<UnitOfMeasureCommand> listAllUoms();
}

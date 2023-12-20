package ch.hearc.ig.guideresto.application;

import ch.hearc.ig.guideresto.persistence.*;
import ch.hearc.ig.guideresto.presentation.CLI;
import ch.hearc.ig.guideresto.service.*;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    var scanner = new Scanner(System.in);
    var printStream = System.out;

    // DAO instances
    var restaurantService = new RestaurantTypeService();
    var cityService = new CityService();
    var restaurantTypeService = new RestaurantTypeService();
    var basicEvaluationService = new BasicEvaluationService();
    var completeEvaluationService = new CompleteEvaluationService();
    var evaluationCriteriaService = new EvaluationCriteriaService();
    var gradeService = new GradeService();

    // CLI instance with DAOs
    var cli = new CLI(scanner, printStream,
            restaurantService, cityService,
            restaurantTypeService,
            basicEvaluationService,
            completeEvaluationService,
            evaluationCriteriaService,
            gradeService);

    cli.start();
  }
}

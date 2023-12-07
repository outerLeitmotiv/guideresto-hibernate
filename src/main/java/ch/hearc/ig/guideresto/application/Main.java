package ch.hearc.ig.guideresto.application;

import ch.hearc.ig.guideresto.persistence.*;
import ch.hearc.ig.guideresto.presentation.CLI;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    var scanner = new Scanner(System.in);
    var printStream = System.out;

    // DAO instances
    var restaurantDAO = new RestaurantDAO();
    var cityDAO = new CityDAO();
    var restaurantTypeDAO = new RestaurantTypeDAO();
    var basicEvaluationDAO = new BasicEvaluationDAO();
    var completeEvaluationDAO = new CompleteEvaluationDAO();
    var evaluationCriteriaDAO = new EvaluationCriteriaDAO();
    var gradeDAO = new GradeDAO();

    // CLI instance with DAOs
    var cli = new CLI(scanner, printStream,
            restaurantDAO, cityDAO,
            restaurantTypeDAO,
            basicEvaluationDAO,
            completeEvaluationDAO,
            evaluationCriteriaDAO,
            gradeDAO);

    cli.start();
  }
}

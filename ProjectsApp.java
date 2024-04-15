package projects;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import projects.entity.Project;
import projects.service.ProjectService;
import projects.exception.DbException;


public class ProjectsApp {
	private Scanner sc = new Scanner(System.in);
	private ProjectService projectService = new ProjectService();			
	
	
			// @formatter:off 
			private List<String> operations = List.of(
					"1) Add a project"
					);
			// @formatter:on
			
			
			
	public static void main(String[] args) {
		new ProjectsApp().processUserSelections();
	
		
}




	private void processUserSelections() {
		// TODO Auto-generated method stub
		boolean done = false;
		
		while(!done) {
			
			try {					
				int selection = getUserSelection();

			switch(selection) {
			case -1:
				done = exitMenu();
				break;
				
			case 1:
				createProject();
				break;
				
				default:
					System.out.println("\n" + selection + "is not valid. Try again.");
					break;
			}
			}
			catch(Exception e) {
				System.out.println("\nError: " + e + " Try again." );
			
		}
	}
	}



	private int getUserSelection() {
		printOperations();
		
		
		
		Integer input = getIntInput("Enter a menu selection");
		
		return Objects.isNull(input) ? -1 : input;
		
	

	}
	
	private void createProject() {

			String projectName = getStringInput("Enter the project name");
			BigDecimal estimatedHours = getDecimalInput("Enter the estimated hours");
			BigDecimal actualHours = getDecimalInput("Enter the actual hours");
			Integer difficulty = getIntInput("Enter the project difficulty (1-5");
			String notes = getStringInput("Enter the project notes");
			
			Project project = new Project();
			
			project.setProjectName(projectName);
			project.setEstimatedHours(estimatedHours);
			project.setActualHours(actualHours);
			project.setDifficulty(difficulty);
			project.setNotes(notes);

			
			Project dbProject = projectService.addProject(project);
			System.out.println("\nYou have successfully created project" + dbProject);
		
	}
	private BigDecimal getDecimalInput(String prompt) {
		String input = getStringInput(prompt);
		
		if (Objects.isNull(input)) {
			return null;
		}
		
		try {
			return new BigDecimal(input).setScale(2);
		}
		catch(NumberFormatException e) {
			throw new DbException(input + "is not a valid decimal number.");
		}
		
	}




	private static void createAndPopulateTables() {
		// TODO Auto-generated method stub
		
	}




	private boolean exitMenu() {
		System.out.println("\nExitting the menu. TTFN!");
		return true;
	}
	private int getOperation() {
		printOperations();
		// TODO Auto-generated method stub
		Integer op = getIntInput("\nEnter an operation number (press Enter to quit)");
		
		return Objects.isNull(op) ? -1 : op;
	}




	private void printOperations() {
		System.out.println("\nThese are the available selections. Press the Enter key to quit:");
		
		operations.forEach(line -> System.out.println("   " + line));
	}




	private Integer getIntInput(String prompt) {
		String input = getStringInput(prompt);
		
		if(Objects.isNull(input)) {
			return null;
		}
		try {
					return Integer.valueOf(input);
		}
		catch(NumberFormatException e) {
				throw new DbException(input + " is not a valid number.");
		}
		
	}
	
	
	private String getStringInput(String prompt) {
		System.out.println(prompt + " :  ");
		String input = sc.nextLine();
		return input.isBlank() ? null : input.trim();
		
	}
}

	


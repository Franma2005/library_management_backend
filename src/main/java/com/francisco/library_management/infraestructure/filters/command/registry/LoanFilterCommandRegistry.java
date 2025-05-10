package com.francisco.library_management.infraestructure.filters.command.registry;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.francisco.library_management.infraestructure.exceptions.customExceptions.CommandNotFoundException;
import com.francisco.library_management.infraestructure.filters.command.loan.IdBookFilterCommand;
import com.francisco.library_management.infraestructure.filters.command.loan.IdLibraryUserFilterCommand;
import com.francisco.library_management.infraestructure.filters.command.loan.IdLoanFilterCommand;
import com.francisco.library_management.infraestructure.filters.command.loan.TimeFilterCommand;
import com.francisco.library_management.infraestructure.filters.interfaces.MyLoanCommand;

import jakarta.annotation.PostConstruct;

@Component
public class LoanFilterCommandRegistry {

	private Map<String, MyLoanCommand> filterLoanCommands;
	
	public LoanFilterCommandRegistry() {
		filterLoanCommands = new HashMap<String, MyLoanCommand>();
	}
	
	@PostConstruct
	public void init(
			IdLoanFilterCommand idLoanFilterCommand,
			IdBookFilterCommand idBookFilterCommand,
			IdLibraryUserFilterCommand idLibraryUserCommand,
			TimeFilterCommand timeFilterCommand
	) {
		filterLoanCommands.put("idLoan", idLoanFilterCommand);
		filterLoanCommands.put("idBook", idBookFilterCommand);
		filterLoanCommands.put("idLibraryUser", idLibraryUserCommand);
		filterLoanCommands.put("time", timeFilterCommand);		
	}
	
	public MyLoanCommand getCommand(String field) {
		MyLoanCommand myLoanCommand = filterLoanCommands.get(field);
		if(myLoanCommand == null)
			throw new CommandNotFoundException();
		return myLoanCommand;
	}
	
}

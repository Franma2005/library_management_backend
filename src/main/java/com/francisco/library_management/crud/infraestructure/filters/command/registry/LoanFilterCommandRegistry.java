package com.francisco.library_management.crud.infraestructure.filters.command.registry;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.francisco.library_management.crud.infraestructure.exceptions.customExceptions.CommandNotFoundException;
import com.francisco.library_management.crud.infraestructure.filters.command.loan.IdBookFilterCommand;
import com.francisco.library_management.crud.infraestructure.filters.command.loan.IdLibraryUserFilterCommand;
import com.francisco.library_management.crud.infraestructure.filters.command.loan.IdLoanFilterCommand;
import com.francisco.library_management.crud.infraestructure.filters.command.loan.TimeFilterCommand;
import com.francisco.library_management.crud.infraestructure.filters.interfaces.MyLoanCommand;

@Component
public class LoanFilterCommandRegistry {

	private Map<String, MyLoanCommand> filterLoanCommands;
	
	public LoanFilterCommandRegistry(
			IdLoanFilterCommand idLoanFilterCommand,
			IdBookFilterCommand idBookFilterCommand,
			IdLibraryUserFilterCommand idLibraryUserCommand,
			TimeFilterCommand timeFilterCommand
	) {
		filterLoanCommands = new HashMap<>(
			    Map.of(
			        "idLoan", idLoanFilterCommand,
			        "idBook", idBookFilterCommand,
			        "idLibraryUser", idLibraryUserCommand,
			        "time", timeFilterCommand
			    )
		);
	}
	
	public MyLoanCommand getCommand(String field) {
		MyLoanCommand myLoanCommand = filterLoanCommands.get(field);
		if(myLoanCommand == null)
			throw new CommandNotFoundException();
		return myLoanCommand;
	}
	
}

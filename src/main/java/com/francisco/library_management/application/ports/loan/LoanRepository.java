package com.francisco.library_management.application.ports.loan;

import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends AllLoansRepository, LoanByCriteriaRepository, CreateLoanRepository, UpdateLoanRepository, DeleteLoanRepository {

}

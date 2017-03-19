package com.mtit.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mtit.exception.BalanceNotSufficientException;
import com.mtit.exception.InvalidAccountException;
import com.mtit.exception.NoAccountException;
import com.mtit.model.Account;
import com.mtit.model.AccountHolder;
import com.mtit.model.Transaction;
import com.mtit.model.User;
import com.mtit.service.AccountHolderService;
import com.mtit.service.AccountService;
import com.mtit.service.TransactionService;
import com.mtit.service.UserService;
import com.mtit.util.CombinedCommand;

@Controller
public class AccountController {

	@Autowired
	private AccountService accountService;
	@Autowired
	private AccountHolderService accountHolderService;
	@Autowired
	private TransactionService transactionService;
	@Autowired
	private UserService userService;

	@RequestMapping("/index")
	public String setupAccountHolder(Map<String, Object> map) {
		AccountHolder accountHolder = new AccountHolder();
		Account account = new Account();
		Transaction transaction = new Transaction();
		CombinedCommand combinedCommand = new CombinedCommand();
		combinedCommand.setAccount(account);
		combinedCommand.setAccountHolder(accountHolder);
		combinedCommand.setTransaction(transaction);
		map.put("CombinedCommand", combinedCommand);
		map.put("accountHolderList",
				accountHolderService.getAllAccountHolders());
		map.put("accountList", accountService.getAllAccounts());
		map.put("transactionList", transactionService.getAllTransactions());
		return "AccountHolder";
	}

	@RequestMapping(value = "/accountHolder.do", method = RequestMethod.POST)
	public String doAccountHolderActions(
			@ModelAttribute CombinedCommand combinedCommand,
			BindingResult result, @RequestParam String action,
			Map<String, Object> map) {
		AccountHolder accountHolderResult = new AccountHolder();
		Account accountResult = new Account();
		switch (action.toLowerCase()) {
		case "add":
			Date date = new Date();
			AccountHolder accountHolder = combinedCommand.getAccountHolder();
			accountHolder.setAccountNo(combinedCommand.getAccountHolder()
					.getAccountHolderId() + 1);
			accountHolderService.add(accountHolder);
			Account account = combinedCommand.getAccount();
			account.setDateStarted(date);
			accountService.add(combinedCommand.getAccount());
			accountHolderResult = combinedCommand.getAccountHolder();
			accountResult = combinedCommand.getAccount();
			break;
		case "edit":
			accountHolderService.edit(combinedCommand.getAccountHolder());
			accountHolderResult = combinedCommand.getAccountHolder();
			accountResult = combinedCommand.getAccount();
			break;
		case "delete":
			accountHolderService.delete(combinedCommand.getAccountHolder()
					.getAccountNo());
			accountHolderResult = new AccountHolder();
			accountResult = combinedCommand.getAccount();
			break;
		case "search":
			AccountHolder searchedAccountHolder = accountHolderService
					.getAccountHolder(combinedCommand.getAccountHolder()
							.getAccountNo());
			Account searchedAccount = accountService.getAccount(combinedCommand
					.getAccount().getAccountId());
			accountHolderResult = searchedAccountHolder != null ? searchedAccountHolder
					: new AccountHolder();
			accountResult = searchedAccount != null ? searchedAccount
					: new Account();
			break;
		}
		combinedCommand.setAccount(accountResult);
		combinedCommand.setAccountHolder(accountHolderResult);
		map.put("CombinedCommand", combinedCommand);
		map.put("accountHolderList",
				accountHolderService.getAllAccountHolders());
		map.put("transactionList", transactionService.getAllTransactions());
		map.put("accountList", accountService.getAllAccounts());
		return "AccountHolder";
	}

	@RequestMapping(value = "/transaction.do", method = RequestMethod.POST)
	public String doTransactionActions(
			@ModelAttribute CombinedCommand combinedCommand,
			BindingResult result, @RequestParam String action,
			Map<String, Object> map) {
		AccountHolder accountHolderResult = new AccountHolder();
		Account accountResult = new Account();
		Transaction transaction = new Transaction();
		switch (action.toLowerCase()) {
		case "deposit":
			try {
				if (transactionService.validate(combinedCommand
						.getTransaction().getTransactionAccountId(),
						combinedCommand.getTransaction()
								.getTransactionAccountHolderId())) {
					transaction = transactionService.deposit(combinedCommand
							.getTransaction().getTransactionAmount());
					transactionService.add(transaction);
				}
			} catch (InvalidAccountException | NoAccountException e1) {
				//System.out.println(" ");
			}
			accountHolderResult = accountHolderService
					.getAccountHolder(combinedCommand.getTransaction()
							.getTransactionAccountHolderId());
			accountResult = accountService.getAccount(combinedCommand
					.getTransaction().getTransactionAccountId());
			combinedCommand.setTransaction(transaction);
			break;
		case "withdraw":
			try {
				if (transactionService.validate(combinedCommand
						.getTransaction().getTransactionAccountId(),
						combinedCommand.getTransaction()
								.getTransactionAccountHolderId())) {
					transaction = transactionService.withdraw(combinedCommand
							.getTransaction().getTransactionAmount());
					transactionService.add(transaction);
				}
			} catch (InvalidAccountException | NoAccountException
					| BalanceNotSufficientException e) {
				//System.out.println(" ");
			}
			accountHolderResult = accountHolderService
					.getAccountHolder(combinedCommand.getTransaction()
							.getTransactionAccountHolderId());
			accountResult = accountService.getAccount(combinedCommand
					.getTransaction().getTransactionAccountId());
			combinedCommand.setTransaction(transaction);
			break;
		}
		combinedCommand.setAccount(accountResult);
		combinedCommand.setAccountHolder(accountHolderResult);
		map.put("CombinedCommand", combinedCommand);
		map.put("accountHolderList",
				accountHolderService.getAllAccountHolders());
		map.put("transactionList", transactionService.getAllTransactions());
		map.put("accountList", accountService.getAllAccounts());
		return "AccountHolder";
	}

	@RequestMapping("/login")
	public String setupLogin(Map<String, Object> map) {
		User user = new User();
		map.put("user", user);
		return "Login";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String doUserActions(@ModelAttribute User user,
			BindingResult result, @RequestParam String action,
			Map<String, Object> map) {
		if (userService.login(user.getUsername(), user.getPassword()) != 0) {
			return "redirect:index";
		}
		return "Login";
	}
}

# Bank Account Simulator

A Kotlin project for learning the language by simulating a simple bank account.

## Specifications

- On startup, ask the user: "Do you want to create an account or access an existing account?"
- Create an account
- Choose which existing account to access
- Delete an account (only allowed if the account balance is zero)
- Deposit money into the account
- Withdraw money from the account
- Request the current account balance
- At any time, the user can press the Escape key to quit the application
- The programme has persistent state: accounts created in a session are saved and restored the next time the programme runs

## Application Flow

```mermaid
flowchart TD
    Start[User runs the application] --> Ask[Which account would you like to access?]
    Ask --> ShowList[Show list of existing accounts]
    ShowList --> OptionA[Choose an account]
    ShowList --> OptionB[Create new account]
    OptionB --> AskName[What's the account to be called?]
    AskName --> AskBalance[What is the starting balance?]
    AskBalance --> CheckBalance{Is the balance above zero?}
    CheckBalance -- No --> AskBalance
    CheckBalance -- Yes --> AccountCreated[Account created]
    OptionA --> AccountAction[Account Action]
    AccountCreated --> AccountAction
    AccountAction --> Choice{Choose an action}
    Choice --> Deposit[Deposit]
    Choice --> Withdraw[Withdraw]
    Choice --> GetBalance[Get balance]
    Deposit --> AskDeposit[Provide deposit amount]
    AskDeposit --> CheckDeposit{Is the amount above zero?}
    CheckDeposit -- No --> AskDeposit
    CheckDeposit -- Yes --> ActionDone[Action completed]
    Withdraw --> AskWithdraw[Provide withdrawal amount]
    AskWithdraw --> CheckWithdraw{Is the amount above zero?}
    CheckWithdraw -- No --> AskWithdraw
    CheckWithdraw -- Yes --> ActionDone
    GetBalance --> ShowBalance[Show account balance]
    ShowBalance --> ActionDone
    ActionDone --> Continue{Continue or quit?}
    Continue -- Continue --> AccountAction
    Continue -- Quit --> End[Quit]
```

## Future Enhancements

- Use Asker as an external dependency for more pleasant command-line input

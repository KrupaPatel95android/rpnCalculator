//A high-level description of your solution
//    Input: The function takes an array of strings (tokens), where each string is either an operand (a number) or an operator (+, -, *, /).
//    Stack-Based Evaluation:
//    It uses a stack to evaluate the expression.
//    Operands are pushed onto the stack.
//    When an operator is encountered, the function pops the required number of operands from the stack, applies the operator, and pushes the result back onto the stack.
//    Final Result: After processing all tokens, the stack should contain exactly one element, which is the result of the expression.
//    Example
//    Given the input arrayOf("-3", "-2", "*", "5", "+"), the evalRPN function:
//
//    Pushes -3.0 and -2.0 onto the stack.
//    Pops -2.0 and -3.0, Multiply them (6.0), and pushes the result onto the stack.
//    Pushes 5.0 onto the stack.
//    Pops 5.0 and 6.0, add them (11.0), and pushes the result onto the stack.
//    The final result is 11.0.


//Reasoning behind your technical choices, including architectural
1. Use of Kotlin

Kotlin was chosen as the programming language for this project due to its concise syntax, modern features, and strong support for Android development. Kotlin's interoperability with Java and its expressive language features (such as data classes, lambda expressions, and extension functions) make it an ideal choice for developing clean and maintainable Android applications.

2. Reverse Polish Notation (RPN) Calculator

The choice to implement an RPN calculator is rooted in the desire to demonstrate a stack-based algorithm in a practical and real-world scenario. RPN simplifies the process of mathematical expression evaluation, avoiding the need for parentheses and respecting operator precedence by design. This makes it a great candidate for a small but insightful Android project.

3. MVVM (Model-View-ViewModel) Architecture

The project follows the MVVM architecture, which is a well-established design pattern in Android development:

Model: Encapsulates the data and business logic. In this case, it includes the ResultListUIModel and ResultListItemUIModel data classes that represent the results of RPN calculations.
ViewModel: Acts as a bridge between the View and Model. It holds the application state and provides methods for updating this state. The ViewModel is responsible for managing the list of ResultListItemUIModel objects and the evaluation of RPN expressions.
View: Built using Jetpack Compose, it observes state changes in the ViewModel and updates the UI reactively. This separation of concerns ensures that the UI remains decoupled from the business logic and data management, making the code easier to maintain and test.

4. Jetpack Compose for UI
Jetpack Compose was chosen for building the user interface because it provides a modern, declarative way to create Android UIs. It allows developers to describe the UI in code, making it more intuitive and less prone to errors compared to traditional XML-based UI design. Additionally, Compose integrates seamlessly with ViewModel and StateFlow, enabling reactive and state-driven UI updates.

5. StateFlow for State Management
StateFlow is used for state management within the ViewModel. It is part of Kotlin's coroutines library and provides a reactive way to manage and observe application state. Unlike LiveData, StateFlow offers better support for Kotlin's coroutines and is more versatile, making it the preferred choice for managing UI state in a Compose-based project.

Immutable State: By using StateFlow, the state in the ViewModel is immutable from the UI's perspective, ensuring that the UI can only observe state changes but not modify them directly.
Reactive UI: StateFlow ensures that the UI reacts to changes in state automatically, providing a smooth and responsive user experience.

6. Data Classes for Structured Data
Kotlin data classes (ResultListUIModel and ResultListItemUIModel) were chosen to represent the results of RPN calculations. Data classes provide a concise and readable way to define models that hold data. They automatically generate common functionality such as equals(), hashCode(), and toString(), making them ideal for handling and displaying structured data in a clean and efficient manner.

7. evalRPN Function Design
The evalRPN function is a core component of the application, responsible for evaluating RPN expressions. It uses a stack-based approach:

Stack-Based Logic: The use of a mutable list as a stack allows the function to handle the evaluation process efficiently. Each operand is pushed onto the stack, and operators trigger the popping of operands, applying the operator, and pushing the result back onto the stack.
Safety and Simplicity: The function is designed to be simple yet robust, ensuring that it handles various edge cases, such as division by zero or malformed expressions, gracefully.

8. LazyColumn for Dynamic Lists
The LazyColumn component in Jetpack Compose is used to display the list of RPN calculation results. It is ideal for rendering lists with potentially large or dynamic data sets, as it efficiently recycles and reuses UI elements, reducing memory usage and improving performance.

//How to run code
-This is open application. pull code into android studio and run on device. 
I added test case inside viewModel so can run directly.





#include <iostream>
#include <limits>

class MathCalculator {
private:
    std::string operatorN;
    float operator1;
    float operator2;

public:
    float mathOperations(float operator1, float operator2, std::string operatorN) {
        if(operatorN == "+") {
            return operator1 + operator2;
        }

        if(operatorN == "-") {
            return operator1 - operator2;
        }

        if(operatorN == "*") {
            return operator1 * operator2;
        }

        if(operatorN == "/") {
            if(operator2 != 0) {
                return operator1 / operator2;
            } else {
                std::cerr << "Error: Division by Zero!\n";
                return 0;
            }
        }
        return 0;
    }

    float getValidNumber(const std::string& prompt) {
        float number;
        int attempts = 3;
        while(attempts > 0) {
            std::cout << prompt;
            std::cin >> number;
            
            if(std::cin.fail()) {
                std::cin.clear();
                std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
                std::cout << "Invalid input. Please enter a valid number. \n";
                attempts--;
            } else {
                return number;
            }
        }
        std::cerr << "Too many invalid attempts. Exiting... \n";
        exit(1);
    }

    std::string getValidOperator() {
        std::string op;
        int attempts = 3;
        while(attempts > 0) {
            std::cout << "Select an operator (+, -, *, /): ";
            std::cin >> op;
            if (op == "+" || op == "-" || op == "*" || op == "/") {
                return op;
            } else {
                std::cout << "Invalid operator. Please enter +, -, * or /: \n";
                attempts--;
            }
        }
        std::cerr << "Too many invalid attempts. Exiting...\n";
        exit(1);
    }


};

int main() {
    MathCalculator math;

    float num1 = math.getValidNumber("Enter the first number: ");
    float num2 = math.getValidNumber("Enter the second number: ");
    std::string op = math.getValidOperator();

    float result = math.mathOperations(num1, num2, op);

    std::cout << "Result: " << result << std::endl;

    return 0;
}


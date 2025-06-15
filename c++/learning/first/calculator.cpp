#include <iostream>

class MathCalulator {
private:
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
            if(operator2 != 0){
                return operator1 / operator2;
            } else {
                std::cerr << "Error: Division by Zero!" << std::endl;
                return 0;
            }
        }
    };

    void display() {
        std::cout << "Select one operator" << "\n";
        std::cout << "| 1. + | 2. - | 3. * | 4. / |";
    }

};

int main() {
    MathCalulator calc;
    float num1, num2;
    std::string op;

    calc.display();

    std::cout << "\nEnter the First number: ";
    std::cin >> num1;

    std::cout << "\nEnter Operator: ";
    std::cin >> op;

    std::cout << "\nEnter the Second number: ";
    std::cin >> num2;

	float result = calc.mathOperations(num1, num2, op);

    std::cout << "Result: " << result << std::endl;

	return 0;
}
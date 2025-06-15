#include "Parser.h"
#include "Lexer.h"
#include <iostream>

int main() {
    std::string input = "3 + 5 + 2";
    Lexer lexer(input);
    Parser parser(lexer);

    try {
        std::unique_ptr<ASTNode> result = parser.parse();
        std::cout << "Parsing successful!" << std::endl;
    }
    catch (const std::exception& e) {
        std::cerr << "Error: " << e.what() << std::endl;
    }

    return 0;
}

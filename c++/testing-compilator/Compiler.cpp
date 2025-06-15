#include <iostream>
#include "Lexer.cpp"
#include "Parser.cpp"
#include "Interpreter.cpp"

int main() {
    std::string code = "3 + 5";
    Lexer lexer(code);
    Parser parser(lexer);
    std::unique_ptr<ASTNode> tree = parser.parse();

    Interpreter interpreter;
    int result = interpreter.visit(tree);

    std::cout << "Resultado: " << result << std::endl;
    return 0;
}

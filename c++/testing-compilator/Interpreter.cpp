#include <memory>
#include "Parser.cpp"

class Interpreter {
public:
    int visit(std::unique_ptr<ASTNode>& node) {
        if (auto number = dynamic_cast<NumberNode*>(node.get())) {
            return std::stoi(number->value);
        }

        if (auto bin_op = dynamic_cast<BinOpNode*>(node.get())) {
            if (bin_op->op == "+") {
                return visit(bin_op->left) + visit(bin_op->right);
            }
        }

        throw std::runtime_error("Erro na interpretação");
    }
};

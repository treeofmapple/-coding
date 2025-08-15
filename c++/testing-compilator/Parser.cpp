#include "Parser.h"
#include <stdexcept>

NumberNode::NumberNode(std::string val) : value(val) {}

BinOpNode::BinOpNode(std::unique_ptr<ASTNode> left, std::string op, std::unique_ptr<ASTNode> right)
    : left(std::move(left)), op(op), right(std::move(right)) {}

Parser::Parser(Lexer lexer) : lexer(lexer) {
    current_token = lexer.get_next_token();
}

void Parser::eat(TokenType type) {
    if (current_token.type == type) {
        current_token = lexer.get_next_token();
    }
    else {
        throw std::runtime_error("Erro de sintaxe");
    }
}

std::unique_ptr<ASTNode> Parser::factor() {
    std::unique_ptr<ASTNode> node = std::make_unique<NumberNode>(current_token.value);
    eat(TOKEN_INT);
    return node;
}

std::unique_ptr<ASTNode> Parser::expr() {
    auto node = factor();
    while (current_token.type == TOKEN_PLUS) {
        std::string op = current_token.value;
        eat(TOKEN_PLUS);
        node = std::make_unique<BinOpNode>(std::move(node), op, factor());
    }
    return node;
}

std::unique_ptr<ASTNode> Parser::parse() {
    return expr();
}
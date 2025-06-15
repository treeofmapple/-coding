#ifndef PARSER_H
#define PARSER_H

#include "Lexer.h"
#include <memory>

class ASTNode {
public:
    virtual ~ASTNode() = default;
};

class NumberNode : public ASTNode {
public:
    std::string value;
    NumberNode(std::string val);
};

class BinOpNode : public ASTNode {
public:
    std::unique_ptr<ASTNode> left;
    std::string op;
    std::unique_ptr<ASTNode> right;

    BinOpNode(std::unique_ptr<ASTNode> left, std::string op, std::unique_ptr<ASTNode> right);
};

class Parser {
    Lexer lexer;
    Token current_token;

public:
    Parser(Lexer lexer);
    std::unique_ptr<ASTNode> parse();

private:
    void eat(TokenType type);
    std::unique_ptr<ASTNode> factor();
    std::unique_ptr<ASTNode> expr();
};

#endif // PARSER_H

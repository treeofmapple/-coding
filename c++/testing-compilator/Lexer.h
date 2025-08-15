#ifndef LEXER_H
#define LEXER_H

#include <string>

enum TokenType { TOKEN_INT, TOKEN_PLUS, TOKEN_EOF };

struct Token {
    TokenType type;
    std::string value;
};

class Lexer {
    std::string input;
    size_t pos;
    char current_char;

public:
    Lexer(std::string src);
    Token get_next_token();

private:
    void advance();
    std::string integer();
};

#endif 

#include "Lexer.h"
#include <cctype>
#include <stdexcept>

Lexer::Lexer(std::string src) : input(src), pos(0) {
    current_char = input[pos];
}

void Lexer::advance() {
    pos++;
    if (pos < input.size()) {
        current_char = input[pos];
    }
    else {
        current_char = '\0';  // EOF
    }
}

std::string Lexer::integer() {
    std::string result;
    while (isdigit(current_char)) {
        result += current_char;
        advance();
    }
    return result;
}

Token Lexer::get_next_token() {
    while (current_char != '\0') {
        if (isspace(current_char)) {
            advance();
            continue;
        }

        if (isdigit(current_char)) {
            return Token{ TOKEN_INT, integer() };
        }

        if (current_char == '+') {
            advance();
            return Token{ TOKEN_PLUS, "+" };
        }

        throw std::runtime_error("Caractere inválido");
    }

    return Token{ TOKEN_EOF, "" };
}

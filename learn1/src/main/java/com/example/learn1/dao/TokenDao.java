package com.example.learn1.dao;

import com.example.learn1.modle.Token;

public interface TokenDao {
    void addToken(Token token);
    void updateToken(Token token);
    Token findTokenByUserId(long userId);
    Token findTokenByToken(String token);
}

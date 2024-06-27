package com.eurekaclient.apibot.service.handler;

import com.eurekaclient.apibot.bot.Bot;
import com.eurekaclient.apibot.repository.UserRepository;
import com.eurekaclient.apibot.service.contract.AbstractHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.interfaces.BotApiObject;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
@RequiredArgsConstructor
public class MessageHandler extends AbstractHandler {
    private final UserRepository userRepository;

    @Override
    public BotApiMethod<?> answer(BotApiObject object, Bot bot) throws TelegramApiException {
        return null;
    }
}

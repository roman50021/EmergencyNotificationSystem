package com.eurekaclient.apibot.service.manager;

import com.eurekaclient.apibot.bot.Bot;
import com.eurekaclient.apibot.service.contract.AbstractManager;
import com.eurekaclient.apibot.service.contract.CommandListener;
import com.eurekaclient.apibot.service.contract.QueryListener;
import com.eurekaclient.apibot.service.factory.KeyboardFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
@RequiredArgsConstructor
public class MainManager extends AbstractManager implements CommandListener, QueryListener {
    private final KeyboardFactory keyboardFactory;

    @Override
    public BotApiMethod<?> mainMenu(Message message, Bot bot) {
        return null;
    }

    @Override
    public BotApiMethod<?> mainMenu(CallbackQuery query, Bot bot) {
        return null;
    }

    @Override
    public BotApiMethod<?> answerCommand(Message message, Bot bot) {
        return greetings(message.getChatId());
    }

    @Override
    public BotApiMethod<?> answerQuery(CallbackQuery query, String[] words, Bot bot) throws TelegramApiException {
        return null;
    }

    private BotApiMethod<?> greetings(Long chatId){
        return SendMessage.builder()
                .chatId(chatId)
                .text("Hello, my dear friend!")
                .build();
    }
}

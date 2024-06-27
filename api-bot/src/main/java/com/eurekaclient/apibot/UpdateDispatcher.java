package com.eurekaclient.apibot;

import com.eurekaclient.apibot.bot.Bot;
import com.eurekaclient.apibot.model.Action;
import com.eurekaclient.apibot.model.User;
import com.eurekaclient.apibot.repository.UserRepository;
import com.eurekaclient.apibot.service.handler.CallbackQueryHandler;
import com.eurekaclient.apibot.service.handler.CommandHandler;
import com.eurekaclient.apibot.service.handler.MessageHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
//Расспредиляем обновления внутри нашего приложения
public class UpdateDispatcher {
    private final MessageHandler messageHandler;
    private final CommandHandler commandHandler;
    private final CallbackQueryHandler queryHandler;
    private final UserRepository userRepository;

    public BotApiMethod<?> distribute(Update update, Bot bot) {
        try {
            if (update.hasCallbackQuery()) {
                checkUser(update.getCallbackQuery().getMessage().getChatId());
                return queryHandler.answer(update.getCallbackQuery(), bot);
            }
            if (update.hasMessage()) {
                var message = update.getMessage();
                checkUser(message.getChatId());
                if (message.hasText()) {
                    if (message.getText().charAt(0) == '/') {
                        return commandHandler.answer(message, bot);
                    }
                    return messageHandler.answer(message, bot);
                }
            }
            log.warn("Unsupported update type: " + update);
        } catch (TelegramApiException e) {
            log.error(e.getMessage());
        }
        return null;
    }

    private void checkUser(Long chatId) {
        if(userRepository.existsByChatId(chatId)){
            return;
        }
        userRepository.save(
                User.builder()
                        .action(Action.FREE)
                        .registeredAt(LocalDateTime.now())
                        .chatId(chatId)
                        .firstName("Yo")
                        .build()
        );
    }

}

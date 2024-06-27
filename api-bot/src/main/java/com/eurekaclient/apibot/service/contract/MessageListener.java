package com.eurekaclient.apibot.service.contract;

import com.eurekaclient.apibot.bot.Bot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public interface MessageListener {
    BotApiMethod<?> answerMessage(Message message, Bot bot) throws TelegramApiException;
}

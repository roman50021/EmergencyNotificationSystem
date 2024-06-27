package com.eurekaclient.apibot.bot;

import com.eurekaclient.apibot.UpdateDispatcher;
import com.eurekaclient.apibot.config.TelegramProperties;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public final class Bot extends TelegramWebhookBot {
    private final TelegramProperties telegramProperties;
    private final UpdateDispatcher updateDispatcher;

    public Bot(TelegramProperties telegramProperties, UpdateDispatcher updateDispatcher) {
        super(telegramProperties.getToken());
        this.telegramProperties = telegramProperties;
        this.updateDispatcher = updateDispatcher;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return updateDispatcher.distribute(update, this);
    }

    @Override
    public String getBotPath() {
        return telegramProperties.getUel();
    }

    @Override
    public String getBotUsername() {
        return telegramProperties.getName();
    }
}

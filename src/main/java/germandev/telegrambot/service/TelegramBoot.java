package germandev.telegrambot.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class TelegramBoot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "notasapp_bot";
    }

    @Override
    public String getBotToken() {
        return "5776347365:AAHTrG7-l2ncX-KwLsX70XZRAEUDap5Tt_s";
    }


    @Override
    public void onUpdateReceived(Update update) {
        //se obitiene el mensaje escrito por el usuario

        final String messageTextReceived = update.getMessage().getText();
        System.out.println("Escribieron en el bot" + messageTextReceived);

        //Se obitnee el id de chat del usuario

        final long chatId = update.getMessage().getChatId();

        //Se crea un objeto mensaje
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Gracias por escribirnos" + chatId);

        try{
            //Se envia el mensaje
            execute(sendMessage);
        }catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}

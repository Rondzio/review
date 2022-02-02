package com.udacity.jwdnd.c1.review.controller;

import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.service.MessageService;
import com.udacity.jwdnd.c1.review.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChatController {

    private MessageService messageService;
    private UserService userService;

    public ChatController(MessageService messageService, UserService userService) {
        this.messageService = messageService;
        this.userService = userService;
    }

    @GetMapping("/chat")
    public String getChatPage(@ModelAttribute ChatForm chatForm, Model model) {
        model.addAttribute("messages", messageService.getMessages());
        return "chat";
    }

    @PostMapping("/chat")
    public String saveChatPage(Authentication authentication, @ModelAttribute ChatForm chatForm, Model model) {
        String currentUser = authentication.getName();
        chatForm.setUserName(currentUser);
        messageService.addMessage(chatForm);
        chatForm.setMessageText("");
        model.addAttribute("messages", messageService.getMessages());
        return "chat";
    }

    @ModelAttribute("allMessageTypes")
    public String[] allMessageTypes () {
        return new String[] { "Say", "Shout", "Whisper", "Another" };
    }

}

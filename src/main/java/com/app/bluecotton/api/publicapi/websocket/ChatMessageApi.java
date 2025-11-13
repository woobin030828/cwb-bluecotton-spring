package com.app.bluecotton.api.publicapi.websocket;

import com.app.bluecotton.domain.vo.chat.ChatMemberVO;
import com.app.bluecotton.domain.vo.chat.ChatMessageVO;
import com.app.bluecotton.service.ChatMemberService;
import com.app.bluecotton.service.ChatMessageService;
import com.app.bluecotton.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ChatMessageApi {
    private final ChatMessageService chatMessageService;
    private final ChatService chatService;
    private final SimpMessagingTemplate simpMessagingTemplate;
    private final ChatMemberService chatMemberService;

    @MessageMapping("/chat/send")
    public void sendMessage(ChatMessageVO chatMessageVO) {
        log.info("받은 메시지: {}", chatMessageVO);
        ChatMemberVO chatMemberVO = new ChatMemberVO(chatMessageVO);

        // 1. 메세지 처리
        if(chatMessageVO.getChatMessageType().equals("JOIN")){
            chatMemberService.createChatMember(chatMemberVO);
        }else if(chatMessageVO.getChatMessageType().equals("LEAVE")){
            chatMemberService.delete(chatMemberVO);
        }else if(chatMessageVO.getChatMessageType().equals("MESSAGE")){
            chatMessageService.insert(chatMessageVO);
        }

        // 2. 브로드캐스트
        if (chatMessageVO.getChatMessageReceiverId() == null) {
            // 공용 메시지 → 방 전체에게 전송
            simpMessagingTemplate.convertAndSend(
                    "/sub/chat/room/" + chatMemberVO.getChatId(),
                    chatMemberVO
            );
        } else {
            // 1:1 메시지 → 특정 사용자에게 전송
            simpMessagingTemplate.convertAndSend(
                    "/sub/chat/room/" + chatMessageVO.getChatId() + "/" + chatMessageVO.getChatMessageReceiverId(),
                    chatMemberVO
            );
        }
    }
}

package JavaProject.Dayoung.infra.openai.domain;

import JavaProject.Dayoung.infra.openai.ChattingType;
import io.github.flashvayne.chatgpt.dto.chat.MultiChatMessage;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", nullable = false)
    private ChattingType type;

    @Column(name = "NAME", columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

    public MultiChatMessage toMultiChatMessage() {
        return new MultiChatMessage(getType().getName(), getContent());
    }

    public static ChatMessage fromUser(String content) {
        return getBuild(ChattingType.USER, content);
    }

    public static ChatMessage fromGPT(String content) {
        return getBuild(ChattingType.CHATGPT, content);
    }

    public static ChatMessage fromSystem(String content) {
        return getBuild(ChattingType.SYSTEM, content);
    }

    private static ChatMessage getBuild(ChattingType type, String content) {
        return ChatMessage.builder()
            .type(type)
            .content(content)
            .createdAt(LocalDateTime.now())
            .build();
    }
}

package ru.sberbank.hibernate.task.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.*;

import lombok.*;

@Entity
@ToString
@Table(name = "BASE_QUOTE")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class BaseQuote implements Serializable {
    //@Id
    @EmbeddedId
    private BaseQuote.QuoteKey key;
    private String symbol;
    @Embedded
    private BaseQuote.QuotePrice price;

    @Embeddable
    @Getter @Setter @NoArgsConstructor @EqualsAndHashCode //Важно переопределить equals() hashCode
    public static class QuoteKey implements Serializable {
        private String id;
        private LocalDateTime timestamp;

        public QuoteKey(LocalDateTime timestamp) {
            this.id = UUID.randomUUID().toString();
            this.timestamp = timestamp;
        }
    }

    @Embeddable
    @Getter @Setter @AllArgsConstructor @NoArgsConstructor
    public static class QuotePrice implements Serializable {
        private Long bid;
        private Long offer;
    }

}

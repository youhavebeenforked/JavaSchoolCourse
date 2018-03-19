package ru.sberbank.hibernate.task.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class BaseQuote implements Serializable {
    private QuoteKey key;
    private String symbol;
    private QuotePrice price;

    @Getter @Setter @NoArgsConstructor @EqualsAndHashCode //Важно переопределить equals() hashCode
    public static class QuoteKey implements Serializable {
        private String id;
        private LocalDateTime timestamp;

        public QuoteKey(LocalDateTime timestamp) {
            this.id = UUID.randomUUID().toString();
            this.timestamp = timestamp;
        }
    }

    @Getter @Setter @AllArgsConstructor @NoArgsConstructor
    public static class QuotePrice implements Serializable {
        private Long bid;
        private Long offer;
    }


}

package volodko.ksenia.enums.convertors;

import volodko.ksenia.enums.GameStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class GameStatusConverter implements AttributeConverter<GameStatus, String> {
    @Override
    public String convertToDatabaseColumn(GameStatus attribute) {
        switch (attribute) {
            case NOTSTARTED:
                return "NOTSTARTED";
            case NOW:
                return "NOW";
            case OVER:
                return  "OVER";
            default:
                throw new IllegalArgumentException("Unknown" + attribute);
        }
    }

    @Override
    public GameStatus convertToEntityAttribute(String dbData) {
        switch (dbData) {
            case "NOTSTARTED":
                return GameStatus.NOTSTARTED;
            case "OVER":
                return GameStatus.OVER;
            case "NOW":
                return GameStatus.NOW;
            default:
                throw new IllegalArgumentException("Unknown " + dbData);
        }
    }
}

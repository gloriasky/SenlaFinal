package volodko.ksenia.enums.convertors;

import volodko.ksenia.enums.PlayerStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class PlayerStatusConverter implements AttributeConverter<PlayerStatus, String> {

    @Override
    public String convertToDatabaseColumn(PlayerStatus attribute) {
        switch (attribute) {
            case PLAY:
                return "PLAY";
            case ILL:
                return "ILL";
            default:
                throw new IllegalArgumentException("Unknown" + attribute);
        }
    }

    @Override
    public PlayerStatus convertToEntityAttribute(String dbData) {
        switch (dbData) {
            case "PLAY":
                return PlayerStatus.PLAY;
            case "ILL":
                return PlayerStatus.ILL;
            case "0":return PlayerStatus.PLAY;
            case "1":return PlayerStatus.ILL;
            default:
                throw new IllegalArgumentException("Unknown " + dbData);
        }
    }
}
package volodko.ksenia.enums.convertors;


import volodko.ksenia.enums.CoachStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class CoachStatusConverter implements AttributeConverter<CoachStatus, String> {

    @Override
    public String convertToDatabaseColumn(CoachStatus attribute) {
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
    public CoachStatus convertToEntityAttribute(String dbData) {
        switch (dbData) {
            case "PLAY":
                return CoachStatus.PLAY;
            case "ILL":
                return CoachStatus.ILL;
            case "0":return CoachStatus.PLAY;
            case "1":return CoachStatus.ILL;
            default:
                throw new IllegalArgumentException("Unknown " + dbData);
        }
    }
}
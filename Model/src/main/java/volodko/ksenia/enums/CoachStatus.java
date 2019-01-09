package volodko.ksenia.enums;

public enum CoachStatus {
    PLAY(0),
    ILL(1),
    ;

    CoachStatus(int i) {

    }
    CoachStatus getStatus(int i){
        switch (i){
            case 0: return PLAY;
            case 1: return ILL;
            default:return PLAY;
        }
    }
}

package volodko.ksenia.enums;

public enum PlayerStatus {
    PLAY(0),
    ILL(1),
    ;

    PlayerStatus(int i) {

    }
    PlayerStatus getStatus(int i){
        switch (i){
            case 0: return PLAY;
            case 1: return ILL;
            default:return PLAY;
        }
    }
}

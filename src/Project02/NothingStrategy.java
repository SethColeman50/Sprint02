package Project02;

public class NothingStrategy implements Strategy{

    @Override
    public int strategy(People me, People otherPerson) {
        return 0;
    }
}

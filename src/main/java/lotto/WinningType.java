package lotto;

public class WinningType {

    private int rank;
    private int sameCount;
    private int prize;
    private boolean hasBonus;

    public WinningType(int rank, int sameCount, int prize, boolean hasBonus) {
        this.rank = rank;
        this.sameCount = sameCount;
        this.prize = prize;
        this.hasBonus = hasBonus;
    }

    public int getRank() {
        return rank;
    }

    public int getPrize() {
        return prize;
    }

    public int getSameCount() {
        return sameCount;
    }

    public boolean hasBonus() {
        return hasBonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WinningType)) {
            return false;
        }
        WinningType winningType = (WinningType) o;
        return prize == winningType.prize;
    }
}
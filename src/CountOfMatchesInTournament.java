/**
 * @author 罗文俊
 * 2022/1/25
 */
public class CountOfMatchesInTournament {
    public static void main(String[] args) {

    }
}

class CountOfMatchesInTournamentSolution1 {
    /**
     * 思路非常好理解，最终只有一只队伍胜出，其余 n - 1 只队伍无法晋级，那么将会有 n - 1 次比赛淘汰掉这些队伍
     */
    public int numberOfMatches(int n) {
        return n - 1;
    }
}

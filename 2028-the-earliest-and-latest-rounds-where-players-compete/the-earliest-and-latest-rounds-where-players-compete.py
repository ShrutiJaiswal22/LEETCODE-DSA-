from typing import List
from functools import lru_cache

class Solution:
    def earliestAndLatest(self, n: int, firstPlayer: int, secondPlayer: int) -> List[int]:
        @lru_cache(None)
        def dfs(players: tuple) -> tuple[int, int]:
            round_num = 1
            a, b = players.index(firstPlayer), players.index(secondPlayer)
            if a + b == len(players) - 1:
                return (1, 1)
            min_round, max_round = float('inf'), 0
            next_round = []

            def simulate(i: int, j: int, current: List[int]):
                if i > j:
                    next_rounds.append(tuple(sorted(current)))
                    return
                if i == j:
                    current.append(players[i])
                    simulate(i + 1, j - 1, current)
                    current.pop()
                    return
                p1, p2 = players[i], players[j]
                if {p1, p2} == {firstPlayer, secondPlayer}:
                    return
                elif p1 in {firstPlayer, secondPlayer}:
                    current.append(p1)
                    simulate(i + 1, j - 1, current)
                    current.pop()
                elif p2 in {firstPlayer, secondPlayer}:
                    current.append(p2)
                    simulate(i + 1, j - 1, current)
                    current.pop()
                else:
                    current.append(p1)
                    simulate(i + 1, j - 1, current)
                    current.pop()
                    current.append(p2)
                    simulate(i + 1, j - 1, current)
                    current.pop()

            next_rounds = []
            simulate(0, len(players) - 1, [])
            for nxt in next_rounds:
                er, lr = dfs(nxt)
                min_round = min(min_round, er + 1)
                max_round = max(max_round, lr + 1)
            return (min_round, max_round)

        # Initial call with tuple of players in order
        return list(dfs(tuple(range(1, n + 1))))




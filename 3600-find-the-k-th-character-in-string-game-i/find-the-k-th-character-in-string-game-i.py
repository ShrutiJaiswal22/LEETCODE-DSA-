class Solution:
    def kthCharacter(self, k: int) -> str:
        word = ['a']
        while len(word) < k:
            new_part = []
            for ch in word:
                # Calculate next character in cyclic manner (z → a)
                new_char = chr((ord(ch) - ord('a') + 1) % 26 + ord('a'))
                new_part.append(new_char)
            word.extend(new_part)
        return word[k - 1]

# Example usage:
# sol = Solution()
# print(sol.kthCharacter(5))   # Output: "b"
# print(sol.kthCharacter(10))  # Output: "c"

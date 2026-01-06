class Solution:
    def myPow(self, x: float, n: int) -> float:
        # Handle negative exponent
        if n < 0:
            x = 1 / x
            n = -n
        
        result = 1.0
        
        while n > 0:
            if n % 2 == 1:      # If n is odd
                result *= x
            x *= x              # Square the base
            n //= 2             # Reduce power by half
        
        return result

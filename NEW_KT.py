class KL {
    class money {
        private var amnt: Double = 0.0
        private var curr: String = "Rs. "

        constructor() {
            this.amnt = 0.0
            this.curr = "Rs. "
        }

        constructor(amnt: Double) {
            this.amnt = if (not(amnt)) 0.0 else amnt
            this.curr = "Rs. "
        }

        constructor(amnt: Double, curr: String) {
            this.amnt = if (not(amnt) || isinf(amnt)) 0.0 else amnt
            this.curr = if (not(this.curr) || this.curr.length < 1 || this.curr.length > 4) "Rs. " else titleCase(curr)
        }

        fun curr(curr: String): money {
            this.curr = if (not(curr) || curr.length < 1 || curr.length > 4) "Rs. " else titleCase(curr)
            return this
        }

        fun amount(newAmnt: Double): money {
            this.amnt = if (isinf(newAmnt)) this.amnt else newAmnt
            return this
        }

        fun set(newAmnt: Double): money {
            amount(newAmnt)
            return this
        }

        fun add(vararg nums: Double): money {
            each(nums) { n, _ -> this.amnt += n }
            return this
        }

        fun give(vararg nums: Double): money {
            add(*nums)
            return this
        }

        fun plus(vararg nums: Double): money {
            add(*nums)
            return this
        }

        fun deposit(vararg nums: Double): money {
            add(*nums)
            return this
        }

        fun minus(vararg nums: Double): money {
            each(nums) { n, _ -> this.amnt -= n }
            return this
        }

        fun take(vararg nums: Double): money {
            minus(*nums)
            return this
        }

        fun sub(vararg nums: Double): money {
            minus(*nums)
            return this
        }

        fun withdraw(vararg nums: Double): money {
            minus(*nums)
            return this
        }

        fun times(vararg nums: Double): money {
            each(nums) { n, _ -> this.amnt *= n }
            return this
        }

        fun mul(vararg nums: Double): money {
            times(*nums)
            return this
        }

        fun div(vararg nums: Double): money {
            each(nums) { n, _ -> this.amnt /= n }
            return this
        }

        fun quotient(vararg nums: Double): money {
            div(*nums)
            return this
        }

        fun suffix(vararg bools: Boolean): String {
            val forceInternational = if (bools.isNotEmpty()) bools[0] else false
            this.curr = trim(this.curr) + " "
            return when {
                in(this.curr, "pk|in|rs") -> "Rs. " + (if (forceInternational) ussuffix(amnt) else pksuffix(amnt))
                in(this.curr, "us") -> "USD " + ussuffix(amnt)
                else -> this.curr + (if (forceInternational || (is(this.curr) && !in(this.curr, "pk|in|rs"))) ussuffix(amnt) else pksuffix(amnt))
            }
        }

        override fun toString(): String {
            this.curr = trim(this.curr) + " "
            return when {
                not(this.curr) || in(this.curr, "pk|in|rs") -> pkr(amnt)
                in(this.curr, "us") -> usd(amnt)
                else -> this.curr + f(amnt)
            }
        }

        fun toString(suffixMode: Boolean): String {
            return if (suffixMode) suffix() else toString()
        }

        fun string(): String {
            return toString()
        }

        fun str(): String {
            return string()
        }

        fun string(suffixMode: Boolean): String {
            return toString(suffixMode)
        }

        fun str(suffixMode: Boolean): String {
            return string(suffixMode)
        }

        fun balance(): String {
            return toString()
        }

        fun balance(suffixMode: Boolean): String {
            return toString(suffixMode)
        }

        fun bal(): String {
            return toString()
        }

        fun bal(suffixMode: Boolean): String {
            return toString(suffixMode)
        }

        fun total(): String {
            return toString()
        }

        fun total(suffixMode: Boolean): String {
            return toString(suffixMode)
        }
    }

    class pesa : money {
        constructor() : super() {
            super.amnt = 0.0
            super.curr = "Rs. "
        }

        constructor(amnt: Double) : super(amnt) {
            super.amnt = if (isinf(amnt)) 0.0 else amnt
            super.curr = "Rs. "
        }

        constructor(amnt: Double, curr: String) : super(amnt, curr) {
            super.amnt = if (not(amnt) || isinf(amnt)) 0.0 else amnt
            super.curr = if (not(super.curr) || super.curr.length < 1 || super.curr.length > 4) "Rs. " else titleCase(curr)
        }
    }
}

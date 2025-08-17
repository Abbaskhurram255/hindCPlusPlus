import java.io.*
import java.nio.file.*
import java.nio.charset.*
import java.security.*
import javax.crypto.*
import javax.crypto.spec.*
import java.text.*
import java.util.*
import java.util.TreeMap.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import java.lang.reflect.*
import java.net.*
open class KL() {
    open class money {
        var amnt: Double = 0.0
        var curr: String = ""
        internal constructor() {
            amnt = 0.0
            curr = "Rs. "
        }
        internal constructor(amnt: Double) {
            this.amnt = if (not(amnt)) 0.0 else amnt
            curr = "Rs. "
        }
        internal constructor(amnt: Double, curr: String) {
            this.amnt = if (not(amnt) || isinf(amnt)) 0.0 else amnt
            this.curr = if (not(this.curr) || len(this.curr) < 1 || len(this.curr) > 4) "Rs. " else titleCase(curr)
        }
        fun curr(curr: String): money {
            this.curr = if (not(curr) || len(curr) < 1 || len(curr) > 4) "Rs. " else titleCase(curr)
            return this
        }
        fun amount(newAmnt: Double): money {
            amnt = if (isinf(newAmnt)) amnt else newAmnt
            return this
        }
        fun set(newAmnt: Double): money {
            amount(newAmnt)
            return this
        }
        fun add(vararg nums: Double): money {
            each(nums, ObjIntConsumer<Double> { n: Double, _: Int -> amnt += n })
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
            each(nums, ObjIntConsumer<Double> { n: Double, _: Int -> amnt -= n })
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
            each(nums, ObjIntConsumer<Double> { n: Double, _: Int -> amnt *= n })
            return this
        }
        fun mul(vararg nums: Double): money {
            times(*nums)
            return this
        }
        fun div(vararg nums: Double): money {
            each(nums, ObjIntConsumer<Double> { n: Double, _: Int -> amnt /= n })
            return this
        }
        fun quotient(vararg nums: Double): money {
            div(*nums)
            return this
        }
        fun suffix(vararg bools: Boolean): String {
            val forceInternational = if (bools.size > 0) bools[0] else false
            curr = trim(curr) + " "
            if (`in`(curr, "pk|in|rs")) return "Rs. " + if (forceInternational) ussuffix(amnt) else pksuffix(amnt)
            return if (`in`(curr, "us")) "USD " + ussuffix(amnt) else curr + (if ((forceInternational
                        || (`is`(curr) && !`in`(curr, "pk|in|rs")))) ussuffix(amnt) else pksuffix(amnt))
        }
        override fun toString(): String {
            curr = trim(curr) + " "
            if (not(curr) || `in`(curr, "pk|in|rs")) return pkr(amnt)
            return if (`in`(curr, "us")) usd(amnt) else curr + f(amnt)
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
        internal constructor() {
            super.amnt = 0.0
            super.curr = "Rs. "
        }
        internal constructor(amnt: Double) {
            super.amnt = if (isinf(amnt)) 0.0 else amnt
            super.curr = "Rs. "
        }
        internal constructor(amnt: Double, curr: String) {
            super.amnt = if (not(amnt) || isinf(amnt)) 0.0 else amnt
            super.curr = if (not(super.curr) || len(super.curr) < 1 || len(super.curr) > 4) "Rs. " else titleCase(curr)
        }
    }
    object kmath {
        var pi = 3.141592653589793
        var c = 2.99792e8
        var earthsGravity = 9.80665
        var earthsMass = 5.9722e24
        var earthsRadius = 6.378137e3
        var cUnit = "m/s"
        var earthsGravityUnit = "m/s^2"
        var earthsMassUnit = "km"
        var earthsRadiusUnit = "km"
    }
    fun getPath(to: String): String {
        return if (not(to)) "" else javaClass.getResource(to).toString()
    }
    fun filePath(filename: String): String {
        return getPath(filename)
    }
    fun pathTo(filename: String): String {
        return getPath(filename)
    }
    object os {
        
        var version: String = java.lang.System.getProperty("os.version").lowercase(Locale.getDefault())
        var arch: String = java.lang.System.getProperty("os.arch").lowercase(Locale.getDefault())
        fun `is`(s: String): Boolean {
            return `in`(name, s)
        }
    }
    object user {
        var name: String = java.lang.System.getProperty("user.name")
        var language: String = java.lang.System.getProperty("user.language").lowercase(Locale.getDefault())
        var homeDirectory: String = java.lang.System.getProperty("user.home")
        var workDirectory = Companion.workDirectory
    }
    
    fun printf(str: String, vararg args: Any) {
        println(str, *args)
    }
    
    object blank {
        var Str = arrayOf<String>()
        var Int = intArrayOf()
        var Ch: CharArray
        var Char: CharArray = charArrayOf().also { Ch = it }
        var Long = longArrayOf()
        var Flt = floatArrayOf()
        var Dbl = doubleArrayOf()
        var Bool = booleanArrayOf()
        var Num = arrayOf<Number>()
        var Obj = arrayOf<Any>()
    }
    companion object {
        fun encode(s: String): String {
            return java.util.Base64.getEncoder().encodeToString(s.toByteArray())
        }
        fun decode(s: String): String {
            return String(java.util.Base64.getDecoder().decode(s))
        }
        fun encodeUrl(s: String): String {
            return s.replace("%", "%25").replace(" ", "%20")
                .replace("!", "%21").replace("#", "%23").replace("$", "%24")
                .replace("&", "%26").replace("'", "%27").replace("(", "%28")
                .replace(")", "%29").replace("*", "%2A").replace("+", "%2B")
                .replace(",", "%2C").replace("/", "%2F").replace(":", "%3A")
                .replace(";", "%3B").replace("=", "%3D").replace("", "%3F")
                .replace("@", "%40").replace("[", "%5B").replace("]", "%5D")
        }
        fun decodeUrl(s: String): String {
            return s.replace("%21", "!").replace("%20", " ")
                .replace("%23", "#").replace("%24", "$").replace("%26", "&")
                .replace("%27", "'").replace("%28", "(").replace("%29", ")")
                .replace("%2A", "*").replace("%2B", "+").replace("%2C", ",")
                .replace("%2F", "/").replace("%3A", ":").replace("%3B", ";")
                .replace("%3D", "=").replace("%3F", "").replace("%40", "@")
                .replace("%5B", "[").replace("%5D", "]").replace("%25", "%")
        }
        fun encrypt(data: String, key: String): String {
            val ofXAlgo = "AES"
            try {
                val secretKey = SecretKeySpec(
                    key.toByteArray(java.nio.charset.StandardCharsets.UTF_8), ofXAlgo)
                val cipher: Cipher = Cipher.getInstance(ofXAlgo)
                cipher.init(Cipher.ENCRYPT_MODE, secretKey)
                val encryptedBytes: ByteArray = cipher
                    .doFinal(data.toByteArray(java.nio.charset.StandardCharsets.UTF_8))
                return java.util.Base64.getEncoder().encodeToString(encryptedBytes)
            } catch (err: java.lang.Exception) {
                return data
            }
        }
        fun decrypt(encryptedData: String, key: String): String {
            val ofXAlgo = "AES"
            try {
                val secretKey = SecretKeySpec(
                    key.toByteArray(java.nio.charset.StandardCharsets.UTF_8), ofXAlgo)
                val cipher: Cipher = Cipher.getInstance(ofXAlgo)
                cipher.init(Cipher.DECRYPT_MODE, secretKey)
                val decryptedBytes: ByteArray = cipher
                    .doFinal(java.util.Base64.getDecoder().decode(encryptedData))
                return String(decryptedBytes, java.nio.charset.StandardCharsets.UTF_8)
            } catch (err: java.lang.Exception) {
                print("[KL.Decryptor.BadArguments]:\nFailed to decrypt the message.")
                return ""
            }
        }
        fun internet(): Boolean {
            try {
                val url: java.net.URL = java.net.URL("https://java.com/")
                val conn: java.net.URLConnection = url.openConnection()
                conn.connect()
                return true
            } catch (e: IOException) {
                return false
            }
        }
        
        var fileSeparator: String = java.lang.System.getProperty("file.separator")
        var workDirectory: String = java.lang.System.getProperty("user.dir").lowercase(Locale.getDefault())
        // some other syntax candies
        fun rakam(): pesa {
            return KL.pesa()
        }
        fun rakam(amnt: Double): pesa {
            return KL.pesa(amnt)
        }
        fun rakam(amnt: Double, curr: String): pesa {
            return KL.pesa(amnt, curr)
        }
        fun pesa(): pesa {
            return KL.pesa()
        }
        fun pesa(amnt: Double): pesa {
            return KL.pesa(amnt)
        }
        fun pesa(amnt: Double, curr: String): pesa {
            return KL.pesa(amnt, curr)
        }
        fun naiRakam(): pesa {
            return KL.pesa()
        }
        fun naiRakam(amnt: Double): pesa {
            return KL.pesa(amnt)
        }
        fun naiRakam(amnt: Double, curr: String): pesa {
            return KL.pesa(amnt, curr)
        }
        fun runTask(fn: Runnable): Boolean {
            if (not(fn)) return false
            java.lang.Thread(fn).run()
            return true
        }
        private val timeoutThreads: MutableMap<Int, java.lang.Thread> = ConcurrentHashMap<Int, java.lang.Thread>()
        private var timeoutId = 0
        private var iterationsDone = 0
        fun setTimeout(fn: Runnable, delay: Int): Int {
            if (isNull<Runnable>(fn) || isNull<Int>(delay) || isInf(delay.toDouble()) || isNeg(delay)) return -1
            timeoutId++
            val thread: java.lang.Thread = java.lang.Thread(Runnable {
                try {
                    java.lang.Thread.sleep((if (delay < 1000) delay * 1000 else delay).toLong())
                } catch (e: InterruptedException) {
                    print("[KL.Info.InterruptedTimeout]:\nThe timeout was interrupted, either intentionally or by a background task.")
                    return@Runnable
                }
                javax.swing.SwingUtilities.invokeLater(fn)
            })
            timeoutThreads.put(timeoutId, thread)
            thread.start()
            return timeoutId
        }
        fun clearTimeout(id: Int) {
            val thread: java.lang.Thread? = timeoutThreads.remove(id)
            if (thread != null) {
                thread.interrupt()
            }
        }
        fun delay(fn: Runnable, delay: Int) {
            setTimeout(fn, delay)
        }
        fun clearDelay(id: Int) {
            clearTimeout(id)
        }
        private val intervalThreads: MutableMap<Int, java.lang.Thread> = ConcurrentHashMap<Int, java.lang.Thread>()
        private var intervalId = 0
        fun setInterval(fn: Runnable, interval: Int): Int {
            if (isNull<Runnable>(fn) || isNull<Int>(interval) || isInf(interval.toDouble())
                || isNeg(interval)) return -1
            intervalId++
            val thread: java.lang.Thread = java.lang.Thread(Runnable {
                while (!java.lang.Thread.currentThread().isInterrupted()) {
                    try {
                        java.lang.Thread.sleep((if (interval < 1000) interval * 1000 else interval).toLong())
                    } catch (e: InterruptedException) {
                        print("[KL.Info.InterruptedInterval]:\nThe interval was interrupted, either intentionally or by a background task.")
                        break
                    }
                    javax.swing.SwingUtilities.invokeLater(fn)
                }
            })
            intervalThreads.put(intervalId, thread)
            thread.start()
            return intervalId
        }
        fun setInterval(fn: Runnable, interval: Int,
                        maxIterations: Int): Int {
            if (isNull<Runnable>(fn) || isNull<Int>(interval) || isInf(interval.toDouble()) || isNeg(interval)
                || isNull<Int>(maxIterations) || isInf(maxIterations.toDouble())
                || isNeg(maxIterations) || not(maxIterations)) return -1
            intervalId++
            val thread: java.lang.Thread = java.lang.Thread(Runnable {
                while (!java.lang.Thread.currentThread().isInterrupted()) {
                    try {
                        if (iterationsDone < maxIterations) {
                            java.lang.Thread.sleep(
                                (
                                        if (interval < 1000) interval * 1000 else interval).toLong())
                            iterationsDone++
                        } else clearInterval(intervalId)
                    } catch (e: InterruptedException) {
                        print("[KL.Info.InterruptedInterval]:\nThe interval was interrupted, either intentionally or by a background task.")
                        break
                    }
                    javax.swing.SwingUtilities.invokeLater(fn)
                }
            })
            intervalThreads.put(intervalId, thread)
            thread.start()
            return intervalId
        }
        fun clearInterval(id: Int) {
            val thread: java.lang.Thread? = intervalThreads.remove(id)
            if (thread != null) {
                thread.interrupt()
            }
        }
        val Yes = true
        val No = !Yes
        val On = Yes
        val Off = No
        val Ok = Yes
        val NotOk = !Ok
        val Fail = NotOk
        var none: Any = null
        var ignore = none
        var pass = ignore
        var Else = "else"
        // helps method sw handle default/else cases
        var _s = ""
        var _i = 0
        var _l: Long = 0
        var _f = 0f
        var _d = 0.0
        var _b = false
        fun range(n: Int): IntArray {
            val arr = KL.intArr()
            if (not(n) || n < 1) return arr.array()
            for (i in 0 until n) arr.add(i)
            return arr.array()
        }
        fun range(n: Double): DoubleArray {
            val arr = KL.dblArr()
            if (not(n) || n < 1.1) return arr.array()
            var i = 0.0
            while (i < n) {
                arr.add(i)
                i += .1
            }
            return arr.array()
        }
        fun range(m: Int, n: Int, vararg optional: Int): IntArray {
            val arr = KL.intArr()
            if (isNull(m) || isNull(n) || eq(m, n)) return arr.array()
            var step = 1
            if (`is`(optional) && len(optional) == 1) {
                step = if (`is`(optional[0]) && !isNeg(optional[0]) && !isInf(optional[0].toDouble())) optional[0] else 1
            }
            if (m > n) {
                var i = m
                while (i >= n) {
                    arr.add(i)
                    i -= step
                }
            } else {
                var i = m
                while (i <= n) {
                    arr.add(i)
                    i += step
                }
            }
            return arr.array()
        }
        fun range(m: String, n: String, vararg optional: Int): Array<String> {
            val arr = KL.strArr()
            if (isNull(m) || isNull(n) || eq(m, n) || !eq(m, "[A-Za-z]")
                || !eq(n, "[A-Za-z]")) return arr.array()
            var step = 1
            if (`is`(optional) && len(optional) == 1) {
                step = if (`is`(optional[0]) && !isNeg(optional[0]) && !isInf(optional[0].toDouble())) optional[0] else 1
            }
            val charCodeOfM: Int = m[0].code
            val charCodeOfN: Int = n[0].code
            if (charCodeOfM > charCodeOfN) {
                var i = charCodeOfM
                while (i >= charCodeOfN) {
                    arr.add(Str(i.toChar()))
                    i -= step
                }
            } else {
                var i = charCodeOfM
                while (i <= charCodeOfN) {
                    arr.add(Str(i.toChar()))
                    i += step
                }
            }
            return arr.array()
        }
        fun range(m: Char, n: Char): CharArray {
            return if (not(m) || not(n)) blank.Char else join(range(Str(m), Str(n)), "").toCharArray()
        }
        fun range(m: Double, n: Double, vararg optional: Int): DoubleArray {
            val arr = KL.dblArr()
            if (isNull(m) || isNull(n) || eq(m, n)) return arr.array()
            var step = 1
            if (`is`(optional) && len(optional) == 1) {
                step = if (`is`(optional[0]) && !isNeg(optional[0]) && !isInf(optional[0].toDouble())) optional[0] else 1
            }
            if (m > n) {
                var i = m
                while (i >= n) {
                    arr.add(Dbl(setPrecision(i)))
                    i -= .1 * step
                }
            } else {
                var i = m
                while (i <= n) {
                    arr.add(Dbl(setPrecision(i)))
                    i += .1 * step
                }
            }
            return arr.array()
        }
        fun range(n: Int, reverse: Boolean): IntArray {
            if (not(n) || isNeg(n)) return intArrayOf()
            return if (reverse) range(n, 1) else range(n)
        }
        fun range(m: Int, n: Int, gap: Int, reverse: Boolean): IntArray {
            if (isNull(m) || isNull(n) || eq(m, n)) return intArrayOf()
            return if (reverse) range(n, m, gap) else range(m, n, gap)
        }
        fun range(m: Int, n: Int, reverse: Boolean): IntArray {
            if (isNull(m) || isNull(n) || eq(m, n)) return intArrayOf()
            return if (reverse) range(n, m) else range(m, n)
        }
        fun range(n: Double, reverse: Boolean): DoubleArray {
            if (not(n) || isNeg(n)) return doubleArrayOf()
            return if (reverse) range(n, 1.0) else range(n)
        }
        fun range(m: Double, n: Double, gap: Int, reverse: Boolean): DoubleArray {
            if (isNull(m) || isNull(n) || eq(m, n)) return doubleArrayOf()
            return if (reverse) range(n, m, gap) else range(m, n, gap)
        }
        fun range(m: Double, n: Double, reverse: Boolean): DoubleArray {
            if (isNull(m) || isNull(n) || eq(m, n)) return doubleArrayOf()
            return if (reverse) range(n, m) else range(m, n)
        }
        fun range(m: String, n: String, gap: Int, reverse: Boolean): Array<String> {
            if (not(m) || not(n) || eq(m, n)) return arrayOf()
            return if (reverse) range(n, m, gap) else range(m, n, gap)
        }
        fun range(m: String, n: String, reverse: Boolean): Array<String> {
            if (not(m) || not(n) || eq(m, n)) return arrayOf()
            return if (reverse) range(n, m) else range(m, n)
        }
        fun range(m: Char, n: Char, reverse: Boolean): CharArray {
            if (not(m) || not(n) || eq(m, n)) return charArrayOf()
            return if (reverse) range(n, m) else range(m, n)
        }
        fun range(str: String): IntArray {
            return range(len(str))
        }
        fun range(arr: CharArray): IntArray {
            return range(len(arr))
        }
        fun range(arr: Array<String>): IntArray {
            return range(len(arr))
        }
        fun range(arr: IntArray): IntArray {
            return range(len(arr))
        }
        fun range(arr: LongArray): IntArray {
            return range(len(arr))
        }
        fun range(arr: FloatArray): IntArray {
            return range(len(arr))
        }
        fun range(arr: DoubleArray): IntArray {
            return range(len(arr))
        }
        fun range(arr: BooleanArray): IntArray {
            return range(len(arr))
        }
        fun range(arr: Array<Any>): IntArray {
            return range(len(arr))
        }
        fun idx(str: String): IntArray {
            return range(str)
        }
        fun idx(arr: CharArray): IntArray {
            return range(arr)
        }
        fun idx(arr: Array<String>): IntArray {
            return range(arr)
        }
        fun idx(arr: IntArray): IntArray {
            return range(arr)
        }
        fun idx(arr: LongArray): IntArray {
            return range(arr)
        }
        fun idx(arr: FloatArray): IntArray {
            return range(arr)
        }
        fun idx(arr: DoubleArray): IntArray {
            return range(arr)
        }
        fun idx(arr: BooleanArray): IntArray {
            return range(arr)
        }
        fun idx(arr: Array<Any>): IntArray {
            return range(arr)
        }
        fun each(iterable: Array<String>,
                 consumer: ObjIntConsumer<String>) {
            if (not(iterable) || not(consumer)) return
            var i = 0
            for (item: String in iterable) {
                consumer.accept(item, i)
                i++
            }
        }
        fun each(iterable: Array<String>, consumer: java.util.function.Consumer<String>) {
            if (not(iterable) || not(consumer)) return
            for (item: String in iterable) {
                consumer.accept(item)
            }
        }
        fun each(iterable: IntArray, consumer: ObjIntConsumer<Int>) {
            if (not(iterable) || not(consumer)) return
            var i = 0
            for (item: Int in iterable) {
                consumer.accept(item, i)
                i++
            }
        }
        fun each(iterable: IntArray, consumer: java.util.function.Consumer<Int>) {
            if (not(iterable) || not(consumer)) return
            for (item: Int in iterable) {
                consumer.accept(item)
            }
        }
        fun each(iterable: LongArray, consumer: ObjIntConsumer<Long>) {
            if (not(iterable) || not(consumer)) return
            var i = 0
            for (item: Long in iterable) {
                consumer.accept(item, i)
                i++
            }
        }
        fun each(iterable: LongArray, consumer: java.util.function.Consumer<Long>) {
            if (not(iterable) || not(consumer)) return
            for (item: Long in iterable) {
                consumer.accept(item)
            }
        }
        fun each(iterable: FloatArray, consumer: ObjIntConsumer<Float>) {
            if (not(iterable) || not(consumer)) return
            var i = 0
            for (item: Float in iterable) {
                consumer.accept(item, i)
                i++
            }
        }
        fun each(iterable: FloatArray, consumer: java.util.function.Consumer<Float>) {
            if (not(iterable) || not(consumer)) return
            for (item: Float in iterable) {
                consumer.accept(item)
            }
        }
        fun each(iterable: DoubleArray,
                 consumer: ObjIntConsumer<Double>) {
            if (not(iterable) || not(consumer)) return
            var i = 0
            for (item: Double in iterable) {
                consumer.accept(item, i)
                i++
            }
        }
        fun each(iterable: DoubleArray, consumer: java.util.function.Consumer<Double>) {
            if (not(iterable) || not(consumer)) return
            for (item: Double in iterable) {
                consumer.accept(item)
            }
        }
        fun each(iterable: BooleanArray,
                 consumer: ObjIntConsumer<Boolean>) {
            if (not(iterable) || not(consumer)) return
            var i = 0
            for (item: Boolean in iterable) {
                consumer.accept(item, i)
                i++
            }
        }
        fun each(iterable: BooleanArray, consumer: java.util.function.Consumer<Boolean>) {
            if (not(iterable) || not(consumer)) return
            for (item: Boolean in iterable) {
                consumer.accept(item)
            }
        }
        fun <T> each(iterable: Array<T>, consumer: ObjIntConsumer<T>) {
            if (not(iterable) || not(consumer)) return
            var i = 0
            for (item: T in iterable) {
                consumer.accept(item, i)
                i++
            }
        }
        fun <T> each(iterable: Array<T>, consumer: java.util.function.Consumer<T>) {
            if (not(iterable) || not(consumer)) return
            for (item: T in iterable) {
                consumer.accept(item)
            }
        }
        // handling Object arrays
        // DON'T remove
        fun forEach(iterable: Array<String>,
                    consumer: ObjIntConsumer<String>) {
            each(iterable, consumer)
        }
        fun forEach(iterable: IntArray,
                    consumer: ObjIntConsumer<Int>) {
            each(iterable, consumer)
        }
        fun forEach(iterable: LongArray, consumer: ObjIntConsumer<Long>) {
            each(iterable, consumer)
        }
        fun forEach(iterable: FloatArray,
                    consumer: ObjIntConsumer<Float>) {
            each(iterable, consumer)
        }
        fun forEach(iterable: DoubleArray,
                    consumer: ObjIntConsumer<Double>) {
            each(iterable, consumer)
        }
        fun forEach(iterable: BooleanArray,
                    consumer: ObjIntConsumer<Boolean>) {
            each(iterable, consumer)
        }
        fun <T> forEach(iterable: Array<T>, consumer: ObjIntConsumer<T>) {
            each<T>(iterable, consumer)
        }
        // handling Object arrays
        // DON'T remove
        fun repeat(fn: Runnable, times: Int) {
            while (times > 0) {
                java.lang.Thread(fn).run()
                times--
            }
        }
        @kotlin.jvm.JvmOverloads
        fun repeat(s: String, times: Int = 2): String {
            if (not(s) || not(times) || isNeg(times)) return s
            val org = s
            while (-1 + times > 0) {
                s += org
                times--
            }
            return s
        }
        fun map(arr: CharArray, func: java.util.function.Function<Char, Char>): CharArray {
            if (not(arr) || not(func)) return arr
            val result = CharArray(arr.size)
            for (i in arr.indices) {
                result[i] = func.apply(arr[i])
            }
            return result
        }
        fun map(arr: Array<String>, func: java.util.function.Function<String, String>): Array<String> {
            if (not(arr) || not(func)) return arr
            val result = arrayOfNulls<String>(arr.size)
            for (i in arr.indices) {
                result[i] = func.apply(arr[i])
            }
            return result
        }
        fun map(arr: IntArray, func: IntUnaryOperator): IntArray {
            return if (not(arr) || not(func)) arr else Arrays.stream(arr).map(func).toArray()
        }
        fun map(arr: LongArray, func: LongUnaryOperator): LongArray {
            return if (not(arr) || not(func)) arr else Arrays.stream(arr).map(func).toArray()
        }
        fun map(arr: FloatArray, func: java.util.function.Function<Float, Float>): FloatArray {
            if (not(arr) || not(func)) return arr
            val result = FloatArray(arr.size)
            for (i in arr.indices) {
                result[i] = func.apply(arr[i])
            }
            return result
        }
        fun map(arr: DoubleArray, func: DoubleUnaryOperator): DoubleArray {
            return if (not(arr) || not(func)) arr else Arrays.stream(arr).map(func).toArray()
        }
        fun map(arr: BooleanArray,
                func: java.util.function.Function<Boolean, Boolean>): BooleanArray {
            if (not(arr) || not(func)) return arr
            val result = BooleanArray(arr.size)
            for (i in arr.indices) {
                result[i] = func.apply(arr[i])
            }
            return result
        }
        fun reduce(arr: Array<String>, func: BinaryOperator<String>): String {
            return if (not(arr) || not(func)) "" else Arrays.stream<String>(arr).reduce("", func)
        }
        fun reduce(arr: IntArray, func: IntBinaryOperator): Int {
            return if (not(arr) || not(func)) 0 else Arrays.stream(arr).reduce(0, func)
        }
        fun reduce(arr: LongArray, func: LongBinaryOperator): Long {
            return if (not(arr) || not(func)) 0 else Arrays.stream(arr).reduce(0, func)
        }
        fun reduce(arr: DoubleArray, func: DoubleBinaryOperator): Double {
            return if (not(arr) || not(func)) 0 else Arrays.stream(arr).reduce(0.0, func)
        }
        fun filterOut(array: Array<String>,
                      condition: java.util.function.Predicate<String>): Array<String> {
            return popIf(array, condition)
        }
        fun filterOut(array: IntArray, condition: java.util.function.Predicate<Int>): IntArray {
            return popIf(array, condition)
        }
        fun filterOut(array: LongArray, condition: java.util.function.Predicate<Long>): LongArray {
            return popIf(array, condition)
        }
        fun filterOut(array: FloatArray, condition: java.util.function.Predicate<Float>): FloatArray {
            return popIf(array, condition)
        }
        fun filterOut(array: DoubleArray,
                      condition: java.util.function.Predicate<Double>): DoubleArray {
            return popIf(array, condition)
        }
        fun filterOut(array: BooleanArray,
                      condition: java.util.function.Predicate<Boolean>): BooleanArray {
            return popIf(array, condition)
        }
        fun filter(array: Array<String>, condition: java.util.function.Predicate<String>): Array<String> {
            return keepIf(array, condition)
        }
        fun filter(array: IntArray, condition: java.util.function.Predicate<Int>): IntArray {
            return keepIf(array, condition)
        }
        fun filter(array: LongArray, condition: java.util.function.Predicate<Long>): LongArray {
            return keepIf(array, condition)
        }
        fun filter(array: FloatArray, condition: java.util.function.Predicate<Float>): FloatArray {
            return keepIf(array, condition)
        }
        fun filter(array: DoubleArray, condition: java.util.function.Predicate<Double>): DoubleArray {
            return keepIf(array, condition)
        }
        fun filter(array: BooleanArray,
                   condition: java.util.function.Predicate<Boolean>): BooleanArray {
            return keepIf(array, condition)
        }
        fun onlyPop(array: Array<String>,
                    condition: java.util.function.Predicate<String>): Array<String> {
            return popIf(array, condition)
        }
        fun onlyPop(array: IntArray, condition: java.util.function.Predicate<Int>): IntArray {
            return popIf(array, condition)
        }
        fun onlyPop(array: LongArray, condition: java.util.function.Predicate<Long>): LongArray {
            return popIf(array, condition)
        }
        fun onlyPop(array: FloatArray, condition: java.util.function.Predicate<Float>): FloatArray {
            return popIf(array, condition)
        }
        fun onlyPop(array: DoubleArray,
                    condition: java.util.function.Predicate<Double>): DoubleArray {
            return popIf(array, condition)
        }
        fun onlyPop(array: BooleanArray,
                    condition: java.util.function.Predicate<Boolean>): BooleanArray {
            return popIf(array, condition)
        }
        fun onlyKeep(array: Array<String>,
                     condition: java.util.function.Predicate<String>): Array<String> {
            return keepIf(array, condition)
        }
        fun onlyKeep(array: IntArray, condition: java.util.function.Predicate<Int>): IntArray {
            return keepIf(array, condition)
        }
        fun onlyKeep(array: LongArray, condition: java.util.function.Predicate<Long>): LongArray {
            return keepIf(array, condition)
        }
        fun onlyKeep(array: FloatArray, condition: java.util.function.Predicate<Float>): FloatArray {
            return keepIf(array, condition)
        }
        fun onlyKeep(array: DoubleArray,
                     condition: java.util.function.Predicate<Double>): DoubleArray {
            return keepIf(array, condition)
        }
        fun onlyKeep(array: BooleanArray,
                     condition: java.util.function.Predicate<Boolean>): BooleanArray {
            return keepIf(array, condition)
        }
		@JvmStatic
        fun randItem(arr: Array<String>): String {
            return try {
                if (arr.isEmpty()) {
                    ""
                } else {
                    arr[randInt(arr.size)]
                }
            } catch (e: Exception) {
                // Handle exception
                ""
            }
        }

        @JvmStatic
        fun randItem(arr: Array<Int>): Int {
            return try {
                if (arr.isEmpty()) {
                    0
                } else {
                    arr[randInt(arr.size)]
                }
            } catch (e: Exception) {
                // Handle exception
                0
            }
        }

        @JvmStatic
        fun randItem(arr: Array<Long>): Long {
            return try {
                if (arr.isEmpty()) {
                    0
                } else {
                    arr[randInt(arr.size)]
                }
            } catch (e: Exception) {
                // Handle exception
                0
            }
        }

        @JvmStatic
        fun randItem(arr: Array<Float>): Float {
            return try {
                if (arr.isEmpty()) {
                    0f
                } else {
                    arr[randInt(arr.size)]
                }
            } catch (e: Exception) {
                // Handle exception
                0f
            }
        }

        @JvmStatic
        fun randItem(arr: Array<Double>): Double {
            return try {
                if (arr.isEmpty()) {
                    0.0
                } else {
                    arr[randInt(arr.size)]
                }
            } catch (e: Exception) {
                // Handle exception
                0.0
            }
        }

        @JvmStatic
        fun randItem(arr: Array<Boolean>): Boolean {
            return try {
                if (arr.isEmpty()) {
                    false
                } else {
                    arr[randInt(arr.size)]
                }
            } catch (e: Exception) {
                // Handle exception
                false
            }
        }

        @JvmStatic
        fun randItem(arr: Array<Any>): Any {
            return try {
                if (arr.isEmpty()) {
                    ""
                } else {
                    arr[randInt(arr.size)]
                }
            } catch (e: Exception) {
                // Handle exception
                ""
            }
        }

        @JvmStatic
        fun randFrom(arr: Array<String>): String {
            return randItem(arr)
        }

        @JvmStatic
        fun randFrom(arr: Array<Int>): Int {
            return randItem(arr)
        }

        @JvmStatic
        fun randFrom(arr: Array<Long>): Long {
            return randItem(arr)
        }

        @JvmStatic
        fun randFrom(arr: Array<Float>): Float {
            return randItem(arr)
        }

        @JvmStatic
        fun randFrom(arr: Array<Double>): Double {
            return randItem(arr)
        }

        @JvmStatic
        fun randFrom(arr: Array<Boolean>): Boolean {
            return randItem(arr)
        }

        @JvmStatic
        fun randFrom(arr: Array<Any>): Any {
            return randItem(arr)
        }
        // Date functions
        fun nthDay(n: Int): String {
            val days = arrayOf("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday",
                "Friday", "Saturday")
            return days[n]
        }
        fun nthMonth(n: Int): String {
            val months = arrayOf("January", "February", "March", "April", "May",
                "June", "July", "August", "September", "October", "November",
                "December")
            return months[n]
        }
        fun formattedDate(dt: java.util.Date): String {
            val dayOfWeek: Int = dt.getDay()
            val monthOfYear: Int = dt.getMonth()
            val day: String
            val month: String
            var date: String = dt.toLocaleString()
            val ampm: String = date.substring(date.length - 2)
            date = date.substring(0, date.length - 6) + " " + ampm
            month = nthMonth(monthOfYear)
            date = month + " " + date.substring(4)
            day = nthDay(dayOfWeek)
            date = "$day, $date"
            return date
        }
        fun now(): String {
            val dt: java.util.Date = java.util.Date()
            dt.setTime(dt.getTime() + 5 * (3600 * 1000)) // fix 5-hour bug
            val date = formattedDate(dt)
            val parts: Array<String> = date.split(", ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            parts[0] = parts[0]
            parts[1] = split(parts[1], " ")[0] + " " + split(parts[1], " ")[1]
            val time = slice(parts, len(parts) - 1)[0]
            val x = arrayOf(time, join(slice(parts, 0, len(parts) - 1), ", "))
            return join(x, ", ")
        }
        fun now(shortened: Boolean): String {
            if (!shortened) return now()
            val parts: Array<String> = now().split(", ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            val time = parts[0]
            val day = sliceKeep(parts[1], 3)
            val dateOfMonth = (sliceKeep(parts[2], 3) + " "
                    + parts[2].split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray().get(1))
            val year = parts[3]
            return join(arrayOf<String>(time, day, dateOfMonth, year), ", ")
        }
        val date: String
            get() {
                val parts: Array<String> = now().split(", ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                return parts[2] + ", " + parts[3]
            }
        val day: String
            get() = now().split(", ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray().get(1)
        val month: String
            get() = now().split(", ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray().get(2).split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray().get(0)
        val year: String
            get() = now().split(", ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray().get(3)
        val time: String
            get() = now().split(", ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray().get(0)
        val timestamp: String
            get() = now(true).uppercase(Locale.getDefault()).replace("\\W+".toRegex(), "-")
        fun timestamp(): String {
            return timestamp
        }
        fun timesignature(): String {
            return datestamp
        }
        val datestamp: String
            get() = timestamp.split("(<=[AP]M)-".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray().get(1)
        fun datestamp(): String {
            return datestamp
        }
        fun datesignature(): String {
            return datestamp
        }
        val season: String
            get() {
                val m: String = slice(month, 0, 3).lowercase(Locale.getDefault())
                when (m) {
                    "may", "jun", "jul", "aug" -> return "Summer"
                    "sep", "oct" -> return "Spring"
                    "nov", "dec", "jan", "feb" -> return "Winter"
                    else -> return "Fall/Autumn"
                }
            }
        fun yesterday(): String {
            val dt: java.util.Date = java.util.Date()
            dt.setTime(dt.getTime() + 5 * 36e5.toInt()) // fix 5-hour bug
            dt.setTime(dt.getTime() - 36e5.toInt() * 24) // decrement 24 hours or
            // (3.6*10⁶)*24
            // milliseconds
            var date = formattedDate(dt)
            val parts: Array<String> = date.split(", ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            date = parts[0] + ", " + parts[1] + ", " + parts[2]
            return date
        }
        fun dayBeforeYesterday(): String {
            val dt: java.util.Date = java.util.Date()
            dt.setTime(dt.getTime() + 5 * 36e5.toInt()) // fix 5-hour bug
            dt.setTime(dt.getTime() - 72e5.toInt() * 24) // decrement 48 hours or
            // (7.2*10⁶)*24
            // milliseconds
            var date = formattedDate(dt)
            val parts: Array<String> = date.split(", ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            date = parts[0] + ", " + parts[1] + ", " + parts[2]
            return date
        }
        fun twoDaysAgo(): String {
            return dayBeforeYesterday()
        }
        fun tomorrow(): String {
            val dt: java.util.Date = java.util.Date()
            dt.setTime(dt.getTime() + 5 * (36e2 * 1e3).toInt()) // fix 5-hour bug
            dt.setTime(dt.getTime() + 36e5.toInt() * 24) // increment 24 hours or
            // (3.6*10⁶)*24
            // milliseconds
            var date = formattedDate(dt)
            val parts: Array<String> = date.split(", ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            date = parts[0] + ", " + parts[1] + ", " + parts[2]
            return date
        }
        fun dayAfterTomorrow(): String {
            val dt: java.util.Date = java.util.Date()
            dt.setTime(dt.getTime() + 5 * 36e5.toInt()) // fix 5-hour bug
            dt.setTime(dt.getTime() + 72e5.toInt() * 24) // increment 48 hours or
            // (7.2*10⁶)*24
            // milliseconds
            var date = formattedDate(dt)
            val parts: Array<String> = date.split(", ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            date = parts[0] + ", " + parts[1] + ", " + parts[2]
            return date
        }
        fun twoDaysLater(): String {
            return dayAfterTomorrow()
        }
        fun lastMonth(): String {
            val dt: java.util.Date = java.util.Date()
            dt.setTime(dt.getTime() + 5 * 36e5.toInt()) // fix 5-hour bug
            dt.setMonth(dt.getMonth() - 1) // decrement a month
            var date = formattedDate(dt)
            date = date.split(", ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray().get(1).split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray().get(0)
            return date
        }
        fun lastMonthOf(date: String): String {
            val dt: java.util.Date = java.util.Date(date)
            dt.setTime(dt.getTime() + 5 * 36e5.toInt()) // fix 5-hour bug
            dt.setMonth(dt.getMonth() - 1) // decrement a month
            date = formattedDate(dt)
            date = date.split(", ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray().get(1).split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray().get(0)
            return date
        }
        fun nextMonth(): String {
            val dt: java.util.Date = java.util.Date()
            dt.setTime(dt.getTime() + 5 * 36e5.toInt()) // fix 5-hour bug
            dt.setMonth(dt.getMonth() + 1) // increment a month
            var date = formattedDate(dt)
            val parts: Array<String> = date.split(", ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            date = date.split(", ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray().get(1).split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray().get(0)
            return date
        }
        fun nextMonthOf(date: String): String {
            val dt: java.util.Date = java.util.Date(date)
            dt.setTime(dt.getTime() + 5 * 36e5.toInt()) // fix 5-hour bug
            dt.setMonth(dt.getMonth() + 1) // increment a month
            date = formattedDate(dt)
            val parts: Array<String> = date.split(", ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            date = date.split(", ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray().get(1).split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray().get(0)
            return date
        }
        fun lastYear(): String {
            val dt: java.util.Date = java.util.Date()
            dt.setTime(dt.getTime() + 5 * 36e5.toInt()) // fix 5-hour bug
            dt.setYear(dt.getYear() - 1) // decrement a year
            var date = formattedDate(dt)
            val parts: Array<String> = date.split(", ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            date = date.split(", ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray().get(2)
            return date
        }
        fun lastYearOf(date: String): String {
            val dt: java.util.Date = java.util.Date(date)
            dt.setTime(dt.getTime() + 5 * 36e5.toInt()) // fix 5-hour bug
            dt.setYear(dt.getYear() - 1) // decrement a year
            date = formattedDate(dt)
            date = date.split(", ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray().get(2)
            return date
        }
        fun nextYear(): String {
            val dt: java.util.Date = java.util.Date()
            dt.setTime(dt.getTime() + 5 * 36e5.toInt()) // fix 5-hour bug
            dt.setYear(dt.getYear() + 1) // increment a year
            var date = formattedDate(dt)
            date = date.split(", ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray().get(2)
            return date
        }
        fun nextYear(date: String): String {
            val dt: java.util.Date = java.util.Date(date)
            dt.setTime(dt.getTime() + 5 * 36e5.toInt()) // fix 5-hour bug
            dt.setYear(dt.getYear() + 1) // increment a year
            date = formattedDate(dt)
            date = date.split(", ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray().get(2)
            return date
        }
        fun age2bday(age: Int): String {
            val dt: java.util.Date = java.util.Date()
            // dt.setTime(dt.getTime()+(5*((int)36e5))); //fix 5-hour bug
            // resolve a bug
            return "" + ((dt.getYear() + 1900) - age)
        }
        fun bday2age(date: String): Int {
            val dt: java.util.Date = java.util.Date(date)
            dt.setTime(dt.getTime() + 5 * 36e5.toInt()) // fix 5-hour bug
            return java.util.Date().getYear() - dt.getYear()
        }
        fun date2day(date: String): String {
            val dt: java.util.Date = java.util.Date(date)
            dt.setTime(dt.getTime() + 5 * 36e5.toInt()) // fix 5-hour bug
            date = formattedDate(dt)
            date = date.split(", ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray().get(0)
            return date
        }
        fun date2month(date: String): String {
            val dt: java.util.Date = java.util.Date(date)
            dt.setTime(dt.getTime() + 5 * 36e5.toInt()) // fix 5-hour bug
            date = formattedDate(dt)
            date = date.split(", ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray().get(1).split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray().get(0)
            return date
        }
        fun timeGreet(): String {
            val greeting: String
            val h: Int = java.util.Date().getHours() + 5 // fix 5-hour bug along the way
            if (h >= 20) greeting = "Good night" else if (h >= 16) greeting = "Good evening" else if (h >= 12) greeting = "Good afternoon" else if (h >= 0 && h <= 4) greeting = "Good new day" else greeting = "Good morning"
            return greeting
        }
        fun lastOfMonth(m: Int): String {
            val dt: java.util.Date = java.util.Date()
            val dt2 = KL()
            dt.setTime(dt.getTime() + 5 * 36e5.toInt()) // fix 5-hour bug for
            // better accuracy
            return "" + (("" + nthMonth(m - 1) + " "
                    + java.util.Date(java.util.Date().getYear(), m, 0).getDate()))
        }
        val isWeekend: Boolean
            get() {
                val dt: java.util.Date = java.util.Date()
                dt.setTime(dt.getTime() + 5 * 36e5.toInt()) // fix 5-hour bug
                return dt.getDay() % 6 == 0
            }
        val isLeapYear: Boolean
            get() = (1900 + java.util.Date().getYear()) % 4 == 0
        fun nextLeapYear(): Int {
            val dt: java.util.Date = java.util.Date()
            dt.setTime(dt.getTime() + 5 * 36e5.toInt()) // fix 5-hour bug for
            // better accuracy
            var i = 0
            if (dt.getYear() % 4 == 0) dt.setYear(dt.getYear() + 1) // ignore current year, if it's leap
            while (dt.getYear() % 4 != 0) {
                dt.setYear(dt.getYear() + i)
                i++
            }
            return (1900 + dt.getYear())
        }
        fun dateBefore(n: Int): String {
            val dt: java.util.Date = java.util.Date()
            dt.setTime(dt.getTime() + 5 * 36e5.toInt()) // fix 5-hour bug
            dt.setDate(dt.getDate() - java.lang.Math.abs(n))
            var date = formattedDate(dt)
            val parts: Array<String> = date.split(", ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            date = parts[0] + ", " + parts[1] + ", " + parts[2]
            return date
        }
        fun dateAfter(n: Int): String {
            val dt: java.util.Date = java.util.Date()
            dt.setTime(dt.getTime() + 5 * 36e5.toInt()) // fix 5-hour bug
            dt.setDate(dt.getDate() + java.lang.Math.abs(n))
            var date = formattedDate(dt)
            val parts: Array<String> = date.split(", ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            date = parts[0] + ", " + parts[1] + ", " + parts[2]
            return date
        }
        fun minsAgo(n: Int): String {
            val dt: java.util.Date = java.util.Date()
            dt.setTime(dt.getTime() + 5 * 36e5.toInt()) // fix 5-hour bug
            dt.setTime(dt.getTime() - n * 60e3.toInt())
            var time = formattedDate(dt)
            time = time.split(", ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray().get(3)
            return time
        }
        fun minsLater(n: Int): String {
            val dt: java.util.Date = java.util.Date()
            dt.setTime(dt.getTime() + 5 * 36e5.toInt()) // fix 5-hour bug
            dt.setTime(dt.getTime() + n * 60e3.toInt())
            var time = formattedDate(dt)
            time = time.split(", ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray().get(3)
            return time
        }
        fun hoursAgo(n: Int): String {
            val dt: java.util.Date = java.util.Date()
            dt.setTime(dt.getTime() + 5 * 36e5.toInt()) // first fix the 5-hour
            // bug
            dt.setTime(dt.getTime() - n * 36e5.toInt())
            var time = formattedDate(dt)
            time = time.split(", ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray().get(3)
            return time
        }
        fun hoursLater(n: Int): String {
            val dt: java.util.Date = java.util.Date()
            dt.setTime(dt.getTime() + 5 * 36e5.toInt()) // first fix the 5-hour
            // bug
            dt.setTime(dt.getTime() + n * 36e5.toInt())
            var time = formattedDate(dt)
            time = time.split(", ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray().get(3)
            return time
        }
        fun nthHour(n: Int): String {
            val dt: java.util.Date = java.util.Date()
            dt.setTime(dt.getTime() + 5 * 36e5.toInt()) // fix 5-hour bug
            dt.setTime(
                dt.getTime() - 36e5.toInt() * dt.getHours() + n * 36e5.toInt())
            var time = formattedDate(dt)
            time = time.split(", ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray().get(3)
            return time
        }
        fun date(): String {
            return now()
        }
        // utilities
        fun println(vararg args: Any) {
            if (isNull(*args) || not(args.size)) return
            if (!isNull(args[0]) && args[0] is String
                && `in`(Str(args[0]), "[\\%\\$\\&\\{\\}]")) {
                if (len(args) >= 2) {
                    KL().printf(args[0] as String, *slice(args, 1))
                    return
                } else {
                    KL().printf(args[0] as String, '\u0000', "", 0, 0L, 0f, 0.0, No)
                    return
                }
            }
            if (len(args) == 1 && !isNull(args[0]) && isArr(args[0])) {
                printArr(args[0])
                return
            } else {
                for (arg: Any in args) {
                    if (isNull(arg)) continue
                    if (isArr(arg)) {
                        printArr(arg)
                        print(" ")
                    }
                    if (arg is Char) arg = "'$arg'"
                    if (arg is Double) {
                        if (`in`(Str(arg), "(<=\\.)\\d{3,}")) arg = setPrecision(arg, 2) else arg = setPrecision(arg)
                    }
                    print("$arg ")
                }
            }
        }
        fun print(vararg args: Any) {
            println(*args)
            print("\n")
        }
        fun kaho(vararg args: Any) {
            println(*args)
            print("\n")
        }
        fun printf(n: Int) {
            print(f(n))
        }
        fun printf(n: Long) {
            print(f(n))
        }
        fun printf(n: Float) {
            print(f(n))
        }
        fun printf(n: Double) {
            print(f(n))
        }
        // printing arrays
        fun printArr(arg: Any) {
            if (isNull(arg)) return
            if (arg is Array<Any>) {
                // if one it's of those arrays that are based on a class
                if (isArrOfStr(arg)) {
                    print("[" + (if (!isEmpty(arg as Array<String>)) "\"" + join(arg as Array<String>, "\", \"") + "\"" else "") + "]")
                } else if (isArrOfNum(arg)) {
                    print("[" + join(*arg as Array<Number>) + "]")
                } else if (isArrOfObj(arg)) {
                    print("[" + join(arg, ", ") + "]")
                }
            } else {
                if (isArrOfChar(arg)) {
                    print("[" + (if (!isEmpty(arg as CharArray)) "\'" + join(arg, "\', \'") + "\'" else "") + "]")
                } else if (isArrOfInt(arg)) {
                    print("[" + join(*arg as IntArray) + "]")
                } else if (isArrOfLong(arg)) {
                    print("[" + join(*arg as LongArray) + "]")
                } else if (isArrOfFlt(arg)) {
                    print("[" + join(*arg as FloatArray) + "]")
                } else if (isArrOfDbl(arg)) {
                    print("[" + join(*arg as DoubleArray) + "]")
                } else if (isArrOfBool(arg)) {
                    print("[" + join(*arg as BooleanArray) + "]")
                }
            }
            print("\n")
        }
        fun printAll(arr: Array<String>) {
            printArr(arr)
        }
        fun printAll(arr: IntArray) {
            printArr(arr)
        }
        fun printAll(arr: LongArray) {
            printArr(arr)
        }
        fun printAll(arr: FloatArray) {
            printArr(arr)
        }
        fun printAll(arr: DoubleArray) {
            printArr(arr)
        }
        fun printAll(arr: BooleanArray) {
            printArr(arr)
        }
        // getting user input
        fun ask(s: String): String {
            print(s)
            val input: java.util.Scanner = java.util.Scanner(java.lang.System.`in`)
            return input.nextLine()
        }
        fun askI(s: String): Int {
            print(s)
            val input: java.util.Scanner = java.util.Scanner(java.lang.System.`in`)
            return input.nextInt()
        }
        fun askC(s: String): Int {
            print(s)
            val input: java.util.Scanner = java.util.Scanner(java.lang.System.`in`)
            val x: Char = input.next().get(0)
            return x.code
        }
        fun askL(s: String): Long {
            print(s)
            val input: java.util.Scanner = java.util.Scanner(java.lang.System.`in`)
            return input.nextLong()
        }
        fun askF(s: String): Float {
            print(s)
            val input: java.util.Scanner = java.util.Scanner(java.lang.System.`in`)
            return input.nextFloat()
        }
        fun askD(s: String): Double {
            print(s)
            val input: java.util.Scanner = java.util.Scanner(java.lang.System.`in`)
            return input.nextDouble()
        }
        fun askInt(s: String): Int {
            return askI(s)
        }
        fun askChar(s: String): Int {
            return askC(s)
        }
        fun askLong(s: String): Long {
            return askL(s)
        }
        fun askFloat(s: String): Float {
            return askF(s)
        }
        fun askDouble(s: String): Double {
            return askD(s)
        }
        @kotlin.jvm.JvmOverloads
        fun br(n: Int = 1) {
            while (n > 0) {
                print("\n")
                n--
            }
        }
        fun String(arg: String): String {
            // if already a string, return as/is
            return arg
        }
        fun String(arg: Char): String {
            return ("" + arg)
        }
        fun String(arg: Int): String {
            return ("" + arg)
        }
        fun String(arg: Long): String {
            return ("" + arg)
        }
        fun String(arg: Float): String {
            return ("" + arg)
        }
        fun String(arg: Double): String {
            return ("" + arg)
        }
        fun String(arg: Boolean): String {
            return ("" + arg)
        }
        fun String(arg: Any): String {
            return ("" + arg)
        }
        fun String(arr: Array<String>): String {
            return Arrays.toString(arr)
        }
        fun String(arr: IntArray): String {
            return Arrays.toString(arr)
        }
        fun String(arr: CharArray): String {
            return Arrays.toString(arr)
        }
        fun String(arr: LongArray): String {
            return Arrays.toString(arr)
        }
        fun String(arr: FloatArray): String {
            return Arrays.toString(arr)
        }
        fun String(arr: DoubleArray): String {
            return Arrays.toString(arr)
        }
        fun String(arr: BooleanArray): String {
            return Arrays.toString(arr)
        }
        fun String(arr: Array<Any>): String {
            return Arrays.toString(arr)
        }
        fun Str(arg: String): String {
            return String(arg)
        }
        fun Str(arg: Char): String {
            return String(arg)
        }
        fun Str(arg: Int): String {
            return String(arg)
        }
        fun Str(arg: Long): String {
            return String(arg)
        }
        fun Str(arg: Float): String {
            return String(arg)
        }
        fun Str(arg: Double): String {
            return String(arg)
        }
        fun Str(arg: Boolean): String {
            return String(arg)
        }
        fun Str(arg: Any): String {
            return ("" + arg)
        }
        fun Str(arr: Array<String>): String {
            return String(arr)
        }
        fun Str(arr: IntArray): String {
            return String(arr)
        }
        fun Str(arr: CharArray): String {
            return String(arr)
        }
        fun Str(arr: LongArray): String {
            return String(arr)
        }
        fun Str(arr: FloatArray): String {
            return String(arr)
        }
        fun Str(arr: DoubleArray): String {
            return String(arr)
        }
        fun Str(arr: BooleanArray): String {
            return String(arr)
        }
        fun Str(arg: Array<Any>): String {
            return String(arg)
        }
        fun concat(vararg args: Any): String {
            if (not(args)) return ""
            var result = ""
            for (arg: Any in args) {
                if (isNull(arg)) continue
                result += "" + arg
            }
            return result
        }
        fun cat(vararg args: Any): String {
            return concat(*args)
        }
        fun Chars(str: String): CharArray {
            if (not(str)) return blank.Char
            return str.toCharArray()
        }
        fun Char(str: String): Char {
            if (not(str)) return '\u0000'
            return Chars(str).get(0)
        }
        fun Char(n: Int): Char {
            if (isNull(n)) return '\u0000'
            return n.toChar()
        }
        fun Char(str: String, n: Int): Char {
            if (not(str) || n < 0 || n >= len(str)) return '\u0000'
            return Chars(str).get(n)
        }
        fun nthCharOf(str: String, n: Int): Char {
            if (not(str) || n < 0 || n >= len(str)) return '\u0000'
            return Chars(str).get(n)
        }
        fun nthLastCharOf(str: String, n: Int): Char {
            if (not(str) || n <= 0 || n > len(str)) return '\u0000'
            // tested, NO EDITS please; in the case of reverse indexes, this IS the
            // way the
            // "if" condition is meant to be, i.e. the 'n <= 0' part stays as found
            return nthCharOf(str, len(str) - n)
        }
        fun secondLastCharOf(str: String): Char {
            return nthLastCharOf(str, 2)
        }
        fun lastCharOf(str: String): Char {
            return nthLastCharOf(str, 1)
        }
        fun split(str: String): Array<String> {
            if (not(str)) return blank.Str
            // TESTED AND LEARNED: Java split(""), unlike in JavaScript , adds an
            // extra "" character at the beginning, i.e. at index 0, of the array
            // the string has been split into. JavaScript is way better in this
            // case.
            return slice(str.split("".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray(), 1)
        }
        fun split(str: String, delimiting_str_or_regex: String): Array<String> {
            if (not(str) || isNull(delimiting_str_or_regex)) return blank.Str
            // the null check was needed here
            var returnValue: Array<String> = str.split(delimiting_str_or_regex.toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            if (eq(delimiting_str_or_regex, "") || len(returnValue) > 0 && eq(returnValue[0], "")) returnValue = slice(returnValue, 1)
            // TESTED AND LEARNED: Java split(""), unlike in JavaScript , adds an
            // extra "" character at the beginning, i.e. at index 0, of the array
            // the string has been split into. JavaScript is way better in this
            // case.
            return returnValue
        }
        fun splitIntoWords(str: String): Array<String> {
            if (not(str)) return blank.Str
            return split(str, "[^a-zA-Z'\\-]+|\\-(![a-zA-Z]{2,})")
        }
        fun wordsOf(str: String): Array<String> {
            return splitIntoWords(str)
        }
        fun wordsIn(str: String): Boolean {
            return splitIntoWords(str).size > 0
        }
        fun join(arr: Array<String>, with: String): String {
            if (not(arr) || isNull<String>(with)) return ""
            return java.lang.String.join(with, *arr)
        }
        fun join(arr: IntArray, with: String): String {
            if (not(arr) || isNull<String>(with)) return ""
            val midProcessedArray: Array<String> = arrayOfNulls(arr.size)
            for (i: Int in range(arr)) midProcessedArray[i] = "" + arr[i]
            return java.lang.String.join(with, *midProcessedArray)
        }
        fun join(arr: LongArray, with: String): String {
            if (not(arr) || isNull<String>(with)) return ""
            val midProcessedArray: Array<String> = arrayOfNulls(arr.size)
            for (i: Int in range(arr)) midProcessedArray[i] = "" + arr[i]
            return java.lang.String.join(with, *midProcessedArray)
        }
        fun join(arr: FloatArray, with: String): String {
            if (not(arr) || isNull<String>(with)) return ""
            val midProcessedArray: Array<String> = arrayOfNulls(arr.size)
            for (i: Int in range(arr)) midProcessedArray[i] = "" + arr[i]
            return java.lang.String.join(with, *midProcessedArray)
        }
        fun join(arr: DoubleArray, with: String): String {
            if (not(arr) || isNull<String>(with)) return ""
            val midProcessedArray: Array<String> = arrayOfNulls(arr.size)
            for (i: Int in range(arr)) midProcessedArray[i] = "" + arr[i]
            return java.lang.String.join(with, *midProcessedArray)
        }
        fun join(arr: BooleanArray, with: String): String {
            if (not(arr) || isNull<String>(with)) return ""
            val midProcessedArray: Array<String> = arrayOfNulls(arr.size)
            for (i: Int in range(arr)) midProcessedArray[i] = "" + arr[i]
            return java.lang.String.join(with, *midProcessedArray)
        }
        fun join(arr: Array<Number>, with: String): String {
            if (not(arr) || isNull<String>(with)) return ""
            val midProcessedArray: Array<String> = arrayOfNulls(arr.size)
            for (i: Int in range(arr)) midProcessedArray[i] = "" + arr[i]
            return java.lang.String.join(with, *midProcessedArray)
        }
        fun join(arr: Array<Any>, with: String): String {
            if (not(arr) || isNull<String>(with)) return ""
            val midProcessedArray: Array<String> = arrayOfNulls(arr.size)
            for (i: Int in range(arr)) midProcessedArray[i] = "" + arr[i]
            return java.lang.String.join(with, *midProcessedArray)
        }
        fun join(vararg array: String): String {
            if (not(array)) return ""
            val halfProcessed = join(array, ", ")
            var returnValue = replace(halfProcessed, "(<=,)(\\s)(=\\w+$)",
                "$1and$1")
            // helps return a string in the American format of joining: a, b, and c
            // for
            // three items
            returnValue = sentCase(returnValue)
            return returnValue
        }
        fun join(vararg array: Int): String {
            if (not(array)) return ""
            val halfProcessed = join(array, ", ")
            var returnValue = replace(halfProcessed, "(<=,)(\\s)(=\\w+$)",
                "$1and$1")
            // helps return a string in the American format of joining: a, b, and c
            // for
            // three items
            returnValue = sentCase(returnValue)
            return returnValue
        }
        fun join(vararg array: Long): String {
            if (not(array)) return ""
            val halfProcessed = join(array, ", ")
            var returnValue = replace(halfProcessed, "(<=,)(\\s)(=\\w+$)",
                "$1and$1")
            // helps return a string in the American format of joining: a, b, and c
            // for
            // three items
            returnValue = sentCase(returnValue)
            return returnValue
        }
        fun join(vararg array: Float): String {
            if (not(array)) return ""
            val halfProcessed = join(array, ", ")
            var returnValue = replace(halfProcessed, "(<=,)(\\s)(=\\w+$)",
                "$1and$1")
            // helps return a string in the American format of joining: a, b, and c
            // for
            // three items
            returnValue = sentCase(returnValue)
            return returnValue
        }
        fun join(vararg array: Double): String {
            if (not(array)) return ""
            val halfProcessed = join(array, ", ")
            var returnValue = replace(halfProcessed, "(<=,)(\\s)(=\\w+$)",
                "$1and$1")
            // helps return a string in the American format of joining: a, b, and c
            // for
            // three items
            returnValue = sentCase(returnValue)
            return returnValue
        }
        fun join(vararg array: Boolean): String {
            if (not(array)) return ""
            val halfProcessed = join(array, ", ")
            var returnValue = replace(halfProcessed, "(<=,)(\\s)(=\\w+$)",
                "$1and$1")
            // helps return a string in the American format of joining: a, b, and c
            // for
            // three items
            returnValue = sentCase(returnValue)
            return returnValue
        }
        fun join(vararg array: Number): String {
            if (not(array)) return ""
            val halfProcessed = join(array, ", ")
            var returnValue = replace(halfProcessed, "(<=,)(\\s)(=\\w+$)",
                "$1and$1")
            // helps return a string in the American format of joining: a, b, and c
            // for
            // three items
            returnValue = sentCase(returnValue)
            return returnValue
        }
        fun join(vararg array: Any): String {
            if (not(array)) return ""
            val halfProcessed = join(array, ", ")
            var returnValue = replace(halfProcessed, "(<=,)(\\s)(=\\w+$)",
                "$1and$1")
            // helps return a string in the American format of joining: a, b, and c
            // for
            // three items
            returnValue = sentCase(returnValue)
            return returnValue
        }
        fun eq(x: String, y: String): Boolean {
            if (not(x) || not(y)) return false
            y = y.replace("^\\^|\\$$".toRegex(), "")
            return match(x, "^($y)$")
        }
        fun eq(x: String, y: String, strict: Boolean): Boolean {
            if (not(x) || not(y)) return false
            if (!strict) return eq(x, y) else {
                y = y.replace("^\\^|\\$$".toRegex(), "")
                return x == y || match(x, "^($y)$", true)
            }
        }
        fun uneq(x: String, y: String): Boolean {
            return !eq(x, y)
        }
        fun uneq(x: String, y: String, strict: Boolean): Boolean {
            return !eq(x, y, strict)
        }
        // numbers
        @kotlin.jvm.JvmOverloads
        fun Int(arg: String, base: Int = 10): Int {
            try {
                return arg.replace("(<=\\d)\\.\\d+".toRegex(), "").toInt(
                    base)
            } catch (err: java.lang.Exception) {
                return 0
            }
        }
        fun Int(n: Int): Int {
            return n
        }
        fun Int(n: Long): Int {
            return n.toInt()
        }
        fun Int(n: Float): Int {
            return n.toInt()
        }
        fun Int(n: Double): Int {
            return n.toInt()
        }
        fun Int(n: Number): Int {
            return n.toInt()
        }
        fun Int(b: Boolean): Int {
            return if (b == true) 1 else 0
        }
        fun Long(arg: String): Long {
            return Int(arg).toLong()
        }
        fun Long(n: Int): Long {
            return n.toLong()
        }
        fun Long(n: Long): Long {
            return n
        }
        fun Long(n: Float): Long {
            return n.toLong()
        }
        fun Long(n: Double): Long {
            return n.toLong()
        }
        fun Long(n: Number): Long {
            return n.toLong()
        }
        fun Long(b: Boolean): Long {
            return if (b == true) 1 else 0
        }
        fun Flt(arg: String): Float {
            try {
                return arg.replace("[^\\-\\d\\.]".toRegex(), "").toFloat()
            } catch (err: java.lang.Exception) {
                return 0
            }
        }
        fun Flt(n: Int): Float {
            return n.toFloat()
        }
        fun Flt(n: Long): Float {
            return n.toFloat()
        }
        fun Flt(n: Float): Float {
            return n
        }
        fun Flt(n: Double): Float {
            return n.toFloat()
        }
        fun Flt(n: Number): Float {
            return n.toFloat()
        }
        fun Flt(b: Boolean): Float {
            return if (b == true) 1 else 0
        }
        fun Dbl(arg: String): Double {
            try {
                return arg.replace("[^\\-\\d\\.]".toRegex(), "").toDouble()
            } catch (err: java.lang.Exception) {
                return 0
            }
        }
        fun Dbl(arg: Int): Double {
            return arg.toDouble()
        }
        fun Dbl(arg: Long): Double {
            return arg.toDouble()
        }
        fun Dbl(arg: Float): Double {
            return arg.toDouble()
        }
        fun Dbl(arg: Double): Double {
            return arg
        }
        fun Dbl(n: Number): Double {
            return n.toDouble()
        }
        fun Dbl(b: Boolean): Double {
            return if (b == true) 1 else 0
        }
        fun Double(arg: String): Double {
            return Dbl(arg)
        }
        fun Double(arg: Int): Double {
            return Dbl(arg)
        }
        fun Double(arg: Long): Double {
            return Dbl(arg)
        }
        fun Double(arg: Float): Double {
            return Dbl(arg)
        }
        fun Double(arg: Double): Double {
            return arg
        }
        fun Double(n: Number): Double {
            return Dbl(n)
        }
        fun Double(arg: Boolean): Double {
            return Dbl(arg)
        }
        fun setPrecision(n: Double, decimalPlaces: Int): Double {
            if (not(n) || isNull(decimalPlaces) || isNeg(decimalPlaces)) return n
            val formatted: String = String.format("%." + Str(decimalPlaces) + "f", n)
            return Dbl(formatted)
        }
        fun toPrecision(n: Double, decimalPlaces: Int): Double {
            return setPrecision(n, decimalPlaces)
        }
        fun setPrecision(n: Double): Double {
            return setPrecision(n, 1)
        }
        fun toPrecision(n: Double): Double {
            return setPrecision(n)
        }
        fun setPrecision(n: Float, decimalPlaces: Int): Float {
            if (not(n) || isNull(decimalPlaces) || isNeg(decimalPlaces)) return n
            val formatted: String = String.format("%." + Str(decimalPlaces) + "f", n)
            return Flt(formatted)
        }
        fun toPrecision(n: Float, decimalPlaces: Int): Float {
            return setPrecision(n, decimalPlaces)
        }
        fun setPrecision(n: Float): Float {
            return setPrecision(n, 1)
        }
        fun toPrecision(n: Float): Float {
            return setPrecision(n)
        }
        fun <T> List(vararg args: T): List<T> {
            return Arrays.asList<T>(*args)
        }
        // may or MAY NOT work, as working with generic types can be unpredictable,
        // as
        // learned from the mistakes in the past. So, here are some backup plans:
        fun List(vararg arg: String): List<String> {
            return Arrays.asList<String>(*arg)
        }
        fun List(vararg arg: Int): List<Int> {
            return Arrays.asList<Int>(*arg)
        }
        fun List(vararg arg: Long): List<Long> {
            return Arrays.asList<Long>(*arg)
        }
        fun List(vararg arg: Float): List<Float> {
            return Arrays.asList<Float>(*arg)
        }
        fun List(vararg arg: Double): List<Double> {
            return Arrays.asList<Double>(*arg)
        }
        fun List(vararg arg: Boolean): List<Boolean> {
            return Arrays.asList<Boolean>(*arg)
        }
        fun <T> list(vararg args: T): List<T> {
            return List(*args)
        }
        // may or MAY NOT work, as working with generic types can be unpredictable,
        // as
        // learned from the mistakes in the past. So, here are some backup plans:
        fun list(vararg arg: String): List<String> {
            return List(*arg)
        }
        fun list(vararg arg: Int): List<Int> {
            return List(*arg)
        }
        fun list(vararg arg: Long): List<Long> {
            return List(*arg)
        }
        fun list(vararg arg: Float): List<Float> {
            return List(*arg)
        }
        fun list(vararg arg: Double): List<Double> {
            return List(*arg)
        }
        fun list(vararg arg: Boolean): List<Boolean> {
            return List(*arg)
        }
        fun isIntLike(s: String): Boolean {
            if (not(s)) return false
            try {
                return s.toInt() % 1 == 0
            } catch (err: java.lang.Exception) {
                return false
            }
        }
        fun isLongLike(s: String): Boolean {
            return isIntLike(s)
        }
        fun isFltLike(s: String): Boolean {
            if (not(s)) return false
            try {
                return s.toFloat() % 1 != 0f
            } catch (err: java.lang.Exception) {
                return false
            }
        }
        fun isDblLike(s: String): Boolean {
            if (not(s)) return false
            try {
                return s.toDouble() % 1 != 0.0
            } catch (err: java.lang.Exception) {
                return false
            }
        }
        fun isChar(o: Any): Boolean {
            return type(o, Char)
        }
        fun isStr(o: Any): Boolean {
            return type(o, Str)
        }
        fun isInt(o: Any): Boolean {
            return type(o, Int)
        }
        fun isLong(o: Any): Boolean {
            return type(o, Long)
        }
        fun isFlt(o: Any): Boolean {
            return type(o, Flt)
        }
        fun isDbl(o: Any): Boolean {
            return type(o, Dbl)
        }
        fun isBool(o: Any): Boolean {
            return type(o, Bool)
        }
        fun isArr(o: Any): Boolean {
            return type(o, Arr)
        }
        fun isArrOfChar(o: Any): Boolean {
            return type(o, ArrOfChar)
        }
        fun isArrOfStr(o: Any): Boolean {
            return type(o, ArrOfStr)
        }
        fun isArrOfInt(o: Any): Boolean {
            return type(o, ArrOfInt)
        }
        fun isArrOfLong(o: Any): Boolean {
            return type(o, ArrOfLong)
        }
        fun isArrOfFlt(o: Any): Boolean {
            return type(o, ArrOfFlt)
        }
        fun isArrOfDbl(o: Any): Boolean {
            return type(o, ArrOfDbl)
        }
        fun isArrOfBool(o: Any): Boolean {
            return type(o, ArrOfBool)
        }
        fun isArrOfNum(o: Any): Boolean {
            return type(o, ArrOfNum)
        }
        fun isArrOfObj(o: Any): Boolean {
            return type(o, ArrOfObj)
        }
        fun isAlpha(c: Char): Boolean {
            return c.code >= 65 && c.code <= 122
        }
        fun isPos(n: Int): Boolean {
            return n > 0
        }
        fun isPos(n: Long): Boolean {
            return n > 0
        }
        fun isPos(n: Float): Boolean {
            return n > 0
        }
        fun isPos(n: Double): Boolean {
            return n > 0
        }
        fun isNeg(n: Int): Boolean {
            return n < 0
        }
        fun isNeg(n: Long): Boolean {
            return n < 0
        }
        fun isNeg(n: Float): Boolean {
            return n < 0
        }
        fun isNeg(n: Double): Boolean {
            return n < 0
        }
        fun Pos(n: Int): Int {
            return java.lang.Math.abs(n)
        }
        fun Pos(n: Long): Long {
            return java.lang.Math.abs(n)
        }
        fun Pos(n: Float): Float {
            return java.lang.Math.abs(n)
        }
        fun Pos(n: Double): Double {
            return java.lang.Math.abs(n)
        }
        fun Neg(n: Int): Int {
            return -Pos(n)
        }
        fun Neg(n: Long): Long {
            return -Pos(n)
        }
        fun Neg(n: Float): Float {
            return -Pos(n)
        }
        fun Neg(n: Double): Double {
            return -Pos(n)
        }
        fun Neg(b: Boolean): Boolean {
            return not(b)
        }
        fun reverse(n: Int): Int {
            return if (n > 0) Neg(n) else Pos(n)
        }
        fun reverse(n: Long): Long {
            return if (n > 0) Neg(n) else Pos(n)
        }
        fun reverse(n: Float): Float {
            return if (n > 0) Neg(n) else Pos(n)
        }
        fun reverse(n: Double): Double {
            return if (n > 0) Neg(n) else Pos(n)
        }
        fun sum(vararg ns: Int): Int {
            if (not(ns)) return 0
            var acc = 0
            for (next in ns.indices) acc += ns[next]
            return acc
        }
        fun sum(vararg ns: Long): Long {
            if (not(ns)) return 0
            var acc: Long = 0
            for (next in ns.indices) acc += ns[next]
            return acc
        }
        fun sum(vararg ns: Float): Float {
            if (not(ns)) return 0
            var acc = 0f
            for (next in ns.indices) acc += ns[next]
            return acc
        }
        fun sum(vararg ns: Double): Double {
            if (not(ns)) return 0
            var acc = 0.0
            for (next in ns.indices) acc += ns[next]
            return acc
        }
        fun difference(vararg ns: Int): Int {
            if (not(ns)) return 0
            var acc = ns[0]
            for (next in 1 until ns.size) acc -= ns[next]
            return acc
        }
        fun difference(vararg ns: Long): Long {
            if (not(ns)) return 0
            var acc = ns[0]
            for (next in 1 until ns.size) acc -= ns[next]
            return acc
        }
        fun difference(vararg ns: Float): Float {
            if (not(ns)) return 0
            var acc = ns[0]
            for (next in 1 until ns.size) acc -= ns[next]
            return acc
        }
        fun difference(vararg ns: Double): Double {
            if (not(ns)) return 0
            var acc = ns[0]
            for (next in 1 until ns.size) acc -= ns[next]
            return acc
        }
        fun product(vararg ns: Int): Int {
            if (not(ns)) return 0
            var acc = ns[0]
            for (next in 1 until ns.size) acc *= ns[next]
            return acc
        }
        fun product(vararg ns: Long): Long {
            if (not(ns)) return 0
            var acc = ns[0]
            for (next in 1 until ns.size) acc *= ns[next]
            return acc
        }
        fun product(vararg ns: Float): Float {
            if (not(ns)) return 0
            var acc = ns[0]
            for (next in 1 until ns.size) acc *= ns[next]
            return acc
        }
        fun product(vararg ns: Double): Double {
            if (not(ns)) return 0
            var acc = ns[0]
            for (next in 1 until ns.size) acc *= ns[next]
            return acc
        }
        fun quotient(vararg ns: Int): Int {
            if (not(ns)) return 0
            var acc = ns[0]
            for (next in 1 until ns.size) acc /= ns[next]
            return acc
        }
        fun quotient(vararg ns: Long): Long {
            if (not(ns)) return 0
            var acc = ns[0]
            for (next in 1 until ns.size) acc /= ns[next]
            return acc
        }
        fun quotient(vararg ns: Float): Float {
            if (not(ns)) return 0
            var acc = ns[0]
            for (next in 1 until ns.size) acc /= ns[next]
            return acc
        }
        fun quotient(vararg ns: Double): Double {
            if (not(ns)) return 0
            var acc = ns[0]
            for (next in 1 until ns.size) acc /= ns[next]
            return acc
        }
        fun pow(n: Int, power: Int): Int {
            return if (isNull<Int>(n, power)) 0 else java.lang.Math.pow(n.toDouble(), power.toDouble()).toInt()
        }
        fun sq(n: Double): Double {
            return n * n
        }
        fun sqrt(n: Double): Double {
            return java.lang.Math.sqrt(n)
        }
        fun cb(n: Double): Double {
            return sq(n) * n
        }
        fun cbrt(n: Double): Double {
            return java.lang.Math.cbrt(n)
        }
        fun area(w: Double, h: Double): Double {
            return w * h
        }
        fun tria(w: Double, h: Double): Double {
            return .5 * area(w, h)
        }
        fun min(vararg nums: Int): Int {
            val stat: IntSummaryStatistics = Arrays.stream(nums).summaryStatistics()
            return stat.getMin()
        }
        fun min(vararg nums: Long): Long {
            val stat: LongSummaryStatistics = Arrays.stream(nums).summaryStatistics()
            return stat.getMin()
        }
        fun min(vararg nums: Double): Double {
            val stat: DoubleSummaryStatistics = Arrays.stream(nums).summaryStatistics()
            return stat.getMin()
        }
        fun mod(n1: Double, n2: Double): Double {
            if (n2 > n1) {
                // swap
                n1 += n2
                n2 = n1 - n2
                n1 -= n2
            }
            return java.lang.Math.abs(n1 % n2)
        }
        fun isPerfectMod(n1: Double, n2: Double): Boolean {
            return mod(n1, n2) == 0.0
        }
        fun isDivisorOf(n1: Int, n2: Int): Boolean {
            return isPerfectMod(n1.toDouble(), n2.toDouble())
        }
        fun isDivisorOf(n1: Long, n2: Long): Boolean {
            return isPerfectMod(n1.toDouble(), n2.toDouble())
        }
        fun isEven(n: Int): Boolean {
            return isPerfectMod(n.toDouble(), 2.0)
        }
        fun isEven(n: Long): Boolean {
            return isPerfectMod(n.toDouble(), 2.0)
        }
        fun isOdd(n: Int): Boolean {
            return !isPerfectMod(n.toDouble(), 2.0)
        }
        fun isOdd(n: Long): Boolean {
            return !isPerfectMod(n.toDouble(), 2.0)
        }
        fun isPrime(n: Double): Boolean {
            var i = 2
            while (i <= n / 2) {
                if (n % i == 0.0) return false
                i++
            }
            return true
        }
        fun th(n: Int): String {
            var result = Str(n)
            val size = len(result)
            val seclast_char = if (size - 2 >= 0) result[size - 2] else '\u0000'
            val last_char = if (size - 1 >= 0) result[size - 1] else '\u0000'
            val last_two = Str(seclast_char) + Str(last_char)
            if (n > 14 && n < 111) {
                when (last_char) {
                    '1' -> result += "st"
                    '2' -> result += "nd"
                    '3' -> result += "rd"
                    else -> result += "th"
                }
            } else {
                if (eq(last_two, "11") || eq(last_two, "12") || eq(last_two, "13")) result += "th" else {
                    when (last_char) {
                        '1' -> result += "st"
                        '2' -> result += "nd"
                        '3' -> result += "rd"
                        else -> result += "th"
                    }
                }
            }
            return result
        }
        fun th(n: Long): String {
            var result = Str(n)
            val size = len(result)
            val seclast_char = if (size - 2 >= 0) result[size - 2] else '\u0000'
            val last_char = if (size - 1 >= 0) result[size - 1] else '\u0000'
            val last_two = Str(seclast_char) + Str(last_char)
            if (n > 14 && n < 111) {
                when (last_char) {
                    '1' -> result += "st"
                    '2' -> result += "nd"
                    '3' -> result += "rd"
                    else -> result += "th"
                }
            } else {
                if (eq(last_two, "11") || eq(last_two, "12") || eq(last_two, "13")) result += "th" else {
                    when (last_char) {
                        '1' -> result += "st"
                        '2' -> result += "nd"
                        '3' -> result += "rd"
                        else -> result += "th"
                    }
                }
            }
            return result
        }
        // since a long is just a LONG integer, this should work^
        // let's set up some currency variables
        var zr = 1e3
        var lc = 1e5
        var cr = 1e7
        var ar = 1e9
        var kh = 1e11
        var K = 1e3
        var M = 1e6
        var B = 1e9
        var T = 1e12
        var qd = 1e15
        var qt = 1e18
        var sx = 1e21
        var sp = 1e24
        var oc = 1e27
        var nn = 1e30
        var dc = 1e33
        fun fpkr(amount: Int): String {
            if (isNull(amount)) return ""
            val floats = (amount % 1).toDouble()
            val amountFix = Long(amount - floats)
            val stringBuilder = StringBuilder()
            val amountArray: CharArray = Str(amountFix).toCharArray()
            var a = 0
            var b = 0
            for (i in amountArray.indices.reversed()) {
                if (a < 3) {
                    stringBuilder.append(amountArray[i])
                    a++
                } else if (b < 2) {
                    if (b == 0) {
                        stringBuilder.append(",")
                        stringBuilder.append(amountArray[i])
                        b++
                    } else {
                        stringBuilder.append(amountArray[i])
                        b = 0
                    }
                }
            }
            return replace(
                stringBuilder.reverse().toString() + "."
                        + sliceToAfter(Str(floats), "."),
                "(<=\\.\\d{2})\\d+", "")
        }
        fun fpkr(amount: Long): String {
            if (isNull(amount)) return ""
            val floats = (amount % 1).toDouble()
            val amountFix = Long(amount - floats)
            val stringBuilder = StringBuilder()
            val amountArray: CharArray = Str(amountFix).toCharArray()
            var a = 0
            var b = 0
            for (i in amountArray.indices.reversed()) {
                if (a < 3) {
                    stringBuilder.append(amountArray[i])
                    a++
                } else if (b < 2) {
                    if (b == 0) {
                        stringBuilder.append(",")
                        stringBuilder.append(amountArray[i])
                        b++
                    } else {
                        stringBuilder.append(amountArray[i])
                        b = 0
                    }
                }
            }
            return replace(
                (stringBuilder.reverse().toString() + "."
                        + sliceToAfter(Str(floats), ".")),
                "(<=\\.\\d{2})\\d+", "")
        }
        fun fpkr(amount: Float): String {
            if (isNull(amount)) return ""
            val floats = setPrecision(amount % 1).toDouble()
            val amountFix = Long(amount - floats)
            val stringBuilder = StringBuilder()
            val amountArray: CharArray = Str(amountFix).toCharArray()
            var a = 0
            var b = 0
            for (i in amountArray.indices.reversed()) {
                if (a < 3) {
                    stringBuilder.append(amountArray[i])
                    a++
                } else if (b < 2) {
                    if (b == 0) {
                        stringBuilder.append(",")
                        stringBuilder.append(amountArray[i])
                        b++
                    } else {
                        stringBuilder.append(amountArray[i])
                        b = 0
                    }
                }
            }
            return replace(
                (stringBuilder.reverse().toString() + "."
                        + sliceToAfter(Str(floats), ".")),
                "(<=\\.\\d{2})\\d+", "")
        }
        fun fpkr(amount: Double): String {
            if (isNull(amount)) return ""
            val floats = setPrecision(amount % 1)
            val amountFix = Long(amount - floats)
            val stringBuilder = StringBuilder()
            val amountArray: CharArray = Str(amountFix).toCharArray()
            var a = 0
            var b = 0
            for (i in amountArray.indices.reversed()) {
                if (a < 3) {
                    stringBuilder.append(amountArray[i])
                    a++
                } else if (b < 2) {
                    if (b == 0) {
                        stringBuilder.append(",")
                        stringBuilder.append(amountArray[i])
                        b++
                    } else {
                        stringBuilder.append(amountArray[i])
                        b = 0
                    }
                }
            }
            return replace(
                (stringBuilder.reverse().toString() + "."
                        + sliceToAfter(Str(floats), ".")),
                "(<=\\.\\d{2})\\d+", "")
        }
        fun fus(n: Int): String {
            return if (isNull<Int>(n)) "" else NumberFormat
                .getCurrencyInstance(Locale.Builder().setLanguage("en")
                    .setRegion("US").build())
                .format(n.toLong()).replace("[^\\d\\,\\.]".toRegex(), "")
        }
        fun fus(n: Long): String {
            return if (isNull<Long>(n)) "" else NumberFormat
                .getCurrencyInstance(Locale.Builder().setLanguage("en")
                    .setRegion("US").build())
                .format(n).replace("[^\\d\\,\\.]".toRegex(), "")
        }
        fun fus(n: Float): String {
            return if (isNull<Float>(n)) "" else NumberFormat
                .getCurrencyInstance(Locale.Builder().setLanguage("en")
                    .setRegion("US").build())
                .format(n.toDouble()).replace("[^\\d\\,\\.]".toRegex(), "")
        }
        fun fus(n: Double): String {
            return if (isNull<Double>(n)) "" else NumberFormat
                .getCurrencyInstance(Locale.Builder().setLanguage("en")
                    .setRegion("US").build())
                .format(n).replace("[^\\d\\,\\.]".toRegex(), "")
        }
        fun f(n: Int): String {
            return fpkr(n)
        }
        fun f(n: Long): String {
            return fpkr(n)
        }
        fun f(n: Float): String {
            return fpkr(n)
        }
        fun f(n: Double): String {
            return fpkr(n)
        }
        fun pkr(n: Int): String {
            val formattedN = fpkr(n)
            return "Rs. $formattedN"
        }
        fun pkr(n: Long): String {
            val formattedN = fpkr(n)
            return "Rs. $formattedN"
        }
        fun pkr(n: Float): String {
            val formattedN = fpkr(n)
            return "Rs. $formattedN"
        }
        fun pkr(n: Double): String {
            val formattedN = fpkr(n)
            return "Rs. $formattedN"
        }
        fun usd(n: Int): String {
            val formattedN = fus(n)
            return "USD $formattedN"
        }
        fun usd(n: Long): String {
            val formattedN = fus(n)
            return "USD $formattedN"
        }
        fun usd(n: Float): String {
            val formattedN = fus(n)
            return "USD $formattedN"
        }
        fun usd(n: Double): String {
            val formattedN = fus(n)
            return "USD $formattedN"
        }
        fun curr(n: Int, locale: String): String {
            val formattedN = fus(n)
            if (startsWith(locale, "pk|in|rs")) return pkr(n) else if (startsWith(locale, "us")) return usd(n) else if (len(locale) >= 1 && len(locale) <= 4) return trim(titleCase(locale)) + " " + formattedN
            return formattedN
        }
        fun curr(n: Long, locale: String): String {
            val formattedN = fus(n)
            if (startsWith(locale, "pk|in|rs")) return pkr(n) else if (startsWith(locale, "us")) return usd(n) else if (len(locale) >= 1 && len(locale) < 4) return trim(titleCase(locale)) + " " + formattedN
            return formattedN
        }
        fun curr(n: Float, locale: String): String {
            val formattedN = fus(n)
            if (startsWith(locale, "pk|in|rs")) return pkr(n) else if (startsWith(locale, "us")) return usd(n) else if (len(locale) >= 1 && len(locale) < 4) return trim(titleCase(locale)) + " " + formattedN
            return formattedN
        }
        fun curr(n: Double, locale: String): String {
            val formattedN = fus(n)
            if (startsWith(locale, "pk|in|rs")) return pkr(n) else if (startsWith(locale, "us")) return usd(n) else if (len(locale) >= 1 && len(locale) < 4) return trim(titleCase(locale)) + " " + formattedN
            return formattedN
        }
        fun pksuffix(n: Int): String {
            n -= n % 1
            val formattedN = fpkr(n)
            val parts = split(formattedN, ",")
            val size = len(parts)
            if (n < 800 || n > 99 * kh) return formattedN
            var result = ""
            when (size) {
                1, 2 -> result = Str(n / zr) + "zr"
                3 -> result = Str(n / lc) + "lc"
                4 -> result = Str(n / cr) + "cr"
                5 -> result = Str(n / ar) + "ar"
                6 -> result = Str(n / kh) + "kh"
            }
            return result
        }
        fun pksuffix(n: Long): String {
            n -= n % 1
            val formattedN = fpkr(n)
            val parts = split(formattedN, ",")
            val size = len(parts)
            if (n < 800 || n > 99 * kh) return formattedN
            var result = ""
            when (size) {
                1, 2 -> result = Str(n / zr) + "zr"
                3 -> result = Str(n / lc) + "lc"
                4 -> result = Str(n / cr) + "cr"
                5 -> result = Str(n / ar) + "ar"
                6 -> result = Str(n / kh) + "kh"
            }
            return result
        }
        fun pksuffix(n: Float): String {
            n -= n % 1
            val formattedN = fpkr(n)
            val parts = split(formattedN, ",")
            val size = len(parts)
            if (n < 800 || n > 99 * kh) return formattedN
            var result = ""
            when (size) {
                1, 2 -> result = Str(n / zr) + "zr"
                3 -> result = Str(n / lc) + "lc"
                4 -> result = Str(n / cr) + "cr"
                5 -> result = Str(n / ar) + "ar"
                6 -> result = Str(n / kh) + "kh"
            }
            return result
        }
        fun pksuffix(n: Double): String {
            n -= n % 1
            val formattedN = fpkr(n)
            val parts = split(formattedN, ",")
            val size = len(parts)
            if (n < 800 || n > 99 * kh) return formattedN
            var result = ""
            when (size) {
                1, 2 -> result = Str(n / zr) + "zr"
                3 -> result = Str(n / lc) + "lc"
                4 -> result = Str(n / cr) + "cr"
                5 -> result = Str(n / ar) + "ar"
                6 -> result = Str(n / kh) + "kh"
            }
            return result
        }
        fun ussuffix(n: Int): String {
            n -= n % 1
            val formattedN = fus(n)
            val parts = split(formattedN, ",")
            val size = len(parts)
            if (n < 800 || n > 99 * dc) return formattedN
            var result = ""
            when (size) {
                1, 2 -> result = Str(n / K) + "k"
                3 -> result = Str(n / M) + "M"
                4 -> result = Str(n / B) + "B"
                5 -> result = Str(n / T) + "T"
                6 -> result = Str(n / qd) + "qd"
                7 -> result = Str(n / qt) + "qt"
                8 -> result = Str(n / sx) + "sx"
                9 -> result = Str(n / sp) + "sp"
                10 -> result = Str(n / oc) + "oc"
                11 -> result = Str(n / nn) + "nn"
                12 -> result = Str(n / dc) + "dc"
            }
            return result
        }
        fun ussuffix(n: Long): String {
            n -= n % 1
            val formattedN = fus(n)
            val parts = split(formattedN, ",")
            val size = len(parts)
            if (n < 800 || n > 99 * dc) return formattedN
            var result = ""
            when (size) {
                1, 2 -> result = Str(n / K) + "k"
                3 -> result = Str(n / M) + "M"
                4 -> result = Str(n / B) + "B"
                5 -> result = Str(n / T) + "T"
                6 -> result = Str(n / qd) + "qd"
                7 -> result = Str(n / qt) + "qt"
                8 -> result = Str(n / sx) + "sx"
                9 -> result = Str(n / sp) + "sp"
                10 -> result = Str(n / oc) + "oc"
                11 -> result = Str(n / nn) + "nn"
                12 -> result = Str(n / dc) + "dc"
            }
            return result
        }
        fun ussuffix(n: Float): String {
            n -= n % 1
            val formattedN = fus(n)
            val parts = split(formattedN, ",")
            val size = len(parts)
            if (n < 800 || n > 99 * dc) return formattedN
            var result = ""
            when (size) {
                1, 2 -> result = Str(n / K) + "k"
                3 -> result = Str(n / M) + "M"
                4 -> result = Str(n / B) + "B"
                5 -> result = Str(n / T) + "T"
                6 -> result = Str(n / qd) + "qd"
                7 -> result = Str(n / qt) + "qt"
                8 -> result = Str(n / sx) + "sx"
                9 -> result = Str(n / sp) + "sp"
                10 -> result = Str(n / oc) + "oc"
                11 -> result = Str(n / nn) + "nn"
                12 -> result = Str(n / dc) + "dc"
            }
            return result
        }
        fun ussuffix(n: Double): String {
            n -= n % 1
            val formattedN = fus(n)
            val parts = split(formattedN, ",")
            val size = len(parts)
            if (n < 800 || n > 99 * dc) return formattedN
            var result = ""
            when (size) {
                1, 2 -> result = Str(n / K) + "k"
                3 -> result = Str(n / M) + "M"
                4 -> result = Str(n / B) + "B"
                5 -> result = Str(n / T) + "T"
                6 -> result = Str(n / qd) + "qd"
                7 -> result = Str(n / qt) + "qt"
                8 -> result = Str(n / sx) + "sx"
                9 -> result = Str(n / sp) + "sp"
                10 -> result = Str(n / oc) + "oc"
                11 -> result = Str(n / nn) + "nn"
                12 -> result = Str(n / dc) + "dc"
            }
            return result
        }
        fun toRoman(n: Int): String {
            val tree = treeI()
            tree.add(1, "I").add(4, "IV").add(5, "V").add(9, "IX").add(10, "X")
                .add(40, "XL").add(50, "L").add(90, "XC").add(100, "C")
                .add(400, "CD").add(500, "D").add(900, "CM").add(1000, "M")
                .add(4000, "M_V").add(9000, "I_X").add(10000, "_X")
            val x: Int = tree.floorKey(n)
            return if (n != x) tree.get(x) + toRoman(n - x) else tree.get(n)
        }
        fun fibonacci(n: Int): Int {
            return if (n < 2) n else fibonacci(n - 1) + fibonacci(n - 2)
        }
        fun fibonacciSequence(n: Int): IntArray {
            val result = KL.intArr()
            for (i: Int in range(n)) result.push(fibonacci(i + 1))
            return result.array()
        }
        fun percentify(n1: Double, n2: Double): Double {
            if (not(n1) || not(n2)) return 0
            return if (n1 < n2) java.lang.Math.round(n1 / n2 * 100.0) / 100.0 else java.lang.Math.round(n1 * (n2 * .01) * 100.0) / 100.0
        }
        val infinity: Double = POSITIVE_INFINITY
        fun <T> isNull(vararg objs: T): Boolean {
            if (objs == null) return true
            var count = 0
            for (o: Any in objs) {
                if ((o == null
                            || (if (o is Double) isInfinity(o) else false))) {
                    // tested: the else false clause stays, as it gets ignored; if o
                    // is a non-double, only the first condition is tested, the RHS
                    // will just be ignored
                    count++
                }
            }
            return count > 0
        }
        fun <T> isNull(vararg subArrays: Array<T>): Boolean {
            if (subArrays == null) return true
            var count = 0
            for (arr: Array<Any> in subArrays) {
                if (isNull<Any>(*arr)) count++
            }
            return count > 0
            // to handle null arrays, not just regular objects
        }
        fun <T> isNl(vararg objs: T): Boolean {
            return isNull(*objs)
        }
        fun <T> isNl(vararg subArrays: Array<T>): Boolean {
            return isNull<T>(*subArrays)
        }
        fun <T> isnl(vararg objs: T): Boolean {
            return isNull(*objs)
        }
        fun <T> isnl(vararg subArrays: Array<T>): Boolean {
            return isNull<T>(*subArrays)
        }
        fun isInfinity(n: Double): Boolean {
            return n == infinity || n == NEGATIVE_INFINITY
        }
        fun isInf(n: Double): Boolean {
            return isInfinity(n)
        }
        fun isinf(n: Double): Boolean {
            return isInfinity(n)
        }
        fun round(n: Int): Int {
            return n
        }
        fun round(n: Long): Long {
            return n
        }
        fun round(n: Float): Int {
            return java.lang.Math.round(n)
        }
        fun round(n: Double): Int {
            return java.lang.Math.round(n).toInt()
        }
        fun ceil(n: Int): Int {
            return n
        }
        fun ceil(n: Long): Long {
            return n
        }
        fun ceil(n: Float): Int {
            return java.lang.Math.ceil(n.toDouble()).toInt()
        }
        fun ceil(n: Double): Int {
            return java.lang.Math.ceil(n).toInt()
        }
        fun floor(n: Int): Int {
            return n
        }
        fun floor(n: Long): Long {
            return n
        }
        fun floor(n: Float): Int {
            return java.lang.Math.floor(n.toDouble()).toInt()
        }
        fun floor(n: Double): Int {
            return java.lang.Math.floor(n).toInt()
        }
        fun celciusToFarhenheit(c: Double): Double {
            return round(1.8 * c + 32).toDouble()
        }
        fun farhenheitToCelcius(f: Double): Double {
            return round(((f - 32) * 5) / 9).toDouble()
        }
        fun cToF(c: Double): Double {
            return celciusToFarhenheit(c)
        }
        fun fToC(f: Double): Double {
            return farhenheitToCelcius(f)
        }
        fun eq(x: Char, y: Char): Boolean {
            return x == y
        }
        fun eq(x: Int, y: Int): Boolean {
            return x == y
        }
        fun eq(x: Long, y: Long): Boolean {
            return x == y
        }
        fun eq(x: Float, y: Float): Boolean {
            return x == y
        }
        fun eq(x: Double, y: Double): Boolean {
            return x == y
        }
        fun eq(x: Boolean, y: Boolean): Boolean {
            return x == y
        }
        fun eq(x: Any, y: Any): Boolean {
            return (x == y)
        }
        fun eq(x: Array<String>, y: Array<String>): Boolean {
            return Arrays.equals(x, y)
        }
        fun eq(x: IntArray, y: IntArray): Boolean {
            return Arrays.equals(x, y)
        }
        fun eq(x: LongArray, y: LongArray): Boolean {
            return Arrays.equals(x, y)
        }
        fun eq(x: FloatArray, y: FloatArray): Boolean {
            return Arrays.equals(x, y)
        }
        fun eq(x: DoubleArray, y: DoubleArray): Boolean {
            return Arrays.equals(x, y)
        }
        fun eq(x: BooleanArray, y: BooleanArray): Boolean {
            return Arrays.equals(x, y)
        }
        fun eq(x: Array<Any>, y: Array<Any>): Boolean {
            return Arrays.equals(x, y)
        }
        fun uneq(x: Char, y: Char): Boolean {
            return !eq(x, y)
        }
        fun uneq(x: Int, y: Int): Boolean {
            return !eq(x, y)
        }
        fun uneq(x: Long, y: Long): Boolean {
            return !eq(x, y)
        }
        fun uneq(x: Float, y: Float): Boolean {
            return !eq(x, y)
        }
        fun uneq(x: Double, y: Double): Boolean {
            return !eq(x, y)
        }
        fun uneq(x: Boolean, y: Boolean): Boolean {
            return !eq(x, y)
        }
        fun uneq(x: Any, y: Any): Boolean {
            return !eq(x, y)
        }
        fun uneq(x: Array<String>, y: Array<String>): Boolean {
            return !eq(x, y)
        }
        fun uneq(x: IntArray, y: IntArray): Boolean {
            return !eq(x, y)
        }
        fun uneq(x: LongArray, y: LongArray): Boolean {
            return !eq(x, y)
        }
        fun uneq(x: FloatArray, y: FloatArray): Boolean {
            return !eq(x, y)
        }
        fun uneq(x: DoubleArray, y: DoubleArray): Boolean {
            return !eq(x, y)
        }
        fun uneq(x: BooleanArray, y: BooleanArray): Boolean {
            return !eq(x, y)
        }
        fun uneq(x: Array<Any>, y: Array<Any>): Boolean {
            return !eq(x, y)
        }
        fun both(vararg strings: String): Boolean {
            var count = 0
            for (s: String in strings) {
                if (`is`(s)) count += 1
            }
            return count == len(strings)
        }
        fun both(vararg ints: Int): Boolean {
            var count = 0
            for (n: Int in ints) {
                if (`is`(n)) count += 1
            }
            return count == len(ints)
        }
        fun both(vararg longs: Long): Boolean {
            var count = 0
            for (n: Long in longs) {
                if (`is`(n)) count += 1
            }
            return count == len(longs)
        }
        fun both(vararg floats: Float): Boolean {
            var count = 0
            for (n: Float in floats) {
                if (`is`(n)) count += 1
            }
            return count == len(floats)
        }
        fun both(vararg doubles: Double): Boolean {
            var count = 0
            for (n: Double in doubles) {
                if (`is`(n)) count += 1
            }
            return count == len(doubles)
        }
        fun both(vararg bools: Boolean): Boolean {
            var count = 0
            for (bool: Boolean in bools) {
                if (`is`(bool)) count += 1
            }
            return count == len(bools)
        }
        fun either(vararg strings: String): Boolean {
            var count = 0
            for (s: String in strings) {
                if (`is`(s)) count += 1
            }
            return count > 0
        }
        fun either(vararg ints: Int): Boolean {
            var count = 0
            for (n: Int in ints) {
                if (`is`(n)) count += 1
            }
            return count > 0
        }
        fun either(vararg longs: Long): Boolean {
            var count = 0
            for (n: Long in longs) {
                if (`is`(n)) count += 1
            }
            return count > 0
        }
        fun either(vararg floats: Float): Boolean {
            var count = 0
            for (n: Float in floats) {
                if (`is`(n)) count += 1
            }
            return count > 0
        }
        fun either(vararg doubles: Double): Boolean {
            var count = 0
            for (n: Double in doubles) {
                if (`is`(n)) count += 1
            }
            return count > 0
        }
        fun either(vararg bools: Boolean): Boolean {
            var count = 0
            for (bool: Boolean in bools) {
                if (`is`(bool)) count += 1
            }
            return count > 0
        }
        fun any(vararg strings: String): Boolean {
            return either(*strings)
        }
        fun any(vararg ints: Int): Boolean {
            return either(*ints)
        }
        fun any(vararg longs: Long): Boolean {
            return either(*longs)
        }
        fun any(vararg floats: Float): Boolean {
            return either(*floats)
        }
        fun any(vararg doubles: Double): Boolean {
            return either(*doubles)
        }
        fun any(vararg bools: Boolean): Boolean {
            return either(*bools)
        }
        fun neither(vararg strings: String): Boolean {
            var count = 0
            for (s: String in strings) {
                if (not(s)) count += 1
            }
            return count == len(strings)
        }
        fun neither(vararg ints: Int): Boolean {
            var count = 0
            for (n: Int in ints) {
                if (not(n)) count += 1
            }
            return count == len(ints)
        }
        fun neither(vararg longs: Long): Boolean {
            var count = 0
            for (n: Long in longs) {
                if (not(n)) count += 1
            }
            return count == len(longs)
        }
        fun neither(vararg floats: Float): Boolean {
            var count = 0
            for (n: Float in floats) {
                if (not(n)) count += 1
            }
            return count == len(floats)
        }
        fun neither(vararg doubles: Double): Boolean {
            var count = 0
            for (n: Double in doubles) {
                if (not(n)) count += 1
            }
            return count == len(doubles)
        }
        fun neither(vararg bools: Boolean): Boolean {
            var count = 0
            for (bool: Boolean in bools) {
                if (not(bool)) count += 1
            }
            return count == len(bools)
        }
        fun not(s: String): Boolean {
            return isnl<String>(s) || isEmpty(s)
        }
        fun not(c: Char): Boolean {
            return isnl(c) || isEmpty(c)
        }
        fun not(n: Int): Boolean {
            return isnl(n) || 0 == n
        }
        fun not(n: Long): Boolean {
            return isnl(n) || 0L == n
        }
        fun not(n: Float): Boolean {
            return isnl(n) || 0f == n
        }
        fun not(n: Double): Boolean {
            return isnl(n) || 0.0 == n
        }
        fun not(condition: Boolean): Boolean {
            return isnl(condition) || !condition
        }
        fun not(o: Any): Boolean {
            return isnl<Any>(o)
        }
        fun not(arr: CharArray): Boolean {
            return isnl<CharArray>(*arr) || isEmpty(arr)
        }
        fun not(vararg arrays: CharArray): Boolean {
            return isnl<CharArray>(*arrays) || isEmpty(*arrays)
        }
        fun not(arr: Array<String>): Boolean {
            return isnl<String>(*arr) || isEmpty(arr)
        }
        fun not(vararg arrays: Array<String>): Boolean {
            return isnl<String>(*(arrays)) || isEmpty(*arrays)
        }
        fun not(arr: IntArray): Boolean {
            return isnl<IntArray>(*arr) || isEmpty(arr)
        }
        fun not(vararg arrays: IntArray): Boolean {
            return isnl<IntArray>(*arrays) || isEmpty(*arrays)
        }
        fun not(arr: LongArray): Boolean {
            return isnl<LongArray>(*arr) || isEmpty(arr)
        }
        fun not(vararg arrays: LongArray): Boolean {
            return isnl<LongArray>(*arrays) || isEmpty(*arrays)
        }
        fun not(arr: FloatArray): Boolean {
            return isnl<FloatArray>(*arr) || isEmpty(arr)
        }
        fun not(vararg arrays: FloatArray): Boolean {
            return isnl<FloatArray>(*arrays) || isEmpty(*arrays)
        }
        fun not(arr: DoubleArray): Boolean {
            return isnl<DoubleArray>(*arr) || isEmpty(arr)
        }
        fun not(vararg arrays: DoubleArray): Boolean {
            return isnl<DoubleArray>(*arrays) || isEmpty(*arrays)
        }
        fun not(arr: BooleanArray): Boolean {
            return isnl<BooleanArray>(*arr) || isEmpty(arr)
        }
        fun not(vararg arrays: BooleanArray): Boolean {
            return isnl<BooleanArray>(*arrays) || isEmpty(*arrays)
        }
        fun not(vararg arrays: Array<Any>): Boolean {
            return isnl<Any>(*(arrays)) || isEmpty(*arrays)
        }
        fun `is`(c: Char): Boolean {
            return !not(c)
        }
        fun `is`(s: String): Boolean {
            return !not(s)
        }
        fun `is`(n: Int): Boolean {
            return !not(n)
        }
        fun `is`(n: Long): Boolean {
            return !not(n)
        }
        fun `is`(n: Float): Boolean {
            return !not(n)
        }
        fun `is`(n: Double): Boolean {
            return !not(n)
        }
        fun `is`(condition: Boolean): Boolean {
            return !not(condition)
        }
        fun `is`(o: Any): Boolean {
            return !not(o)
        }
        fun `is`(arr: CharArray): Boolean {
            return !not(arr)
        }
        fun `is`(vararg arrays: CharArray): Boolean {
            return !not(*arrays)
        }
        fun `is`(arr: Array<String>): Boolean {
            return !not(arr)
        }
        fun `is`(vararg arrays: Array<String>): Boolean {
            return !not(*arrays)
        }
        fun `is`(arr: IntArray): Boolean {
            return !not(arr)
        }
        fun `is`(vararg arrays: IntArray): Boolean {
            return !not(*arrays)
        }
        fun `is`(arr: LongArray): Boolean {
            return !not(arr)
        }
        fun `is`(vararg arrays: LongArray): Boolean {
            return !not(*arrays)
        }
        fun `is`(arr: FloatArray): Boolean {
            return !not(arr)
        }
        fun `is`(vararg arrays: FloatArray): Boolean {
            return !not(*arrays)
        }
        fun `is`(arr: DoubleArray): Boolean {
            return !not(arr)
        }
        fun `is`(vararg arrays: DoubleArray): Boolean {
            return !not(*arrays)
        }
        fun `is`(arr: BooleanArray): Boolean {
            return !not(arr)
        }
        fun `is`(vararg arrays: BooleanArray): Boolean {
            return !not(*arrays)
        }
        fun `is`(vararg arr: Any): Boolean {
            return !not(arr)
        }
        fun `is`(vararg arrays: Array<Any>): Boolean {
            return !not(*arrays)
        }
        fun xor(a: String, b: String): Boolean {
            return (`is`(a) || `is`(b)) && !(`is`(a) && `is`(b))
        }
        fun xor(a: Int, b: Int): Boolean {
            return (`is`(a) || `is`(b)) && !(`is`(a) && `is`(b))
        }
        fun xor(a: Long, b: Long): Boolean {
            return (`is`(a) || `is`(b)) && !(`is`(a) && `is`(b))
        }
        fun xor(a: Float, b: Float): Boolean {
            return (`is`(a) || `is`(b)) && !(`is`(a) && `is`(b))
        }
        fun xor(a: Double, b: Double): Boolean {
            return (`is`(a) || `is`(b)) && !(`is`(a) && `is`(b))
        }
        fun xor(a: Boolean, b: Boolean): Boolean {
            return (a || b) && !(a && b)
        }
        fun implies(a: Boolean, b: Boolean): Boolean {
            return if (a && !b) false else true
        }
        fun randInt(): Int {
            return ThreadLocalRandom.current().nextInt(0, 99)
        }
        fun randInt(end: Int): Int {
            if (not(end) || isNeg(end)) return 0
            return ThreadLocalRandom.current().nextInt(0, end)
        }
        fun randInt(start: Int, end: Int): Int {
            if (isNull(start) || not(end) || eq(start, end) || (start > end
                        ) || isNeg(end)) return 0
            return ThreadLocalRandom.current().nextInt(start, end)
        }
        @kotlin.jvm.JvmOverloads
        fun randPin(len: Int = 4): Int {
            var str: String = ""
            if (not(len) || len < 4) len = 4
            if (isInf(len.toDouble()) || len > 8) len = 8
            while (len > 0) {
                str += "" + randInt(10)
                len--
            }
            return Int(str)
        }
        fun randOTP(len: Int): Int {
            return randPin(len)
        }
        fun randOTP(): Int {
            return randPin()
        }
        fun randFlt(): Double {
            val number = randInt() * .3
            return toPrecision(number, 1)
        }
        fun randFlt(end: Int): Double {
            if (not(end) || isNeg(end)) return 0
            val number = randInt(end) * .3
            return toPrecision(number, 1)
        }
        fun randFlt(start: Int, end: Int): Double {
            if (isNull(start) || not(end) || eq(start, end) || (start > end
                        ) || isNeg(end)) return 0
            val number = randInt(start, end) * .3
            return toPrecision(number, 1)
        }
        fun randDbl(): Double {
            return randFlt()
        }
        fun randDbl(end: Int): Double {
            return if (not(end) || isNeg(end)) 0 else randFlt(end)
        }
        fun randDbl(start: Int, end: Int): Double {
            return if (isNull(start) || not(end) || eq(start, end) || (start > end
                        ) || isNeg(end)) 0 else randFlt(start, end)
        }
        fun randPct(): String {
            val nums = arrayOf<Number>(randInt(100), randDbl())
            return randFrom(nums).toString() + "%"
        }
        @kotlin.jvm.JvmOverloads
        fun randStr(len: Int = randInt(8, 32)): String {
            val AB = ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnop"
                    + "qrstuvwxyz\\+=")
            val rnd: java.security.SecureRandom = java.security.SecureRandom()
            val sb = StringBuilder(len)
            for (i in 0 until len) sb.append(AB[rnd.nextInt(AB.length)])
            return sb.toString()
        }
        @kotlin.jvm.JvmOverloads
        fun randChar(low: Int = 47, high: Int = 127): Char {
            if (low < 0) low = 0
            if (high > 127) high = 127
            return randInt(low, high).toChar()
        }
        fun randUuid(): String {
            return UUID.randomUUID().toString()
        }
        fun randId(len: Int): String {
            val id: String = randUuid().replace("-".toRegex(), "")
            return if (not(len) || isNeg(len) || (len >= len(id))) id else id.substring(0, len)
        }
        fun randId(): String {
            val id: String = randUuid().replace("-".toRegex(), "")
            return id.substring(0, 8)
        }
		@JvmStatic
        fun randItem(arr: Array<String>): String {
            return if (not(arr)) "" else arr.get(randInt(len(arr)))
        }
        fun randItem(arr: IntArray): Int {
            return if (not(arr)) 0 else arr.get(randInt(len(arr)))
        }
        fun randItem(arr: LongArray): Long {
            return if (not(arr)) 0 else arr.get(randInt(len(arr)))
        }
        fun randItem(arr: FloatArray): Float {
            return if (not(arr)) 0 else arr.get(randInt(len(arr)))
        }
        fun randItem(arr: DoubleArray): Double {
            return if (not(arr)) 0 else arr.get(randInt(len(arr)))
        }
        fun randItem(arr: BooleanArray): Boolean {
            return if (not(arr)) false else arr.get(randInt(len(arr)))
        }
		@JvmStatic
        fun randItem(arr: Array<Any>): Any {
            return if (not(arr)) false else arr.get(randInt(len(arr)))
        }
        fun anyOf(arr: Array<String>): String {
            return randItem(arr)
        }
        fun anyOf(arr: IntArray): Int {
            return randItem(arr)
        }
        fun anyOf(arr: LongArray): Long {
            return randItem(arr)
        }
        fun anyOf(arr: FloatArray): Float {
            return randItem(arr)
        }
        fun anyOf(arr: DoubleArray): Double {
            return randItem(arr)
        }
        fun anyOf(arr: BooleanArray): Boolean {
            return randItem(arr)
        }
        fun anyOf(arr: Array<Any>): Any {
            return arr[randInt(arr.size)]
        }
        fun noDuplicates(arr: IntArray): IntArray {
            return if (not(arr)) blank.Int else IntStream.of(*arr).distinct().toArray()
        }
        fun noDuplicates(arr: LongArray): LongArray {
            return if (not(arr)) blank.Long else LongStream.of(*arr).distinct().toArray()
        }
        fun noDuplicates(arr: DoubleArray): DoubleArray {
            return if (not(arr)) blank.Dbl else DoubleStream.of(*arr).distinct().toArray()
        }
        fun replace(str: String, to_replace: String,
                    regex_to_replace_with: String): String {
            return if (not(str) || not(to_replace)) str else str.replace(to_replace.toRegex(), regex_to_replace_with)
        }
        fun replace(str: String, to_replace: String,
                    fn: java.util.function.Function<String, String>): String {
            if (not(str) || not(to_replace) || not(fn)) return str
            val s = StringBuilder(str)
            val p: java.util.regex.Pattern = java.util.regex.Pattern.compile(to_replace)
            val matcher: java.util.regex.Matcher = p.matcher(s)
            return matcher.replaceAll(java.util.function.Function<MatchResult, String> { m: MatchResult -> fn.apply(m.group()) })
        }
        fun replaceFirst(str: String, to_replace: String,
                         regex_to_replace_with: String): String {
            return if (not(str) || not(to_replace)) str else str.replaceFirst(to_replace.toRegex(), regex_to_replace_with)
        }
        fun replaceOne(str: String, to_replace: String,
                       regex_to_replace_with: String): String {
            return if (not(str) || not(to_replace)) str else replaceFirst(str, to_replace, regex_to_replace_with)
        }
        fun remove(str: String, re: String): String {
            return if (not(str) || not(re)) str else (replace(str, re, ""))!!
        }
        fun slice(str: String): String {
            return if (not(str)) "" else remove(str, "^\\s+|\\s+$")
            // TESTED, and proven: DOUBLE-ESCAPING WASN'T NEEDED here. As a matter
            // of fact, for some reason, it's not needed with whitespaces ("\\s") in
            // Java. Though functionally equivalent to str.trim(), I believe it's
            // better to at least try and create your own implementation.
        }
        fun slice(arr: Array<String>): Array<String> {
            return if (not(arr)) blank.Str else arr.clone()
        }
        fun slice(arr: IntArray): IntArray {
            return if (not(arr)) blank.Int else arr.clone()
        }
        fun slice(arr: LongArray): LongArray {
            return if (not(arr)) blank.Long else arr.clone()
        }
        fun slice(arr: FloatArray): FloatArray {
            return if (not(arr)) blank.Flt else arr.clone()
        }
        fun slice(arr: DoubleArray): DoubleArray {
            return if (not(arr)) blank.Dbl else arr.clone()
        }
        fun slice(arr: BooleanArray): BooleanArray {
            return if (not(arr)) blank.Bool else arr.clone()
        }
        fun slice(arr: Array<Any>): Array<Any> {
            return if (not(arr)) blank.Obj else arr.clone()
        }
        fun slice(str: String, start: Int): String {
            return if (not(str) || not(start) || isNeg(start) || (start >= len(str))) slice(str) else str.substring(start, len(str))
        }
        fun slice(oldArr: Array<String>, start: Int): Array<String> {
            if (not(oldArr) || not(start) || isNeg(start) || (start >= len(oldArr))) return slice(oldArr)
            return Arrays.copyOfRange<String>(oldArr.clone(), start,
                len(oldArr))
        }
        fun slice(oldArr: IntArray, start: Int): IntArray {
            if (not(oldArr) || not(start) || isNeg(start) || (start >= len(oldArr))) return slice(oldArr)
            return Arrays.copyOfRange(oldArr.clone(), start, len(oldArr))
        }
        fun slice(oldArr: LongArray, start: Int): LongArray {
            if (not(oldArr) || not(start) || isNeg(start) || (start >= len(oldArr))) return slice(oldArr)
            return Arrays.copyOfRange(oldArr.clone(), start, len(oldArr))
        }
        fun slice(oldArr: FloatArray, start: Int): FloatArray {
            if (not(oldArr) || not(start) || isNeg(start) || (start >= len(oldArr))) return slice(oldArr)
            return Arrays.copyOfRange(oldArr.clone(), start, len(oldArr))
        }
        fun slice(oldArr: DoubleArray, start: Int): DoubleArray {
            if (not(oldArr) || not(start) || isNeg(start) || (start >= len(oldArr))) return slice(oldArr)
            return Arrays.copyOfRange(oldArr.clone(), start,
                len(oldArr))
        }
        fun slice(oldArr: BooleanArray, start: Int): BooleanArray {
            if (not(oldArr) || not(start) || isNeg(start) || (start >= len(oldArr))) return slice(oldArr)
            return Arrays.copyOfRange(oldArr.clone(), start,
                len(oldArr))
        }
        fun slice(oldArr: Array<Any>, start: Int): Array<Any> {
            if (not(oldArr) || not(start) || isNeg(start) || (start >= len(oldArr))) return slice(oldArr)
            return Arrays.copyOfRange<Any>(oldArr.clone(), start,
                len(oldArr))
        }
        fun slice(str: String, start: Int, end: Int): String {
            return if ((not(str) || isNull<Int>(start) || (start >= len(str)) || eq(start, end)
                        || (end < start) || not(end) || isNeg(start) || isNeg(end)
                        || (end >= len(str)))) slice(str) else str.substring(start, end)
        }
        fun slice(oldArr: Array<String>, start: Int, end: Int): Array<String> {
            if ((not(oldArr) || isNull(start) || (start >= len(oldArr)
                        ) || eq(start, end) || (end < start) || not(end) || isNeg(start)
                        || isNeg(end) || (end >= len(oldArr)))) return slice(oldArr)
            return Arrays.copyOfRange<String>(oldArr.clone(), start, end)
        }
        fun slice(oldArr: IntArray, start: Int, end: Int): IntArray {
            if ((not(oldArr) || isNull(start) || (start >= len(oldArr)
                        ) || eq(start, end) || (end < start) || not(end) || isNeg(start)
                        || isNeg(end) || (end >= len(oldArr)))) return slice(oldArr)
            return Arrays.copyOfRange(oldArr.clone(), start, end)
        }
        fun slice(oldArr: LongArray, start: Int, end: Int): LongArray {
            if ((not(oldArr) || isNull(start) || (start >= len(oldArr)
                        ) || eq(start, end) || (end < start) || not(end) || isNeg(start)
                        || isNeg(end) || (end >= len(oldArr)))) return slice(oldArr)
            return Arrays.copyOfRange(oldArr.clone(), start, end)
        }
        fun slice(oldArr: FloatArray, start: Int, end: Int): FloatArray {
            if ((not(oldArr) || isNull(start) || (start >= len(oldArr)
                        ) || eq(start, end) || (end < start) || not(end) || isNeg(start)
                        || isNeg(end) || (end >= len(oldArr)))) return slice(oldArr)
            return Arrays.copyOfRange(oldArr.clone(), start, end)
        }
        fun slice(oldArr: DoubleArray, start: Int, end: Int): DoubleArray {
            if ((not(oldArr) || isNull(start) || (start >= len(oldArr)
                        ) || eq(start, end) || (end < start) || not(end) || isNeg(start)
                        || isNeg(end) || (end >= len(oldArr)))) return slice(oldArr)
            return Arrays.copyOfRange(oldArr.clone(), start, end)
        }
        fun slice(oldArr: BooleanArray, start: Int, end: Int): BooleanArray {
            if ((not(oldArr) || isNull(start) || (start >= len(oldArr)
                        ) || eq(start, end) || (end < start) || not(end) || isNeg(start)
                        || isNeg(end) || (end >= len(oldArr)))) return slice(oldArr)
            return Arrays.copyOfRange(oldArr.clone(), start, end)
        }
        fun slice(oldArr: Array<Any>, start: Int, end: Int): Array<Any> {
            if ((not(oldArr) || isNull(start) || (start >= len(oldArr)
                        ) || eq(start, end) || (end < start) || not(end) || isNeg(start)
                        || isNeg(end) || (end >= len(oldArr)))) return slice(oldArr)
            return Arrays.copyOfRange<Any>(oldArr.clone(), start, end)
        }
        fun sliceRight(str: String, start: Int): String {
            return if (not(str) || not(start) || isNeg(start) || (start >= len(str))) slice(str) else slice(str, len(str) - start, len(str))
        }
        fun sliceRight(arr: Array<String>, start: Int): Array<String> {
            return if (not(arr) || not(start) || isNeg(start) || (start >= len(arr))) slice(arr) else slice(arr, len(arr) - start, len(arr))
        }
        fun sliceRight(arr: IntArray, start: Int): IntArray {
            return if (not(arr) || not(start) || isNeg(start) || (start >= len(arr))) slice(arr) else slice(arr, len(arr) - start, len(arr))
        }
        fun sliceRight(arr: LongArray, start: Int): LongArray {
            return if (not(arr) || not(start) || isNeg(start) || (start >= len(arr))) slice(arr) else slice(arr, len(arr) - start, len(arr))
        }
        fun sliceRight(arr: FloatArray, start: Int): FloatArray {
            return if (not(arr) || not(start) || isNeg(start) || (start >= len(arr))) slice(arr) else slice(arr, len(arr) - start, len(arr))
        }
        fun sliceRight(arr: DoubleArray, start: Int): DoubleArray {
            return if (not(arr) || not(start) || isNeg(start) || (start >= len(arr))) slice(arr) else slice(arr, len(arr) - start, len(arr))
        }
        fun sliceRight(arr: BooleanArray, start: Int): BooleanArray {
            return if (not(arr) || not(start) || isNeg(start) || (start >= len(arr))) slice(arr) else slice(arr, len(arr) - start, len(arr))
        }
        fun sliceRight(arr: Array<Any>, start: Int): Array<Any> {
            return if (not(arr) || not(start) || isNeg(start) || (start >= len(arr))) slice(arr) else slice(arr, len(arr) - start, len(arr))
        }
        fun sliceEnd(str: String, earlyEnd: Int): String {
            return if ((not(str) || not(earlyEnd) || isNeg(earlyEnd)
                        || (earlyEnd >= len(str)))) slice(str) else slice(str, 0, len(str) - earlyEnd)
        }
        fun sliceEnd(arr: Array<String>, earlyEnd: Int): Array<String> {
            return if ((not(arr) || not(earlyEnd) || isNeg(earlyEnd)
                        || (earlyEnd >= len(arr)))) slice(arr) else slice(arr, 0, len(arr) - earlyEnd)
        }
        fun sliceEnd(arr: IntArray, earlyEnd: Int): IntArray {
            return if ((not(arr) || not(earlyEnd) || isNeg(earlyEnd)
                        || (earlyEnd >= len(arr)))) slice(arr) else slice(arr, 0, len(arr) - earlyEnd)
        }
        fun sliceEnd(arr: LongArray, earlyEnd: Int): LongArray {
            return if ((not(arr) || not(earlyEnd) || isNeg(earlyEnd)
                        || (earlyEnd >= len(arr)))) slice(arr) else slice(arr, 0, len(arr) - earlyEnd)
        }
        fun sliceEnd(arr: FloatArray, earlyEnd: Int): FloatArray {
            return if ((not(arr) || not(earlyEnd) || isNeg(earlyEnd)
                        || (earlyEnd >= len(arr)))) slice(arr) else slice(arr, 0, len(arr) - earlyEnd)
        }
        fun sliceEnd(arr: DoubleArray, earlyEnd: Int): DoubleArray {
            return if ((not(arr) || not(earlyEnd) || isNeg(earlyEnd)
                        || (earlyEnd >= len(arr)))) slice(arr) else slice(arr, 0, len(arr) - earlyEnd)
        }
        fun sliceEnd(arr: BooleanArray, earlyEnd: Int): BooleanArray {
            return if ((not(arr) || not(earlyEnd) || isNeg(earlyEnd)
                        || (earlyEnd >= len(arr)))) slice(arr) else slice(arr, 0, len(arr) - earlyEnd)
        }
        fun sliceEnd(arr: Array<Any>, earlyEnd: Int): Array<Any> {
            return if ((not(arr) || not(earlyEnd) || isNeg(earlyEnd)
                        || (earlyEnd >= len(arr)))) slice(arr) else slice(arr, 0, len(arr) - earlyEnd)
        }
        fun sliceOff(str: String, earlyEnd: Int): String {
            return sliceEnd(str, earlyEnd)
        }
        fun sliceOff(arr: Array<String>, earlyEnd: Int): Array<String> {
            return sliceEnd(arr, earlyEnd)
        }
        fun sliceOff(arr: IntArray, earlyEnd: Int): IntArray {
            return sliceEnd(arr, earlyEnd)
        }
        fun sliceOff(arr: LongArray, earlyEnd: Int): LongArray {
            return sliceEnd(arr, earlyEnd)
        }
        fun sliceOff(arr: FloatArray, earlyEnd: Int): FloatArray {
            return sliceEnd(arr, earlyEnd)
        }
        fun sliceOff(arr: DoubleArray, earlyEnd: Int): DoubleArray {
            return sliceEnd(arr, earlyEnd)
        }
        fun sliceOff(arr: BooleanArray, earlyEnd: Int): BooleanArray {
            return sliceEnd(arr, earlyEnd)
        }
        fun sliceOff(arr: Array<Any>, earlyEnd: Int): Array<Any> {
            return sliceEnd(arr, earlyEnd)
        }
        fun sliceOut(str: String, earlyEnd: Int): String {
            return sliceEnd(str, earlyEnd)
        }
        fun sliceOut(arr: Array<String>, earlyEnd: Int): Array<String> {
            return sliceEnd(arr, earlyEnd)
        }
        fun sliceOut(arr: IntArray, earlyEnd: Int): IntArray {
            return sliceEnd(arr, earlyEnd)
        }
        fun sliceOut(arr: LongArray, earlyEnd: Int): LongArray {
            return sliceEnd(arr, earlyEnd)
        }
        fun sliceOut(arr: FloatArray, earlyEnd: Int): FloatArray {
            return sliceEnd(arr, earlyEnd)
        }
        fun sliceOut(arr: DoubleArray, earlyEnd: Int): DoubleArray {
            return sliceEnd(arr, earlyEnd)
        }
        fun sliceOut(arr: BooleanArray, earlyEnd: Int): BooleanArray {
            return sliceEnd(arr, earlyEnd)
        }
        fun sliceOut(arr: Array<Any>, earlyEnd: Int): Array<Any> {
            return sliceEnd(arr, earlyEnd)
        }
        fun sliceKeep(str: String, end: Int): String {
            return if (not(str) || not(end) || isNeg(end) || (end >= len(str))) str else slice(str, 0, end)
        }
        fun sliceKeep(arr: Array<String>, end: Int): Array<String> {
            if (not(arr)) return blank.Str
            return if (not(end) || isNeg(end) || (end >= len(arr))) slice(arr) else slice(arr, 0, end)
        }
        fun sliceKeep(arr: IntArray, end: Int): IntArray {
            if (not(arr)) return blank.Int
            return if (not(end) || isNeg(end) || (end >= len(arr))) slice(arr) else slice(arr, 0, end)
        }
        fun sliceKeep(arr: LongArray, end: Int): LongArray {
            if (not(arr)) return blank.Long
            return if (not(end) || isNeg(end) || (end >= len(arr))) slice(arr) else slice(arr, 0, end)
        }
        fun sliceKeep(arr: FloatArray, end: Int): FloatArray {
            if (not(arr)) return blank.Flt
            return if (not(end) || isNeg(end) || (end >= len(arr))) slice(arr) else slice(arr, 0, end)
        }
        fun sliceKeep(arr: DoubleArray, end: Int): DoubleArray {
            if (not(arr)) return blank.Dbl
            return if (not(end) || isNeg(end) || (end >= len(arr))) slice(arr) else slice(arr, 0, end)
        }
        fun sliceKeep(arr: BooleanArray, end: Int): BooleanArray {
            if (not(arr)) return blank.Bool
            return if (not(end) || isNeg(end) || (end >= len(arr))) slice(arr) else slice(arr, 0, end)
        }
        fun trim(str: String): String {
            return slice(str)
        }
        fun trim(arr: Array<String>): Array<String> {
            return slice(arr)
        }
        fun trim(arr: IntArray): IntArray {
            return slice(arr)
        }
        fun trim(arr: LongArray): LongArray {
            return slice(arr)
        }
        fun trim(arr: FloatArray): FloatArray {
            return slice(arr)
        }
        fun trim(arr: DoubleArray): DoubleArray {
            return slice(arr)
        }
        fun trim(arr: BooleanArray): BooleanArray {
            return slice(arr)
        }
        fun trim(str: String, start: Int): String {
            return slice(str, start)
        }
        fun trim(arr: Array<String>, start: Int): Array<String> {
            return slice(arr, start)
        }
        fun trim(arr: IntArray, start: Int): IntArray {
            return slice(arr, start)
        }
        fun trim(arr: LongArray, start: Int): LongArray {
            return slice(arr, start)
        }
        fun trim(arr: FloatArray, start: Int): FloatArray {
            return slice(arr, start)
        }
        fun trim(arr: DoubleArray, start: Int): DoubleArray {
            return slice(arr, start)
        }
        fun trim(arr: BooleanArray, start: Int): BooleanArray {
            return slice(arr, start)
        }
        fun trim(str: String, start: Int, end: Int): String {
            return slice(str, start, end)
        }
        fun trim(arr: Array<String>, start: Int, end: Int): Array<String> {
            return slice(arr, start, end)
        }
        fun trim(arr: IntArray, start: Int, end: Int): IntArray {
            return slice(arr, start, end)
        }
        fun trim(arr: LongArray, start: Int, end: Int): LongArray {
            return slice(arr, start, end)
        }
        fun trim(arr: FloatArray, start: Int, end: Int): FloatArray {
            return slice(arr, start, end)
        }
        fun trim(arr: DoubleArray, start: Int, end: Int): DoubleArray {
            return slice(arr, start, end)
        }
        fun trim(arr: BooleanArray, start: Int, end: Int): BooleanArray {
            return slice(arr, start, end)
        }
        fun trimRight(str: String, start: Int): String {
            return sliceRight(str, start)
        }
        fun trimRight(arr: Array<String>, start: Int): Array<String> {
            return sliceRight(arr, start)
        }
        fun trimRight(arr: IntArray, start: Int): IntArray {
            return sliceRight(arr, start)
        }
        fun trimRight(arr: LongArray, start: Int): LongArray {
            return sliceRight(arr, start)
        }
        fun trimRight(arr: FloatArray, start: Int): FloatArray {
            return sliceRight(arr, start)
        }
        fun trimRight(arr: DoubleArray, start: Int): DoubleArray {
            return sliceRight(arr, start)
        }
        fun trimRight(arr: BooleanArray, start: Int): BooleanArray {
            return sliceRight(arr, start)
        }
        fun trimKeep(str: String, end: Int): String {
            return sliceKeep(str, end)
        }
        fun trimKeep(arr: Array<String>, end: Int): Array<String> {
            return sliceKeep(arr, end)
        }
        fun trimKeep(arr: IntArray, end: Int): IntArray {
            return sliceKeep(arr, end)
        }
        fun trimKeep(arr: LongArray, end: Int): LongArray {
            return sliceKeep(arr, end)
        }
        fun trimKeep(arr: FloatArray, end: Int): FloatArray {
            return sliceKeep(arr, end)
        }
        fun trimKeep(arr: DoubleArray, end: Int): DoubleArray {
            return sliceKeep(arr, end)
        }
        fun trimKeep(arr: BooleanArray, end: Int): BooleanArray {
            return sliceKeep(arr, end)
        }
        fun trimEnd(str: String, earlyEnd: Int): String {
            return sliceEnd(str, earlyEnd)
        }
        fun trimEnd(arr: Array<String>, earlyEnd: Int): Array<String> {
            return sliceEnd(arr, earlyEnd)
        }
        fun trimEnd(arr: IntArray, earlyEnd: Int): IntArray {
            return sliceEnd(arr, earlyEnd)
        }
        fun trimEnd(arr: LongArray, earlyEnd: Int): LongArray {
            return sliceEnd(arr, earlyEnd)
        }
        fun trimEnd(arr: FloatArray, earlyEnd: Int): FloatArray {
            return sliceEnd(arr, earlyEnd)
        }
        fun trimEnd(arr: DoubleArray, earlyEnd: Int): DoubleArray {
            return sliceEnd(arr, earlyEnd)
        }
        fun trimEnd(arr: BooleanArray, earlyEnd: Int): BooleanArray {
            return sliceEnd(arr, earlyEnd)
        }
        fun trimOff(str: String, earlyEnd: Int): String {
            return trimEnd(str, earlyEnd)
        }
        fun trimOff(arr: Array<String>, earlyEnd: Int): Array<String> {
            return trimEnd(arr, earlyEnd)
        }
        fun trimOff(arr: IntArray, earlyEnd: Int): IntArray {
            return trimEnd(arr, earlyEnd)
        }
        fun trimOff(arr: LongArray, earlyEnd: Int): LongArray {
            return trimEnd(arr, earlyEnd)
        }
        fun trimOff(arr: FloatArray, earlyEnd: Int): FloatArray {
            return trimEnd(arr, earlyEnd)
        }
        fun trimOff(arr: DoubleArray, earlyEnd: Int): DoubleArray {
            return trimEnd(arr, earlyEnd)
        }
        fun trimOff(arr: BooleanArray, earlyEnd: Int): BooleanArray {
            return trimEnd(arr, earlyEnd)
        }
        fun trimOut(str: String, earlyEnd: Int): String {
            return trimEnd(str, earlyEnd)
        }
        fun trimOut(arr: Array<String>, earlyEnd: Int): Array<String> {
            return trimEnd(arr, earlyEnd)
        }
        fun trimOut(arr: IntArray, earlyEnd: Int): IntArray {
            return trimEnd(arr, earlyEnd)
        }
        fun trimOut(arr: LongArray, earlyEnd: Int): LongArray {
            return trimEnd(arr, earlyEnd)
        }
        fun trimOut(arr: FloatArray, earlyEnd: Int): FloatArray {
            return trimEnd(arr, earlyEnd)
        }
        fun trimOut(arr: DoubleArray, earlyEnd: Int): DoubleArray {
            return trimEnd(arr, earlyEnd)
        }
        fun trimOut(arr: BooleanArray, earlyEnd: Int): BooleanArray {
            return trimEnd(arr, earlyEnd)
        }
        fun sliceTo(str: String, thatSpecificPart: String): String {
            val index = indexOf(str, thatSpecificPart)
            return if (index < 0 || index == -1) str else slice(str, index)
        }
        fun sliceToAfter(str: String, thatSpecificPart: String): String {
            val index = indexOf(str, thatSpecificPart)
            if (index < 0) return str
            val retrievedString = sliceTo(str, thatSpecificPart)
            return slice(retrievedString, len(thatSpecificPart))
        }
        fun startsWith(str: String, re: String): Boolean {
            val pattern: java.util.regex.Pattern = java.util.regex.Pattern.compile("^($re)",
                java.util.regex.Pattern.CASE_INSENSITIVE)
            val matcher: java.util.regex.Matcher = pattern.matcher(str)
            return !!matcher.find()
        }
        fun endsWith(str: String, re: String): Boolean {
            val pattern: java.util.regex.Pattern = java.util.regex.Pattern.compile("($re)$",
                java.util.regex.Pattern.CASE_INSENSITIVE)
            val matcher: java.util.regex.Matcher = pattern.matcher(str)
            return !!matcher.find()
        }
        fun endsWith(arr: Array<String>, lookupStr: String): Boolean {
            return if (not(arr)) false else (arr.get(len(arr) - 1) == lookupStr)
        }
        fun endsWith(arr: IntArray, lookupInt: Int): Boolean {
            return if (not(arr)) false else arr.get(len(arr) - 1) == lookupInt
        }
        fun endsWith(arr: LongArray, lookupLong: Long): Boolean {
            return if (not(arr)) false else arr.get(len(arr) - 1) == lookupLong
        }
        fun endsWith(arr: FloatArray, lookupFloat: Float): Boolean {
            return if (not(arr)) false else arr.get(len(arr) - 1) == lookupFloat
        }
        fun endsWith(arr: DoubleArray, lookupDbl: Double): Boolean {
            return if (not(arr)) false else arr.get(len(arr) - 1) == lookupDbl
        }
        fun endsWith(arr: BooleanArray, lookupBool: Boolean): Boolean {
            return if (not(arr)) false else arr.get(len(arr) - 1) == lookupBool
        }
        fun nthLastOf(str: String, n: Int): String {
            return if (n > 0 && n <= len(str)) ("" + str.toCharArray().get(len(str) - n)) else ""
        }
        fun nthLastOf(arr: CharArray, n: Int): Char {
            return if (n > 0 && n <= len(arr)) arr[len(arr) - n] else '\u0000'
        }
        fun nthLastOf(arr: Array<String>, n: Int): String {
            return if (n > 0 && n <= len(arr)) arr[len(arr) - n] else ""
        }
        fun nthLastOf(arr: IntArray, n: Int): Int {
            return if (n > 0 && n <= len(arr)) arr[len(arr) - n] else 0
        }
        fun nthLastOf(arr: LongArray, n: Int): Long {
            return if (n > 0 && n <= len(arr)) arr[len(arr) - n] else 0
        }
        fun nthLastOf(arr: FloatArray, n: Int): Float {
            return if (n > 0 && n <= len(arr)) arr[len(arr) - n] else 0
        }
        fun nthLastOf(arr: DoubleArray, n: Int): Double {
            return if (n > 0 && n <= len(arr)) arr[len(arr) - n] else 0
        }
        fun nthLastOf(arr: BooleanArray, n: Int): Boolean {
            return if (n > 0 && n <= len(arr)) arr[len(arr) - n] else false
        }
        fun secondLastOf(str: String): String {
            return if (len(str) - 2 >= 0) ("" + str.toCharArray().get(len(str) - 2)) else ""
        }
        fun secondLastOf(arr: Array<String>): String {
            return if (len(arr) - 2 >= 0) arr[len(arr) - 2] else ""
        }
        fun secondLastOf(arr: IntArray): Int {
            return if (len(arr) - 2 >= 0) arr[len(arr) - 2] else 0
        }
        fun secondLastOf(arr: LongArray): Long {
            return if (len(arr) - 2 >= 0) arr[len(arr) - 2] else 0
        }
        fun secondLastOf(arr: FloatArray): Float {
            return if (len(arr) - 2 >= 0) arr[len(arr) - 2] else 0
        }
        fun secondLastOf(arr: DoubleArray): Double {
            return if (len(arr) - 2 >= 0) arr[len(arr) - 2] else 0
        }
        fun secondLastOf(arr: BooleanArray): Boolean {
            return if (len(arr) - 2 >= 0) arr[len(arr) - 2] else false
        }
        fun lastOf(str: String): String {
            return if (len(str) - 1 >= 0) ("" + str.toCharArray().get(len(str) - 1)) else ""
        }
        fun lastOf(arr: Array<String>): String {
            return if (len(arr) - 1 >= 0) arr[len(arr) - 1] else ""
        }
        fun lastOf(arr: IntArray): Int {
            return if (len(arr) - 1 >= 0) arr[len(arr) - 1] else 0
        }
        fun lastOf(arr: LongArray): Long {
            return if (len(arr) - 1 >= 0) arr[len(arr) - 1] else 0
        }
        fun lastOf(arr: FloatArray): Float {
            return if (len(arr) - 1 >= 0) arr[len(arr) - 1] else 0
        }
        fun lastOf(arr: DoubleArray): Double {
            return if (len(arr) - 1 >= 0) arr[len(arr) - 1] else 0
        }
        fun lastOf(arr: BooleanArray): Boolean {
            return if (len(arr) - 1 >= 0) arr[len(arr) - 1] else false
        }
        @kotlin.jvm.JvmOverloads
        fun indexOf(inStr: String, lookupStr: String, startIndex: Int = 0): Int {
            return if (not(inStr) || isNull<Int>(startIndex) || isNeg(startIndex)) -1 else inStr.indexOf(lookupStr, startIndex)
        }
        @kotlin.jvm.JvmOverloads
        fun indexOf(inStr: String, lookupCh: Char, startIndex: Int = 0): Int {
            if ((not(inStr) || not(lookupCh) || isNull(startIndex)
                        || isNeg(startIndex))) return -1
            for (i: Int in range(inStr)) {
                if (slice(inStr, startIndex).toCharArray().get(i) == lookupCh) return i
            }
            return -1
        }
        fun lastIndexOf(inStr: String, lookupStr: String): Int {
            return inStr.lastIndexOf(lookupStr)
        }
        fun lastIndexOf(inStr: String, lookupCh: Char): Int {
            for (i in len(inStr) - 1 downTo 0) {
                if (inStr.toCharArray().get(i) == lookupCh) return i
            }
            return -1
        }
        fun indexOf(inStrArr: Array<String>, lookupStr: String): Int {
            for (i in 0 until len(inStrArr)) {
                if ((inStrArr[i] == lookupStr)) return i
            }
            return -1
        }
        fun lastIndexOf(inStrArr: Array<String>, lookupStr: String): Int {
            for (i in len(inStrArr) - 1 downTo 0) {
                if ((inStrArr[i] == lookupStr)) return i
            }
            return -1
        }
        fun indexOf(inIntArr: IntArray, lookupInt: Int): Int {
            for (i in 0 until len(inIntArr)) {
                if (inIntArr[i] == lookupInt) return i
            }
            return -1
        }
        fun lastIndexOf(inIntArr: IntArray, lookupInt: Int): Int {
            for (i in len(inIntArr) - 1 downTo 0) {
                if (inIntArr[i] == lookupInt) return i
            }
            return -1
        }
        fun indexOf(inLongArr: LongArray, lookupLong: Long): Int {
            for (i in 0 until len(inLongArr)) {
                if (inLongArr[i] == lookupLong) return i
            }
            return -1
        }
        fun lastIndexOf(inLongArr: LongArray, lookupLong: Long): Int {
            for (i in len(inLongArr) - 1 downTo 0) {
                if (inLongArr[i] == lookupLong) return i
            }
            return -1
        }
        fun indexOf(inFltArr: FloatArray, lookupFlt: Float): Int {
            for (i in 0 until len(inFltArr)) {
                if (inFltArr[i] == lookupFlt) return i
            }
            return -1
        }
        fun lastIndexOf(inFloatArr: FloatArray, lookupFloat: Float): Int {
            for (i in len(inFloatArr) - 1 downTo 0) {
                if (inFloatArr[i] == lookupFloat) return i
            }
            return -1
        }
        fun indexOf(inDblArr: DoubleArray, lookupDbl: Double): Int {
            for (i in 0 until len(inDblArr)) {
                if (inDblArr[i] == lookupDbl) return i
            }
            return -1
        }
        fun lastIndexOf(inDblArr: DoubleArray, lookupDbl: Double): Int {
            for (i in len(inDblArr) - 1 downTo 0) {
                if (inDblArr[i] == lookupDbl) return i
            }
            return -1
        }
        fun indexOf(inBoolArr: BooleanArray, lookupBool: Boolean): Int {
            for (i in 0 until len(inBoolArr)) {
                if (inBoolArr[i] == lookupBool) return i
            }
            return -1
        }
        fun lastIndexOf(inBoolArr: BooleanArray, lookupBool: Boolean): Int {
            for (i in len(inBoolArr) - 1 downTo 0) {
                if (inBoolArr[i] == lookupBool) return i
            }
            return -1
        }
        fun numberOfOccurrencesIn(inStr: String, lookupCh: Char): Int {
            var occurrences = 0
            for (i in 0 until len(inStr)) {
                if (inStr.toCharArray().get(i) == lookupCh) occurrences++
            }
            return occurrences
        }
        fun numberOfOccurrencesIn(inStr: String, lookupStr: String): Int {
            var occurrences = 0
            for (i in 0 until len(inStr)) {
                if (inStr.toCharArray().get(i) == lookupStr[0]) occurrences++
            }
            return occurrences
        }
        fun numberOfOccurrencesIn(inStrArr: Array<String>,
                                  lookupStr: String): Int {
            var occurrences = 0
            for (i in 0 until len(inStrArr)) {
                if ((inStrArr[i] == lookupStr)) occurrences++
            }
            return occurrences
        }
        fun numberOfOccurrencesIn(inIntArr: IntArray, lookupInt: Int): Int {
            var occurrences = 0
            for (i in 0 until len(inIntArr)) {
                if (inIntArr[i] == lookupInt) occurrences++
            }
            return occurrences
        }
        fun numberOfOccurrencesIn(inLongArr: LongArray, lookupLong: Long): Int {
            var occurrences = 0
            for (i in 0 until len(inLongArr)) {
                if (inLongArr[i] == lookupLong) occurrences++
            }
            return occurrences
        }
        fun numberOfOccurrencesIn(inFltArr: FloatArray, lookupFlt: Float): Int {
            var occurrences = 0
            for (i in 0 until len(inFltArr)) {
                if (inFltArr[i] == lookupFlt) occurrences++
            }
            return occurrences
        }
        fun numberOfOccurrencesIn(inDblArr: DoubleArray,
                                  lookupDbl: Double): Int {
            var occurrences = 0
            for (i in 0 until len(inDblArr)) {
                if (inDblArr[i] == lookupDbl) occurrences++
            }
            return occurrences
        }
        fun numberOfOccurrencesIn(inBoolArr: BooleanArray,
                                  lookupBool: Boolean): Int {
            var occurrences = 0
            for (i in 0 until len(inBoolArr)) {
                if (inBoolArr[i] == lookupBool) occurrences++
            }
            return occurrences
        }
        fun `in`(inStr: String, ch: Char): Boolean {
            return indexOf(inStr, ch) >= 0
        }
        fun `in`(strA: String, strB: String): Boolean {
            return indexOf(lower(strA), lower(strB)) >= 0 || match(strA, strB)
        }
        fun `in`(arr: Array<String>, str: String): Boolean {
            return indexOf(arr, str) >= 0
        }
        fun `in`(arr: IntArray, n: Int): Boolean {
            return indexOf(arr, n) >= 0
        }
        fun `in`(arr: LongArray, n: Long): Boolean {
            return indexOf(arr, n) >= 0
        }
        fun `in`(arr: FloatArray, n: Float): Boolean {
            return indexOf(arr, n) >= 0
        }
        fun `in`(arr: DoubleArray, n: Double): Boolean {
            return indexOf(arr, n) >= 0
        }
        fun `in`(arr: BooleanArray, bool: Boolean): Boolean {
            return indexOf(arr, bool) >= 0
        }
        fun `in`(arr: Array<Any>, targetValue: Any): Boolean {
            if (arr == null || targetValue == null) {
                return false
            }
            for (element: Any in arr) {
                if ((targetValue == element)) {
                    return true
                }
            }
            return false
        }
        fun contains(str: String, lookupCh: Char): Boolean {
            return `in`(str, lookupCh)
        }
        fun contains(str: String, lookupStr: String): Boolean {
            return `in`(str, lookupStr)
        }
        fun contains(arr: Array<String>, lookupStr: String): Boolean {
            return `in`(arr, lookupStr)
        }
        fun contains(arr: IntArray, lookupInt: Int): Boolean {
            return `in`(arr, lookupInt)
        }
        fun contains(arr: LongArray, lookupLong: Long): Boolean {
            return `in`(arr, lookupLong)
        }
        fun contains(arr: FloatArray, lookupFloat: Float): Boolean {
            return `in`(arr, lookupFloat)
        }
        fun contains(arr: DoubleArray, lookupDbl: Double): Boolean {
            return `in`(arr, lookupDbl)
        }
        fun contains(arr: BooleanArray, lookupBool: Boolean): Boolean {
            return `in`(arr, lookupBool)
        }
        fun contains(arr: Array<Any>, targetValue: Any): Boolean {
            return `in`(arr, targetValue)
        }
        fun match(str: String, re: String, vararg bools: Boolean): Boolean {
            if (isNull<String>(str) || isNull(re)) return false
            // these null checks have to stay NULL checks, not entire `not` checks,
            // as not(re) would trim whitespace " ", which we sometimes DO need to
            // look up in a string to see if the string is more than one word, down
            // to ""
            if (((re == ".") || (re == "*") || (re == "+") || (re == ""))) re = "\\" + re
            try {
                re = re.replace("(<![\\.\\\\])\\.(![*+])".toRegex(), "\\\\.")
                    .replace("(<![\\\\\\.\\w\\)\\]\\|\\%\\$@])([\\+\\*])".toRegex(),
                        "\\\\$1")
                    .replace("%%".toRegex(), "%").replace("(<!\\\\)%c".toRegex(), "[A-Za-z]")
                    .replace("(<!\\\\)(%[sw]|\\{\\})".toRegex(), "[A-Za-z][\\\\w]+")
                    .replace("(<!\\\\)%b".toRegex(), "(true|false)")
                    .replace("(<!\\\\)%[di]".toRegex(), "(<!\\.)\\\\d+(!\\.)")
                    .replace("(<!\\\\)%[\\.\\\\d]*f".toRegex(), "\\\\d*\\.\\\\d+")
                    .replace("(<!\\\\)%n".toRegex(), "\\\\d+")
            } catch (e: java.lang.Exception) {
            }
            // modification precaution: it has been tested, and hence learned,
            // the
            // double-escaping remains AS-IS
            // THIS IS THE ONLY PART OF THE FILE WHERE YOU NEED TO ESCAPE TWICE
            // escaping tricky characters, if they're the only content: helps avoid
            // false positives as a "." or a "*" alone, can match just anything.
            // Needless to say, these quantifiers, along with a "+" and an
            // optionality quantifier, i.e. a "" quantifier, might also cause
            // memory heap to exceed
            // plus, handling both, standard and custom, format specifiers
            var strict = false
            if (`is`(bools)) strict = bools[0] == true
            val pattern: java.util.regex.Pattern = java.util.regex.Pattern.compile(re,
                if (strict) 0 else java.util.regex.Pattern.CASE_INSENSITIVE)
            val matcher: java.util.regex.Matcher = pattern.matcher(str.trim { it <= ' ' })
            return !!matcher.find()
        }
        fun findMatch(str: String, re: String, vararg bools: Boolean): String {
            if (not(str) || not(re)) return ""
            if (((re == ".") || (re == "*") || (re == "+") || (re == ""))) {
                re = "\\" + re
            }
            try {
                re = re.replace("(<![\\.\\\\])\\.(![*+])".toRegex(), "\\\\.")
                    .replace("(<![\\\\\\.\\w\\)\\]\\|\\%\\$@])([\\+\\*])".toRegex(),
                        "\\\\$1")
                    .replace("%%".toRegex(), "%").replace("(<!\\\\)%c".toRegex(), "[A-Za-z]")
                    .replace("(<!\\\\)(%[sw]|\\{\\})".toRegex(), "[A-Za-z][\\\\w]+")
                    .replace("(<!\\\\)%b".toRegex(), "(true|false)")
                    .replace("(<!\\\\)%[di]".toRegex(), "(<!\\.)\\\\d+(!\\.)")
                    .replace("(<!\\\\)%[\\.\\\\d]*f".toRegex(), "\\\\d*\\.\\\\d+")
                    .replace("(<!\\\\)%n".toRegex(), "\\\\d+")
            } catch (e: java.lang.Exception) {
            }
            // modification precaution: it has been tested, and hence learned,
            // the
            // double-escaping remains AS-IS
            // THIS IS THE ONLY PART OF THE FILE WHERE YOU NEED TO ESCAPE TWICE
            // escaping tricky characters, if they're the only content: helps avoid
            // false positives as a "." or a "*" alone, can match just anything.
            // Needless to say, these quantifiers, along with a "+" and an
            // optionality quantifier, i.e. a "" quantifier, might also cause
            // memory heap to exceed
            // plus, handling both, standard and custom, format specifiers
            var strict = false
            if (`is`(bools)) {
                strict = bools[0] == true
            }
            val pattern: java.util.regex.Pattern = java.util.regex.Pattern.compile("($re)",
                if (strict) 0 else java.util.regex.Pattern.CASE_INSENSITIVE)
            val matcher: java.util.regex.Matcher = pattern.matcher(str.trim { it <= ' ' })
            return if (!matcher.find()) "" else matcher.group()
        }
        fun match(arrA: Array<String>, arrB: Array<String>): Boolean {
            return Arrays.compare<String>(arrA, arrB) >= 0
            // returns a negative value if true, just like with most functions in C,
            // or C++
        }
        fun match(arrA: IntArray, arrB: IntArray): Boolean {
            return Arrays.compare(arrA, arrB) >= 0
            // returns a negative value if true, just like with most functions in C,
            // or C++
        }
        fun match(arrA: LongArray, arrB: LongArray): Boolean {
            return Arrays.compare(arrA, arrB) >= 0
            // returns a negative value if true, just like with most functions in C,
            // or C++
        }
        fun match(arrA: FloatArray, arrB: FloatArray): Boolean {
            return Arrays.compare(arrA, arrB) >= 0
            // returns a negative value if true, just like with most functions in C,
            // or C++
        }
        fun match(arrA: DoubleArray, arrB: DoubleArray): Boolean {
            return Arrays.compare(arrA, arrB) >= 0
            // returns a negative value if true, just like with most functions in C,
            // or C++
        }
        fun match(arrA: BooleanArray, arrB: BooleanArray): Boolean {
            return Arrays.compare(arrA, arrB) >= 0
            // returns a negative value if true, just like with most functions in C,
            // or C++
        }
        fun compare(strA: String, strB: String): Boolean {
            return match(strA, strB)
        }
        fun compare(arrA: Array<String>, arrB: Array<String>): Boolean {
            return match(arrA, arrB)
        }
        fun compare(arrA: IntArray, arrB: IntArray): Boolean {
            return match(arrA, arrB)
        }
        fun compare(arrA: LongArray, arrB: LongArray): Boolean {
            return match(arrA, arrB)
        }
        fun compare(arrA: FloatArray, arrB: FloatArray): Boolean {
            return match(arrA, arrB)
        }
        fun compare(arrA: DoubleArray, arrB: DoubleArray): Boolean {
            return match(arrA, arrB)
        }
        fun compare(arrA: BooleanArray, arrB: BooleanArray): Boolean {
            return match(arrA, arrB)
        }
        fun clone(arr: Array<String>): Array<String> {
            return slice(arr)
        }
        fun clone(arr: IntArray): IntArray {
            return slice(arr)
        }
        fun clone(arr: LongArray): LongArray {
            return slice(arr)
        }
        fun clone(arr: FloatArray): FloatArray {
            return slice(arr)
        }
        fun clone(arr: DoubleArray): DoubleArray {
            return slice(arr)
        }
        fun clone(arr: BooleanArray): BooleanArray {
            return slice(arr)
        }
        fun copyArr(arr: Array<String>): Array<String> {
            return clone(arr)
        }
        fun copyArr(arr: IntArray): IntArray {
            return clone(arr)
        }
        fun copyArr(arr: LongArray): LongArray {
            return clone(arr)
        }
        fun copyArr(arr: FloatArray): FloatArray {
            return clone(arr)
        }
        fun copyArr(arr: DoubleArray): DoubleArray {
            return clone(arr)
        }
        fun copyArr(arr: BooleanArray): BooleanArray {
            return clone(arr)
        }
        fun upper(s: String): String {
            s = s.uppercase(Locale.getDefault())
            return s
        }
        fun upper(vararg arr: String): Array<String> {
            if (not(arr)) return arr
            arr = map(arr, java.util.function.Function<String, String> { s: String -> upper(s) })
            return arr
        }
        fun upper(c: Char): Char {
            c = Str(c).uppercase(Locale.getDefault()).get(0)
            return c
        }
        fun upper(vararg arr: Char): CharArray {
            if (not(arr)) return arr
            arr = map(arr, java.util.function.Function<Char, Char> { c: Char -> upper(c) })
            return arr
        }
        fun lower(s: String): String {
            s = s.lowercase(Locale.getDefault())
            return s
        }
        fun lower(vararg arr: String): Array<String> {
            if (not(arr)) return arr
            arr = map(arr, java.util.function.Function<String, String> { s: String -> lower(s) })
            return arr
        }
        fun lower(c: Char): Char {
            c = Str(c).lowercase(Locale.getDefault()).get(0)
            return c
        }
        fun inUpper(s: String): Boolean {
            return (upper(s) == s)
        }
        fun inUpper(c: Char): Boolean {
            return upper(c) == c
        }
        fun notInUpper(s: String): Boolean {
            return !inUpper(s)
        }
        fun notInUpper(c: Char): Boolean {
            return !inUpper(c)
        }
        fun inLower(s: String): Boolean {
            return (lower(s) == s)
        }
        fun inLower(c: Char): Boolean {
            return lower(c) == c
        }
        fun notInLower(s: String): Boolean {
            return !inLower(s)
        }
        fun notInLower(c: Char): Boolean {
            return !inLower(c)
        }
        fun sentCase(input: String): String {
            if (not(input)) return ""
            input = ((input.uppercase(Locale.getDefault()).substring(0, 1)
                    + (if (!`in`(input, "[A-Z]{2,}")) input.lowercase(Locale.getDefault()) else input)
                .substring(1)))
                .replace("(<!\\w)i(!\\w)".toRegex(), "I")
            return input
        }
        fun sentCase(vararg inputs: String): Array<String> {
            if (not(inputs)) return blank.Str
            inputs = map(inputs, java.util.function.Function<String, String> { input: String -> sentCase(input) })
            return inputs
        }
        fun titleCase(input: String): String {
            if (not(input)) return ""
            val parts: Array<String> = input.split("".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            var result = ""
            var nextTitleCase = true
            for (c: String in parts) {
                if (eq(c, " ")) {
                    nextTitleCase = true
                } else if (nextTitleCase) {
                    c = upper(c)
                    nextTitleCase = false
                }
                result += c
            }
            return result
        }
        fun titleCase(vararg inputs: String): Array<String> {
            if (not(inputs)) return blank.Str
            inputs = map(inputs, java.util.function.Function<String, String> { input: String -> titleCase(input) })
            return inputs
        }
        fun reverse(str: String): String {
            return if (not(str)) "" else StringBuilder(str).reverse().toString()
        }
        fun len(str: String): Int {
            return if (str == null) 0 else str.trim { it <= ' ' }.length
        }
        fun len(n: Int): Int {
            var result = 0
            while (n > 0) {
                n /= 10
                result++
            }
            return result
        }
        fun len(n: Long): Int {
            var result = 0
            while (n > 0) {
                n /= 10
                result++
            }
            return result
        }
        fun len(arr: CharArray): Int {
            return if (arr == null) 0 else arr.size
        }
        fun len(arr: Array<String>): Int {
            return if (arr == null) 0 else arr.size
        }
        fun len(arr: IntArray): Int {
            return if (arr == null) 0 else arr.size
        }
        fun len(arr: LongArray): Int {
            return if (arr == null) 0 else arr.size
        }
        fun len(arr: FloatArray): Int {
            return if (arr == null) 0 else arr.size
        }
        fun len(arr: DoubleArray): Int {
            return if (arr == null) 0 else arr.size
        }
        fun len(arr: BooleanArray): Int {
            return if (arr == null) 0 else arr.size
        }
        fun len(arr: Array<Any>): Int {
            return if (arr == null) 0 else arr.size
        }
        fun size(str: String): Int {
            return len(str)
        }
        fun size(n: Int): Int {
            return len(n)
        }
        fun size(n: Long): Int {
            return len(n)
        }
        fun size(arr: Array<String>): Int {
            return len(arr)
        }
        fun size(arr: IntArray): Int {
            return len(arr)
        }
        fun size(arr: LongArray): Int {
            return len(arr)
        }
        fun size(arr: FloatArray): Int {
            return len(arr)
        }
        fun size(arr: DoubleArray): Int {
            return len(arr)
        }
        fun size(arr: BooleanArray): Int {
            return len(arr)
        }
        fun isEmpty(c: Char): Boolean {
            return '\u0000' == c
        }
        fun isEmpty(s: String): Boolean {
            return 0 == len(s)
        }
        fun isEmpty(n: Int): Boolean {
            return 0 == n
        }
        fun isEmpty(n: Long): Boolean {
            return 0L == n
        }
        fun isEmpty(n: Float): Boolean {
            return 0f == n
        }
        fun isEmpty(n: Double): Boolean {
            return 0.0 == n
        }
        fun isEmpty(arr: CharArray): Boolean {
            return 0 == len(arr)
        }
        fun isEmpty(vararg subArrays: CharArray): Boolean {
            var count = 0
            for (arr: CharArray in subArrays) {
                if (isEmpty((arr))) count++
            }
            return count > 0
            // to handle sub arays
        }
        fun isEmpty(arr: Array<String>): Boolean {
            return 0 == len(arr)
        }
        fun isEmpty(vararg subArrays: Array<String>): Boolean {
            var count = 0
            for (arr: Array<String> in subArrays) {
                if (isEmpty((arr))) count++
            }
            return count > 0
            // to handle sub arays
        }
        fun isEmpty(arr: IntArray): Boolean {
            return 0 == len(arr)
        }
        fun isEmpty(vararg subArrays: IntArray): Boolean {
            var count = 0
            for (arr: IntArray in subArrays) {
                if (isEmpty((arr))) count++
            }
            return count > 0
            // to handle sub arays
        }
        fun isEmpty(arr: LongArray): Boolean {
            return 0 == len(arr)
        }
        fun isEmpty(vararg subArrays: LongArray): Boolean {
            var count = 0
            for (arr: LongArray in subArrays) {
                if (isEmpty((arr))) count++
            }
            return count > 0
            // to handle sub arays
        }
        fun isEmpty(arr: FloatArray): Boolean {
            return 0 == len(arr)
        }
        fun isEmpty(vararg subArrays: FloatArray): Boolean {
            var count = 0
            for (arr: FloatArray in subArrays) {
                if (isEmpty((arr))) count++
            }
            return count > 0
            // to handle sub arays
        }
        fun isEmpty(arr: DoubleArray): Boolean {
            return 0 == len(arr)
        }
        fun isEmpty(vararg subArrays: DoubleArray): Boolean {
            var count = 0
            for (arr: DoubleArray in subArrays) {
                if (isEmpty((arr))) count++
            }
            return count > 0
            // to handle sub arays
        }
        fun isEmpty(arr: BooleanArray): Boolean {
            return 0 == len(arr)
        }
        fun isEmpty(vararg subArrays: BooleanArray): Boolean {
            var count = 0
            for (arr: BooleanArray in subArrays) {
                if (isEmpty((arr))) count++
            }
            return count > 0
            // to handle sub arays
        }
        fun isEmpty(arr: Array<Any>): Boolean {
            return 0 == len(arr)
        }
        fun isEmpty(vararg subArrays: Array<Any>): Boolean {
            var count = 0
            for (arr: Array<Any> in subArrays) {
                if (0 == len(arr)) count++
            }
            return count > 0
            // to handle sub arays
        }
        fun hasLen(c: Char): Boolean {
            return !isEmpty(c)
        }
        fun hasLen(s: String): Boolean {
            return !isEmpty(s)
        }
        fun hasLen(n: Int): Boolean {
            return !isEmpty(n)
        }
        fun hasLen(n: Long): Boolean {
            return !isEmpty(n)
        }
        fun hasLen(n: Float): Boolean {
            return !isEmpty(n)
        }
        fun hasLen(n: Double): Boolean {
            return !isEmpty(n)
        }
        fun hasLen(arr: CharArray): Boolean {
            return !isEmpty(arr)
        }
        fun hasLen(vararg subArrays: CharArray): Boolean {
            return !isEmpty(*subArrays)
        }
        fun hasLen(arr: Array<String>): Boolean {
            return !isEmpty(arr)
        }
        fun hasLen(vararg subArrays: Array<String>): Boolean {
            return !isEmpty(*subArrays)
        }
        fun hasLen(arr: IntArray): Boolean {
            return !isEmpty(arr)
        }
        fun hasLen(vararg subArrays: IntArray): Boolean {
            return !isEmpty(*subArrays)
        }
        fun hasLen(arr: LongArray): Boolean {
            return !isEmpty(arr)
        }
        fun hasLen(vararg subArrays: LongArray): Boolean {
            return !isEmpty(*subArrays)
        }
        fun hasLen(arr: FloatArray): Boolean {
            return !isEmpty(arr)
        }
        fun hasLen(vararg subArrays: FloatArray): Boolean {
            return !isEmpty(*subArrays)
        }
        fun hasLen(arr: DoubleArray): Boolean {
            return !isEmpty(arr)
        }
        fun hasLen(vararg subArrays: DoubleArray): Boolean {
            return !isEmpty(*subArrays)
        }
        fun hasLen(arr: BooleanArray): Boolean {
            return !isEmpty(arr)
        }
        fun hasLen(vararg subArrays: BooleanArray): Boolean {
            return !isEmpty(*subArrays)
        }
        fun hasLen(arr: Array<Any>): Boolean {
            return !isEmpty(arr)
        }
        fun hasLen(vararg subArrays: Array<Any>): Boolean {
            return !isEmpty(*subArrays)
        }
        // Arrays
        fun type(o: Any): String {
            if (isNull<Any>(o)) return "null"
            var middleware: String = o.javaClass.toString()
            if (`in`(middleware, "\\s")) {
                middleware = middleware.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray().get(1)
                return if (`in`(middleware, "\\[")) replace(middleware.replace("\\[".toRegex(), "array\\."), "\\w$",
                    java.util.function.Function<String, String> { m: String ->
                        if (eq(m, "C")) return@replace "char" else if (eq(m, "I")) return@replace "int" else if (eq(m, "J")) return@replace "long" else if (eq(m, "F")) return@replace "flt" else if (eq(m, "D")) return@replace "dbl" else if (eq(m, "Z")) return@replace "bool"
                        "arr"
                    }).replace("Ljava\\.lang\\.|\\;".toRegex(), "")
                    .replace("String".toRegex(), "str").replace("Number".toRegex(), "num")
                    .replace("Object".toRegex(), "obj") else middleware.lowercase(Locale.getDefault())
                    .replace("(<=\\w{3,4})arr".toRegex(), "Arr")
                    .replace("\\$".toRegex(), "\\.").replace("\\w+\\.".toRegex(), "")
            }
            // arrays that belong to a class, for instance, Number[], Object[],
            // instead leave a trailing semicolon at the end
            return middleware.split("\\.".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray().get(2).lowercase(Locale.getDefault())
        }
        fun type(obj: Any, guessedType: String): Boolean {
            if (not(guessedType)) return false
            return if (len(guessedType) < 3) startsWith(type(obj), guessedType) else `in`(type(obj), guessedType)
        }
        // ^this one stays too
        fun type(src: Any, cond1: Any, sol1: Runnable,
                 cond2: Any, sol2: Runnable, cond3: Any, sol3: Runnable,
                 cond4: Any, sol4: Runnable, cond5: Any, sol5: Runnable,
                 cond6: Any, sol6: Runnable, cond7: Any, sol7: Runnable,
                 cond8: Any, sol8: Runnable, cond9: Any, sol9: Runnable,
                 cond10: Any, sol10: Runnable): Boolean {
            return if (not(src)) false else sw(type(src), cond1, sol1, cond2, sol2, cond3, sol3, cond4, sol4,
                cond5, sol5, cond6, sol6, cond7, sol7, cond8, sol8, cond9, sol9,
                cond10, sol10)
        }
        fun type(src: Any, cond1: Any, sol1: Runnable,
                 cond2: Any, sol2: Runnable, cond3: Any, sol3: Runnable,
                 cond4: Any, sol4: Runnable, cond5: Any, sol5: Runnable,
                 cond6: Any, sol6: Runnable, cond7: Any, sol7: Runnable,
                 cond8: Any, sol8: Runnable, cond9: Any, sol9: Runnable): Boolean {
            return if (not(src)) false else sw(type(src), cond1, sol1, cond2, sol2, cond3, sol3, cond4, sol4,
                cond5, sol5, cond6, sol6, cond7, sol7, cond8, sol8, cond9,
                sol9)
        }
        fun type(src: Any, cond1: Any, sol1: Runnable,
                 cond2: Any, sol2: Runnable, cond3: Any, sol3: Runnable,
                 cond4: Any, sol4: Runnable, cond5: Any, sol5: Runnable,
                 cond6: Any, sol6: Runnable, cond7: Any, sol7: Runnable,
                 cond8: Any, sol8: Runnable): Boolean {
            return if (not(src)) false else sw(type(src), cond1, sol1, cond2, sol2, cond3, sol3, cond4, sol4,
                cond5, sol5, cond6, sol6, cond7, sol7, cond8, sol8)
        }
        fun type(src: Any, cond1: Any, sol1: Runnable,
                 cond2: Any, sol2: Runnable, cond3: Any, sol3: Runnable,
                 cond4: Any, sol4: Runnable, cond5: Any, sol5: Runnable,
                 cond6: Any, sol6: Runnable, cond7: Any, sol7: Runnable): Boolean {
            return if (not(src)) false else sw(type(src), cond1, sol1, cond2, sol2, cond3, sol3, cond4, sol4,
                cond5, sol5, cond6, sol6, cond7, sol7)
        }
        fun type(src: Any, cond1: Any, sol1: Runnable,
                 cond2: Any, sol2: Runnable, cond3: Any, sol3: Runnable,
                 cond4: Any, sol4: Runnable, cond5: Any, sol5: Runnable,
                 cond6: Any, sol6: Runnable): Boolean {
            return if (not(src)) false else sw(type(src), cond1, sol1, cond2, sol2, cond3, sol3, cond4, sol4,
                cond5, sol5, cond6, sol6)
        }
        fun type(src: Any, cond1: Any, sol1: Runnable,
                 cond2: Any, sol2: Runnable, cond3: Any, sol3: Runnable,
                 cond4: Any, sol4: Runnable, cond5: Any, sol5: Runnable): Boolean {
            return if (not(src)) false else sw(type(src), cond1, sol1, cond2, sol2, cond3, sol3, cond4, sol4,
                cond5, sol5)
        }
        fun type(src: Any, cond1: Any, sol1: Runnable,
                 cond2: Any, sol2: Runnable, cond3: Any, sol3: Runnable,
                 cond4: Any, sol4: Runnable): Boolean {
            return if (not(src)) false else sw(type(src), cond1, sol1, cond2, sol2, cond3, sol3, cond4,
                sol4)
        }
        fun type(src: Any, cond1: Any, sol1: Runnable,
                 cond2: Any, sol2: Runnable, cond3: Any, sol3: Runnable): Boolean {
            return if (not(src)) false else sw(type(src), cond1, sol1, cond2, sol2, cond3, sol3)
        }
        fun type(src: Any, cond1: Any, sol1: Runnable,
                 cond2: Any, sol2: Runnable): Boolean {
            return if (not(src)) false else sw(type(src), cond1, sol1, cond2, sol2)
        }
        fun type(src: Any, cond1: Any, sol1: Runnable): Boolean {
            return if (not(src)) false else sw(type(src), cond1, sol1)
        }
        // let's set up some "type"-helpers for the function
        var None: Any = "null"
        var Ch: String = "character"
        var Str = "string"
        var Int = "integer"
        var Char: String = "character".also { Ch = it }
        var Long = "long"
        var Flt = "float"
        var Dbl = "double"
        var Bool = "boolean"
        var Arr = "array\\."
        var ArrOfChar = "array\\.char"
        var ArrOfStr = "array\\.str"
        var ArrOfInt = "array\\.int"
        var ArrOfLong = "array\\.long"
        var ArrOfFlt = "array\\.flt"
        var ArrOfDbl = "array\\.dbl"
        var ArrOfBool = "array\\.bool"
        var ArrOfNum = "array\\.num"
        var ArrOfObj = "array\\.obj"
        fun charArrToCharArr(inputArr: Array<Char>): CharArray {
            if (not(inputArr)) return blank.Char
            val length = inputArr.size
            val resultingArr = CharArray(length)
            for (i in 0 until length) resultingArr[i] = (inputArr[i])!!
            return resultingArr
        }
        fun intArrToIntArr(inputArr: Array<Int>): IntArray {
            if (not(inputArr)) return blank.Int
            val length = inputArr.size
            val resultingArr = IntArray(length)
            for (i in 0 until length) resultingArr[i] = (inputArr[i])!!
            return resultingArr
        }
        fun longArrToLongArr(inputArr: Array<Long>): LongArray {
            if (not(inputArr)) return blank.Long
            val length = inputArr.size
            val resultingArr = LongArray(length)
            for (i in 0 until length) resultingArr[i] = (inputArr[i])!!
            return resultingArr
        }
        fun floatArrToFloatArr(inputArr: Array<Float>): FloatArray {
            if (not(inputArr)) return blank.Flt
            val length = inputArr.size
            val resultingArr = FloatArray(length)
            for (i in 0 until length) resultingArr[i] = (inputArr[i])!!
            return resultingArr
        }
        fun fltArrToFltArr(inputArr: Array<Float>): FloatArray {
            return floatArrToFloatArr(inputArr)
        }
        fun dblArrToDblArr(inputArr: Array<Double>): DoubleArray {
            if (not(inputArr)) return blank.Dbl
            val length = inputArr.size
            val resultingArr = DoubleArray(length)
            for (i in 0 until length) resultingArr[i] = (inputArr[i])!!
            return resultingArr
        }
        fun boolArrToBoolArr(inputArr: Array<Boolean>): BooleanArray {
            if (not(inputArr)) return blank.Bool
            val length = inputArr.size
            val resultingArr = BooleanArray(length)
            for (i in 0 until length) resultingArr[i] = (inputArr[i])!!
            return resultingArr
        }
        fun untangle(inputArr: Array<Char>): CharArray {
            return charArrToCharArr(inputArr)
        }
        fun untangle(inputArr: Array<Int>): IntArray {
            return intArrToIntArr(inputArr)
        }
        fun untangle(inputArr: Array<Long>): LongArray {
            return longArrToLongArr(inputArr)
        }
        fun untangle(inputArr: Array<Float>): FloatArray {
            return floatArrToFloatArr(inputArr)
        }
        fun untangle(inputArr: Array<Double>): DoubleArray {
            return dblArrToDblArr(inputArr)
        }
        fun untangle(inputArr: Array<Boolean>): BooleanArray {
            return boolArrToBoolArr(inputArr)
        }
        fun shuffle(str: String): String {
            val chars: CharArray = str.toCharArray()
            val random = Random()
            for (i in chars.size - 1 downTo 1) {
                val j: Int = random.nextInt(i + 1)
                val temp = chars[i]
                chars[i] = chars[j]
                chars[j] = temp
            }
            return kotlin.String(chars)
        }
        fun shuffle(arr: Array<String>): Array<String> {
            val rnd = Random()
            for (i in arr.size - 1 downTo 1) {
                val index: Int = rnd.nextInt(i + 1)
                val temp = arr[index]
                arr[index] = arr[i]
                arr[i] = temp
            }
            return arr
        }
        fun shuffle(arr: IntArray): IntArray {
            val rnd = Random()
            for (i in arr.size - 1 downTo 1) {
                val index: Int = rnd.nextInt(i + 1)
                val temp = arr[index]
                arr[index] = arr[i]
                arr[i] = temp
            }
            return arr
        }
        fun shuffle(arr: LongArray): LongArray {
            val rnd = Random()
            for (i in arr.size - 1 downTo 1) {
                val index: Int = rnd.nextInt(i + 1)
                val temp = arr[index]
                arr[index] = arr[i]
                arr[i] = temp
            }
            return arr
        }
        fun shuffle(arr: FloatArray): FloatArray {
            val rnd = Random()
            for (i in arr.size - 1 downTo 1) {
                val index: Int = rnd.nextInt(i + 1)
                val temp = arr[index]
                arr[index] = arr[i]
                arr[i] = temp
            }
            return arr
        }
        fun shuffle(arr: DoubleArray): DoubleArray {
            val rnd = Random()
            for (i in arr.size - 1 downTo 1) {
                val index: Int = rnd.nextInt(i + 1)
                val temp = arr[index]
                arr[index] = arr[i]
                arr[i] = temp
            }
            return arr
        }
        fun shuffle(arr: BooleanArray): BooleanArray {
            val rnd = Random()
            for (i in arr.size - 1 downTo 1) {
                val index: Int = rnd.nextInt(i + 1)
                val temp = arr[index]
                arr[index] = arr[i]
                arr[i] = temp
            }
            return arr
        }
        private val ctss = arrayOf<String>("Abbottabad", "Adilpur", "Ahmadpur East",
            "Ahmadpur Sial", "Akora", "Aliabad", "Alik Ghund", "Alipur",
            "Alizai", "Alpurai", "Aman Garh", "Amirabad", "Arifwala",
            "Ashanagro Koto", "Athmuqam", "Attock City", "Awaran", "Baddomalhi",
            "Badin", "Baffa", "Bagarji", "Bagh", "Bahawalnagar", "Bahawalnagar",
            "Bahawalpur", "Bakhri Ahmad Khan", "Bandhi", "Bannu", "Barishal",
            "Barkhan", "Basirpur", "Basti Dosa", "Bat Khela", "Battagram",
            "Begowala", "Bela", "Berani", "Bhag", "Bhakkar", "Bhalwal", "Bhan",
            "Bhawana", "Bhera", "Bhimbar", "Bhiria", "Bhit Shah", "Bhopalwala",
            "Bozdar Wada", "Bulri", "Burewala", "Chak", "Chak Azam Sahu",
            "Chak Five Hundred Seventy-five", "Chak Jhumra",
            "Chak One Hundred Twenty Nine Left", "Chak Thirty-one -Eleven Left",
            "Chak Two Hundred Forty-nine Thal Development Authority", "Chakwal",
            "Chaman", "Chamber", "Charsadda", "Chawinda", "Chenab Nagar",
            "Cherat Cantonement", "Chhor", "Chichawatni", "Chilas", "Chiniot",
            "Chishtian", "Chitral", "Choa Saidan Shah", "Chowki Jamali",
            "Chuchar-kana Mandi", "Chuhar Jamali", "Chunian", "Dadhar", "Dadu",
            "Daggar", "Daira Din Panah", "Dajal", "Dalbandin", "Dandot RS",
            "Daromehar", "Darya Khan", "Darya Khan Marri", "Daska Kalan",
            "Dasu", "Daud Khel", "Daulatpur", "Daultala", "Daur",
            "Dera Alahyar", "Dera Bugti", "Dera Ghazi Khan", "Dera Ismail Khan",
            "Dera Murad Jamali", "Dhanot", "Dhaunkal", "Dhoro Naro", "Digri",
            "Dijkot", "Dinan Bashnoian Wala", "Dinga", "Dipalpur", "Diplo",
            "Doaba", "Dokri", "Duki", "Dullewala", "Dunga Bunga", "Dunyapur",
            "Eidgah", "Eminabad", "Faisalabad", "Faqirwali", "Faruka",
            "Fazilpur", "Fort Abbas", "Gadani", "Gakuch", "Gambat", "Gandava",
            "Garh Maharaja", "Garhi Khairo", "Garhiyasin", "Ghauspur", "Ghotki",
            "Gilgit", "Gojra", "Goth Garelo", "Goth Phulji", "Goth Radhan",
            "Gujar Khan", "Gujranwala", "Gujrat", "Gulishah Kach", "Gwadar",
            "Hadali", "Hafizabad", "Hala", "Hangu", "Haripur", "Harnai",
            "Harnoli", "Harunabad", "Hasilpur", "Hattian Bala", "Haveli Lakha",
            "Havelian", "Hazro City", "Hingorja", "Hujra Shah Muqim",
            "Hyderabad", "Islamabad", "Islamkot", "Jacobabad", "Jahanian Shah",
            "Jalalpur Jattan", "Jalalpur Pirwala", "Jampur", "Jamshoro", "Jand",
            "Jandiala Sher Khan", "Jaranwala", "Jati", "Jatoi Shimali",
            "Jauharabad", "Jhang City", "Jhang Sadr", "Jhawarian", "Jhelum",
            "Jhol", "Jiwani", "Johi", "Jam Sahib", "Kabirwala", "Kadhan",
            "Kahna Nau", "Kahror Pakka", "Kahuta", "Kakad Wari Dir Upper",
            "Kalabagh", "Kalaswala", "Kalat", "Kaleke Mandi", "Kallar Kahar",
            "Kalur Kot", "Kamalia", "Kamar Mushani", "Kambar", "Kamoke",
            "Kamra", "Kandhkot", "Kandiari", "Kandiaro", "Kanganpur", "Karachi",
            "Karak", "Karaundi", "Kario Ghanwar", "Karor", "Kashmor", "Kasur",
            "Keshupur", "Keti Bandar", "Khadan Khak", "Khadro", "Khairpur",
            "Khairpur Mir\'s", "Khairpur Nathan Shah", "Khairpur Tamewah",
            "Khalabat", "Khandowa", "Khanewal", "Khangah Dogran", "Khangarh",
            "Khanpur", "Khanpur Mahar", "Kharan", "Kharian", "Khewra",
            "Khurrianwala", "Khushab", "Khuzdar", "Kohat", "Kohlu", "Kot Addu",
            "Kot Diji", "Kot Ghulam Muhammad", "Kot Malik Barkhurdar",
            "Kot Mumin", "Kot Radha Kishan", "Kot Rajkour", "Kot Samaba",
            "Kot Sultan", "Kotli", "Kotli Loharan", "Kotri", "Kulachi",
            "Kundian", "Kunjah", "Kunri", "Lachi", "Ladhewala Waraich",
            "Lahore", "Lakhi", "Lakki", "Lala Musa", "Lalian", "Landi Kotal",
            "Larkana", "Layyah", "Liliani", "Lodhran", "Loralai", "Mach",
            "Madeji", "Mailsi", "Malakand", "Malakwal", "Malakwal City",
            "Malir Cantonment", "Mamu Kanjan", "Mananwala", "Mandi Bahauddin",
            "Mangla", "Mankera", "Mansehra", "Mardan", "Mastung", "Matiari",
            "Matli", "Mehar", "Mehmand Chak", "Mehrabpur", "Mian Channun",
            "Mianke Mor", "Mianwali", "Minchianabad", "Mingora", "Miran Shah",
            "Miro Khan", "Mirpur Bhtoro", "Mirpur Khas", "Mirpur Mathelo",
            "Mirpur Sakro", "Mirwah Gorchani", "Mitha Tiwana", "Mithi", "Moro",
            "Moza Shahwala", "Multan", "Muridke", "Murree", "Musa Khel Bazar",
            "Mustafabad", "Muzaffargarh", "Muzaffarabad", "Nabisar",
            "Nankana Sahib", "Narang Mandi", "Narowal", "Nasirabad", "Naudero",
            "Naukot", "Naushahra Virkan", "Naushahro Firoz", "Nawabshah",
            "Nazir Town", "New Badah", "New Mirpur", "Noorabad", "Nowshera",
            "Nowshera Cantonment", "Nushki", "Okara", "Ormara", "Pabbi",
            "Pad Idan", "Paharpur", "Pakpattan", "Panjgur", "Pano Aqil",
            "Parachinar", "Pasni", "Pasrur", "Pattoki", "Peshawar", "Phalia",
            "Pind Dadan Khan", "Pindi Bhattian", "Pindi Gheb", "Pir Jo Goth",
            "Pir Mahal", "Pishin", "Pithoro", "Qadirpur Ran", "Qila Abdullah",
            "Qila Saifullah", "Quetta", "Rahim Yar Khan", "Raiwind",
            "Raja Jang", "Rajanpur", "Rajo Khanani", "Ranipur", "Rasulnagar",
            "Ratodero", "Rawala Kot", "Rawalpindi", "Renala Khurd",
            "Risalpur Cantonment", "Rohri", "Rojhan", "Rustam", "Saddiqabad",
            "Sahiwal", "Sahiwal", "Saidu Sharif", "Sakrand", "Samaro",
            "Sambrial", "Sanghar", "Sangla Hill", "Sanjwal", "Sann",
            "Sarai Alamgir", "Sarai Naurang", "Sarai Sidhu", "Sargodha",
            "Sehwan", "Setharja Old", "Shabqadar", "Shahdad Kot", "Shahdadpur",
            "Shahkot", "Shahpur", "Shahpur Chakar", "Shahr Sultan",
            "Shakargarh", "Sharqpur Sharif", "Shekhupura", "Shikarpur",
            "Shingli Bala", "Shinpokh", "Shorkot", "Shujaabad", "Sialkot",
            "Sibi", "Sillanwali", "Sinjhoro", "Skardu", "Sobhodero", "Sodhri",
            "Sohbatpur", "Sukheke Mandi", "Sukkur", "Surab", "Surkhpur",
            "Swabi", "Sita Road", "Talagang", "Talamba", "Talhar",
            "Tandlianwala", "Tando Adam", "Tando Alahyar", "Tando Bago",
            "Tando Jam", "Tando Mitha Khan", "Tando Muhammad Khan", "Tangi",
            "Tangwani", "Tank", "Taunsa", "Thal", "Tharu Shah", "Thatta",
            "Thul", "Timargara", "Toba Tek Singh", "Topi", "Turbat", "Ubauro",
            "Umarkot", "Upper Dir", "Usta Muhammad", "Uthal", "Utmanzai",
            "Vihari", "Wana", "Warah", "Wazirabad", "Yazman", "Zafarwal",
            "Zahir Pir", "Zaida", "Zhob", "Ziarat")
        private val wdss = arrayOf<String>("documentary", "compliment", "insult", "vocalist",
            "pianist", "violinist", "thirst", "hunger", "brevity",
            "longevity", "sanity", "insanity", "bikini", "panty",
            "hymen", "synthesis", "dementia", "amnesia", "blood sugar",
            "fever", "flu", "diarrhea", "glucose", "Latino", "Latina",
            "anesthetics", "anesthesia", "Cannabis", "oasis", "desert",
            "dessert", "hemoglobin", "cardiographer", "carpenter",
            "oceanic", "terran", "abroad", "absorbing", "abstract",
            "academic", "accelerated", "accented", "accountant",
            "acquainted", "acute", "obtuse", "protective", "possessive",
            "real", "unreal", "realistic", "unrealistic", "imagined",
            "delusional", "addicting", "addictive", "adjustable",
            "admired", "adult", "adverse", "advised", "aerosol",
            "afraid", "creeped out", "horrified", "horrific",
            "terrified", "terrific", "devastated", "frustrated",
            "aggravated", "aggressive", "agreeable", "alienate",
            "aligned", "all-round", "alleged", "almond", "alright",
            "altruistic", "ambient", "ambivalent", "amiable", "amino",
            "amorphous", "amused", "anatomical", "ancestral", "angelic",
            "angrier", "answerable", "antiquarian", "antiretroviral",
            "appellate", "applicable", "apportioned", "approachable",
            "appropriated", "archer", "aroused", "arrested",
            "assertive", "assigned", "athletic", "atrocious",
            "attained", "authoritarian", "autobiographical",
            "avaricious", "avocado", "awake", "awesome", "backstage",
            "backwoods", "balding", "bandaged", "banded", "banned",
            "barreled", "battle", "beaten", "begotten", "beguiled",
            "bellied", "belted", "beneficent", "besieged", "betting",
            "big-money", "biggest", "biochemical", "bipolar",
            "blackened", "blame", "blessed", "blindfolded", "bloat",
            "blocked", "blooded", "decrepit", "dedicated", "defaced",
            "defective", "defenseless", "deluded", "deodorant",
            "departed", "depress", "fretted", "frugal",
            "indiscriminate", "indomitable", "inert", "inflate",
            "inform", "inheriting", "injured", "injurious", "inking",
            "inoffensive", "insane", "insensible", "insidious",
            "insincere", "insistent", "insolent", "insufferable",
            "intemperate", "interdependent", "interesting",
            "interfering", "intern", "interpreted", "intersecting",
            "intolerable", "intolerant", "intuitive", "irresolute",
            "irritate", "jealous", "jerking", "joining", "joint",
            "journalistic", "joyful", "keyed", "knowing", "lacklustre",
            "laden", "lagging", "lamented", "laughable", "layered",
            "leather", "leathern", "leery", "left-footed", "legible",
            "leisure", "lessening", "liberating", "life-size", "lifted",
            "lightest", "limitless", "listening", "literary", "liver",
            "livid", "lobster", "locked", "long-held", "long-lasting",
            "long-running", "oversize", "overworked", "oyster", "paced",
            "panting", "paralyzed", "paramount", "parental", "parted",
            "partisan", "passive", "edible", "eatable", "kissable",
            "palette")
        private val ntltss = arrayOf<String>("Afghan", "Egyptian", "Alantic", "Albanian", "Algerian",
            "Virgin Islander", "American Samoan", "Andorran", "Angolan",
            "Anguillan", "Antarctic", "Antiguan and Barbudan",
            "Equatorial Guinean", "Argentine; Argentinian", "Armenian",
            "Aruban", "Azerbaijani", "Ethiopian", "Australian",
            "Bahamian", "Bahraini", "Bangladeshi", "Barbadian",
            "Belarusian", "Belgian", "Belizean", "Beninese",
            "Bermudian", "Bhutanese", "Bolivian", "Bosnian",
            "Botswanan", "of Bouvet Island", "Brazilian",
            "of the British Indian Ocean Territory",
            "British Virgin Islander", "Bruneian", "Bulgarian",
            "Burkinabe", "Burundian", "Cape Verdean", "Chilean",
            "Chinese", "of Clipperton Island", "Cook Islander",
            "Costa Rican", "Ivorian", "Curacaoan", "Danish", "German",
            "Dominican", "Djiboutian", "Ecuadorian",
            "Salvadorian; Salvadoran", "Eritrean", "Estonian",
            "Falklander", "Faroese", "Fijian", "Finnish", "French",
            "of the French Southern and Antarctic Lands", "Guianese",
            "Polynesian", "Gabonese", "Gambian", "Georgian", "Ghanaian",
            "Gibraltarian", "Grenadian", "Greek", "Greenlandic",
            "Guadeloupean", "Guamanian", "Guatemalan", "Guernsey",
            "Guinean", "Bissau-Guinean", "Guyanese", "Haitian",
            "of the Heard Island and McDonald Islands",
            "of the Holy See/of the Vatican", "Honduran",
            "Hong Kong Chinese", "Indian", "Indonesian", "Manx",
            "Iraqi", "Iranian", "Irish", "Icelandic", "Israeli",
            "Italian", "Jamaican", "Japanese", "Yemeni", "Jersey",
            "Jordanian", "Caymanian", "Cambodian", "Cameroonian",
            "Canadian", "Kazakh", "Qatari", "Kenyan", "Kyrgyz",
            "Kiribatian", "of the Cocos (Keeling) Islands", "Colombian",
            "Comorian", "Congolese", "Croatian", "Cuban", "Kuwaiti",
            "Lao; Laotian", "Mesotho", "Latvian", "Lebanese",
            "Liberian", "Libyan", "Liechtensteiners", "Lithuanian",
            "Luxembourgish", "Macanese", "Malagasy", "Malawian",
            "Malaysian", "Maldivian", "Malian", "Maltese", "Moroccan",
            "Marshallese", "Martinican", "Mauritanian", "Mauritian",
            "Mahoran", "Mexican", "Micronesian", "Moldovan",
            "Monegasque", "Mongolian", "Montenegrin", "Montserratian",
            "Mozambican", "Burmese", "Namibian", "Nauruan", "Nepalese",
            "New Caledonian", "New Zealander", "Nicaraguan", "Dutch",
            "Nigerien", "Nigerian", "Niuean", "North Korean",
            "Marian Islander", "Norfolk Islander", "Norwegian", "Omani",
            "Austrian", "Pakistani", "Palauan", "Panamanian",
            "Papua New Guinean", "Paraguayan", "Peruvian", "Filipino",
            "Pitcairner", "Polish", "Portuguese", "Puerto Rican",
            "Reunionese", "Rwandan; Rwandese", "Romanian", "Russian",
            "Solomon Islander", "Zambian", "Samoan", "Sammarinese",
            "Sao Tomean", "Saudi Arabian", "Swedish", "Swiss",
            "Senegalese", "Serbian", "Seychellois", "Sierra Leonean",
            "Zimbabwean", "Singaporean", "Slovak", "Slovenian",
            "Somali; Somalian", "Spanish", "Sri Lankan",
            "Saint Barthelemian",
            "of Saint Helena, Ascension and Tristan da Cunha",
            "of Saint Kitts and Nevis", "Saint Lucian",
            "of Saint Martin", "of Sint Maarten",
            "of Saint Pierre and Miquelon",
            "Vincentian; of Saint Vincent and the Grenadines",
            "South African", "Sudanese",
            "of South Georgia and the South Sandwich Islands",
            "South Korean", "South Sudanese", "Surinamese",
            "of Svalbard, of Jan Mayen", "Swazi", "Syrian", "Tajik",
            "Taiwanese", "Tanzanian", "Thai", "East Timorese",
            "Togolese", "Tokelauan", "Tongan", "of Trinidad and Tobago",
            "Chadian", "Czech", "Tunisian", "Turkish", "Turkmen",
            "of the Turks and Caicos Islands", "Tuvaluan", "Ugandan",
            "Ukrainian", "Hungarian", "Uruguayan", "Uzbek", "Vanuatuan",
            "Venezuelan", "Emirian",
            "American; The United States of America", "British",
            "Vietnamese", "of the Wallis and Futuna Islands",
            "of Christmas Island", "Sahrawi", "Central African",
            "Cypriot")
        private val rfnss = arrayOf<String>("+92 (308) 215 2441", "+92 (305) 205 3250",
            "+92 (314) 763 2228", "+92 (323) 267 3234",
            "+92 (320) 005 8284", "+92 (312) 486 1408",
            "+92 (313) 556 6782", "+92 (312) 188 8504",
            "+92 (321) 517 0564", "+92 (300) 215 0018",
            "+92 (331) 066 8182", "+92 (305) 621 8357",
            "+92 (312) 303 6683", "+92 (330) 315 6554",
            "+92 (318) 702 7462", "+92 (307) 083 6477",
            "+92 (333) 585 3443", "+92 (315) 547 0136",
            "+92 (327) 660 2848", "+92 (330) 144 4028",
            "+92 (323) 276 4840", "+92 (327) 738 8321",
            "+92 (305) 812 7050", "+92 (324) 620 5556",
            "+92 (310) 681 7606", "+92 (336) 286 8600",
            "+92 (333) 241 8207", "+92 (322) 527 1520",
            "+92 (303) 510 4857", "+92 (337) 650 1744",
            "+92 (321) 331 4144", "+92 (301) 515 4836",
            "+92 (332) 460 3760", "+92 (333) 168 2174",
            "+92 (304) 272 1350", "+92 (320) 375 3538",
            "+92 (336) 516 5606", "+92 (330) 088 7340",
            "+92 (317) 523 7275", "+92 (314) 128 3831",
            "+92 (326) 825 7157", "+92 (302) 115 2032",
            "+92 (336) 362 6505", "+92 (313) 627 6536",
            "+92 (302) 832 5304", "+92 (300) 131 4753",
            "+92 (311) 588 0281", "+92 (337) 412 0180",
            "+92 (321) 601 7236", "+92 (306) 075 0548",
            "+92 (336) 744 6742", "+92 (335) 684 5677",
            "+92 (323) 753 4302", "+92 (322) 864 6866",
            "+92 (301) 077 0316", "+92 (320) 080 7036",
            "+92 (327) 613 3783", "+92 (334) 138 2771",
            "+92 (330) 343 8104", "+92 (325) 201 0684",
            "+92 (337) 775 7221", "+92 (311) 857 5310",
            "+92 (322) 615 5255", "+92 (310) 731 2176",
            "+92 (323) 412 7433", "+92 (323) 180 3238",
            "+92 (318) 704 5111", "+92 (321) 485 2814",
            "+92 (334) 611 2074", "+92 (314) 343 0881",
            "+92 (300) 537 3177", "+92 (310) 187 8100",
            "+92 (320) 878 2262", "+92 (324) 785 1028",
            "+92 (313) 070 1354", "+92 (318) 204 0637",
            "+92 (328) 877 2626", "+92 (318) 018 4006",
            "+92 (306) 104 1463", "+92 (313) 862 3726",
            "+92 (318) 388 7683", "+92 (330) 738 5730",
            "+92 (316) 166 6803", "+92 (313) 271 3641",
            "+92 (307) 718 8285", "+92 (306) 256 2360",
            "+92 (321) 104 8067", "+92 (300) 884 5048",
            "+92 (307) 085 3035", "+92 (335) 446 3531",
            "+92 (322) 647 3410", "+92 (328) 760 2861",
            "+92 (327) 772 6701", "+92 (300) 211 6834",
            "+92 (333) 515 7716", "+92 (314) 534 3700",
            "+92 (330) 078 1205", "+92 (304) 316 1564",
            "+92 (338) 782 0723", "+92 (318) 250 1765",
            "+92 (300) 125 7551", "+92 (330) 715 6381",
            "+92 (306) 366 6305", "+92 (330) 548 0703",
            "+92 (324) 818 1781", "+92 (334) 057 4635",
            "+92 (327) 646 3800")
        private val rgynss = arrayOf<String>("Ahmed Raza", "Bilal Tariq", "Usman Siddiqi",
            "Omar Farooq", "Waleed Kamal", "Talha Iqbal",
            "Faisal Latif", "Hassan Jameel", "Adnan Bashir",
            "Kashif Rauf", "Imran Saeed", "Adeel Qureshi",
            "Zeeshan Hashmi", "Shoaib Nadeem", "Noman Shahid",
            "Faizan Khalid", "Hammad Zubair", "Naveed Aslam",
            "Waqar Mehmood", "Sarmad Sheikh", "Tariq Anwar",
            "Junaid Riaz", "Sufyan Abbas", "Shahzad Hussain",
            "Mudassir Younas", "Jawad Hamid", "Ammar Khalil",
            "Rizwan Waheed", "Hasnain Saleem", "Basit Jamal",
            "Sheraz Ahmed", "Umer Shahbaz", "Arsalan Hashim",
            "Raheel Sultan", "Fahad Zaman", "Sajid Irfan", "Owais Rauf",
            "Sarfaraz Kamran", "Khizar Ali", "Ahsan Waseem",
            "Tauseef Haroon", "Murtaza Shah", "Maaz Asif",
            "Samiullah Arif", "Nabeel Qamar", "Taimoor Rauf",
            "Atif Nawaz", "Hashir Siddiqui", "Zubair Imran",
            "Abrar Hussain", "Farhan Waseem", "Umair Tariq", "Arif Ali",
            "Shayan Latif", "Irfan Khalid", "Hamza Masood",
            "Sameer Riaz", "Shoaib Hanif", "Adil Jameel", "Ahmed Saeed",
            "Mudassir Kamal", "Haris Younas", "Noman Waqar",
            "Waseem Abbas", "Faizan Rauf", "Mubashir Jamil",
            "Sohail Shahzad", "Ubaid Latif", "Sikandar Saeed",
            "Hasham Khalid", "Farrukh Hussain", "Zain Qureshi",
            "Arslan Abbas", "Muzammil Tariq", "Usama Rasheed",
            "Adeel Sultan", "Taha Iqbal", "Kamil Arshad", "Danish Rauf",
            "Talal Farooq", "Sarmad Mehmood", "Shoaib Azhar",
            "Omer Siddiqi", "Dawood Mushtaq", "Ammar Waheed",
            "Fasih Shah", "Adnan Khalil", "Imran Waseem",
            "Waleed Anwar", "Yasir Rauf", "Arham Bashir",
            "Shehryar Latif", "Azhar Siddiqui", "Jibran Hussain",
            "Hassan Qamar", "Usman Kamal", "Tariq Yousaf",
            "Owais Farooq", "Raheel Bashir", "Waqas Khalid",
            "Faisal Shah", "Bilal Latif", "Zeeshan Abbas",
            "Faizan Hussain", "Mudassir Farooq", "Kashif Khalid",
            "Abrar Tariq", "Umair Siddiqi", "Hamza Jameel",
            "Nabeel Usman", "Khalil Laghari", "Murtaza Waseem",
            "Sajid Waheed", "Noman Riaz", "Hashir Hussain",
            "Sheraz Rauf", "Ahmed Tariq", "Atif Bashir",
            "Omar Siddiqui", "Irfan Khalil", "Raheel Jamil",
            "Tauseef Rauf", "Hammad Abbas", "Hasnain Kamran",
            "Waleed Hussain", "Taimoor Abbas", "Mudassir Waheed",
            "Umer Khalid", "Azeem Munawar", "Junaid Bashir",
            "Shayan Rauf", "Ahmed Hanif", "Bilal Hussain", "Umair Riaz",
            "Zubair Khalid", "Adeel Haroon", "Sajid Qamar",
            "Faizan Latif", "Hammad Saleem", "Shoaib Tariq",
            "Noman Anwar", "Fahad Hussain", "Hashim Waseem",
            "Hamza Abbas", "Arsalan Khalid", "Taha Rasheed",
            "Usama Farooq", "Sarim Bashir", "Khizar Waheed",
            "Mudassir Khalid", "Waqas Rauf", "Tariq Hussain",
            "Jawad Siddiqui", "Shehryar Abbas", "Naveed Tariq",
            "Muzammil Jamil", "Zeeshan Khalid", "Atif Hussain",
            "Sarmad Waqar", "Shoaib Khalid", "Ahmed Qureshi",
            "Raheel Abbas", "Hammad Riaz", "Sheraz Bashir",
            "Danish Khalid", "Adil Waheed", "Hashir Tariq",
            "Faizan Waseem", "Usman Abbas", "Khurram Latif",
            "Owais Siddiqui", "Mudassir Hussain", "Tauseef Khalid",
            "Farrukh Waseem", "Umer Saleem", "Hamza Rauf",
            "Shoaib Kamran", "Bilal Abbas", "Sajid Tariq",
            "Faizan Shahbaz", "Hasnain Abbas", "Abrar Khalid",
            "Ahmed Farooq", "Atif Khalid", "Irfan Waseem",
            "Junaid Tariq", "Umair Saleem", "Arsalan Hussain",
            "Waleed Abbas", "Adnan Waseem", "Sheraz Khalid",
            "Mudassir Abbas", "Shoaib Rauf", "Omar Hussain",
            "Raheel Khalid", "Hammad Waseem", "Waseem Farooq",
            "Hasham Tariq", "Faisal Khalid", "Kashif Abbas",
            "Tauseef Abbas", "Hamza Saleem", "Zeeshan Waseem",
            "Sarmad Hussain", "Bilal Khalid", "Umair Abbas",
            "Mudassir Riaz", "Adil Khalid", "Ahmed Abbas",
            "Owais Hussain")
        private val rglnss = arrayOf<String>("Ayesha Waleed", "Fatima Kamal", "Hira Latif",
            "Sana Farooq", "Mahnoor Tariq", "Faiza Tehseem",
            "Fozia Mehshar", "Iqra Siddiqui", "Laiba Aslam",
            "Anum Riaz", "Saba Kiani", "Hafsa Saeed", "Sidra Hashmi",
            "Zunaira Naz", "Sadaf Bhutto", "Kiran Jameel",
            "Rida qAbbas", "Nimra Waseem", "Huma Tariq",
            "Samina Khalid", "Zeenat Rauf", "Amna Waheed",
            "Neelam Hashmi", "Aiman Qamar", "Romaisa Hussain",
            "Fareeda Asif", "Sania Anwar", "Humaisa Khalil",
            "Asma Riaz", "Sadia Kamran", "Sehrish Waseem", "Uzma Tariq",
            "Mehwish Latif", "Hina Abbas", "Areeba Waqar",
            "Tanzeela Jafar", "Anila Saleem", "Mahira Umer",
            "Bushra Nadeem", "Zoya Mehmood", "Nida Hashim",
            "Sumaira Yasir", "Mahnoor Hussain", "Komal Saeed",
            "Laiba Waseem", "Amina Abbas", "Rida Jameel",
            "Saeeka Haroon", "Zainab Farooq", "Fatima Hussain",
            "Hafsa Mehmood", "Minal Khawar", "Yumna Tariq",
            "Ayeza Barkat", "Asia Farhan", "Kinza Jamal",
            "Mehwish Touseef", "Rimsha Ibrahim", "Neelam Saeed",
            "Hira Khalid", "Amna Riaz", "Iqra Farooq", "Anum Abbas",
            "Mehwish Iqrar", "Sumaiya Tariq", "Romaisa Khalil",
            "Faiza Waseem", "Bushra Farooq", "Sadia Abbas",
            "Hiba Hussain", "Afshan Siddiqui", "Sana Basit",
            "Areeba Khalid", "Maira Waseem", "Nimra Hussain",
            "Sehrish Saleem", "Amna Jameel", "Zoya Khalid",
            "Mehreen Tariq", "Aiman Abbas", "Komal Riaz", "Hira Saleem",
            "Palwasha Moazzam", "Laiba Nayyar", "Minahal Tahir",
            "Mehwish Shuja", "Javeria Feroze", "Zara Munawwar",
            "Fiza Jatoi", "Fatima Riaz", "Zainab Alvi",
            "Tanzeela Abbas", "Kiran Waseem", "Ayesha Khalid",
            "Samina Hussain", "Sadia Waseem", "Bisma Majeed",
            "Areeba Latif", "Sehrish Tariq", "Hafsa Waseem",
            "Hina Tariq", "Zoya Saleem", "Maham Khalid", "Muneera Rauf",
            "Bushra Tariq", "Zeenat Hussain", "Areeba Saleem",
            "Kainat Rizvi", "Sumaiya Hussain", "Sadia Khalid",
            "Mahnoor Irshad", "Fatima Jameel", "Sakina Hilaj",
            "Iqra Danyal", "Hina Riaz", "Neha Saleem", "Mehwish Khalid",
            "Asma Waseem", "Romaisa Tariq", "Laiba Khalid",
            "Komal Noor", "Bushra Waseem", "Zainab Tariq",
            "Sadia Saleem", "Kiran Jamshed", "Uzmia Sayyad",
            "Komal Hussain", "Maryam Raza", "Romaisa Haroon",
            "Mehwish Abbas", "Maham Riaz", "Sumaiya Khalid",
            "Anila Anjum", "Areeba Hussain")
        private val areas_in_karachi = arrayOf<String>("Askari 1", "Askari 2", "Askari 3", "Askari 4",
            "Askari 5", "Bahria Town - Precinct 1",
            "Bahria Town - Precinct 10", "Bahria Town - Precinct 11",
            "Bahria Town - Precinct 12", "Bahria Town - Precinct 13",
            "Bahria Town - Precinct 14", "Bahria Town - Precinct 15",
            "Bahria Town - Precinct 16", "Bahria Town - Precinct 17",
            "Bahria Town - Precinct 18", "Bahria Town - Precinct 19",
            "Bahria Town - Precinct 2", "Bahria Town - Precinct 20",
            "Bahria Town - Precinct 21", "Bahria Town - Precinct 22",
            "Bahria Town - Precinct 23", "Bahria Town - Precinct 24",
            "Bahria Town - Precinct 25", "Bahria Town - Precinct 26",
            "Bahria Town - Precinct 27", "Bahria Town - Precinct 28",
            "Bahria Town - Precinct 29", "Bahria Town - Precinct 3",
            "Bahria Town - Precinct 30", "Bahria Town - Precinct 31",
            "Bahria Town - Precinct 32", "Bahria Town - Precinct 33",
            "Bahria Town - Precinct 4", "Bahria Town - Precinct 5",
            "Bahria Town - Precinct 6", "Bahria Town - Precinct 7",
            "Bahria Town - Precinct 8", "Bahria Town - Precinct 9",
            "BufferZone - Sector 15 A 1", "BufferZone - Sector 15 A 2",
            "BufferZone - Sector 15 A 3", "BufferZone - Sector 15 A 4",
            "BufferZone - Sector 15 A 5", "BufferZone - Sector 15 B",
            "BufferZone - Sector 16 A", "BufferZone - Sector 16 B",
            "Cantonment", "Clifton - Block 1", "Clifton - Block 2",
            "Clifton - Block 3", "Clifton - Block 4",
            "Clifton - Block 5", "Clifton - Block 6",
            "Clifton - Block 7", "Clifton - Block 8",
            "Clifton - Block 9", "Clifton - Kehkashan", "DHA - Phase 1",
            "DHA - Phase 2", "DHA - Phase 3", "DHA - Phase 4",
            "DHA - Phase 5", "DHA - Phase 6", "DHA - Phase 7",
            "DHA - Phase 8", "DHA - Phase 9", "F.B Area - Azizabad",
            "F.B Area - B1 Area", "F.B Area - B Area",
            "F.B Area - Block 1", "F.B Area - Block 10",
            "F.B Area - Block 11", "F.B Area - Block 12",
            "F.B Area - Block 13", "F.B Area - Block 14",
            "F.B Area - Block 15", "F.B Area - Block 16",
            "F.B Area - Block 17", "F.B Area - Block 18",
            "F.B Area - Block 19", "F.B Area - Block 2",
            "F.B Area - Block 20", "F.B Area - Block 21",
            "F.B Area - Block 22", "F.B Area - Block 3",
            "F.B Area - Block 4", "F.B Area - Block 5",
            "F.B Area - Block 6", "F.C Area - C1 Area",
            "F.C Area - C Area", "Garden - Garden East",
            "Garden - Garden West", "Garden - Soldier Bazaar",
            "Gulistan-e-Johar - Block 1", "Gulistan-e-Johar - Block 10",
            "Gulistan-e-Johar - Block 11",
            "Gulistan-e-Johar - Block 12",
            "Gulistan-e-Johar - Block 13",
            "Gulistan-e-Johar - Block 14",
            "Gulistan-e-Johar - Block 15",
            "Gulistan-e-Johar - Block 16",
            "Gulistan-e-Johar - Block 17",
            "Gulistan-e-Johar - Block 18",
            "Gulistan-e-Johar - Block 19", "Gulistan-e-Johar - Block 2",
            "Gulistan-e-Johar - Block 20", "Gulistan-e-Johar - Block 3",
            "Gulistan-e-Johar - Block 4", "Gulistan-e-Johar - Block 5",
            "Gulistan-e-Johar - Block 6", "Gulistan-e-Johar - Block 7",
            "Gulistan-e-Johar - Block 8", "Gulistan-e-Johar - Block 9",
            "Gulshan-e-Hadeed - Data Nagar",
            "Gulshan-e-Hadeed - EIDU Goth",
            "Gulshan-e-Hadeed - Gulshan-e-Mauzzam",
            "Gulshan-e-Hadeed - Gulshan-e-Rehman",
            "Gulshan-e-Hadeed - Mehran Road",
            "Gulshan-e-Hadeed - Phase 1", "Gulshan-e-Hadeed - Phase 2",
            "Gulshan-e-Hadeed - Phase 3",
            "Gulshan-e-Hadeed - PTCL Satellite Station",
            "Gulshan-e-Hadeed - Shah Latif Town",
            "Gulshan-e-Hadeed - Shahnawaz Goth",
            "Gulshan-e-Hadeed - Shah Town",
            "Gulshan-e-Hadeed - Steel Town",
            "Gulshan-e-Iqbal - Adamjee Nagar",
            "Gulshan-e-Iqbal - Block 1", "Gulshan-e-Iqbal - Block 10",
            "Gulshan-e-Iqbal - Block 11", "Gulshan-e-Iqbal - Block 12",
            "Gulshan-e-Iqbal - Block 13", "Gulshan-e-Iqbal - Block 14",
            "Gulshan-e-Iqbal - Block 15", "Gulshan-e-Iqbal - Block 16",
            "Gulshan-e-Iqbal - Block 17", "Gulshan-e-Iqbal - Block 18",
            "Gulshan-e-Iqbal - Block 19", "Gulshan-e-Iqbal - Block 2",
            "Gulshan-e-Iqbal - Block 3", "Gulshan-e-Iqbal - Block 4",
            "Gulshan-e-Iqbal - Block 5", "Gulshan-e-Iqbal - Block 6",
            "Gulshan-e-Iqbal - Block 7", "Gulshan-e-Iqbal - Block 8",
            "Gulshan-e-Iqbal - Block 9",
            "Gulshan-e-Iqbal - Civic Center",
            "Gulshan-e-Iqbal - Dhoraji",
            "Korangi - Abdullah Shah Noorani Pahari Colony",
            "Korangi - Korangi Industrial Area",
            "Korangi - Nasir Colony",
            "Korangi - PAF Base Korangi Creek", "Korangi - Zaman Town",
            "Korangi - Zia Colony", "Landhi - Alflah Housing Society",
            "Landhi - Awami Colony", "Landhi - Bagh-e-Korangi",
            "Landhi - Bakhtawar Goth", "Landhi - Barmi Colony",
            "Landhi - Bhutto Nagar", "Landhi - Future Colony",
            "Landhi - Gulshan-e-Rafi", "Landhi - Ilyas Goth",
            "Landhi - Labour Colony", "Landhi - Landhi Industrial Area",
            "Landhi - Muslimabad Colony",
            "Landhi - Muzaffarabad Colony", "Landhi - Punjab Town",
            "Landhi - Qasim Town", "Landhi - Sadat Colony",
            "Landhi - Shah Khalid Colony", "Landhi - Sharafi Goth",
            "Landhi - Zamanabad", "Liaquatabad - Block 1",
            "Liaquatabad - Block 10", "Liaquatabad - Block 2",
            "Liaquatabad - Block 3", "Liaquatabad - Block 4",
            "Liaquatabad - Block 5", "Liaquatabad - Block 6",
            "Liaquatabad - Block 7", "Liaquatabad - Block 8",
            "Liaquatabad - Block 9", "Malir - Malir Halt",
            "Malir - Malir Cantt", "Nazimabad - Block 1",
            "Nazimabad - Block 2", "Nazimabad - Block 3",
            "Nazimabad - Block 4", "Nazimabad - Block 5",
            "North Karachi - Sector 10",
            "North Karachi - Sector 11 - A",
            "North Karachi - Sector 11 - B",
            "North Karachi - Sector 11 - C 1",
            "North Karachi - Sector 11 - C 2",
            "North Karachi - Sector 11 - C 3",
            "North Karachi - Sector 11 - E",
            "North Karachi - Sector 11 - H",
            "North Karachi - Sector 11 - I",
            "North Karachi - Sector 11 - K",
            "North Karachi - Sector 11 - L", "North Karachi - Sector 2",
            "North Karachi - Sector 3", "North Karachi - Sector 4",
            "North Karachi - Sector 5 - A 1",
            "North Karachi - Sector 5 - A 2",
            "North Karachi - Sector 5 - A 3",
            "North Karachi - Sector 5 - A 4",
            "North Karachi - Sector 5 - B 1",
            "North Karachi - Sector 5 - B 2",
            "North Karachi - Sector 5 - B 3",
            "North Karachi - Sector 5 - B 4",
            "North Karachi - Sector 5 - C 1",
            "North Karachi - Sector 5 - C 2",
            "North Karachi - Sector 5 - C 3",
            "North Karachi - Sector 5 - C 4",
            "North Karachi - Sector 5 - I",
            "North Karachi - Sector 5 - J",
            "North Karachi - Sector 5 - K",
            "North Karachi - Sector 5 - L",
            "North Karachi - Sector 5 - M", "North Karachi - Sector 6",
            "North Karachi - Sector 7 - D 1",
            "North Karachi - Sector 7 - D 2",
            "North Karachi - Sector 7 - D 3",
            "North Karachi - Sector 7 - D 4",
            "North Karachi - Sector 8", "North Karachi - Sector 9",
            "North Nazimabad - Block A", "North Nazimabad - Block B",
            "North Nazimabad - Block C", "North Nazimabad - Block D",
            "North Nazimabad - Block E", "North Nazimabad - Block F",
            "North Nazimabad - Block G", "North Nazimabad - Block H",
            "North Nazimabad - Block I", "North Nazimabad - Block J",
            "North Nazimabad - Block K", "North Nazimabad - Block L",
            "North Nazimabad - Block M", "North Nazimabad - Block N",
            "North Nazimabad - Block O", "North Nazimabad - Block P",
            "North Nazimabad - Block Q", "North Nazimabad - Block R",
            "North Nazimabad - Block S", "North Nazimabad - Block T",
            "Old Town - Bhimpora", "Old Town - Bohra Pir",
            "Old Town - Bombay Bazar", "Old Town - Jodia Bazar",
            "Old Town - Kagzi Bazar", "Old Town - Kakri Ground",
            "Old Town - Kamil Gali", "Old Town - Khada Market",
            "Old Town - Kharadar", "Old Town - Lee Market",
            "Old Town - Mithadar", "Old Town - Nanwara",
            "Old Town - Nishter Road", "Old Town - Pan Mandi",
            "Old Town - Ramswami", "Old Town - Ranchorline",
            "Orangi Town - Banaras Town", "Orangi Town - Bangla Bazaar",
            "Orangi Town - Bilal Colony", "Orangi Town - Katti Pahari",
            "Orangi Town - Moria Goth Orangi", "Orangi Town - Orangi",
            "Orangi Town - Sector 14 - A",
            "Orangi Town - Sector 14 - C", "Orangi Town - Thorani Goth",
            "Baldiya Town", "Baloch Colony", "Civil Line", "FC Area",
            "Firdous Colony", "Gulshan-e-Maymar", "Hawksbay",
            "I.I Chundrigar", "Jamshed Road", "K.D.A Officers",
            "Kemari", "Liyari", "M.A Jinnah Rd", "Manora",
            "New Karachi", "New Surjani", "PIB Colony", "Pipri Goth",
            "Rizvia Society", "Saddar", "Scheme 33", "Shabbirabad",
            "P.E.C.H.S - Block 1", "P.E.C.H.S - Block 2",
            "P.E.C.H.S - Block 3", "P.E.C.H.S - Block 4",
            "P.E.C.H.S - Block 5", "P.E.C.H.S - Block 6",
            "P.E.C.H.S - Khalid Bin Walid", "P.E.C.H.S - Tariq Road",
            "S.I.T.E - Golimar", "S.I.T.E - S.I.T.E",
            "Shah Faisal Colony - Aswan Town",
            "Shah Faisal Colony - Gulshan-e-Asghar",
            "Shah Faisal Colony - Shah Faisal Colony 1",
            "Shah Faisal Colony - Shah Faisal Colony 5",
            "F.B Area - Block 7", "F.B Area - Block 9",
            "P.E.C.H.S - Block 7", "Aram Bagh", "Bath Island",
            "University Road", "Bahadurabad", "Shah Faisal Colony - 4",
            "Banglore Town", "Fowler Lines",
            "Shah Faisal Colony - Shamsi Society", "Gulshan-e-Jamal",
            "Shah Faisal Colony - 3", "Shah Faisal Colony - Green Town",
            "Darwaish Colony", "Korangi - Sector 31 B",
            "Firdous Colony", "North Nazimabad - Block W",
            "K.A.E.C.H.S", "Mehmoodabad", "Korangi - Mehran Town",
            "Landhi Town - 36 B", "Karachi Memon Society",
            "Madras Cooperative Housing Society", "Shahrah-e-Faisal",
            "Korangi - Sector 41 B", "Clifton - Delhi Colony",
            "Korangi - Sector 32 B", "Dhoraji - Adamjee Nagar",
            "Bhimpura", "Dhoraji - CP& Berar Society",
            "Shahra-e-Faisal - Umar Colony", "Model Colony",
            "Gulshan-e-Shamim", "Clifton - Shah Rasool Colony",
            "North Karachi - Sector 12 C",
            "Jail Road - Hyderabad Colony", "Napier Quarter",
            "Gulzar-e-Hijri", "North Karachi - Sector 12 A",
            "Shahra-e-Faisal - Jinnah Housing Society",
            "K.D.A Scheme 1", "Clifton - Punjab Colony",
            "Korangi - Sector 31 D", "Clifton - Zamzama",
            "Parsi Colony", "Qayyumabad", "Khokrapar",
            "Shah Faisal Colony - Muslimabad Malir City",
            "F.B Area - Block 8", "Nanak Wara", "Mohammad Ali Society",
            "Manzoor Colony", "Dalmia", "Defence View - Phase 1",
            "Defence View - Phase 2", "KDA Officers Housing Society",
            "Karimabad", "Soldier Bazar", "Hussainabad",
            "Sharfabad Society", "Gharibabad",
            "Sindhi Muslim Cooperative Housing Society")
        private val rndcts = arrayOf<String>(
            "Your heart is the size of an ocean. Go find yourself in its hidden depths.",
            "Thinking is the capital, enterprise is the way, hard work is the solution.",
            "If you can't make it good, at least make it look good.",
            "Heart be brave. If you cannot be brave, just go. Love's glory is not a small thing.",
            "If you are out to describe the truth, leave elegance to the tailor.",
            "O man you are busy working for the world, and the world is busy trying to turn you out.",
            "While children are struggling to be unique, the world around them is trying all means to make them look like everybody else.",
            "These capitalists generally act harmoniously and in concert, to fleece the people.",
            "I don't believe in failure. It is not failure if you enjoyed the process.",
            "Wear gratitude like a cloak and it will feed every corner of your life.",
            "If you even dream of beating me you'd better wake up and apologize.",
            "I will praise any man that will praise me.",
            "One of the greatest diseases is to be nobody to anybody.",
            "I'm so fast that last night I turned off the light switch in my hotel room and was in bed before the room was dark.",
            "People must learn to hate and if they can learn to hate, they can be taught to love.",
            "Everyone has been made for some particular work, and the desire for that work has been put in every heart.",
            "The less of the world, the freer you live.",
            "Respond to every call that excites your spirit.",
            "The way to get started is to quit talking and begin doing.",
            "Speak any language, turkish, greek, persian, arabic, but always speak with love.",
            "Knowledge is of two kinds: that which is absorbed and that which is heard. And that which is heard does not profit if it is not absorbed.",
            "When I am silent, I have thunder hidden inside.",
            "Technological progress is like an axe in the hands of a pathological criminal.",
            "No one would choose a friendless existence on condition of having all the other things in the world.",
            "Life is a gamble. You can get hurt, but people die in plane crashes, lose their arms and legs in car accidents; people die every day. Same with fighters: some die, some get hurt, some go on. You just don't let yourself believe it will happen to you.",
            "Let us sacrifice our today so that our children can have a better tomorrow.",
            "Your task is not to seek for love, but merely to seek and find all the barriers within yourself that you have built against it.",
            "Everything in the universe is within you. Ask all from yourself.",
            "I'm not a handsome guy, but I can give my hand to someone who needs help. Beauty is in the heart, not in the face.",
            "A good head and a good heart are always a formidable combination.",
            "The soul never thinks without a picture.",
            "Let the beauty we love be what we do. There are hundreds of ways to kneel and kiss the ground.",
            "Success is dependent upon the glands - sweat glands.")
        private val rkuniss = arrayOf<String>("Aga Khan University",
            "Air War College Institute, Karachi",
            "Baqai Medical University",
            "Benazir Bhutto Shaheed University Lyari",
            "Commecs Institute of Business & Emerging Sciences",
            "Dadabhoy Institute of Higher Education",
            "Dawood University of Engineering & Technology",
            "DHA Suffa University", "DOW University of Health Sciences",
            "Emaan Institute of Management & Sciences, Karachi",
            "Greenwich University", "Habib University",
            "Hamdard University", "ILMA University", "Indus University",
            "Indus Valley School of Art & Architecture",
            "Institute of Business Administration",
            "Institute of Business Management", "Iqra University",
            "Jinnah Sindh Medical University",
            "Jinnah University for Women",
            "Karachi Institute of Economics & Technology", (
                    "Karachi Institute of Technology and Entrepreneurship (KITE), "
                            + "Karachi"),
            "Karachi School of Business and Leadership",
            "KASB Institute of Technology",
            "Malir University of Science & Technology, Karachi",
            "Metropolitan University Karachi",
            "Millennium Institute of Technology and Entrepreneurship, Karachi",
            "Muhammad Ali Jinnah University",
            "NED University of Engineering & Technology",
            "Newport Institute of Communications & Economics",
            "Pakistan Naval Academy",
            "Preston Institute of Management, Science & Technology",
            "Preston University", (
                    "Salim Habib University (Former Barret Hodgson University), "
                            + "Karachi"),
            "Shaheed Benazir Bhutto City University",
            "Shaheed Benazir Bhutto Dewan University",
            "Shaheed Zulfikar Ali Bhutto Institute of Science & Technology",
            "Shaheed Zulfiqar Ali Bhutto University of Law",
            "Sindh Institute of Management & Technology",
            "Sindh Institute of Medical Sciences",
            "Sindh Madresatul Islam University",
            "Sir Syed University of Engineering & Technology",
            "Sohail University, Karachi",
            "Textile Institute of Pakistan",
            "The Nazeer Hussain University", "UIT University, Karachi",
            "University of Karachi", "Zia-ud-Din University")
        private val rjbss = arrayOf<String>("Accountant", "Banker", "Pilot", "Marine Pilot", "Doctor",
            "Nurse", "Physician", "Laboratorian",
            "Psychiatrist/Psychologist", "Dermatologist",
            "Gynecologist", "Cardiologist", "Surgeon",
            "Ophthalmologist", "Pediatrician", "Watchman", "Tailor",
            "Designer", "Photographer", "Model", "Fashion Designer",
            "Makeup Artist", "Dressmaker", "Content Writer",
            "Police Officer", "Undercover Police Officer",
            "Prison Officer/Jailer", "Reporter", "Journalist",
            "Investigator", "Laborer", "Data Analyst", "Data Scientist",
            "Saleswo/man", "Tele-saleswo/man", "Developer", "Engineer",
            "Plumber", "Human Resources Manager", "Legal Counsel",
            "Judge", "Lawyer", "Travel Guide", "Scientist", "Goldsmith",
            "Blacksmith", "Lumberjack", "White-hat hacker",
            "Black-hat hacker", "Caretaker", "Nanny", "Fisher",
            "Architect", "Software Architect", "Farmer",
            "Agriculture Engineer", "Software Engineer",
            "Support Specialist", "Systems Analyst",
            "Technical Support Engineer", "Web Developer",
            "Web Designer", "Animator", "Filmmaker", "Actor",
            "Comedian", "Director", "Vocalist", "Musician",
            "Bedroom Musician/DJ", "Songwriter", "Screenwriter",
            "Barber", "Barista/Bartender", "Tattooist", "Electrician",
            "Vehicle Technician", "Cartoonist", "Cook",
            "Travel Advisor", "Translator", "Relationship Counselor",
            "accountant", "actor", "actuary",
            "adhesive bonding machine tender", "adjudicator",
            "administrative assistant",
            "administrative services manager", "trapper",
            "travel agent", "travel clerk", "travel guide",
            "tree pruner", "tree trimmer", "trimmer", "truck loader",
            "truck mechanic", "tuner", "turning machine tool operator",
            "tutor", "typist", "umpire", "undertaker", "urban planner",
            "usher", "UX designer", "waiter/ess", "watch repairer",
            "water treatment plant operator", "weaving machine setter",
            "web developer", "weigher", "welder", "wellhead pumper",
            "wholesale buyer", "wildlife photographer",
            "window trimmer", "wood patternmaker", "woodworker",
            "word processor", "writer")
        fun randNationality(): String {
            return randFrom(ntltss)
        }
        fun fakeNationality(): String {
            return randNationality()
        }
        fun randCity(): String {
            return randFrom(ctss)
        }
        fun randAreaInKarachi(): String {
            return randFrom(areas_in_karachi)
        }
        fun randKarachiArea(): String {
            return randAreaInKarachi()
        }
        fun randKarachiUniversity(): String {
            return randFrom(rkuniss)
        }
        fun randPhone(): String {
            return randFrom(rfnss)
        }
        @kotlin.jvm.JvmOverloads
        fun randEmail(name: String = randFrom(join(rgynss, *rglnss))): String {
            // @params
            // @@name means a chosen name from either array rgynss, or rglnss
            if (not(name) || not(eq(name, "[a-zA-Z]{2,}\\s[a-zA-Z]{2,}"))) return ""
            val names: Array<String> = combine(rgynss, *rglnss)
            val randName = randFrom(names)
            val addonA = randFrom(arrayOf<String>(".", "_", "-"))
            val addonB = (randFrom(arrayOf(addonA, ""))
                    + Str(randInt(10, 500)))
            val processedName: String = (lower(randName).replace("\\s".toRegex(), addonA)
                    + addonB)
            val mailProviders = arrayOf<String>("gmail", "yahoo", "hotmail", "outlook",
                "icloud")
            val provider = randFrom(mailProviders)
            return "$processedName@$provider.com"
        }
        fun randJob(): String {
            return randFrom(rjbss)
        }
        fun randGirlName(): String {
            return randFrom(rglnss)
        }
        fun randGuyName(): String {
            return randFrom(rgynss)
        }
        fun randWord(): String {
            return randFrom(wdss)
        }
        fun randSentence(): String {
            return randFrom(rndcts)
        }
        var fakeNationality = ""
        var randAreaInKarachi = ""
        val randNationality: String = fakeNationality().also { fakeNationality = it }
        val randCity = randCity()
        val randKarachiArea: String = randAreaInKarachi().also { randAreaInKarachi = it }
        val randKarachiUniversity = randKarachiUniversity()
        val randJob = randJob()
        val randPhone = randPhone()
        val randEmail = randEmail()
        val randGirlName = randGirlName()
        val randGuyName = randGuyName()
        val randWord = randWord()
        val randSentence = randSentence()
        var name = "Ayesha"
        var age = 23
        var _dev = "https://github.com/abbaskhurram255"
        @kotlin.jvm.JvmStatic
        fun main(args: Array<String>) {
        }
    }
}
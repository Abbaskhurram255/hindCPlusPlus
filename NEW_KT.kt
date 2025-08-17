import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec
import java.nio.charset.StandardCharsets
import java.net.HttpURLConnection
import java.net.URL
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.IOException

class KL {
    // to shorten new KL() instance calls into just kl()
    companion object {
        @JvmStatic
        fun kl(): KL {
            return KL()
        }
    }

    class money {
        private var amnt: Double
        private var curr: String

        init {
            this.amnt = 0.0
            this.curr = "Rs. "
        }

        constructor(amnt: Double) {
            this.amnt = if (not(amnt)) 0.0 else amnt
            this.curr = "Rs. "
        }

        constructor(amnt: Double, curr: String) {
            this.amnt = if (not(amnt) || isinf(amnt)) 0.0 else amnt
            this.curr = if (not(this.curr) || this.curr.length < 1 || this.curr.length > 4) 
                "Rs. " else titleCase(curr)
        }

        fun curr(curr: String): money {
            this.curr = if (not(curr) || curr.length < 1 || curr.length > 4) 
                "Rs. " else titleCase(curr)
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
                else -> this.curr + (forceInternational || (is(this.curr) && !in(this.curr, "pk|in|rs")) 
                    ? ussuffix(amnt) : pksuffix(amnt))
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
        constructor() : super(0.0) {
            super.curr = "Rs. "
        }

        constructor(amnt: Double) : super(if (isinf(amnt)) 0.0 else amnt) {
            super.curr = "Rs. "
        }

        constructor(amnt: Double, curr: String) : super(if (not(amnt) || isinf(amnt)) 0.0 else amnt, curr) {
            super.curr = if (not(super.curr) || super.curr.length < 1 || super.curr.length > 4) 
                "Rs. " else titleCase(curr)
        }
    }
    companion object {
        @JvmStatic
        fun encode(s: String): String {
            return try {
                Base64.getEncoder().encodeToString(s.toByteArray())
            } catch (e: Exception) {
                ""
            }
        }

        @JvmStatic
        fun cypher(s: String): String {
            return encode(s)
        }

        @JvmStatic
        fun lock(s: String): String {
            return encode(s)
        }

        @JvmStatic
        fun encode(s: String, salt: Any?): String {
            return encrypt(s, salt)
        }

        @JvmStatic
        fun cypher(s: String, salt: Any?): String {
            return encrypt(s, salt)
        }

        @JvmStatic
        fun lock(s: String, salt: Any?): String {
            return encrypt(s, salt)
        }

        @JvmStatic
        fun decode(s: String): String {
            return try {
                String(Base64.getDecoder().decode(s))
            } catch (e: Exception) {
                ""
            }
        }

        @JvmStatic
        fun decypher(s: String): String {
            return decode(s)
        }

        @JvmStatic
        fun unlock(s: String): String {
            return decode(s)
        }

        @JvmStatic
        fun decode(s: String, salt: Any?): String {
            return decrypt(s, salt)
        }

        @JvmStatic
        fun decypher(s: String, salt: Any?): String {
            return decrypt(s, salt)
        }

        @JvmStatic
        fun unlock(s: String, salt: Any?): String {
            return decrypt(s, salt)
        }

        @JvmStatic
        fun encodeUrl(s: String): String {
            if (not(s)) return ""
            var encoded = s.replace("%", "%25").replace(" ", "%20")
                .replace("!", "%21").replace("#", "%23").replace("$", "%24")
                .replace("&", "%26").replace("'", "%27").replace("(", "%28")
                .replace(")", "%29").replace("*", "%2A").replace("+", "%2B")
                .replace(",", "%2C").replace("/", "%2F").replace(":", "%3A")
                .replace(";", "%3B").replace("=", "%3D").replace("?", "%3F")
                .replace("@", "%40").replace("[", "%5B").replace("]", "%5D")
            return encoded
        }

        @JvmStatic
        fun decodeUrl(s: String): String {
            if (not(s)) return ""
            var decoded = s.replace("%21", "!").replace("%20", " ")
                .replace("%23", "#").replace("%24", "$").replace("%26", "&")
                .replace("%27", "'").replace("%28", "(").replace("%29", ")")
                .replace("%2A", "*").replace("%2B", "+").replace("%2C", ",")
                .replace("%2F", "/").replace("%3A", ":").replace("%3B", ";")
                .replace("%3D", "=").replace("%3F", "?").replace("%40", "@")
                .replace("%5B", "[").replace("%5D", "]").replace("%25", "%")
            return decoded
        }

        @JvmStatic
        fun encrypt(data: String, salt: Any?): String {
            if (not(data) || isNull(salt)) return ""
            val key = Str(salt)
            val ofXAlgo = "AES"
            return try {
                val secretKey = SecretKeySpec(key.toByteArray(StandardCharsets.UTF_8), ofXAlgo)
                val cipher = Cipher.getInstance(ofXAlgo)
                cipher.init(Cipher.ENCRYPT_MODE, secretKey)
                val encryptedBytes = cipher.doFinal(data.toByteArray(StandardCharsets.UTF_8))
                Base64.getEncoder().encodeToString(encryptedBytes)
            } catch (err: Exception) {
                data
            }
        }

        @JvmStatic
        fun decrypt(encryptedData: String, salt: Any?): String {
            if (not(encryptedData) || isNull(salt)) return ""
            val key = Str(salt)
            val ofXAlgo = "AES"
            return try {
                val secretKey = SecretKeySpec(key.toByteArray(StandardCharsets.UTF_8), ofXAlgo)
                val cipher = Cipher.getInstance(ofXAlgo)
                cipher.init(Cipher.DECRYPT_MODE, secretKey)
                val decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData))
                String(decryptedBytes, StandardCharsets.UTF_8)
            } catch (err: Exception) {
                println("[KL.Decryptor.BadArguments]:\nFailed to decrypt the message.")
                ""
            }
        }

        @JvmStatic
        fun internet(): Boolean {
            return try {
                val url = URL("https://java.com/")
                val conn = url.openConnection()
                conn.connect()
                true
            } catch (e: IOException) {
                false
            }
        }

        @JvmStatic
        fun parseJson(jsonString: String): o {
            val map = o()
            if (not(jsonString)) {
                return map
            }
            var jsonString = jsonString.trim()
            if (!jsonString.startsWith("{") || !jsonString.endsWith("}")) {
                map.add("status", "notok").add("error", "yes")
                return map
            }
            jsonString = jsonString.substring(1, jsonString.length - 1)
            val keyValuePairs = jsonString.split("\\s*,\\s*".toRegex()).toTypedArray()
            for (pair in keyValuePairs) {
                val parts = pair.split("[\\[\\]\\s\\w]*:[\\[\\]\\s\\w]*".toRegex(), 2)
                if (parts.size == 2) {
                    val key = parts[0].replace("[\"\\{\\[\\]\\}]+".toRegex(), "").trim()
                    val value = parts[1].replace("[\"\\{\\[\\]\\}]+".toRegex(), "")
                        .replace("\\w+:\\s*".toRegex(), "").trim()
                    if (key.isNotEmpty() && in(key, "[a-zA-Z]+") && value.isNotEmpty() && in(value, "[a-zA-Z]+")) {
                        map.add(key, value)
                    }
                }
            }
            map.add("status", "ok").add("error", "no")
            return map
        }

        @JvmStatic
        fun fetch(url: String): o {
            val map = o()
            try {
                val urlString = URL(url)
                val connection = urlString.openConnection() as HttpURLConnection
                connection.requestMethod = "GET"
                val statusCode = connection.responseCode
                if (statusCode == HttpURLConnection.HTTP_OK) {
                    val reader = BufferedReader(InputStreamReader(connection.inputStream))
                    val respBuilder = StringBuilder()
                    var line: String?
                    while (reader.readLine().also { line = it } != null) {
                        respBuilder.append(line)
                    }
                    reader.close()
                    val jsonString = respBuilder.toString().trim()
                    map.add("response", "200").add("status", "ok").add("error", "no")
                    return parseJson(jsonString)
                } else {
                    map.add("response", Str(statusCode)).add("status", "notok").add("error", "yes")
                    println("[KLFetch.Status.NotOK]:\nMessage: GET request failed with status code $statusCode")
                }
                connection.disconnect()
            } catch (e: IOException) {
                map.add("response", "404").add("status", "notok").add("error", "yes")
                println("[KLFetch.Status.Offline]:\nMessage: Failed to fetch. It appears, you might be offline.")
            }
            return map
        }

        @JvmStatic
        fun silentFetch(url: String): o {
            val map = o()
            try {
                val urlString = URL(url)
                val connection = urlString.openConnection() as HttpURLConnection
                connection.requestMethod = "GET"
                val statusCode = connection.responseCode
                if (statusCode == HttpURLConnection.HTTP_OK) {
                    val reader = BufferedReader(InputStreamReader(connection.inputStream))
                    val respBuilder = StringBuilder()
                    var line: String?
                    while (reader.readLine().also { line = it } != null) {
                        respBuilder.append(line)
                    }
                    reader.close()
                    val jsonString = respBuilder.toString().trim()
                    map.add("response", "200").add("status", "ok").add("error", "no")
                    return parseJson(jsonString)
                } else {
                    map.add("response", ""+statusCode).add("status", "notok").add("error", "yes")
                }
                connection.disconnect()
            } catch (e: IOException) {
                map.add("response", "404").add("status", "notok").add("error", "yes")
            }
            return map
        }

        @JvmStatic
        fun path(to: String): String {
            if (not(to)) {
                return ""
            }
            return KL::class.java.getResource(to).toString()
        }

        @JvmStatic
        fun filePath(filename: String): String {
            return path(filename)
        }

        @JvmStatic
        fun pathTo(filename: String): String {
            return path(filename)
        }

        @JvmStatic
        val fileSeparator: String = System.getProperty("file.separator")
        val workDirectory: String = System.getProperty("user.dir").lowercase()

        class sys {
            companion object {
                @JvmStatic
                val name: String = System.getProperty("os.name").lowercase().split(" ")[0]
                @JvmStatic
                val version: String = System.getProperty("os.version").lowercase()
                @JvmStatic
                val arch: String = System.getProperty("os.arch").lowercase()

                @JvmStatic
                fun is_(s: String): Boolean {
                    return name.startsWith(s)
                }
            }
        }

        class user {
            companion object {
                @JvmStatic
                val name: String = System.getProperty("user.name")
                @JvmStatic
                val language: String = System.getProperty("user.language").lowercase()
                @JvmStatic
                val homeDirectory: String = System.getProperty("user.home")
                @JvmStatic
                val workDirectory: String = KL.workDirectory
            }
        }
    }
}
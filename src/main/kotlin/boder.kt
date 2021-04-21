import java.text.SimpleDateFormat


fun readLineTrim() = readLine()!!.trim()

fun main() {
    @@ -19,11 +23,14 @@ fun main() {
    }
    "article write" -> {
        val articlesLastId
        val id = articlesLastId + 1
        val regDate = Util.getNowDateStr()
        val updateDate = Util.getNowDateStr()

        print("제목 : ")
        val title = readLineTrim()
        print("내용 : ")
        val body = readLineTrim()
        val article = Article(id, title, body)
        val article = Article(id, regDate, updateDate, title, body)

        println("${id}번 게시물이 작성되었습니다.")

        @@ -32,10 +39,10 @@ fun main() {
        var articlesLastId = id
    }
        "article list" -> {
        println("번호 / 제목")
        println("번호 / 작성날짜 / 제목")

        for ( article in articles ) {
            println("${article.id} / ${article.title}")
            println("${article.id} / ${article.regDate} / ${article.title}")
        }
    }
        else -> {
        @@ -49,6 +56,16 @@ fun main() {git

        data class Article(
            val id: Int,
            val regDate: String,
            val updateDate: String,
            val title: String,
            val body: String
        )
        )

        object Util {
            fun getNowDateStr(): String {
                val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

                return dateFormat.format(System.currentTimeMillis())
            }
        }
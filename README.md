# 第七回課題

* 授業で扱った実装例を参考にHTTPメソッドのGET/POST/PATCH/DELETEのリクエストを扱えるControllerを実装しましょう。

# 実行内容
* http://localhost:8080/names?name=koyama のようにクエリ文字列を受け取れるようにする
* 名前以外にも生年月日を受け取れるよう実装する
* バリデーションについて調べてnameが空文字、null、20文字以上の場合はエラーとする